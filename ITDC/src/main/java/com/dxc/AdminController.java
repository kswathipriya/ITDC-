package com.dxc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;
import com.dxc.service.AdminServiceImpl;
import com.dxc.service.IAdminService;


@Controller
public class AdminController {
	
	IAdminService service=new AdminServiceImpl();
	
	@RequestMapping("/homepage")
	public String displayIndex()
	{
		return "home.html";
	}
	
	@RequestMapping("/alogin")
	public String adminLogin(@RequestParam String name,@RequestParam String password,Model m)
	{
		System.out.println("test");
		Admin admin=new Admin();
		admin.setName(name);
		admin.setPassword(password);
		boolean b=service.admin_login(admin);
		System.out.println(b);
		if(b==true)
		{
			return "admin_operations.jsp";
		}else
		{
			m.addAttribute("message", "Login Fails!!...");
			return "message.jsp";
		}
	}
	
	@RequestMapping("add_hotel")
	public String addHotel(@ModelAttribute Hotel hotel,Model m)
	{
		boolean b=service.addHotel(hotel);
		if(b==true)
		{

			m.addAttribute("message", "Successfully Hotel Detailes added");
			return "message.jsp";
		}else
		{
			m.addAttribute("message", "Failes to add Hotel!!...");
			return "message.jsp";
		}
	}
	
	
	
	@RequestMapping("/update_hotel")
	public String updateHotel(@ModelAttribute Hotel hotel,Model m)
	{
		boolean b=service.updateHotel(hotel);
		if(b==true)
		{

			m.addAttribute("message", "Successfully Hotel Detailes Updated!!!...");
			return "message.jsp";
		}else
		{
			m.addAttribute("message", "Failes to add Hotel!!!...");
			return "message.jsp";
		}
	}
	
	
	@RequestMapping("/delete_hotel")
	public String deleteHotel(@RequestParam String phno,Model m)
	{
		boolean b=service.deleteHotel(phno);
		if(b==true)
		{

			m.addAttribute("message", "Successfully Hotel Detailes Deleted!!!...");
			return "message.jsp";
		}else
		{
			m.addAttribute("message", "Failes to Delete Hotel!!!...");
			return "message.jsp";
		}
	}
	
	
	@RequestMapping("/select_hotels")
	public String selectHotel(Model m)
	{
		List<Hotel> list=service.selectHotel();
		m.addAttribute("list", list);
		return "get_hotel_list.jsp";
	}
	
	@RequestMapping("/booking_details")
	public String selectBookingDetails(Model m)
	{
		List<BookingDetails> list=service.selectBookingDetails();
		m.addAttribute("list", list);
		return "view_booking_details.jsp";
	}
	
	
	@RequestMapping("/cancel_bookings")
	public String cancelBooking(@ModelAttribute BookingDetails bd,Model m)
	{
		boolean b=service.cancelBooking(bd);
		if(b==true)
		{

			m.addAttribute("message", "Successfully Cancelled!!!...");
			return "message.jsp";
		}else
		{
			m.addAttribute("message", "Failes to Cancel!!!...");
			return "message.jsp";
		}
	}
	
	@RequestMapping("/cancel_request_order")
	public String cancel_request_order(Model m)
	{
		List<BookingDetails> list=service.cancel_request_order();
		m.addAttribute("list", list);
		return "cancel_request_booking.jsp";
	}
	
	@RequestMapping("/cancel_booking_orders")
	public String cancelBookingorders(@ModelAttribute BookingDetails bd,Model m)
	{
		
		boolean b=service.cancelBookingOrders(bd);
		if(b==true)
		{

			m.addAttribute("message", "Successfully Cancelled!!!...");
			return "message.jsp";
		}else
		{
			m.addAttribute("message", "Failes to Cancel!!!...");
			return "message.jsp";
		}
	}
	
	
	@RequestMapping("/get_customers")
	public String getCustomers(Model m)
	{
		List<Customers> list=service.getCustomers();
		m.addAttribute("list", list);
		return "customers_details.jsp";
	}
	
	
}
