package com.wipro.ata.dao.administrator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.RouteBean;
@Component
public class RouteDao {
@Autowired
SessionFactory sessionFactory;
	public String addRoute(RouteBean routebean){
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Query query = session.createSQLQuery("select * from ata_tbl_route where source = ? and destination = ?");
		    
		    query.setString(0, routebean.getSource());
		    query.setString(1, routebean.getDestination());
		    ArrayList<Object> sameroutecheck = (ArrayList<Object>) query.list();
		    
		    if(sameroutecheck.size()>0){
		    	System.out.println(sameroutecheck);
		    	return "PRESENT";
		    }
		    
		   try{
			   session.save(routebean);
			   trx.commit();
			   session.close();
			   
			   return "SUCCESS";
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
			   return "FAIL";
		   }
	}
	public RouteBean ViewRoute(String routenumber){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    try{
	    return (RouteBean)session.get(RouteBean.class, routenumber);
	    }catch(Exception e)
	    {
	    	return null;    	
	    }
	   
	}
	public String ModifyRoute(RouteBean routebean){
		
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();	    
	    session.saveOrUpdate(routebean);
	    trx.commit();
		   session.close();
		   
		   return "SUCCESS";
		}
	public String ConfirmDeleteRoute(RouteBean routebean){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.delete(routebean);
	    trx.commit();
		   session.close();
		   return "SUCCESS";
	}
	public List<RouteBean> displayall()
	{
	    Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Query query=session.createQuery("from ata_tbl_route");
	    List<RouteBean> routes= query.list();
		return routes;
	}
}