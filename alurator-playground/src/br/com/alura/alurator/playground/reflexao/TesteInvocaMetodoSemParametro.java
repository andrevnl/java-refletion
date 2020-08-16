package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> subControleClasse = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Constructor<?> constructor = subControleClasse.getDeclaredConstructor();
        constructor.setAccessible(true);

        Object subControle = constructor.newInstance();

        //Tds os metodos publicos inclusive os das superclasses
        for (Method m : subControleClasse.getMethods()) {
            System.out.println(m);
        }

        System.out.println();

        //Tds os metodos da classe inclusive os não publicos, mas não os das superclasses
        for (Method m : subControleClasse.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println();
        Method m1 = subControleClasse.getDeclaredMethod("metodoSubControle1");
        Method m2 = subControleClasse.getDeclaredMethod("metodoSubControle2");
        m2.setAccessible(true);
        System.out.println("Execução dos metodos:");
        Object retorno1 = m1.invoke(subControle);
        Object retorno2 = m2.invoke(subControle);

        System.out.println();
        System.out.println("Retorno dos metodos:");
        System.out.println(retorno1);
        System.out.println(retorno2);
    }
}
