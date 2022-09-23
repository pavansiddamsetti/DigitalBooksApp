package com.digitalbook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.digitalbook.models.BookDetails;




public interface BookService {
public Optional<BookDetails> createBook(BookDetails bdtls);
public int updateBook(BookDetails bdtls,int bid,int aid);
public List<BookDetails> serachByBook(String title,String auhtor,String publisher,LocalDate rdate);
public int blockBookDetails(int bid,int aid);
public List<BookDetails> getAllBooks();
public BookDetails getBookById(int bookid);
}
