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

package controller;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import bean.LoginBean;
import bean.UserProfileBean;
import service.LoginService;



@Controller
public class Logincontroller {
	 @Autowired
	private LoginService login;

	 @RequestMapping(value="/",method = RequestMethod.GET)
	   public ModelAndView Login1() {
		   ModelAndView model = new ModelAndView("Login");
			return model;
	   }


	/*@RequestMapping(value="/",method = RequestMethod.GET)
	   public ModelAndView Login() {
		   ModelAndView model = new ModelAndView("Login");
			return model;
	   }*/

	 @RequestMapping(value="/login",method = RequestMethod.POST)
	   public ModelAndView login(LoginBean bean, HttpSession session ) {
		 String result=login.login(bean);
		 System.out.println(result);
		// ModelAndView model = new ModelAndView("Login");
		 if(result.equals("INVALID"))
		 {
			 ModelAndView model = new ModelAndView("Login");
			 model.addObject("message", "Login Id or password is not present");
			return model;
			}
		 else if(result.equals("A"))
		 {ModelAndView model = new ModelAndView("Admin");
         model.addObject("message", "Welcome Admin");
			return model;
			}
		 else
		 {
			 ModelAndView model = new ModelAndView("Customer");
	         model.addObject("message", "Welcome Customer");
	         session.setAttribute("loginid", bean.getLogin_id());
				return model;
		 }


	 }

	 @RequestMapping(value="/register",method = RequestMethod.GET)
	   public ModelAndView register() {
		   ModelAndView model = new ModelAndView("register");
			return model;
	   }

	 @RequestMapping(value="/registerMain",method = RequestMethod.POST)
	   public ModelAndView registerMain(@RequestParam Map<String,String> map) {
		  DateFormat formatter ;
		  Date date;

		  if(map.get("login_id").length()<6)
		  {
			  ModelAndView model = new ModelAndView("register");
				model.addObject("message", "please give input login_id more than 6 characters");
				return model;
		  }
		  if(map.get("password").length()<6)
		  {
			  ModelAndView model = new ModelAndView("register");
				model.addObject("message", "please give password more than 6 characters");
				return model;
		  }

		  formatter = new SimpleDateFormat("dd/MM/YYYY");
		  try {
			date=formatter.parse(map.get("dateOfBirth"));
		} catch (ParseException e) {
			ModelAndView model = new ModelAndView("register");
			model.addObject("message", "please give input in (dd/mm/yyyy) format");
			return model;

		}


		  if(map.get("password").equals(map.get("con_password"))==false){
			  ModelAndView model = new ModelAndView("register");
				model.addObject("warning", "Please make the password same");
				return model;
		  }


		  UserProfileBean upbean = new UserProfileBean();
		  upbean.setLogin_id(map.get("login_id"));
		  upbean.setFirstName(map.get("firstName"));
		  upbean.setLastName(map.get("lastName"));
		  upbean.setGender(map.get("gender"));
		  upbean.setDateOfBirth(date);
		  upbean.setMobileNumber(map.get("mobileNumber"));

		LoginBean loginbean = new LoginBean();
		loginbean.setLogin_id(map.get("login_id"));
		loginbean.setPassword(map.get("password"));
		loginbean.setUser_type(map.get("userType"));
		if(login.addNewUser(loginbean).equals("PRESENT")){
			 ModelAndView model = new ModelAndView("register");
				model.addObject("login_id_message", "login_id already present, choose another login_id");
				return model;
		}
		else{
			login.addNewUser(loginbean);
			login.addNewUser(upbean);
			ModelAndView model = new ModelAndView("Login");
			model.addObject("message", "You have successfully registered, Now Login to continue");
			return model;
		}


	   }
	 @RequestMapping(value="/logout",method = RequestMethod.GET)
	   public ModelAndView logOut(HttpSession session) {
		   ModelAndView model = new ModelAndView("Login");
		   session.invalidate();
		   model.addObject("message", "You have successfully logged out");
			return model;

	   }


	 }
