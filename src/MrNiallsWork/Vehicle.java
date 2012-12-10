package MrNeilsWork;

import java.util.Calendar;


public class Vehicle implements Comparable
{
	public int compareTo(Object arg0) 
	{
		if(arg0 instanceof Vehicle)
		{
			Vehicle v = (Vehicle)arg0;
			
	  if(this.getManufactureDate().before(v.getManufactureDate()))
				return -1;
	  else if(this.getManufactureDate().after(v.getManufactureDate()))
		  return 1;
	  else
		  return 0;
			
			
			
			
			/*
			if(!this.isDiesel() && v.isDiesel())
				return -1;
			else if(this.isDiesel() && !v.isDiesel())
				return 1;
			else	
				return 0;
			*/	
				
			//this compareTo belongs to String::compareTo()
	//return this.licenceNumber.compareTo(v.getLicenceNumber());
			/*
		if(this.engineSize - v.getEngineSize() < 0)
			return -1;
		else if(this.engineSize - v.getEngineSize() > 0)
			return 1;
		else
			return 0;
			*/
			
			
			
			
			
			
		}
		return 0;
	}
	
	
	private String licenceNumber, owner;
	private float engineSize;
	private boolean isDiesel;
	private Calendar manufactureDate;
	
	public Vehicle(String licenceNumber, String owner, 
			float engineSize, boolean isDiesel,
			MyDate myManufactureDate) 
	{
		this.manufactureDate = myManufactureDate.getCalendar();
		this.licenceNumber = licenceNumber;
		this.owner = owner;
		this.engineSize = engineSize;
		this.isDiesel = isDiesel;
	}
	public Calendar getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(MyDate myManufactureDate) {
		this.manufactureDate = myManufactureDate.getCalendar();
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public float getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(float engineSize) {
		this.engineSize = engineSize;
	}
	public boolean isDiesel() {
		return isDiesel;
	}
	public void setDiesel(boolean isDiesel) {
		this.isDiesel = isDiesel;
	}
	public String toString() {
		return "Vehicle [licenceNumber=" + licenceNumber + ", owner=" + owner
				+ ", engineSize=" + engineSize + ", isDiesel=" + isDiesel 
				+ ", manufactureDate=" 
				+ MyDate.getDateAsString(manufactureDate, 
						MyDate.FORMATTYPE.YMD_FRMT_TYPE)
				+"]";
	}

	
}
