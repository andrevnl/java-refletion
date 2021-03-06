package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjeto {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Controle> controleClasse1 = Controle.class;

        Controle controle = new Controle();
        Class<? extends Controle> controleClasse2 = controle.getClass();

        Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

//        Controle objetoControle = controleClasse1.newInstance();
        Controle objetoControle = controleClasse1.getConstructor().newInstance();

//        Object outroObjetoControle = controleClasse3.newInstance();
        Object outroObjetoControle = controleClasse3.getConstructor().newInstance();

        System.out.println(objetoControle instanceof Controle);
        System.out.println(outroObjetoControle instanceof Controle);
    }
}
