package com.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.digitalbook.controllers.AuthorController;
import com.digitalbook.models.BookDetails;
import com.digitalbook.service.BookService;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {
	@Mock
	private BookService bservice;
	
	@InjectMocks
	private AuthorController aController;

	@Test
	public void  testIsBookBlocked() {
		when(bservice.blockBookDetails(10, 10)).thenReturn(1);
		ResponseEntity<?> blockedBook = aController.blockedBook(10, 10);
		assertEquals(200, blockedBook.getStatusCodeValue());
	}
	
	@Test
	public void  testIsBookBlocked1() {
		when(bservice.blockBookDetails(10, 10)).thenReturn(0);
		ResponseEntity<?> blockedBook = aController.blockedBook(10, 10);
		assertEquals(400, blockedBook.getStatusCodeValue());
	}
	@Test
	public void testEditBookDetails() {
		BookDetails bkdtls=new BookDetails();
		bkdtls.setActive(true);
		bkdtls.setAuthorId(10);
		bkdtls.setAuthorName("JOHN KING");
		bkdtls.setBlocked(true);
		bkdtls.setCategory("BOOK");
		bkdtls.setContent("THIS BOOK");
		when(bservice.updateBook(bkdtls, 1, 10)).thenReturn(1);
		ResponseEntity<?> saveEditBook = aController.saveEditBook(bkdtls, 10, 1);
		assertEquals(200, saveEditBook.getStatusCodeValue());
	}
	
}
