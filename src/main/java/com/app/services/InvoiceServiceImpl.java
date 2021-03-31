package com.app.services;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exc.ResourceNotFoundException;
import com.app.pojos.Invoice;
import com.app.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceServiceImpl implements IInvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepo;

	@Override
	public List<Invoice> allInvoice() {
		return invoiceRepo.findAll();

	}

	@Override
	public List<Invoice> findByCustomerIs(int cID) {
		return invoiceRepo.findByCustomerIs(cID);
	}

	@Override
	public Invoice getInovoice(int invoiceId) {

		Invoice i = invoiceRepo.findById(invoiceId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Invoice Id"));
		return i;
	}

	@Override
	public Invoice addInvoice(Invoice i) {
		invoiceRepo.save(i);
		return i;
	}


	@Override
	public int updateExitTime(int invId, LocalTime exitTime) {
		
		invoiceRepo.updateExitTime(invId, exitTime);
		return 1;
	}

	@Override
	public double calculateAmount(int invoiceId) {
		Invoice i = invoiceRepo.findById(invoiceId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Invoice Id"));
		LocalTime inTime = i.getInTime();
		LocalTime outTime = i.getOutTime();
		int timeDifference = ((outTime.getHour() - inTime.getHour())+1);
		double rate = 20.00;
		double amount = timeDifference * rate;
		i.setAmount(amount);
		return amount;
	}

	@Override
	public List<Invoice> staffInvoice() {
		
		return invoiceRepo.staffInvoice("not");
	}

	@Override
	public int updatePayment(int invId, String status) {
		
		invoiceRepo.updatePayment(invId, status);
		return 0;
	}
	
	
	
}
