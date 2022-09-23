package com.digitalbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.models.BuyerDetails;
import com.digitalbook.models.PaymentDetails;
import com.digitalbook.service.PaymentService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class ReaderController {

	@Autowired
	private PaymentService pservice;
	
	@PreAuthorize("hasRole('ROLE_READER')")
	@PostMapping("/books/buy")
	public PaymentDetails readerBuyBook(@RequestBody BuyerDetails bdtls) {
		PaymentDetails savePaymentDetails = pservice.savePaymentDetails(bdtls);
		return savePaymentDetails;
	}
	@PreAuthorize("hasRole('ROLE_READER')")
	@GetMapping("/readers/{emailid}/books")
	public List<PaymentDetails> findAllPerchasedBooks(@PathVariable("emailid") String emailid){
		List<PaymentDetails> findAllPerchasedBooks = pservice.findAllPerchasedBooks(emailid);
		return findAllPerchasedBooks;
	}
	
	@GetMapping("/readers/{bookid}/book")
	public String getCotentByBook() {
		return null;
	}
}
