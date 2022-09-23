package com.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.digitalbook.controllers.BookController;
import com.digitalbook.models.BookDetails;

import com.digitalbook.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
	@Mock
	private BookService bservice;
	
	@InjectMocks
	private BookController bcontroller;
	
	@Test
	public void testCreateBook() {
		BookDetails btls=new BookDetails();
		Optional<BookDetails> ofNullable = Optional.ofNullable(btls);
		when(bservice.createBook(btls)).thenReturn(ofNullable);
		ResponseEntity<?> createBook = bcontroller.createBook(btls, 10);
		int value = createBook.getStatusCode().value();
		//System.out.println(value);
		assertEquals(400, createBook.getStatusCode().value());
	}
	@Test
	public void testCreateBook1() {
		BookDetails btls=new BookDetails();
		btls.setId(10);
		btls.setTitle("A BOOK BY");
		Optional<BookDetails> ofNullable = Optional.ofNullable(btls);
		when(bservice.createBook(btls)).thenReturn(ofNullable);
		ResponseEntity<?> createBook = bcontroller.createBook(btls, 10);
		int value = createBook.getStatusCode().value();
		System.out.println(value);
		assertEquals(200, createBook.getStatusCode().value());
	}
	@Test
	public void testSerachByBook() {
		List<BookDetails> booksList=new ArrayList<>();
		when(bservice.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now())).thenReturn(booksList);
	List<BookDetails> serachByBook = bcontroller.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", null);
	assertEquals(booksList, serachByBook);
	}
	
	@Test
	public void testSerachByBook1() {
		List<BookDetails> booksList=new ArrayList<>();
		when(bservice.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now())).thenReturn(booksList);
	List<BookDetails> serachByBook = bcontroller.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now().toString());
	assertEquals(booksList, serachByBook);
	}
	@Test
	public void testGetAllBooks() {
		List<BookDetails> bookList=new ArrayList<>();
		when(bservice.getAllBooks()).thenReturn(bookList);
		List<BookDetails> allBookDetails = bcontroller.getAllBookDetails();
		assertEquals(bookList, allBookDetails);
	}
	@Test
	public void testGetBookById() {
		BookDetails bkdtls=new BookDetails();
		when(bservice.getBookById(10)).thenReturn(bkdtls);
		BookDetails bookDetailsById = bcontroller.getBookDetailsById(10);
		assertEquals(bkdtls, bookDetailsById);
	}
	
}
