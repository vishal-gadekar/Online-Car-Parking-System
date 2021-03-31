package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.Invoice;
import com.app.pojos.ParkingDetails;
import com.app.services.ICustomerService;
import com.app.services.IInvoiceService;
import com.app.services.IParkingDetailsService;
import com.app.services.IPlaceService;
import com.app.services.ISlotService;

@Controller
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IPlaceService placeService;
	@Autowired
	private ISlotService slotServices;
	@Autowired
	private IInvoiceService invoiceService;
	@Autowired
	private IParkingDetailsService parkingService;

	public CustomerController() {
		System.out.println("In Construtor of " + getClass().getName());
	}

	@GetMapping("/customer-login")
	public String showLoginForm() {
		System.out.println("in Show Login form");
		return "/customer-login";
	}

	@PostMapping("/customer-login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		try {
			Customer customer = customerService.authenticateCustomer(email, password);
			flashMap.addFlashAttribute("message", customer.getFirstName() + " login successful!!!");
			session.setAttribute("customer_details", customer);
			return "/customer-home";
		} catch (RuntimeException e) {
			e.printStackTrace();
			flashMap.addAttribute("message", "Invalid Login ID or Password,Please Retry");
			System.out.println(map.getAttribute("message"));
			return "/customer-login";
		}

	}

	@GetMapping("/aboutus")
	public String inAboutUs() {

		return "/aboutus";
	}

	@GetMapping("/contactus")
	public String inContactUs() {

		return "/contactus";
	}

	@GetMapping("/customer-home")
	public String inHome() {

		return "/customer-home";
	}

	@GetMapping("/customer-register")
	public String showAdminRegistrationForm(Model map) {
		map.addAttribute("customer", new Customer());
		return "/customer-register";
	}

	@PostMapping("/customer-register")
	public String processRegForm(@ModelAttribute(name = "customer") @Valid Customer c, BindingResult result,
			RedirectAttributes flashMap) {
		if (result.hasErrors()) {
			System.out.println("P.L erros");
			return "/customer-register";
		}
		flashMap.addFlashAttribute("message", customerService.registerCustomer(c));
		return "redirect:/customer-login";
	}

	@GetMapping("/customer-place-list")
	public String listPlaces(Model map, HttpSession session) {

		map.addAttribute("place_list", placeService.allPlace());
		return "/customer-place-list";
	}

	@GetMapping("/customer-book-slot")
	public String bookSlot(Model map, HttpSession session) {

		map.addAttribute("place_list", placeService.allPlace());
		return "/customer-book-slot";
	}

	@GetMapping("/customer-slot-list")
	public String listSlots(@RequestParam int pid, Model map, HttpSession session) {

		map.addAttribute("slot_list", slotServices.showVacantSlots(pid, "0"));
		return "/customer-slot-list";
	}

	@GetMapping("/customer-booking")
	public String inBooking() {

		return "/customer-booking";
	}

	@GetMapping("/customer-select-slot")
	public String enterVehicle(@RequestParam int sid, Model map, HttpSession session) {
		Customer c = (Customer) session.getAttribute("customer_details");
		session.setAttribute("booked_slot", sid);
		ParkingDetails p = new ParkingDetails(LocalDate.now(), c.getFirstName(), c.getLastName(), c.getPhoneNo(),
				c.getVehicleNo(), sid, LocalTime.now());
		parkingService.addDetails(p);
		session.setAttribute("parked_vehicle", p);
		System.out.println(p);
		Invoice i = new Invoice(LocalDate.now(), LocalTime.now(), c, "Not Paid");
		invoiceService.addInvoice(i);
		session.setAttribute("invoice", i);
		map.addAttribute("add_slot", slotServices.bookSlot(sid, c.getVehicleNo()));
		return "redirect:/customer-booking";

	}

	@GetMapping("/customer-slot-exit")
	public String exitVehicle(Model map, HttpSession session, RedirectAttributes flashMap) {
		
		if(session.getAttribute("booked_slot")!=null) {
		int sid = (int) session.getAttribute("booked_slot");
		ParkingDetails details = (ParkingDetails) session.getAttribute("parked_vehicle");
		parkingService.updateExitTime(details.getSrNo(), LocalTime.now());
		Invoice i = (Invoice) session.getAttribute("invoice");
		invoiceService.updateExitTime(i.getInvoiceId(), LocalTime.now());
		invoiceService.calculateAmount(i.getInvoiceId());
		map.addAttribute("add_slot", slotServices.cancleSlot(sid));
		return "redirect:/customer-invoice";}
		else
			flashMap.addFlashAttribute("message", "No Parking Slot Alloted for You");
			return "redirect:/customer-booking";
	}

	@GetMapping("/customer-invoice")
	public String listInvoices(Model map, HttpSession session) {

		Customer c = (Customer) session.getAttribute("customer_details");
		map.addAttribute("customer_invoice_list", invoiceService.findByCustomerIs(c.getCustomerId()));
		return "/customer-invoice";
	}

	@GetMapping("/customer-logout")
	public String logout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse responce) {
		System.out.println("in logout " + map);
		map.addAttribute("details", session.getAttribute("customer_details"));
		session.invalidate();
		responce.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/customer-logout";
	}

}
