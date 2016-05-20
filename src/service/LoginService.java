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

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.LoginBean;
import bean.UserProfileBean;
import dao.LoginDao;
@Component
public class LoginService {
    @Autowired
	private LoginDao dao;
	public String login(LoginBean bean) {
		boolean b;
		String temp;
		if(bean==null)
			return "INVALID";
		else if(bean.getLogin_id()==null || bean.getPassword()==null)
			return "INVALID";
		else
			b=dao.validateUser(bean);

		if(b==false)
			return "INVALID";
		else
			{
			temp=dao.getUserType(bean);
		   return temp;
		}

	}

	public String addNewUser(LoginBean loginbean){
		String result = dao.checkUser(loginbean);
		if(result.equals("NOT_PRESENT"))
		{
			return dao.addNewUser(loginbean);

		}
		else
			return "PRESENT";
	}
	public String addNewUser(UserProfileBean upbean){
		return dao.addNewUser(upbean);
	}

	}
