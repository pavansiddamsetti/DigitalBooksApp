package com.digitalbook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.models.BuyerDetails;
import com.digitalbook.models.PaymentDetails;
import com.digitalbook.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository payRepo;

	@Override
	public PaymentDetails savePaymentDetails(BuyerDetails bdtls) {
		PaymentDetails pdtls=new PaymentDetails();
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	   String txnid = String.format("%06d", number);
	   LocalDate now = LocalDate.now();
	   pdtls.setTransactionId(txnid);
	   pdtls.setTransactionDate(now);
	   pdtls.setMailId(bdtls.getEmailid());
	   pdtls.setName(bdtls.getName());
	   pdtls.setPaidAmt(bdtls.getDueAmount());
	   pdtls.setBookId(bdtls.getBookId());
	   pdtls.setAuthor(bdtls.getAuthor());
	   PaymentDetails save = payRepo.save(pdtls);
	   Optional<PaymentDetails> payDtls = Optional.ofNullable(save);
	   if(payDtls.isPresent()) {
		   return payDtls.get();
	   }
		return null;
	}

	@Override
	public List<PaymentDetails> findAllPerchasedBooks(String mail) {
	List<PaymentDetails> perchasedDtls = payRepo.findByMailId(mail);
		return perchasedDtls;
	}

	

}
