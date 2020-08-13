package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDaoImpl;
import com.dxc.dao.ICustomerDao;
import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;

public class CustomerServiceImpl implements ICustomerService {

	ICustomerDao dao=new CustomerDaoImpl();
	
	@Override
	public boolean registerCustomers(Customers cust) {
		return dao.registerCustomers(cust);
	}

	@Override
	public boolean loginCustomers(String name, String password) {
		return dao.loginCustomers(name,password);
	}

	@Override
	public List<Hotel> getHotelList() {
		return dao.getHotelList();
	}

	@Override
	public List<Hotel> getHotelDetails(String phno) {
		return dao.getHotelDetails(phno);
	}

	@Override
	public boolean payBill(BookingDetails bdetails) {
		return dao.payBill(bdetails);
	}

	@Override
	public double checkBalance(String phno) {
		return dao.availableBalance(phno);
	}

	@Override
	public List<BookingDetails> pastBookings(String phno) {
		return dao.pastBookings(phno);
	}

	@Override
	public boolean cancelBooking(BookingDetails bd) {
		return dao.cancelBooking(bd);
	}

}
