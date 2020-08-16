package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

    private Class<?> classe;

    public ManipuladorClasse(Class<?> classe) {
        this.classe = classe;
    }

    public ManipuladorConstrutor getContructorPadrao() {
        try {
            Constructor<?> constructorPadrao = classe.getDeclaredConstructor();
            return new ManipuladorConstrutor(constructorPadrao);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ManipuladorObjeto criarInstancia() {
        Object instancia = getContructorPadrao().invoca();
        return new ManipuladorObjeto(instancia);
    }
}
