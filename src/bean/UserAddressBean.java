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

package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="ata_tbl_user_address")
public class UserAddressBean
{
        @Id
        @Column(name="login_id")
		private String loginid;
        @Column(name="house_number")
        private int houseNumber;
        @Column(name="first_line_of_address")
	    private String firstLineOfAddress;
        @Column(name="second_line_of_address")
        private String  secondLineOfAddress;
        @Column(name="city")
		private String city;
        @Column(name="state")
		private String state;
        @Column(name="pin_code")
		private String pinCode;
		public String getLoginid() {
			return loginid;
		}
		public void setLoginid(String loginid) {
			this.loginid = loginid;
		}
		public int getHouseNumber() {
			return houseNumber;
		}
		public void setHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
		}
		public String getFirstLineOfAddress() {
			return firstLineOfAddress;
		}
		public void setFirstLineOfAddress(String firstLineOfAddress) {
			this.firstLineOfAddress = firstLineOfAddress;
		}
		public String getSecondLineOfAddress() {
			return secondLineOfAddress;
		}
		public void setSecondLineOfAddress(String secondLineOfAddress) {
			this.secondLineOfAddress = secondLineOfAddress;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}

}
