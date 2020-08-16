package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        try {
            controleClasse1.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            e.getTargetException();
        }

        Constructor<SubControle> constructorSubControle1 = subControleClasse1.getConstructor();

        Constructor<SubControle> constructorSubControle2 = subControleClasse1.getDeclaredConstructor(String.class);

        Object subControle = constructorSubControle1.newInstance();

        //Tornar metodos privados em acessiveis
        constructorSubControle2.setAccessible(true);
        Object subControle2 = constructorSubControle2.newInstance("");

        System.out.println(constructorSubControle1);

        System.out.println(subControle);

        System.out.println(subControle2);

        System.out.println(constructorSubControle2);
    }
}
