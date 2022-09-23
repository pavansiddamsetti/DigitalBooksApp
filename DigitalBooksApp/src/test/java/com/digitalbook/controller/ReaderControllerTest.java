package com.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalbook.controllers.ReaderController;
import com.digitalbook.models.BuyerDetails;
import com.digitalbook.models.PaymentDetails;
import com.digitalbook.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class ReaderControllerTest {
	
	@Mock
	private PaymentService pservice;
	@InjectMocks
	private ReaderController rcontroller;

	@Test
	public void testReaderBuyBook() {
		BuyerDetails dtls=new BuyerDetails();
		PaymentDetails pdtls=new PaymentDetails();
		when(pservice.savePaymentDetails(dtls)).thenReturn(pdtls);
		PaymentDetails readerBuyBook = rcontroller.readerBuyBook(dtls);
		assertEquals(pdtls, readerBuyBook);
	}
	@Test
	public void testFindAllPerchasedBooks() {
		List<PaymentDetails> payList=new ArrayList<>();
		when(pservice.findAllPerchasedBooks("pavan@gmail.com")).thenReturn(payList);
		List<PaymentDetails> allPerchasedBooks = rcontroller.findAllPerchasedBooks("pavan@gmail.com");
		assertEquals(allPerchasedBooks, payList);
	}
}
