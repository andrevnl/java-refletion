package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {

    public static void main(String[] args) throws Exception {

        Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Constructor<?> construtorPadrao = controleClasse.getDeclaredConstructor();

        Object controle = construtorPadrao.newInstance();

        Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class);
        Method m2 = controleClasse.getDeclaredMethod("metodoControle2", String.class, String.class);
        Method m3 = controleClasse.getDeclaredMethod("metodoControle2", String.class, Integer.class);

        Object retorno = m.invoke(controle, "AAAA");
        Object retorno2 = m2.invoke(controle, "AAAA", "BBBB");
        Object retorno3 = m3.invoke(controle, "AAAA", 22);

        System.out.println(retorno);
        System.out.println(retorno2);
        System.out.println(retorno3);
    }
}
