package com.wipro.ata.dao.administrator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.DriverAddressBean;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.VehicleBean;
@Component
public class DriverDao {
	@Autowired
	SessionFactory sessionFactory;
		public String addDriver(DriverBean driverbean, DriverAddressBean dabean){
			Transaction trx=null;
			Session session;
			 try{
			 session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			    session.save(driverbean);
			    session.save(dabean);
			    trx.commit();
			    session.close();
			    }catch(Exception e)
			    {
			    	System.out.println(e);
			    	return "ERROR";
			    }
			   
			    return "SUCCESS";
}
		public Object[] viewDriver(String vehicleNumber){
			Object[] array = new Object[2]; 
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 DriverBean driverbean = (DriverBean) session.get(DriverBean.class, vehicleNumber);
			 if(driverbean==null){
				 return null;
			 }
			 else{
				 String id = driverbean.getDriverid();
				 DriverAddressBean dabean = (DriverAddressBean) session.get(DriverAddressBean.class, id);
				 array[0] = driverbean;
				 array[1] = dabean;
				 return array;
			 }
		}
		public String modifyDriver(DriverBean driverbean, DriverAddressBean dabean){
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 System.out.println(driverbean.getDriverid());
			 System.out.println(driverbean.getVehicleNumber());
			 System.out.println(dabean.getDriverid());
			 session.saveOrUpdate(driverbean);
			 session.saveOrUpdate(dabean);
			 trx.commit();
			 session.close();
			 return "SUCCESS";
		}
		
		public String deleteDriver(DriverBean driverbean, DriverAddressBean dabean){
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 session.delete(driverbean);
			 session.delete(dabean);
			 trx.commit();
			 session.close();
			 return "SUCCESS";
		}
		/*public Object[] viewDriver(){
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Query query=session.createQuery("from ata_tbl_driver");
		    List<DriverBean> drivers= query.list();
		    
		    Query queryAddress=session.createQuery("from ata_tbl_driver_address");
		    List<DriverAddressBean> driverAddress= query.list();
			return ;
		}*/
		public ArrayList<Object[]> displayall()
		{
			
			Object[] arraydriver = new Object[12];
		    Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    //Query query=session.createQuery("from DriverBean natural join DriverAddressBean");
		    //ArrayList<Object[]> listdriver = (ArrayList<Object[]>) query.list();
		    Query query= session.createSQLQuery("select * from ata_tbl_driver natural join ata_tbl_driver_address ");
		    ArrayList<Object[]> listdriver = (ArrayList<Object[]>) query.list();
		   return listdriver;
		    
		    
		}
		
}
