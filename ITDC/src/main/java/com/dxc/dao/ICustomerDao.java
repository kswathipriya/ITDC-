package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;

public interface ICustomerDao {

	boolean registerCustomers(Customers cust);

	boolean loginCustomers(String name, String password);

	List<Hotel> getHotelList();

	List<Hotel> getHotelDetails(String phno);

	boolean payBill(BookingDetails bdetails);

	double availableBalance(String cphno);

	List<BookingDetails> pastBookings(String phno);

	boolean cancelBooking(BookingDetails bd);

	
}
