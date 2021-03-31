package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.services.IInvoiceService;

@Controller
@RequestMapping("/")
public class SecurityStaffController {
	
	@Autowired
	private IInvoiceService invoiceService;
	
	
	
	@GetMapping("/staff-home")
	public String paymentStatus(Model map) {

		map.addAttribute("invoice_list", invoiceService.staffInvoice());
		return "/staff-home";
	}
	
	@GetMapping("/update-payment")
	public String updatePyament(@RequestParam int id, Model map) {
		
		invoiceService.updatePayment(id, "Paid");
		return "redirect:/staff-home";
	}
	


}
