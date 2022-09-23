package com.digitalbook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalbook.models.BuyerDetails;
import com.digitalbook.models.PaymentDetails;
import com.digitalbook.repository.PaymentRepository;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
	@Mock
	private PaymentRepository pRepo;
	
	@InjectMocks
	private PaymentServiceImpl pservice;
	
//	@Test
//	public void testBuyBook() {
//		PaymentDetails pdtls=new PaymentDetails();
//		PaymentDetails payDetails=new PaymentDetails();
//		pdtls.setPaymentId(1);
//		when(pRepo.save(pdtls)).thenReturn(pdtls);
//		BuyerDetails bdtls=new BuyerDetails();
//		 pservice.savePaymentDetails(bdtls);
//		assertEquals(pdtls, payDetails);
//	}
	
	@Test
	public void testFindAllPerchasedBooks() {
		List<PaymentDetails> payList=new ArrayList<>();
		when(pRepo.findByMailId("pavan@gmail.com")).thenReturn(payList);
		List<PaymentDetails> findAllPerchasedBooks = pservice.findAllPerchasedBooks("pavan@gmail.com");
	assertEquals(payList, findAllPerchasedBooks);
	}
}
