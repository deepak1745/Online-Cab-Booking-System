package com.wipro.ata.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ata_tbl_vehicle")
public class VehicleBean {
	@Column(name="vehicle_name")
	private String vehicleName;
	@Id
	@Column(name="vehicle_number")
	private String vehicleNumber;
	@Column(name="seating_capacity")
	private int seatingCapacity;
	@Column(name="vehicle_type")
	private String vehicleType;
	@Column(name="fare_per_km")
	private float farePerKM;
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public float getFarePerKM() {
		return farePerKM;
	}
	public void setFarePerKM(float farePerKM) {
		this.farePerKM = farePerKM;
	}
	
}
