package com.literalura.literalura.Main;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    public Main() {

    }

    private final String MAIN_ADDRESS="https://gutendex.com/books/";
    private final Scanner sc=new Scanner(System.in);

    static int option=99;
    public void start() {
        while (option != 0) {
            System.out.println("""
                    ------------------------------------
                                    
                    Escolha o número de sua opção:
                    1 - buscar livro pelo título
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos em um determinado ano
                    5 - listar livros em um determinado idioma
                    0 - sair
                                    
                    ------------------------------------
                    """);

        }
    }

    //create functions/methods to every option in menu. ex. find book by author. return all authors
}
