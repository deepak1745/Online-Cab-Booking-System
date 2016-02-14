package com.wipro.ata.service.administrator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.DriverAddressBean;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.administrator.DriverDao;

@Component
public class DriverService {
	@Autowired 
	DriverDao dao;
	public String addDriver(DriverBean driverbean, DriverAddressBean dabean){
	
		if(driverbean==null||dabean==null)
			return "FAIL";
		 else if(driverbean.getFirstName()==null
				||driverbean.getLastName()==null
				||driverbean.getLicenseNumber()==null
				||driverbean.getContactNumber()==null
				||driverbean.getVehicleNumber()==null
				||dabean.getHouseNumber()==0
				||dabean.getFirstLineOfAddress()==null
				||dabean.getSecondLineOfAddress()==null
				||dabean.getCity()==null
			    ||dabean.getState()==null
			    ||dabean.getPinCode()==null){
			return "FAIL";
		}
			else
			{
				return dao.addDriver(driverbean,dabean);
			}
		}
	public Object[] viewDriver(String vehicleNumber){
		return dao.viewDriver(vehicleNumber);
	}
	
	
	public String modifyDriver(DriverBean driverbean, DriverAddressBean dabean){
		return dao.modifyDriver(driverbean, dabean);
	}
	
	public String deleteDriver(DriverBean driverbean, DriverAddressBean dabean){
		return dao.deleteDriver(driverbean, dabean);
	}
	public ArrayList<Object[]> displayall(){
		return dao.displayall();
	}
}
