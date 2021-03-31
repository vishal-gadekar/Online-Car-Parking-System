package com.app.services;

import java.time.LocalTime;
import java.util.List;

import com.app.pojos.Invoice;

public interface IInvoiceService {
	List<Invoice> allInvoice();
	Invoice getInovoice(int invoiceId);
	Invoice addInvoice(Invoice i);
//	LocalTime getInTime(int invoiceId,LocalTime inTime);
//	LocalTime getOutTime(int invoiceId,LocalTime outTime);
	double calculateAmount(int invoiceId);
	
	
	List<Invoice> findByCustomerIs(int cID);
	int updateExitTime(int invId, LocalTime exitTime);
	List<Invoice> staffInvoice();
	int updatePayment(int invId, String status);

}
