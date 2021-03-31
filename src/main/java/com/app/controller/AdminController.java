package com.app.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojos.Admin;
import com.app.pojos.Place;
import com.app.pojos.SecurityStaff;
import com.app.pojos.Slot;
import com.app.services.IAdminService;
import com.app.services.ICustomerService;
import com.app.services.IInvoiceService;
import com.app.services.IParkingDetailsService;
import com.app.services.IPlaceService;
import com.app.services.ISecurityStaffService;
import com.app.services.ISlotService;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	private IAdminService adminService;
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
	@Autowired
	private ISecurityStaffService securityService;

	public AdminController() {
		System.out.println("In Construtor of " + getClass().getName());
	}

	// Login
	@GetMapping("/admin-login")
	public String showLoginForm() {

		return "/admin-login";
	}

	@PostMapping("/admin-login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		try {
			Admin admin = adminService.authenticateAdmin(email, password);
			SecurityStaff staff = securityService.findByEmailAndPassword(email, password);
			if(admin != null)
			{
				session.setAttribute("admin_details", admin);
				flashMap.addFlashAttribute("message", "Welcome " + admin.getFirstName() + " " + admin.getLastName());
				return "redirect:/admin-home";
			}
			else
			{
				session.setAttribute("staff_details", staff);
				flashMap.addFlashAttribute("message", "Welcome " + staff.getFirstName() + " " + staff.getLastName());
				return "redirect:/staff-home";
			}
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			flashMap.addAttribute("message", "Invalid Login ID or Password,Please Retry");
			return "/admin-login";
		}

	}

	@GetMapping("/admin-home")
	public String inHome() {

		return "/admin-home";
	}

	// register

	@GetMapping("/admin-register")
	public String showAdminRegistrationForm(Model map) {

		map.addAttribute("admin", new Admin());
		return "/admin-register";
	}

	@PostMapping("/admin-register")
	public String processRegForm(@ModelAttribute(name = "admin") @Valid Admin a, BindingResult result,
			RedirectAttributes flashMap) {
		if (result.hasErrors()) {
			System.out.println("P.L erros");
			return "/admin-register";
		}
		flashMap.addFlashAttribute("message", adminService.registerAdmin(a));
		return "redirect:/admin-login";
	}

	@GetMapping("/admin-customer-list")
	public String listCustomers(Model map) {

		map.addAttribute("customer_list", customerService.allCustomer());
		return "/admin-customer-list";
	}

	// Place
	@GetMapping("/admin-place-list")
	public String listPlaces(Model map, HttpSession session) {

		map.addAttribute("place_list", placeService.allPlace());
		return "/admin-place-list";
	}

	@GetMapping("/admin-add-place")
	public String showPlaceAddForm(Model map, HttpSession session) {
		map.addAttribute("place", new Place());
		return "/admin-add-place";
	}

	@PostMapping("/admin-add-place")
	public String processAddForm(@ModelAttribute(name = "place") @Valid Place p, BindingResult result,
			HttpSession session, RedirectAttributes flashMap) {
		if (result.hasErrors()) {
			System.out.println("P.L erros");
			return "/admin-add-place";
		}

		Admin admin = (Admin) session.getAttribute("admin_details");
		p.setAdmin(admin);
		flashMap.addFlashAttribute("message", placeService.addPlace(p));
		session.setAttribute("place_details", p);
		return "redirect:/admin-place-list";
	}

	@GetMapping("/admin-remove-place")
	public String deletePlaceDetails(@RequestParam int pid, RedirectAttributes flashMap) {

		flashMap.addFlashAttribute("message", placeService.deletePlace(pid));
		return "redirect:/admin-place-list";
	}

	@GetMapping("admin-slot-list")
	public String listSlot(@RequestParam int pid, Model map, HttpSession session) {

		map.addAttribute("slot_list", slotServices.slotsByPlace(pid));
		return "/admin-slot-list";
	}

	@GetMapping("/admin-add-slot")
	public String showSlotAddForm(@RequestParam int pid, Model map, HttpSession session) {
		
		session.setAttribute("place", pid);
		map.addAttribute("slot", new Slot());
		return "/admin-add-slot";
	}

	@RequestMapping("admin-add-slots")
	public String processAddForm(@RequestParam int slot, RedirectAttributes flashMap, HttpSession session) {
		
		int pid=(int) session.getAttribute("place");
		Place place = placeService.getPlaceDetails(pid);
		int temp=slot;
		while(temp!=0) {
		Slot s = new Slot("0", place);
		flashMap.addFlashAttribute("message", slotServices.addSlot(s));
		temp--;}
		return "redirect:/admin-place-list";
	}

	@GetMapping("admin-remove-slot")
	public String deleteSlotDetails(@RequestParam int sid, RedirectAttributes flashMap) {

		flashMap.addFlashAttribute("message", slotServices.deleteSlot(sid));
		return "redirect:/admin-place-list";
	}

	@GetMapping("/admin-invoice-list")
	public String invoiceList(Model map) {

		map.addAttribute("invoice_list", invoiceService.allInvoice());
		return "/admin-invoice-list";
	}

	@GetMapping("/admin-parking-details")
	public String parkingDetails(Model map) {

		map.addAttribute("parking_details", parkingService.allDetails());
		return "/admin-parking-details";
	}
	
	@GetMapping("/admin-parking-advance")
	public String parkingAdvanceSearch(Model map) {
		return "/admin-parking-advance";
	}
	
	@RequestMapping("/admin-parking-date")
	public String parkingDetailsByDate(@RequestParam(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate date, Model map) {
		
		map.addAttribute("parking_search",parkingService.findByDate(date));
		return "/admin-parking-advance";
	}
	
	@RequestMapping("/admin-parking-vehicle")
	public String parkingDetailsByVehicle(@RequestParam String vehicle, Model map) {
		
		map.addAttribute("parking_search",parkingService.findByVehicleNoContaining(vehicle));
		return "/admin-parking-advance";
	}
	
	@RequestMapping("/admin-parking-slot")
	public String parkingDetailsBySlot(@RequestParam int id, Model map) {
		
		map.addAttribute("parking_search",parkingService.findAllBySlotId(id));
		return "/admin-parking-advance";
	}
	
	@RequestMapping("/admin-parking-name")
	public String parkingDetailsByName(@RequestParam String name, Model map) {
		
		map.addAttribute("parking_search",parkingService.findAllByName(name));
		return "/admin-parking-advance";
	}

	@GetMapping("/admin-logout")
	public String logout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse responce) {

		map.addAttribute("details", session.getAttribute("admin_details"));
		session.invalidate();
		responce.setHeader("refresh", "2;url=" + request.getContextPath());
		return "/admin-logout";
	}
	
	// ------------------------------  Security Staff Registration -----------------------------
	
	@GetMapping("/admin-register-staff")
	public String showSecurityRegistrationForm(Model map, HttpSession session) {
		
		if(session.getAttribute("admin_details")!=null)
		{
		map.addAttribute("staff", new SecurityStaff());
		return "/admin-register-staff";
		}
		else
			return "/admin-login";
	}

	@PostMapping("/admin-register-staff")
	public String processSecurityRegForm(@ModelAttribute(name = "staff") @Valid SecurityStaff s, BindingResult result,
			RedirectAttributes flashMap) {
		if (result.hasErrors()) {
			System.out.println("P.L erros");
			return "/admin-register-staff";
		}
		flashMap.addFlashAttribute("message", securityService.registerStaff(s));
		return "redirect:/admin-home";
	}
	
	@GetMapping("/admin-staff-list")
	public String listStaff(Model map) {

		map.addAttribute("staff_list", securityService.findAll());
		return "/admin-staff-list";
	}
	
	
}
