package com.digitalbook.service;

import java.util.List;

import com.digitalbook.models.BuyerDetails;
import com.digitalbook.models.PaymentDetails;

public interface PaymentService {
public PaymentDetails savePaymentDetails(BuyerDetails bdtls);
public List<PaymentDetails> findAllPerchasedBooks(String mail);
}
