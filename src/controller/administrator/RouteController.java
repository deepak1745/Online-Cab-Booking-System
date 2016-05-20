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

package controller.administrator;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.RouteBean;
import bean.RouteBean;
import service.administrator.RouteService;


@Controller
public class RouteController {
	@Autowired
	RouteService routeservice;
	@Autowired
	private DataFieldMaxValueIncrementer incrementer1;
	 @RequestMapping(value="/AddRoute",method = RequestMethod.GET)
	   public ModelAndView addRoute() {
		   ModelAndView model = new ModelAndView("AddRoute");
			return model;
	   }
	 @RequestMapping(value="/routemain",method = RequestMethod.POST)
	   public ModelAndView addRouteMain(RouteBean routebean) {
		 if(routebean.getSource()==null||routebean.getSource().length()<2||routebean.getDestination()==null||routebean.getDestination().length()<2)
				 { ModelAndView model = new ModelAndView("AddRoute");
		 model.addObject("Warning", "Please enter valid source and destination of at least 2 characters");
		 return model;}
		 routebean.setRoute_id(routebean.getSource().substring(0,2)+routebean.getDestination().substring(0,2)+((Long)(incrementer1.nextLongValue())).toString());
		 if(routeservice.addRoute(routebean).equals("SUCCESS")){
			 ModelAndView model = new ModelAndView("Admin");
			 model.addObject("Warning", "Successfully Added");
				return model;
		 }
		 else if(routeservice.addRoute(routebean).equals("PRESENT")){

			 ModelAndView model = new ModelAndView("AddRoute");
			 model.addObject("Warning", "This combinaion of source and destination is already present");
			 return model;
		 }
		 else
		 {
			 ModelAndView model = new ModelAndView("AddRoute");
			 model.addObject("Warning", "Could not be added");
			 return model;
		 }

	   }

	 @RequestMapping(value="/ModifyRoute",method = RequestMethod.GET)
	   public ModelAndView ModifyRoute() {
		   ModelAndView model = new ModelAndView("ModifyRoute");
			return model;
	   }
	  @RequestMapping(value="/modifymainroute",method = RequestMethod.GET)
	   public ModelAndView modifymain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("route_id"));
		  if(routeservice.ViewRoute(map.get("route_id"))!=null)
		  {
			  ModelAndView model = new ModelAndView("ModifyRouteMain");
			  model.addObject("route", routeservice.ViewRoute(map.get("route_id")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("ModifyRoute");
		   model.addObject("warning", "route not present");
			return model;
			}
	   }
	  @RequestMapping(value="/FinalModifyRoute",method = RequestMethod.POST)
	  public ModelAndView FinalModifyRoute(RouteBean routebean) {
		  if(routeservice.ModifyRoute(routebean).equals("SUCCESS"))
		  {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Modified");
					return model;
		  }
		  else
			  return null;

	  }


	  @RequestMapping(value="/DeleteRoute",method = RequestMethod.GET)
	   public ModelAndView deleteRoute() {
		   ModelAndView model = new ModelAndView("DeleteRoute");
			return model;
	   }


	  @RequestMapping(value="/deletemainroute",method = RequestMethod.GET)
	   public ModelAndView deletemain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("route_id"));
		  if(routeservice.ViewRoute(map.get("route_id"))!=null)
		  {
			  ModelAndView model = new ModelAndView("DeleteRouteMain");
			  model.addObject("route", routeservice.ViewRoute(map.get("route_id")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("DeleteRoute");
		   model.addObject("warning", "route number to be deleted not present");
			return model;
			}
	   }




	  @RequestMapping(value="/ConfirmDeleteRoute",method = RequestMethod.POST)
	   public ModelAndView ConfirmdeleteRoute(RouteBean routebean) {
		  if(routeservice.ConfirmDeleteRoute(routebean).equals("SUCCESS"))
		   {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Deleted");
					return model;
		   }
		  else
			  return null;
		  }

	  @RequestMapping(value="/ViewAllRoute",method = RequestMethod.GET)
	  public ModelAndView viewAll()
	  {
		  ModelAndView model = new ModelAndView("Displayallroute");
		  List<RouteBean> l=routeservice.displayall();
		  model.addObject("dlist", l);
			return model;
	  }
}
