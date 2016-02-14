package com.wipro.ata.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.ata.bean.LoginBean;
import com.wipro.ata.bean.UserProfileBean;

@Component
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean validateUser(LoginBean loginbean) {
		LoginBean bean;
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    System.out.println(loginbean.getLogin_id());
		 try{
			 bean=(LoginBean) session.get(LoginBean.class,loginbean.getLogin_id());
		    
		 }catch(Exception e)
	 	  {return false;}
		 
		 
		 if(bean==null)
		return false;
		    else
		    { 
		    	if(bean.getPassword().equals(loginbean.getPassword()))
		    		return true;
		    	else
		    		return false;
		    }
		    
		   
	}

	
	
	
	
	

	public String getUserType(LoginBean loginbean) {
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();		    
		    LoginBean bean=(LoginBean) session.get(LoginBean.class,loginbean.getLogin_id());
		return bean.getUser_type();
	}	
	
	public String checkUser(LoginBean loginbean){
		LoginBean bean;
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    bean=(LoginBean) session.get(LoginBean.class,loginbean.getLogin_id());
		    if(bean==null)
		    	return "NOT_PRESENT";
		    else
		    	return "PRESENT";
		 
	}
	
	public String addNewUser(LoginBean loginbean){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.save(loginbean);
	    trx.commit();
	    session.close();
	    return "SUCCESS";
	}
	public String addNewUser(UserProfileBean upbean){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.save(upbean);
	    trx.commit();
	    session.close();
	    return "SUCCESS";
	}
	
}
