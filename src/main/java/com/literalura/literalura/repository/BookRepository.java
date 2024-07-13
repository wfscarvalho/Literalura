package com.literalura.literalura.repository;

import com.literalura.literalura.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
