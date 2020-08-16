package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) throws NoSuchMethodException {
        // TODO - processa a requisicao executando o metodo
        // da classe em questao

        // /produto/lista

        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();

//        Object instanciaControle = new Reflexao()
//                .refleteClasse(pacoteBase + nomeControle)
//                .criarInstancia()
//                .getMetodo(nomeMetodo)
//                .invoca();

        Object retorno = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle)
                .criarInstancia()
                .getMetodo(nomeMetodo)
                .invoca();

        System.out.println(retorno);

        return retorno;
    }
}
