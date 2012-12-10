package MrNeilsWork;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//Wrapped class to store the date and time bytes in one place
public class MyDate 
{
	public enum FORMATTYPE 
	{
		HMS_FRMT_TYPE, 
		YMD_HMS_FRMT_TYPE, 
		YMD_FRMT_TYPE;
		
		public String toString()
		{
			if(this.ordinal() == 0)
				return "hh:mm:ss a";
			else if(this.ordinal() == 1)
				return "E dd MMM yyyy hh:mm:ss a";
			else
				return "E MMM dd yyyy";
		}
	};

	private byte date, month, hour, mins, secs;
	private int year;

	public static String getDateAsString(Calendar date, FORMATTYPE formatType)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatType.toString());
		return dateFormat.format(date.getTime());
	}
	
	
	public MyDate(int date, int month, int year, int hour, int mins, int secs) {
		this.date = (byte)date;
		this.month = (byte)month;
		this.year = year;
		this.hour = (byte)hour;
		this.mins = (byte)mins;
		this.secs = (byte)secs;
	}
	public MyDate(int date, int month, int year) {
		this.date = (byte)date;
		this.month = (byte)month;
		this.year = year;
		this.hour = 9;
		this.mins = 0;
		this.secs = 0;
	}

	//returns a Calendar object corresponding to the date, month, and year
	public Calendar getCalendar()
	{
		Calendar tempDate = Calendar.getInstance();
		tempDate.set(year, month, date,hour,mins,secs);
		return tempDate;
	}
	public byte getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = (byte)date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = (byte)month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(byte hour) {
		this.hour = hour;
	}
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = (byte)mins;
	}
	public int getSecs() {
		return secs;
	}
	public void setSecs(int secs) {
		this.secs = (byte)secs;
	}

	
	
	

	
}
