package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.dxc.pojos.Admin;
import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AdminDaoImpl implements IAdminDao {

	 static MongoCollection<Document> admincollection=null;
	 static MongoCollection<Document> customercollection=null;
	 static MongoCollection<Document> hotelcollection=null;
	 static MongoCollection<Document> bdcollection=null;
	 static MongoCollection<Document> cancelbdcollection=null;
	 static
	 {
		MongoClient mongoClient=new MongoClient("Localhost",27017);
	    MongoDatabase mongoDatabase=mongoClient.getDatabase("itdc");
	    admincollection=mongoDatabase.getCollection("admin");
	    customercollection=mongoDatabase.getCollection("customer");
	    hotelcollection=mongoDatabase.getCollection("hotel");
	    bdcollection=mongoDatabase.getCollection("bookingdetails");
	    cancelbdcollection=mongoDatabase.getCollection("cancelbookingdetails");
	    
	    FindIterable<Document> cursor=admincollection.find();
	    MongoCursor<Document> itr=cursor.iterator();
	    if(itr.hasNext()==false)
	    {
	    	Document d=new Document();
			d.append("name", "admin");
			d.append("password", "adminpass");
			admincollection.insertOne(d);
			System.out.println("Successfully admin added");
	    }
	 }
	@Override
	public boolean admin_login(Admin admin) {
		 FindIterable<Document> cursor=admincollection.find();
		   MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
			  
			   String name=null;
			   String password=null;
			   
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=0; j<tokens.length; j++)
	    		{
	    			if(j%4!=0)
	    			{
	    				int z=0;
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==1)
	    					{
	    						name=arr1[1];
	    					}if(i==2)
	    					{
	    						String str2=arr1[1];
		    					String arr2[]=str2.split("[}]", 0);
	    						password=arr2[0];
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		if(name.equals(admin.getName()) && password.equals(admin.getPassword()))
	    		{
	    			return true;
	    			
	    		}
		   }
		   
		return false;
	}
	@Override
	public boolean addHotel(Hotel hotel) {
		Document h1=new Document();
		h1.append("hname", hotel.getHname());
		h1.append("phno", hotel.getPhno());
		h1.append("flatno", hotel.getFlatno());
		h1.append("city", hotel.getCity());
		h1.append("state", hotel.getState());
		h1.append("website", hotel.getWebsite());
		h1.append("country", hotel.getCountry());
		h1.append("pincode", hotel.getPincode());
		h1.append("trooms", hotel.getTrooms());
		h1.append("uvrooms", hotel.getUvrooms());
		h1.append("rent", hotel.getRent());
		
		hotelcollection.insertOne(h1);
		return true;
	}
	@Override
	public boolean updateHotel(Hotel hotel) {
		
		System.out.println(hotel.getUvrooms());
		Document d=new Document();
		d.append("phno", hotel.getPhno());
		
		Document d1=new Document();
		
		d1.append("$set", new Document("hname",hotel.getHname()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("flatno",hotel.getFlatno()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("city",hotel.getCity()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("state",hotel.getState()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("website",hotel.getWebsite()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("country",hotel.getCountry()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("pincode",hotel.getPincode()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("trooms",hotel.getTrooms()));
		hotelcollection.updateOne(d, d1);
		
		System.out.println(hotel.getUvrooms());
		d1.append("$set", new Document("uvrooms",hotel.getUvrooms()));
		hotelcollection.updateOne(d, d1);
		
		d1.append("$set", new Document("rent",hotel.getRent()));
		hotelcollection.updateOne(d, d1);
		
		return true;
	}
	
	
	@Override
	public boolean deleteHotel(String phno) {
		Document d=new Document();
		d.append("phno", phno);
		
		hotelcollection.deleteOne(d);
		return true;
	}
	
	
	
	
	@Override
	public List<Hotel> selectHotel() {
		List<Hotel> list=new ArrayList<Hotel>();
		FindIterable<Document> cursor=hotelcollection.find();
		MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
				Hotel h=new Hotel();
				
			   String str=itr.next().toString();
			   System.out.println(str);
			   String []tokens=str.split(",");
	    		for(int j=1; j<tokens.length; j++)
	    		{
	    			if(j%12!=0)
	    			{
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==1)
	    					{
	    						h.setHname(arr1[1]);
	    					}else if(i==2)
	    					{
	    						h.setPhno(arr1[1]);
	    					}else if(i==3)
	    					{
	    						h.setFlatno(arr1[1]);
	    					}else if(i==4)
	    					{
	    						h.setCity(arr1[1]);
	    					}else if(i==5)
	    					{
	    						h.setState(arr1[1]);
	    					}else if(i==6)
	    					{
	    						h.setWebsite(arr1[1]);
	    					}else if(i==7)
	    					{
	    						h.setCountry(arr1[1]);
	    					}else if(i==8)
	    					{
	    						h.setPincode(Integer.parseInt(arr1[1]));
	    					}else if(i==9)
	    					{
	    						h.setTrooms(Integer.parseInt(arr1[1]));
	    					}else if(i==10)
	    					{
	    						h.setUvrooms(Integer.parseInt(arr1[1]));
	    					}else if(i==11)
	    					{
	    						String str2=arr1[1].toString();
		    					String arr2[]=str2.split("[}]", 0);
		    					h.setRent(Double.parseDouble(arr2[0]));
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		list.add(h);
		   }
		return list;
	}
	@Override
	public List<BookingDetails> selectBookingDetails() {
		List<BookingDetails> list=new ArrayList<BookingDetails>();
		FindIterable<Document> cursor=bdcollection.find();
		MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
				BookingDetails bd=new BookingDetails();
				
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=1; j<tokens.length; j++)
	    		{
	    			if(j%11!=0)
	    			{
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==1)
	    					{
	    						bd.setCphno(arr1[1]);
	    					}else if(i==2)
	    					{
	    						bd.setHphno(arr1[1]);
	    					}else if(i==3)
	    					{
	    						bd.setHname(arr1[1]);
	    					}else if(i==4)
	    					{
	    						bd.setTrent(Double.parseDouble(arr1[1]));
	    					}
	    					else if(i==5)
	    					{
	    						bd.setDays(Integer.parseInt(arr1[1]));
	    					}
	    					else if(i==6)
	    					{
	    						bd.setFdate(arr1[1]);
	    					}
	    					else if(i==7)
	    					{
	    						bd.setEdate(arr1[1]);
	    					}else if(i==8)
	    					{
	    						String str2=arr1[1].toString();
		    					String arr2[]=str2.split("[}]", 0);
		    					bd.setWrooms(Integer.parseInt(arr2[0]));
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		list.add(bd);
		   }
		return list;
	}
	
	
	
	
	@Override
	public boolean cancelBooking(BookingDetails bd) {
		try {
			int rooms=this.getRooms(bd.getHphno());
			System.out.println(rooms);
			rooms=rooms+bd.getWrooms();
			
			Document rfno=new Document();
			rfno.append("phno", bd.getHphno());
			
			Document hd=new Document();
			hd.append("$set", new Document("uvrooms",rooms));
			
			hotelcollection.updateOne(rfno, hd);
			
			Document rem=new Document();
			rem.append("cphno", bd.getCphno());
			bdcollection.deleteOne(rem);
			
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	
	
	private double getBalance(String cphno) {
		 double balance=0;
		 Document d=new Document();
		 d.append("phno", cphno);
		 FindIterable<Document> cursor=customercollection.find(d);
		 MongoCursor<Document> itr=cursor.iterator();
		   
		   while(itr.hasNext()) {
			   
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=0; j<tokens.length; j++)
	    		{
	    			if(j%4!=0)
	    			{
	    				int z=0;
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==8)
	    					{
	    						String str2=arr1[1].toString();
		    					String arr2[]=str2.split("[}]", 0);
		    					
		    					balance=Double.parseDouble(arr2[0]);
	    						return balance;
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		
		   }
		   
		return balance;
	}
	
	
	
	private int getRooms(String hphno) {
	int avrooms=0;
		
		Document d=new Document();
		d.append("phno", hphno);
		
		FindIterable<Document> cursor=hotelcollection.find(d);
		MongoCursor<Document> itr=cursor.iterator();
		
		   while(itr.hasNext()) {
				Hotel h=new Hotel();
				
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=1; j<tokens.length; j++)
	    		{
	    			if(j%11!=0)
	    			{
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==10)
	    					{
	    						avrooms=Integer.parseInt(arr1[1]);
	    						return avrooms;
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		
		   }
		return avrooms;
	}
	@Override
	public boolean cancelBookingOrders(BookingDetails bd) {
		try {
			int rooms=this.getRooms(bd.getHphno());
			rooms=rooms+bd.getWrooms();
			
			Document rfno=new Document();
			rfno.append("phno", bd.getHphno());
			
			Document hd=new Document();
			hd.append("$set", new Document("uvrooms",rooms));
			
			hotelcollection.updateOne(rfno, hd);
			
	       //-------------------------------------------
			
			double balance=this.getBalance(bd.getCphno());
			balance=balance+bd.getTrent();
			
			Document rfno1=new Document();
			rfno1.append("phno", bd.getCphno());
			
			Document hd1=new Document();
			hd1.append("$set", new Document("wallet",balance));
			
			customercollection.updateOne(rfno1, hd1);
			//-----------------------------
			Document rem=new Document();
			rem.append("cphno", bd.getCphno());
			cancelbdcollection.deleteOne(rem);
			
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	@Override
	public List<BookingDetails> cancel_request_order() {
		List<BookingDetails> list=new ArrayList<BookingDetails>();
		FindIterable<Document> cursor=cancelbdcollection.find();
		MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
				BookingDetails bd=new BookingDetails();
				
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=1; j<tokens.length; j++)
	    		{
	    			if(j%11!=0)
	    			{
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==1)
	    					{
	    						bd.setCphno(arr1[1]);
	    					}else if(i==2)
	    					{
	    						bd.setHphno(arr1[1]);
	    					}else if(i==3)
	    					{
	    						bd.setHname(arr1[1]);
	    					}else if(i==4)
	    					{
	    						bd.setWrooms(Integer.parseInt(arr1[1]));
	    						
	    					}
	    					else if(i==5)
	    					{
	    						bd.setDays(Integer.parseInt(arr1[1]));
	    					}
	    					else if(i==6)
	    					{
	    						bd.setFdate(arr1[1]);
	    					}
	    					else if(i==7)
	    					{
	    						bd.setEdate(arr1[1]);
	    					}else if(i==8)
	    					{
	    						String str2=arr1[1].toString();
		    					String arr2[]=str2.split("[}]", 0);
		    					bd.setTrent(Double.parseDouble(arr2[0]));
		    					
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		list.add(bd);
		   }
		return list;
	}
	
	@Override
	public List<Customers> getCustomers() {
		
		List<Customers> list=new ArrayList<>();
		 FindIterable<Document> cursor=customercollection.find();
		   MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
			  Customers cust=new Customers();
			   
			   String str=itr.next().toString();
			   String []tokens=str.split(",");
	    		for(int j=0; j<tokens.length; j++)
	    		{
	    			if(j%4!=0)
	    			{
	    				int z=0;
	    				String []subtokens= tokens;
	    				for(int i=1;i<subtokens.length;i++)
	    				{
	    					String arr1[]=subtokens[i].split("=");
	    					if(i==1)
	    					{
	    						cust.setCno(arr1[1]);
	    					}
	    					else if(i==2)
	    					{
	    						cust.setName(arr1[1]);
	    					}else if(i==3)
	    					{
	    						cust.setPassword(arr1[1]);
	    					}
	    					else if(i==4)
	    					{
	    						cust.setCity(arr1[1]);
	    					}
	    					else if(i==5)
	    					{
	    						cust.setState(arr1[1]);
	    					}else if(i==6)
	    					{
	    						cust.setCountry(arr1[1]);
	    					}else if(i==7)
	    					{
	    						cust.setPincode(Integer.parseInt(arr1[1]));
	    					}else if(i==8)
	    					{
	    						String str2=arr1[1].toString();
		    					String arr2[]=str2.split("[}]", 0);
		    					cust.setWallet(Double.parseDouble(arr2[0]));
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		list.add(cust);
		   }
		   
		return list;
	}
	
	
}
