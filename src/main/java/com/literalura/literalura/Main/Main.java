package com.literalura.literalura.Main;

import com.literalura.literalura.Model.Book;
import com.literalura.literalura.Model.Results;
import com.literalura.literalura.Service.APIConsumer;
import com.literalura.literalura.Service.ConvertData;
import com.literalura.literalura.repository.AuthorRepository;
import com.literalura.literalura.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main {

    private final String MAIN_ADDRESS = "https://gutendex.com/books/";
    private final Scanner sc = new Scanner(System.in);
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    APIConsumer APIConsumer = new APIConsumer();
    ConvertData convertData = new ConvertData();

    static int option = 99;

    public Main(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void startMenu() {
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
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    listRegisteredBooks();
                    break;
                case 3:
                    listRegisteredAuthors();
                    break;
                case 4:
                    listLivingAuthors();
                    break;
                case 5:
                    listBooksbyLanguage();
                    break;
                case 0:
                    break;

            }
        }
    }
    private void searchBook(){

        System.out.println("Type the book title:");
        String bookTitle = sc.nextLine();

        String url = MAIN_ADDRESS + "?search=" + bookTitle.replace(" ", "%20").toLowerCase();

        var json = APIConsumer.getData(url);



        Results results=convertData.ObtainData(json, Results.class);

        List<Book> booksData = results.getResults()
                        .stream()
                .collect(Collectors.toList());

        if (booksData.size()<1){
            System.out.println("Não encontrado");
            searchBook();
        }

        System.out.println("\n");
        booksData.forEach(System.out::println);

        System.out.println("\nChoose one ID from above books to see details:");

        String bookId = sc.nextLine();

        url = MAIN_ADDRESS+bookId+"/";
        var newjson = APIConsumer.getData(url);
        Book bookChoosed = convertData.ObtainData(newjson, Book.class);

        System.out.println(bookChoosed.detailedDescription());

        if (bookRepository.existsById(bookChoosed.getId())){
            System.out.println("livro já existe no banco de dados");
        } else {
            bookRepository.save(bookChoosed);
            System.out.println("Novo Livro, salvo ao banco de dados");
        }

        startMenu();
    }

    private void listRegisteredBooks(){
        bookRepository.findAll().forEach(System.out::println);
        startMenu();


    }

    private void listRegisteredAuthors(){
        authorRepository.findAll();
        startMenu();

    }

    private void listLivingAuthors(){

        System.out.println("Digit the year");

        int yearDeath = sc.nextInt();
        sc.nextLine();

        authorRepository.findAll().stream()
                .filter(author1 -> author1.getDeath_year()>yearDeath)
                .forEach(System.out::println);
        startMenu();

    }

    private void listBooksbyLanguage(){
        System.out.println("Digit the desired language");

        String desiredLanguage = sc.nextLine();

        String langCode= String.valueOf(desiredLanguage.charAt(0)+desiredLanguage.charAt(1));

        bookRepository.findAll().stream()
                .filter(book -> book.getLanguages().equals(langCode))
                .forEach(System.out::println);
        startMenu();

    }
}
