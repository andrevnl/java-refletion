package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorObjeto;
import br.com.alura.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;
    private ContainerIoC containerIoC;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.containerIoC = new ContainerIoC();
    }

    public Object executa(String url) {
        // Processa a requisicao executando o metodo
        // da classe em questao

        // /produto/lista

        //Lembrar de habilitar o Java a ler o nome original dos parâmetros de métodos utilizando Reflection, a partir do JDK 8.

        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();

        Map<String, Object> params = request.getQueryParams();

        Class<?> classeControle = new Reflexao().getClasse(pacoteBase + nomeControle);
        Object instanciaControle = containerIoC.getInstancia(classeControle);
        Object retorno = new ManipuladorObjeto(instanciaControle)
                .getMetodo(nomeMetodo, params)
                .comTratamentoDeExcecao((metodo, ex) -> {
                    System.out.println("Erro no método " + metodo.getName() + " da classe "
                     + metodo.getDeclaringClass().getName() + " ./n/n");
                    throw new RuntimeException("Erro no método!");
                })
                .invoca();

        System.out.println(retorno);

        retorno = new ConversorXML().converte(retorno);

        return retorno;
    }

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        containerIoC.registra(tipoFonte, tipoDestino);
    }
}
