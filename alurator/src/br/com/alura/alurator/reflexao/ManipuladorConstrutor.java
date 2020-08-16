package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {
    private Constructor<?> constructor;

    public ManipuladorConstrutor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Object invoca() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new RuntimeException("Erro no construtor", e.getTargetException());
        }
    }
}
