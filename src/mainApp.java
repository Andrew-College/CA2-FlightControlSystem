
import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class mainApp {

    public static void main(String[] args) {
        mainApp app = new mainApp();

        HashMap<String, Plane> companyList = new HashMap<String, Plane>();


        //Add known planes/companies up here

        Plane shortTripV45 = new Plane("shortTripV45", 3000, "Dead Air", 100, 20);
        Plane AerDrop212 = new Plane("AerDrop212", 2000, "JK Airtrains", 50, 20);
        companyList.put(shortTripV45.getName(), shortTripV45);
        companyList.put(AerDrop212.getName(), AerDrop212);



        /*
         * Project euler long[] a = {0,1,0}; long result = 0; while(a[0] < *
         * 4000000){
         *
         * System.out.println(a[0]); a[2] = a[0] + a[1]; a[0] = a[1]; a[1] =
         * a[2]; System.out.println(a[0]); if(a[1]%2==0){
         *
         * result = result + a[1];
         *
         * }
         *
         * }
         * System.out.print(result);
         */


        app.incomingWork(companyList);
    }

    public void incomingWork(HashMap<String, Plane> cList) {
        TreeMap<Integer, Plane> incomingPlanes = new TreeMap<Integer, Plane>();


        //adds a plane and checks if it exists, if so, remove this adjust plane with the found plane

        Plane p1 = addPlane("AerDrop212", 2000, "JK Airtrains", 50, 12, 2012, 12, 25, 12, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

<<<<<<< HEAD
        p1 = addPlane("shortTripV456", 5000, "JK Airtrains1", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 14, cList);
=======
<<<<<<< HEAD
        p1 = addPlane("shortTripV456", 5000, "JK Airtrains1", 50, 12, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 13, cList);
=======
        p1 = addPlane("shortTripV456", 5000, "JK Airtrains1", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 14, cList);
>>>>>>> AndrewCode
>>>>>>> 372dacdcd5111645d7ce7c23f14dfe47640d42d0
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        ///////////////////////////////////////////////////////////////

        for (Plane p : cList.values()) {
            System.out.println(p.toString());
        }
    }

    public Plane addPlane(String name, int fuel, String pCompany, int fuelConsumption, int passengers, int year, int month, int day, int hour, HashMap<String, Plane> rList) {

        Plane p1 = new Plane(name, fuel, pCompany, fuelConsumption, passengers, year, month, day, hour);

        for (Plane t : rList.values()) {
            if (t.getName().equalsIgnoreCase(p1.getName()) && t.getpCompany().equalsIgnoreCase(p1.getpCompany())) {
                p1.setSerial(t.getSerial());
                t.decNumPlanes();
                break;
            }
        }
        return p1;
    }
}
