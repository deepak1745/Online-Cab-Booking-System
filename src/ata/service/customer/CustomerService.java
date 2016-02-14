package com.wipro.ata.service.customer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.BookingBean;
import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.SearchBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.customer.CustomerDao;

@Component
public class CustomerService {
	
		@Autowired
		CustomerDao dao;
		
		public ArrayList<Object[]> search(SearchBean searchbean) throws ParseException{
			//System.out.println(searchbean.getSource());
			if(searchbean.getSource()==null||searchbean.getDestination()==null){
				return null;
			}
			else if(searchbean.getSource().equals(searchbean.getDestination())){
				return null;
			}
			else
			return dao.search(searchbean);
		}
		
		public ArrayList<ArrayList<String>> sourceDestination(){
			return dao.sourceDestination();
		}
		
		public ArrayList<Object[]> giveroutedetails(SearchBean searchbean){
			return dao.giveroutedetails(searchbean);
		}
		public VehicleBean getVehicle(String vid)
		{
			return dao.getVehicle(vid);
		}
		public String checkCreditCardDetails(CreditCardBean creditcardbean,HttpSession session)
		{
			return dao.checkCreditCardDetails(creditcardbean,session);
		}
		
		public String Cancellation (String bookingID,HttpSession session1)
		{
			return dao.Cancellation(bookingID,session1);
		}
		public ArrayList<BookingBean>  bookinghistory(HttpSession session1)
		{
			return dao.bookinghistory(session1);
		}
		 public BookingBean generateTicket(String bookingID)
		  {
		      return dao.generateTicket(bookingID);
		  }
		 public ArrayList<BookingBean>  bookinghistorycustomers()
			
		 {
			 return dao.bookinghistorycustomers();
		 }
}
