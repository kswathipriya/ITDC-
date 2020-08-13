package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Admin;
import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;

public interface IAdminDao {

	boolean admin_login(Admin admin);

	boolean addHotel(Hotel hotel);

	boolean updateHotel(Hotel hotel);

	boolean deleteHotel(String phno);

	List<Hotel> selectHotel();

	List<BookingDetails> selectBookingDetails();

	boolean cancelBooking(BookingDetails bd);

	boolean cancelBookingOrders(BookingDetails bd);

	List<BookingDetails> cancel_request_order();

	List<Customers> getCustomers();

}
