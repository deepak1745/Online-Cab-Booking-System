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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.RouteBean;
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
