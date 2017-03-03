package olivia.com.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	@Id
	String id;
	String psngrName;
	String destination;
	String depature;
	Date travelDate;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPsngrName() {
		return psngrName;
	}
	
	public void setPsngrName(String psngrName) {
		this.psngrName = psngrName;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDepature() {
		return depature;
	}
	
	public void setDepature(String depature) {
		this.depature = depature;
	}
	
	public Date getTravelDate() {
		return travelDate;
	}
	
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
}
