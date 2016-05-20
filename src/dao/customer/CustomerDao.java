/*Copyright 2016 Deepak Kumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
This code is written by Deepak Kumar */

package dao.customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.BookingBean;
import bean.CreditCardBean;
import bean.PaymentHistoryBean;
import bean.SearchBean;
import bean.VehicleBean;

@Component
public class CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	public ArrayList<Object[]> search(SearchBean searchbean) throws ParseException{

			 Session session=sessionFactory.openSession();
			    Transaction trx=null;
			    trx=session.beginTransaction();
			    DateFormat formatter ;
				  Date date;
				  formatter = new SimpleDateFormat("dd/MM/YYYY");
				  ArrayList<Object[]> vehicles;
				  if(!(searchbean.getVehicleType().isEmpty())&&!(searchbean.getVehicleName().isEmpty())){
			 Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_type=? and vehicle_name=?");
				  query.setDate(0, formatter.parse(searchbean.getJourneyDate()));
				  query.setString(1, searchbean.getVehicleType());
				  query.setString(2, searchbean.getVehicleName());
				//  System.out.println(searchbean.getVehicleType()+"   "+searchbean.getVehicleName());

				//  System.out.println("both not null");
				  vehicles= (ArrayList<Object[]>) query.list();
				  }

				  else if(searchbean.getVehicleType().isEmpty() && searchbean.getVehicleName().isEmpty()){
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?)");
					  query.setDate(0, formatter.parse(searchbean.getJourneyDate()));
					 // System.out.println("both null");
				vehicles= (ArrayList<Object[]>) query.list();
				  }

				  else if(searchbean.getVehicleType().isEmpty()){
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_name=?");
					  query.setDate(0, formatter.parse(searchbean.getJourneyDate()));
					 // System.out.println("name not null");
					  query.setString(1, searchbean.getVehicleName());

					  vehicles= (ArrayList<Object[]>) query.list();
				  }
				  else{
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_type=?");
					  query.setDate(0, formatter.parse(searchbean.getJourneyDate()));
					  query.setString(1, searchbean.getVehicleType());
					 // System.out.println("type not null");
					  vehicles= (ArrayList<Object[]>) query.list();
				  }

				   trx.commit();
				   session.close();
				   return vehicles;
	}

	public ArrayList<ArrayList<String>> sourceDestination(){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Query querysource = session.createSQLQuery("select source from ata_tbl_route");
	    ArrayList<String> sources = (ArrayList<String>) querysource.list();

	    Query querydestination = session.createSQLQuery("select destination from ata_tbl_route");
	    ArrayList<String> destinations = (ArrayList<String>) querydestination.list();
	    ArrayList<ArrayList<String>> sourceDestination = new ArrayList<ArrayList<String>>();
	    sourceDestination.add(sources);
	    sourceDestination.add(destinations);

	    return sourceDestination;

	}

	public ArrayList<Object[]> giveroutedetails(SearchBean searchbean){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    System.out.println("source"+searchbean.getSource());
	    System.out.println("dest"+searchbean.getDestination());

	    Query query = session.createSQLQuery("select distance,route_id from ata_tbl_route where source=? and destination=?");
	    query.setString(0,searchbean.getSource());
	    query.setString(1,searchbean.getDestination());
	    ArrayList<Object[]> routedetails = (ArrayList<Object[]>) query.list();
	    trx.commit();
		session.close();
	    return routedetails;

	}
	public VehicleBean getVehicle(String vid)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    VehicleBean vehiclebean=(VehicleBean)session.get(VehicleBean.class,vid);
	    return vehiclebean;

	}
	public String checkCreditCardDetails(CreditCardBean creditcardbean,HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();

	    CreditCardBean creditcardBean=(CreditCardBean)session.get(CreditCardBean.class,creditcardbean.getCreditCardNumber());
	    if(creditcardBean==null)
	    {
	    	System.out.println("null object");
	    	return "FAIL";
	    }
	    else if(creditcardBean.getValidFrom().equals(creditcardbean.getValidFrom()) && creditcardBean.getValidTo().equals(creditcardbean.getValidTo()))
	    {

	    	BookingBean bookingbean=(BookingBean) session1.getAttribute("bookingbean");
	    	session.save(bookingbean);
	    	System.out.println(bookingbean.getBookingid());
	    	PaymentHistoryBean history=new PaymentHistoryBean();
	    	history.setBookingId(bookingbean.getBookingid());
	    	history.setCreditCardNumber(creditcardbean.getCreditCardNumber());
	    	history.setModeOfPayment("credit card");
	    	history.setTotalFare(bookingbean.getFare());
	    	session.save(history);
	    	trx.commit();
			session.close();
	    	return "SUCCESS";

	    }
	    else
	    {
            //System.out.println(creditcardBean.getValidFrom());
           // System.out.println(creditcardbean.getValidFrom());
	    	//System.out.println("date doesn't matches");
	    	return "FAIL";
	    }



	}

	public String Cancellation (String bookingID,HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    BookingBean bookingbean=(BookingBean)session.get(BookingBean.class, bookingID);
	    if(bookingbean==null)
	    	return "FAIL";
	    else
	    {

	    	PaymentHistoryBean history=(PaymentHistoryBean) session.get(PaymentHistoryBean.class,bookingID);
	    	session1.setAttribute("history",history);
	    	session.delete(history);
	    	session.delete(bookingbean);
	    	trx.commit();
			session.close();
	    	return "SUCCESS";

	    }

	}
	public ArrayList<BookingBean>  bookinghistory(HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    String loginid=(String) session1.getAttribute("loginid");
	    Query query = session.createQuery("from ata_tbl_booking where login_id=?");
	    query.setString(0,loginid);

	    ArrayList<BookingBean> bookingbeans = (ArrayList <BookingBean>)query.list();
	    return bookingbeans;


	}
	  public BookingBean generateTicket(String bookingID)
	  {
		  Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    BookingBean bookingbean=(BookingBean)session.get(BookingBean.class, bookingID);
		    return bookingbean;
	  }
	  public ArrayList<BookingBean>  bookinghistorycustomers()
		{
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();

		    Query query = session.createQuery("from ata_tbl_booking");


		    ArrayList<BookingBean> bookingbeans = (ArrayList <BookingBean>)query.list();
		    return bookingbeans;


		}
}
