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

package dao.administrator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.VehicleBean;
@Component
public class VehicleDao {
@Autowired
SessionFactory sessionFactory;
	public String addVehicle(VehicleBean vehiclebean){
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		   try{
			   session.save(vehiclebean);
			   trx.commit();
			   session.close();
			   return "SUCCESS";
		   }
		   catch(Exception e){
			   return "FAIL";
		   }
	}

	public VehicleBean ViewVehicle(String vehiclenumber){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    try{
	    return (VehicleBean)session.get(VehicleBean.class, vehiclenumber);
	    }catch(Exception e)
	    {
	    	return null;
	    }

	}

public String ModifyVehicle(VehicleBean vehiclebean){

	Session session=sessionFactory.openSession();
    Transaction trx=null;
    trx=session.beginTransaction();
    session.saveOrUpdate(vehiclebean);
    trx.commit();
	   session.close();
	   return "SUCCESS";
	}

public String ConfirmDeleteVehicle(VehicleBean vehiclebean){
	Session session=sessionFactory.openSession();
    Transaction trx=null;
    trx=session.beginTransaction();
    session.delete(vehiclebean);
    trx.commit();
	   session.close();
	   return "SUCCESS";
}


public List<VehicleBean> displayall()
{
    Session session=sessionFactory.openSession();
    Transaction trx=null;
    trx=session.beginTransaction();
    Query query=session.createQuery("from ata_tbl_vehicle");
    List<VehicleBean> vehicles= query.list();
	return vehicles;
}

}
