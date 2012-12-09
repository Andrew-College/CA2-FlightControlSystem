
import java.util.Calendar;
import java.util.Date;

public class Plane implements Comparable {

    private String name;
    private int NumPlanes = 0;
    private int serial;
    private String pCompany;
    private int fuel;
    private int fuelConsumption;
    private int timeLimitBeforeLand;
    private int passengers;
    private Calendar arrivalTime;
    private Calendar departTime;
    private boolean isLanded;

    public Plane(String name, int fuel, String pCompany, int fuelConsumption, int passengers) {
        this.name = name;
        this.serial = NumPlanes;
        this.fuel = fuel;
        this.pCompany = pCompany;
        this.fuelConsumption = fuelConsumption;
        this.isLanded = false;

        this.passengers = passengers;
        this.arrivalTime = Calendar.getInstance();
        this.departTime = Calendar.getInstance();
        this.timeLimitBeforeLand = gettimeLimitBeforeLand();
        NumPlanes++;
    }

    public Plane(String name, int fuel, String pCompany, int fuelConsumption, int passengers, int year, int month, int day, int hour) {
        this.name = name;
        this.serial = NumPlanes;
        this.fuel = fuel;
        this.pCompany = pCompany;
        this.fuelConsumption = fuelConsumption;
        this.timeLimitBeforeLand = gettimeLimitBeforeLand();
        this.passengers = passengers;
        this.arrivalTime = Calendar.getInstance();
        this.arrivalTime.set(year, month, day, hour, 0);
        this.isLanded = false;
        NumPlanes++;
    }

    public void decNumPlanes() {
        NumPlanes--;
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

        int left = 0;
        int result = this.fuel;
        while (result >= 0) {
            left++;
            result -= this.fuelConsumption;
        }

        return left * 60;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public boolean isIsLanded() {
        return isLanded;
    }

    public void setIsLanded(boolean isLanded) {
        this.isLanded = isLanded;
    }

    
    
    public Calendar getArrivalTime() {
        return arrivalTime;
    }
    

    public void setArrivalTime(int year, int month, int day, int hour) {
        this.arrivalTime.set(year, month, day, hour, 0);
    }

    @Override
    public String toString() {
        return "Plane{" + "name=" + name + ", NumPlanes=" + NumPlanes + ", serial=" + serial + ", pCompany=" + pCompany + ", fuel=" + fuel + ", fuelConsumption=" + fuelConsumption + ", timeLimitBeforeLand=" + timeLimitBeforeLand + ", passengers=" + passengers + ", arrivalTime=" + arrivalTime + ", departTime=" + departTime + '}';
    }

    
    
    @Override
    public int compareTo(Object o) {

        Plane p = (Plane) (o);
        Integer p1 = (Integer) this.gettimeLimitBeforeLand();

        return p1.compareTo(p.gettimeLimitBeforeLand());
    }
    
    public int isOverdue()
    {
        
            return 1;
    }
    
    
}


//CompareTo method to be done here. (Compares the remaining fuel left for the treemap?)
