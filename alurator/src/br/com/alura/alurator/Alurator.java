package br.com.alura.alurator;

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
                .invoca();

        System.out.println(retorno);

        return retorno;
    }
}
