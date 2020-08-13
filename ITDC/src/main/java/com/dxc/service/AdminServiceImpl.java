package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;

public class AdminServiceImpl implements IAdminService {
	
	IAdminDao dao=new AdminDaoImpl();

	@Override
	public boolean admin_login(Admin admin) {
		return dao.admin_login(admin);
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		return dao.addHotel(hotel);
	}

	@Override
	public boolean updateHotel(Hotel hotel) {
		return dao.updateHotel(hotel);
	}

	@Override
	public boolean deleteHotel(String phno) {
		return dao.deleteHotel(phno);
	}

	@Override
	public List<Hotel> selectHotel() {
		return dao.selectHotel();
	}

	@Override
	public List<BookingDetails> selectBookingDetails() {
		return dao.selectBookingDetails();
	}

	@Override
	public boolean cancelBooking(BookingDetails bd) {
		return dao.cancelBooking(bd);
	}

	@Override
	public boolean cancelBookingOrders(BookingDetails bd) {
		return dao.cancelBookingOrders(bd);
	}

	@Override
	public List<BookingDetails> cancel_request_order() {
		return dao.cancel_request_order();
	}

	@Override
	public List<Customers> getCustomers() {
		return dao.getCustomers();
	}

}
