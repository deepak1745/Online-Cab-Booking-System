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

package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.LoginBean;
import bean.UserProfileBean;

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
