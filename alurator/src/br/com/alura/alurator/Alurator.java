package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        // TODO - processa a requisicao executando o metodo
        // da classe em questao

        // /produto/lista

        Request request = new Request(url);

        String nomeControle = request.getNomeControle();

        Object instanciaControle = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle)
                .getContructorPadrao()
                .invoca();

        System.out.println(instanciaControle);

        return null;
    }
}
