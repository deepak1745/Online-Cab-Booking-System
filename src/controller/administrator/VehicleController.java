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

//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.VehicleBean;
import service.administrator.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	VehicleService vehicleservice;


	@RequestMapping(value="/home",method = RequestMethod.GET)
	   public ModelAndView home() {
		   ModelAndView model = new ModelAndView("Admin");
			return model;
	   }


	 @RequestMapping(value="/AddVehicle",method = RequestMethod.GET)
	   public ModelAndView addVehicle() {
		   ModelAndView model = new ModelAndView("AddVehicle");
			return model;
	   }


	 @RequestMapping(value="/vehiclemain",method = RequestMethod.POST)
	   public ModelAndView addVehicleMain(VehicleBean vehiclebean) {
		 if(vehicleservice.addVehicle(vehiclebean).equals("SUCCESS")){
			 ModelAndView model = new ModelAndView("Admin");
			 model.addObject("Warning", "Successfully Added");
				return model;
		 }
		 else
		 {
			 ModelAndView model = new ModelAndView("AddVehicle");
			 model.addObject("Warning", "Could not be added");
			 return model;
		 }

	   }

	  @RequestMapping(value="/ModifyVehicle",method = RequestMethod.GET)
	   public ModelAndView ModifyVehicle() {
		   ModelAndView model = new ModelAndView("ModifyVehicle");
			return model;
	   }
	  @RequestMapping(value="/modifymain",method = RequestMethod.GET)
	   public ModelAndView modifymain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("vehicleNumber"));
		  if(vehicleservice.ViewVehicle(map.get("vehicleNumber"))!=null)
		  {
			  ModelAndView model = new ModelAndView("ModifyVehicleMain");
			  model.addObject("vehicle", vehicleservice.ViewVehicle(map.get("vehicleNumber")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("ModifyVehicle");
		   model.addObject("warning", "vehicle number not present");
			return model;
			}
	   }
	  @RequestMapping(value="/FinalModifyVehicle",method = RequestMethod.POST)
	  public ModelAndView FinalModifyVehicle(VehicleBean vehiclebean) {
		  if(vehicleservice.ModifyVehicle(vehiclebean).equals("SUCCESS"))
		  {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Modified");
					return model;
		  }
		  else
			  return null;

	  }


	  @RequestMapping(value="/Delete",method = RequestMethod.GET)
	   public ModelAndView deleteVehicle() {
		   ModelAndView model = new ModelAndView("DeleteVehicle");
			return model;
	   }


	  @RequestMapping(value="/deletemain",method = RequestMethod.GET)
	   public ModelAndView deletemain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("vehicleNumber"));
		  if(vehicleservice.ViewVehicle(map.get("vehicleNumber"))!=null)
		  {
			  ModelAndView model = new ModelAndView("DeleteVehicleMain");
			  model.addObject("vehicle", vehicleservice.ViewVehicle(map.get("vehicleNumber")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("DeleteVehicle");
		   model.addObject("warning", "vehicle number to be deleted not present");
			return model;
			}
	   }




	  @RequestMapping(value="/ConfirmDeleteVehicle",method = RequestMethod.POST)
	   public ModelAndView ConfirmdeleteVehicle(VehicleBean vehiclebean) {
		  if(vehicleservice.ConfirmDeleteVehicle(vehiclebean).equals("SUCCESS"))
		   {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Deleted");
					return model;
		   }
		  else
			  return null;
		  }

	  @RequestMapping(value="/ViewAll",method = RequestMethod.GET)
	  public ModelAndView viewAll()
	  {
		  ModelAndView model = new ModelAndView("Displayall");
		  List<VehicleBean> l=vehicleservice.displayall();
		  model.addObject("dlist", l);
			return model;
	  }

}
