package com.digitalbook.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbook.models.PaymentDetails;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails, Serializable>{

	List<PaymentDetails> findByMailId(String mail);
}
