
import java.util.Calendar;
import java.util.Date;

public class Plane {

    private String name;
    private int count;
    private int serial;
    private int fuel;
    private int passengers;
    private Calendar arrivalTime;

    

    public Plane(String name, int fuel, int passengers, int year, int month, int day, int hour) {
        count++;
        this.name = name;
        this.serial = count;
        this.fuel = fuel;
        this.passengers = passengers;
        this.arrivalTime = Calendar.getInstance();
        this.arrivalTime.set(year, month, day, hour,0);
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

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
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
