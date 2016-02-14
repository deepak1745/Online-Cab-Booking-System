package com.wipro.ata.service.administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.administrator.VehicleDao;

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
