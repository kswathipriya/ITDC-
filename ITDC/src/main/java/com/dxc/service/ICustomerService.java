package com.dxc.service;

import java.util.List;

import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;

public interface ICustomerService {

	boolean registerCustomers(Customers cust);

	boolean loginCustomers(String name, String password);

	List<Hotel> getHotelList();

	List<Hotel> getHotelDetails(String phno);

	boolean payBill(BookingDetails bdetails);

	double checkBalance(String phno);

	List<BookingDetails> pastBookings(String phno);

	boolean cancelBooking(BookingDetails bd);


}
