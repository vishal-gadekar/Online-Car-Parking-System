package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;
	
	private LocalDate date;
	
	@DateTimeFormat(pattern ="HH:mm:ss")
	private LocalTime inTime;
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime outTime;
	
	@Column(length = 20)
	private double amount;
	
	@Column
	private String paymentStatus;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}	

	
	public Invoice(LocalDate date, LocalTime inTime, Customer customer, String paymentStatus) {
		super();
		this.date = date;
		this.inTime = inTime;
		this.customer = customer;
		this.paymentStatus=paymentStatus;
	}


	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	public LocalTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", inTime=" + inTime + ", outTime=" + outTime + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
