package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        // TODO - processa a requisicao executando o metodo
        // da classe em questao

        // /produto/lista

        //Lembrar de habilitar o Java a ler o nome original dos parâmetros de métodos utilizando Reflection, a partir do JDK 8.

        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();

        Map<String, Object> params = request.getQueryParams();

        Object retorno = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle)
                .criarInstancia()
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
}
