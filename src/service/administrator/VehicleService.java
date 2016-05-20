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

package service.administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.VehicleBean;
import dao.administrator.VehicleDao;

@Component
public class VehicleService {
	@Autowired
	VehicleDao dao;
	public String addVehicle(VehicleBean vehiclebean){
		if(vehiclebean==null)
			return "FAIL";
		else if(vehiclebean.getVehicleNumber()==null){
			return "FAIL";
		}
			else
			{
				return dao.addVehicle(vehiclebean);
			}
		}


	public VehicleBean ViewVehicle(String vehiclenumber){

		return dao.ViewVehicle(vehiclenumber);
	}

public String ModifyVehicle(VehicleBean vehiclebean){
		return dao.ModifyVehicle(vehiclebean);

	}


public String ConfirmDeleteVehicle(VehicleBean vehiclebean){

	return dao.ConfirmDeleteVehicle(vehiclebean);
}

public List<VehicleBean> displayall()
{
	return dao.displayall();
}

	}
