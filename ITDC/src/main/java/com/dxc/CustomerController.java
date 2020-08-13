package com.dxc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;
import com.dxc.service.CustomerServiceImpl;
import com.dxc.service.ICustomerService;

@Controller
public class CustomerController {
	ICustomerService service=new CustomerServiceImpl();
	
	
	@RequestMapping("/register")
	public String registerCustomer(@ModelAttribute Customers cust,Model m)
	{
		boolean b=service.registerCustomers(cust);
		
		if(b==true)
		{
			return "customer_login.html";
		}else
		{
			m.addAttribute("message","Register Failes!!!....");
			return "message.jsp";
		}
	}
	
	
	@RequestMapping("/login")
	public String loginCustomer(@RequestParam String name,@RequestParam String password,Model m)
	{
		boolean b=service.loginCustomers(name,password);
		if(b==true)
		{
			return "customer_operation.jsp";
		}else
		{
			m.addAttribute("message","Login Failes!!!....");
			return "message.jsp";
		}
	}
	
	
	@RequestMapping("/hotel_list")
	public String selectHotel(Model m)
	{
		List<Hotel> list=service.getHotelList();
		m.addAttribute("list", list);
		return "cust_get_hotels.jsp";
	}
	
	@RequestMapping("/hotel_details")
	public String selectHotelDetails(@RequestParam String phno,Model m)
	{
		List<Hotel> list=service.getHotelDetails(phno);
		m.addAttribute("list", list);
		return "cust_get_hdetails.jsp";
	}
	
	@RequestMapping("/hotels_details")
	public String selectHotelsDetails(Model m)
	{
		List<Hotel> list=service.getHotelList();
		m.addAttribute("list", list);
		return "cust_get_hdetails.jsp";
	}
	
	@RequestMapping("/choose_rooms")
	public String chooseRooms(@RequestParam String hname,@RequestParam String phno,@RequestParam double rent,Model m,HttpSession session)
	{
		session.setAttribute("hname", hname);
		session.setAttribute("hphno", phno);
		session.setAttribute("rent", rent);
		return "book_hotel.jsp";
	}
	
	
	@RequestMapping("/pay")
	public String payRent(@RequestParam String phno,@RequestParam int wrooms,@RequestParam int days,
			@RequestParam String fdate,
			@RequestParam String edate,Model m,HttpSession session)
	{
		System.out.println("date");
		
		session.setAttribute("cphno", phno);
		
		m.addAttribute("hname",session.getAttribute("hname"));
		m.addAttribute("phno",phno);
		m.addAttribute("rent",session.getAttribute("rent"));
		
		m.addAttribute("wrooms",wrooms);
		m.addAttribute("days",days);
		m.addAttribute("fdate",fdate);
		m.addAttribute("edate",edate);
		return "display_bill.jsp";
	}
	
	
	@RequestMapping("/confirm_bill")
	public String payBill(@ModelAttribute BookingDetails bdetails,Model m,HttpSession session)
	{
		bdetails.setHphno(session.getAttribute("hphno").toString());
		boolean b=service.payBill(bdetails);
		
		if(b==true)
		{
			m.addAttribute("message","Successfully Hotel Booked....");
			return "message.jsp";
		}else
		{
			m.addAttribute("message","Booking Fails....");
			return "message.jsp";
		}
	}
	
	@RequestMapping("/check_balance")
	public String check_Balance(@RequestParam String phno,Model m)
	{
		
		double balance=service.checkBalance(phno);
		m.addAttribute("balance", balance);
		return "display_balance.jsp";
	}
	
	
	@RequestMapping("/past_bookings")
	public String pastBookings(@RequestParam String phno,Model m)
	{
		List<BookingDetails> list=service.pastBookings(phno);
		m.addAttribute("list", list);
		return "booking_details.jsp";
	}
	
	@RequestMapping("/cancel_booking")
	public String cancelBooking(@ModelAttribute BookingDetails bd,Model m)
	{
		boolean b=service.cancelBooking(bd);
		
		if(b==true)
		{
			m.addAttribute("message","Successfully Requested for Cancel past booking....");
			return "message.jsp";
		}else
		{
			m.addAttribute("message","Request is Fails....");
			return "message.jsp";
		}
	}
	
}
