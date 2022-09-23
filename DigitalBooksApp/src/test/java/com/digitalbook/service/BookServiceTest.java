package com.digitalbook.service;

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

import com.digitalbook.models.BookDetails;
import com.digitalbook.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	@Mock
	private BookRepository bRepo;
	
	@InjectMocks
	private BookServiceImpl bservice;
	
	@Test
	public void testCreateBook() {
		BookDetails bkdtls=new BookDetails();
		when(bRepo.save(bkdtls)).thenReturn(bkdtls);
		Optional<BookDetails> createBook = bservice.createBook(bkdtls);
		assertEquals(createBook.get(), bkdtls);
	}
	@Test
	public void testSearchByBook() {
		List<BookDetails> bookList=new ArrayList();
		when(bRepo.findByBooks("PIRATES", "KRISH", "Arohi", LocalDate.now())).thenReturn(bookList);
		List<BookDetails> serachByBook = bservice.serachByBook("PIRATES", "KRISH", "Arohi", LocalDate.now());
		assertEquals(serachByBook,bookList);
	}
	@Test
	public void testIsBookBlocked() {
		when(bRepo.blockBookDetails(5, 10)).thenReturn(1);
		int blockBookDetails = bservice.blockBookDetails(5, 10);
		assertEquals(1, blockBookDetails);
	}
	@Test
	public void testgetAllBooks() {
		List<BookDetails> bookList=new ArrayList<>();
		when(bRepo.findAll()).thenReturn(bookList);
		List<BookDetails> allBooks = bservice.getAllBooks();
		assertEquals(bookList, allBooks);
	}
	@Test
	public void getBooksById() {
		BookDetails bdtsl=new BookDetails();
		Optional<BookDetails> ofNullable = Optional.ofNullable(bdtsl);
		when(bRepo.findById(10)).thenReturn(ofNullable);
		BookDetails bookById = bservice.getBookById(10);
		assertEquals(bdtsl, bookById);
	}
	@Test
	public void testUpdateBook() {
		BookDetails bkdtls=new BookDetails();
		bkdtls.setTitle("POWER");
		bkdtls.setCategory("ROLEMODEL");
		bkdtls.setPrice(1000);
		bkdtls.setAuthorName("KALYAN");
		bkdtls.setPublisher("BOOK");
		bkdtls.setReleaseDate(LocalDate.now());
		bkdtls.setActive(true);
		when(bRepo.editBookDetails("POWER", "ROLEMODEL", 1000, "KALYAN", "BOOK", LocalDate.now(), true, 1, 12)).thenReturn(1);
		int updateBook = bservice.updateBook(bkdtls, 1, 12);
		assertEquals(1, updateBook);
	}
}
