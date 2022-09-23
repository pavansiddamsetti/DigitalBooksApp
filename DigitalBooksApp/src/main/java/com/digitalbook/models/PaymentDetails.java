package com.digitalbook.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="PAYMENT_DETAILS")
public class PaymentDetails {
	@Id
	 @GenericGenerator(name = "payment_id", strategy = "com.digitalbook.generator.PaymentIdGenerator")
	  @GeneratedValue(generator = "payment_id") 
	@Column(name="PAYMENT_ID")
	private int paymentId;
	@Column(name = "TXN_ID")
	private String transactionId;
	@Column(name = "TXN_DATE")
	private LocalDate transactionDate;
	@Column(name = "EMAIL_ID")
	private String mailId;
	@Column(name = "READER_NAME")
	private String name;
	@Column(name = "PAID_AMT")
	private float paidAmt;
	@Column(name="BOOK_ID")
	private int bookId;
	@Column(name="AUTHOR")
	private String author;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}
}
