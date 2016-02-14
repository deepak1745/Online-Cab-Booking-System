package com.wipro.ata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="ata_tbl_driver_address")
public class DriverAddressBean 
{
		@Id
		@Column(name="driver_id",length=20)
		private String driverid;
        @Column(name="house_number",length=20)
        private int houseNumber;
        @Column(name="first_line_of_address" ,length=20)
	    private String firstLineOfAddress;
        @Column(name="second_Line_Of_Address",length=20)
        private String  secondLineOfAddress;
        @Column(name="city",length=20)
		private String city;
        @Column(name="state",length=20)
		private String state;
        @Column(name="pin_code",length=20)
		private String pinCode;
		
        public String getDriverid() {
			return driverid;
		}
		public void setDriverid(String driverid) {
			this.driverid = driverid;
		}
		public int getHouseNumber() {
			return houseNumber;
		}
		public void setHouseNumber(int housenumber) {
			this.houseNumber = housenumber;
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
