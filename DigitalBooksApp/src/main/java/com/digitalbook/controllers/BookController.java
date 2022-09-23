package com.digitalbook.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.models.BookDetails;
import com.digitalbook.payload.response.MessageResponse;
import com.digitalbook.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {
	@Autowired
	private BookService bservice;
	
	
	@PreAuthorize("hasRole('ROLE_AUTHOR')")
	@PostMapping("/author/{authorid}/books")
	public ResponseEntity<?> createBook(@RequestBody BookDetails bkdtls,@PathVariable("authorid")int authorId){
		bkdtls.setAuthorId(authorId);
		Optional<BookDetails> createBook = bservice.createBook(bkdtls);
		if(createBook.isPresent()) {
			BookDetails bookDetails = createBook.get();
			if(bookDetails.getId()!=0 && bookDetails.getTitle()!=null) {
				return ResponseEntity.ok(new MessageResponse("Book Created Successfully!"));
			}
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Failed to Create a Book"));
	}
	
	@PreAuthorize("hasRole('ROLE_READER')")
	@GetMapping("author/books/search")
	public List<BookDetails> serachByBook(@RequestParam String title,@RequestParam String author,	
																		@RequestParam String publisher,@RequestParam String rdate){
		
		 LocalDate localDate=null;
		if(rdate!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  localDate = LocalDate.parse(rdate, formatter);
		}else {
			localDate=LocalDate.now();
		}
		List<BookDetails> serachBooks = bservice.serachByBook(title,author, publisher, localDate);
	return serachBooks;
	}
	
	@GetMapping("/book/getall")
	public List<BookDetails> getAllBookDetails(){
		List<BookDetails> allBooks = bservice.getAllBooks();
		return allBooks;
	}
	
	@GetMapping("/book/{bookid}")
	public BookDetails getBookDetailsById(@PathVariable("bookid") int bookid) {
		BookDetails bookById = bservice.getBookById(bookid);
		return bookById;
	}


}
