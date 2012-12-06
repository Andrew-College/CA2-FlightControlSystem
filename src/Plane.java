
import java.util.Calendar;
import java.util.Date;

public class Plane {

    private String name;
    private int count;
    private int serial;
    private String pCompany;
    private int fuel;
    private int fuelConsumption;
    private int timeLimitBeforeLand;
    private int passengers;
    private Calendar arrivalTime;
    private Calendar departTime;

    public Plane(String name, int fuel, String pCompany, int fuelConsumption, int passengers) {
        this.name = name;
        this.serial = count;
        this.fuel = fuel;
        this.pCompany = pCompany;
        this.fuelConsumption = fuelConsumption;

        this.passengers = passengers;
        this.arrivalTime = Calendar.getInstance();
        this.departTime = Calendar.getInstance();
        this.timeLimitBeforeLand = gettimeLimitBeforeLand();

    }

    public Plane(String name, int fuel, String pCompany, int fuelConsumption, int passengers, int year, int month, int day, int hour) {

        this.name = name;
        this.serial = count;
        this.fuel = fuel;
        this.pCompany = pCompany;
        this.fuelConsumption = fuelConsumption;
        this.timeLimitBeforeLand = gettimeLimitBeforeLand();
        this.passengers = passengers;
        this.arrivalTime = Calendar.getInstance();
        this.arrivalTime.set(year, month, day, hour, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getpCompany() {
        return pCompany;
    }

    public void setpCompany(String pCompany) {
        this.pCompany = pCompany;
    }
    

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    

    public int gettimeLimitBeforeLand() {

        int count = 0;
        int result = this.fuel;
        while (result >= 0) {
            count++;
            result -= this.fuelConsumption;
        }
        
        return count * 60;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int year, int month, int day, int hour) {
        this.arrivalTime.set(year, month, day, hour, 0);
    }
}


//CompareTo method to be done here. (Compares the remaining fuel left for the treemap?)