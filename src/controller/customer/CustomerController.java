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

package controller.customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.BookingBean;
import bean.CreditCardBean;
import bean.SearchBean;
import bean.VehicleBean;
import service.customer.CustomerService;

@Controller
public class CustomerController {



		@Autowired
		CustomerService customerservice;
		@Autowired
		private DataFieldMaxValueIncrementer incrementer2;

		@RequestMapping(value="/customerhome",method = RequestMethod.GET)
		   public ModelAndView home() {
			   ModelAndView model = new ModelAndView("Customer");
				return model;
		   }
		@RequestMapping(value="/BookVehicleNow",method = RequestMethod.GET)
		   public ModelAndView bookvehiclenow() {
			ArrayList<ArrayList<String>> sourceDestination = customerservice.sourceDestination();
			   ModelAndView model = new ModelAndView("BookVehicleNow");

			   model.addObject("sourceDestination", sourceDestination);
				return model;
		   }


		@RequestMapping(value="/search",method = RequestMethod.POST)
		   public ModelAndView search(SearchBean searchbean,HttpSession session) {

			System.out.println("date is "+searchbean.getJourneyDate());

			 DateFormat formatter ;
			  Date date;
			  formatter = new SimpleDateFormat("dd/MM/YYYY");
			try{  if(searchbean.getJourneyDate().isEmpty())
			  {
				  ModelAndView model = new ModelAndView("BookVehicleNow");
					model.addObject("message", "please give journey a date");
					return model;
			  }}catch(Exception e)
			  {
				  ModelAndView model = new ModelAndView("BookVehicleNow");
					model.addObject("message", "please give input in (dd/mm/yyyy) format");
					return model;
			  }
			 // System.out.println(searchbean.getDestination());

			//System.out.println("prem "+searchbean.getDestination());
			  try {
				date=formatter.parse(searchbean.getJourneyDate());
			} catch (ParseException e) {
				ModelAndView model = new ModelAndView("BookVehicleNow");
				model.addObject("message", "please give input in (dd/mm/yyyy) format");
				return model;

			}
			  session.setAttribute("searchbean",searchbean);
			  ArrayList<Object[]> vehiclebeans=new ArrayList<Object[]>();
			  try {
				vehiclebeans = customerservice.search(searchbean);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				ModelAndView model = new ModelAndView("BookVehicleNow");
				model.addObject("message", "please give input in (dd/mm/yyyy) format");
				return model;
			}
			  if(vehiclebeans==null){
				  ModelAndView model = new ModelAndView("BookVehicleNow");
					model.addObject("warning", "Please Provide Correct Source & Destination");
					return model;
			  }
			  //System.out.println(vehiclebeans.size());
			  if(vehiclebeans.size()==0){
				  ModelAndView model = new ModelAndView("BookVehicleNow");
					model.addObject("warning", "Sorry! vehicle with such specifications is not present, Please try another search");
					return model;
			  }
			  else{
				  /*for (Iterator iterator=vehiclebeans.iterator(); iterator.hasNext();)
				  {
				  	Object[] vehicle=(Object[])iterator.next();
				  	System.out.println(vehicle[0]);
				  }*/
				  ModelAndView model = new ModelAndView("SearchResults");
				  //model.addObject("search", searchbean);
				  model.addObject("dlist", vehiclebeans);
					return model;
			  }
		}

		@RequestMapping(value="/BookTicket",method = RequestMethod.GET)
		   public ModelAndView BookTicket(@RequestParam Map<String,Object> map,HttpSession session) {
			   ModelAndView model = new ModelAndView("ConfirmBook");
			   model.addObject("vehicledeatails",map.get("vid"));
			  String vehicleid=(String)map.get("vid");
			  VehicleBean vehiclebean=customerservice.getVehicle(vehicleid);
			   model.addObject("vehicledetails",vehiclebean);

			   SearchBean searchbean=(SearchBean)session.getAttribute("searchbean");

			   model.addObject("searchdetails",searchbean);
			   ArrayList<Object[]> routedetails = customerservice.giveroutedetails(searchbean);
			   model.addObject("routedetails",routedetails);
				return model;
		   }
		@RequestMapping(value="/FinalBook",method = RequestMethod.GET)
		   public ModelAndView FinalBook(BookingBean bookingbean, HttpSession session) throws ParseException {
			ModelAndView model = new ModelAndView("Gateway");
			Date date = Calendar.getInstance().getTime();

		    // Display a date in day, month, year format
		    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    String today = formatter.format(date);
		    //System.out.println("Today : " + today);
		    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MMM/yyyy");
		    Date date1 = formatter.parse(today);
			bookingbean.setBookingDate(date1);
			System.out.println(date1 +"  "+bookingbean.getJourneyDate());

			String loginid = (String)session.getAttribute("loginid");
			//System.out.println(loginid);
			bookingbean.setBookingid(loginid.substring(0,4)+((Long)(incrementer2.nextLongValue())).toString());
			bookingbean.setLoginid(loginid);
			session.setAttribute("bookingbean", bookingbean);
			return model;
		}
		@RequestMapping(value="/BookCheck",method = RequestMethod.GET)
		   public ModelAndView Bookcheck(@RequestParam Map<String,String> map,HttpSession session) throws ParseException {
			if(((String) map.get("creditCardNumber")).length()<16)
			{
				ModelAndView model = new ModelAndView("Gateway");
				model.addObject("message", "please enter 16 digit number ");
				return model;
			}

			//DateFormat formatter ;
			  Date datefrom,dateto;
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			  try {
				 // System.out.println("in controller"+map.get("validFrom"));
					datefrom=formatter.parse(map.get("validFrom"));
					dateto=formatter.parse(map.get("validTo"));
				} catch (ParseException e) {
					ModelAndView model = new ModelAndView("Gateway");
					model.addObject("message", "please give dates in (yyyy-MM-dd) format");
					return model;

		}
		CreditCardBean creditcardbean=new CreditCardBean();
		creditcardbean.setCreditCardNumber((String) map.get("creditCardNumber"));
		creditcardbean.setValidFrom(datefrom);
		creditcardbean.setValidTo(dateto);
		if(customerservice.checkCreditCardDetails(creditcardbean,session).equals("FAIL"))
		{
			ModelAndView model = new ModelAndView("Gateway");
			model.addObject("message", "Invalid Card Details");
			return model;

		}
		else
		{
			ModelAndView model = new ModelAndView("PaymentSuccess");
			model.addObject("message", "Payment Successful");
			return model;
		}
			}

		@RequestMapping(value="/Cancellation",method = RequestMethod.GET)
		 public ModelAndView Cancellation(@RequestParam Map<String,String> map)
		{
			ModelAndView model = new ModelAndView("Cancellation");
			return model;
		}

		@RequestMapping(value="/CancellationMain",method = RequestMethod.GET)
		 public ModelAndView CancellationMain(@RequestParam Map<String,String> map,HttpSession session)
		{
			String bookingID=map.get("bookingID");
			if(customerservice.Cancellation(bookingID,session).equals("FAIL"))
			{
				ModelAndView model = new ModelAndView("Cancellation");
				model.addObject("message", "Please enter a valid bookingID");
				return model;
			}
			else
			{
				ModelAndView model = new ModelAndView("CancellationSuccess");
				model.addObject("message", "Successful cancellation");
				return model;
			}

		}

		@RequestMapping(value="/BookingHistory",method = RequestMethod.GET)
		 public ModelAndView BookingHistory(HttpSession session)
		{
			ModelAndView model = new ModelAndView("BookingHistory");
			 ArrayList<BookingBean> bookingbeans=customerservice.bookinghistory(session);
			model.addObject("bookingbeans",bookingbeans);
			return model;
		}


		@RequestMapping(value="/PrintTicket",method = RequestMethod.GET)
		 public ModelAndView PrintTicket()
		{
			ModelAndView model = new ModelAndView("PrintTicket");


			return model;
		}


		@RequestMapping(value="/PrintTicketMain",method = RequestMethod.GET)
		 public ModelAndView PrintTicket(@RequestParam Map<String,String> map)
		{
			String bookingID=map.get("bookingID");
			BookingBean bookingbean=customerservice.generateTicket(bookingID);
			if(bookingbean==null)
			{
				ModelAndView model = new ModelAndView("PrintTicket");

				model.addObject("message","Please enter a valid booking id");
				return model;
			}
			else
			{
			    ModelAndView model = new ModelAndView("Ticket");

		        model.addObject("ticket", bookingbean);
			  return model;
			}
		}
		@RequestMapping(value="/BookedTicketsAll",method = RequestMethod.GET)
		 public ModelAndView BookedTicketsAll()
		{
			ModelAndView model = new ModelAndView("CustomerBookingHistory");
		 ArrayList<BookingBean> bookingbeans=customerservice.bookinghistorycustomers();
			model.addObject("bookingbeans",bookingbeans);
			return model;
		}



}
