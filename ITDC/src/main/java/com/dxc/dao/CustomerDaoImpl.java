package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.dxc.pojos.BookingDetails;
import com.dxc.pojos.Customers;
import com.dxc.pojos.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class CustomerDaoImpl implements ICustomerDao  {

	
	 static MongoCollection<Document> customercollection=null;
	 static MongoCollection<Document> hotelcollection=null;
	 static MongoCollection<Document> bdcollection=null;
	 static MongoCollection<Document> cancelbdcollection=null;
	 static
	 {
		MongoClient mongoClient=new MongoClient("Localhost",27017);
	    MongoDatabase mongoDatabase=mongoClient.getDatabase("itdc");
	    customercollection=mongoDatabase.getCollection("customer");
	    hotelcollection=mongoDatabase.getCollection("hotel");
	    bdcollection=mongoDatabase.getCollection("bookingdetails");
	    cancelbdcollection=mongoDatabase.getCollection("cancelbookingdetails");
	 }
	@Override
	public boolean registerCustomers(Customers cust) {
		Document cust1=new Document();
		cust1.append("phno", cust.getCno());
		cust1.append("name", cust.getName());
		cust1.append("password", cust.getPassword());
		cust1.append("city", cust.getCity());
		cust1.append("state", cust.getState());
		cust1.append("country", cust.getCountry());
		cust1.append("pincode", cust.getPincode());
		cust1.append("wallet", cust.getWallet());
		customercollection.insertOne(cust1);
		return true;
	}
	@Override
	public boolean loginCustomers(String name, String password) {
		 FindIterable<Document> cursor=customercollection.find();
		   MongoCursor<Document> itr=cursor.iterator();
		   while(itr.hasNext()) {
			  
			   String cname=null;
			   String cpassword=null;
			   
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
	    					if(i==2)
	    					{
	    						cname=arr1[1];
	    					}if(i==3)
	    					{
	    						
	    						cpassword=arr1[1];
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		if(name.equals(cname) && password.equals(cpassword))
	    		{
	    			return true;
	    			
	    		}
		   }
		   
		return false;
	}
	@Override
	public List<Hotel> getHotelList() {
		List<Hotel> list=new ArrayList<Hotel>();
		FindIterable<Document> cursor=hotelcollection.find();
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
	public List<Hotel> getHotelDetails(String phno) {
		List<Hotel> list=new ArrayList<Hotel>();
		Document phno1=new Document();
		phno1.append("phno", phno);
		FindIterable<Document> cursor=hotelcollection.find(phno1);
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
	public boolean payBill(BookingDetails bdetails) {
		
		Document bd=new Document();
		bd.append("cphno",  bdetails.getCphno());
		bd.append("hphno",  bdetails.getHphno());
		bd.append("Hname",  bdetails.getHname());
		bd.append("trent",  bdetails.getTrent());
		bd.append("days",   bdetails.getDays());
		bd.append("fdate",  bdetails.getFdate());
		bd.append("edate",  bdetails.getEdate());
		bd.append("wrooms", bdetails.getWrooms());
		bdcollection.insertOne(bd);
		
//-------------------------------------------------
		int avrooms=this.getAvailableRooms(bdetails.getHphno());
		System.out.println(avrooms);
		if(avrooms<bdetails.getWrooms())
		{
			return false;
		}
		avrooms=avrooms-bdetails.getWrooms();
		Document rfno=new Document();
		rfno.append("phno", bdetails.getHphno());
		
		Document hd=new Document();
		hd.append("$set", new Document("uvrooms",avrooms));
		
		hotelcollection.updateOne(rfno, hd);
//--------------------------------------------------
		double balance=this.availableBalance(bdetails.getCphno());
		
		if(balance<bdetails.getTrent())
		{
			return false;
		}
		balance=balance-bdetails.getTrent();
		Document rfno1=new Document();
		rfno1.append("phno", bdetails.getCphno());
		
		Document hd1=new Document();
		hd1.append("$set", new Document("wallet",balance));
		
		customercollection.updateOne(rfno1, hd1);
		
		return true;
	}
	
	public double availableBalance(String cphno) {
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
	private int getAvailableRooms(String hphno) {
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
	    						System.out.println(avrooms);
	    						return avrooms;
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    		
		   }
		return 0;
	}
	@Override
	public List<BookingDetails> pastBookings(String phno) {
		
		Document d=new Document();
		d.append("cphno", phno);
		
		List<BookingDetails> list=new ArrayList<BookingDetails>();
		FindIterable<Document> cursor=bdcollection.find(d);
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
		Document d=new Document();
		d.append("cphno", bd.getCphno());
		d.append("hphno", bd.getHphno());
		d.append("hname", bd.getHname());
		d.append("wrooms", bd.getWrooms());
		d.append("days",   bd.getDays());
		d.append("fdate",  bd.getFdate());
		d.append("edate",  bd.getEdate());
		d.append("trent", bd.getTrent());
		
		cancelbdcollection.insertOne(d);
		
		return true;
	}
	 
	 
}
