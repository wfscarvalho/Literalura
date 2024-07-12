package com.literalura.literalura;

import com.literalura.literalura.Model.Author;
import com.literalura.literalura.Model.Book;
import com.literalura.literalura.Service.APIConsumer;
import com.literalura.literalura.Service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var APIConsumer = new APIConsumer();
		var convertData = new ConvertData();
		var json = APIConsumer.getData("https://gutendex.com/books/");
		System.out.println(json);
		var dataBooks = convertData.ObtainData(json, Book.class);
	}
}
