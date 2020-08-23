package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.modelo.Produto;

import java.lang.reflect.Field;

public class TesteManipulaAtributos {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Produto produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> classe = produto.getClass();

        System.out.println(classe.getField("id"));
        System.out.println(classe.getDeclaredField("id"));

//        nome: Produto 1
//        valor: 20.0
//        marca: Marca 1

        for (Field atributo : classe.getDeclaredFields()) {
            atributo.setAccessible(true);
            System.out.println(atributo.getName() + ": " + atributo.get(produto));
        }
    }
}
