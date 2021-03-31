package com.app.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	@Query("select i from Invoice i where i.customer.customerId = ?1")
	List<Invoice> findByCustomerIs(int cID);
	
	@Modifying
	@Query("update Invoice i set i.outTime = ?2 where i.invoiceId = ?1")
	int updateExitTime(int invId, LocalTime exitTime);
	
	@Query("select i from Invoice i where i.paymentStatus like %?1%")
	List<Invoice> staffInvoice(String s);
	
	@Modifying
	@Query("update Invoice i set i.paymentStatus = ?2 where i.invoiceId = ?1")
	int updatePayment(int invId, String status);

}
