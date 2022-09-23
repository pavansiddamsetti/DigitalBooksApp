package com.digitalbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.models.BookDetails;
import com.digitalbook.payload.response.MessageResponse;
import com.digitalbook.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class AuthorController {
	
	@Autowired
	private BookService bservice;
	@PreAuthorize("hasRole('ROLE_AUTHOR')")
	@PutMapping("/author/{authorid}/book/{bookid}/edit")
	public ResponseEntity<?> saveEditBook(BookDetails bdtls,@PathVariable("authorid") int aid,@PathVariable("bookid") int bid){
		int updateBook = bservice.updateBook(bdtls,bid,aid);
		if(updateBook==1) {
				return ResponseEntity.ok(new MessageResponse("Book Edited Successfully!"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Failed to Save  a  Edit Book"));
	}
//	
	@PreAuthorize("hasRole('ROLE_AUTHOR')")
	@GetMapping("/author/{authorid}/books/{bookId}/block")
	public ResponseEntity<?> blockedBook(@PathVariable("authorid") int aid,@PathVariable("bookId") int bid){
		int bdetails = bservice.blockBookDetails(bid, aid);
		if(bdetails==1) {
			return ResponseEntity.ok(new MessageResponse("Book blocked Successfully!"));
	}
	return ResponseEntity.badRequest().body(new MessageResponse("Failed to block a Book"));
		
	}
}
