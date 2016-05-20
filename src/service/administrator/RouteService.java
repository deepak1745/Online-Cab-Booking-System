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

import bean.RouteBean;
import bean.RouteBean;
import dao.administrator.RouteDao;
@Component
public class RouteService {
	@Autowired
	RouteDao dao;
	public String addRoute(RouteBean routebean){
		if(routebean==null)
			return "FAIL";
		else if(routebean.getRoute_id()==null){
			return "FAIL";
		}
			else
			{
				return dao.addRoute(routebean);
			}
		}

	public RouteBean ViewRoute(String route_id){

		return dao.ViewRoute(route_id);
	}

	public String ModifyRoute(RouteBean routebean){
		return dao.ModifyRoute(routebean);

	}
	public String ConfirmDeleteRoute(RouteBean routebean){

		return dao.ConfirmDeleteRoute(routebean);
	}
	public List<RouteBean> displayall()
	{
		return dao.displayall();
	}
}
