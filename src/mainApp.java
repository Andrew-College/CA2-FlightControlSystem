<<<<<<< HEAD

import java.lang.Math;
import java.util.*;

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


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 50, 12, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        for (Plane p : incomingPlanes.values()) {
            System.out.println(p.toString());
        }

        System.out.println("///////////////////////////////////////////////////////////////");

        pDetails(4, incomingPlanes, "JK Airtrains");
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

    public void pDetails(int type, TreeMap<Integer, Plane> planeList, String compName) {

        ArrayList<Integer> openInt = new ArrayList<Integer>();
        openInt.add(0);
        String openString = "";
        
        for (Plane p : planeList.values()) {
            switch (type) {
                case 1://all planes, one airline
                    System.out.print((p.getpCompany().equalsIgnoreCase(compName)) ? p.toString() + "\n" : "");
                    break;
                case 2://all planes passengers
                    openInt.set(0, openInt.get(0)+p.getPassengers());
                    openString = "There are " + openInt + " passengers in the air.";
                    break;
                case 3://next plane for one airline
                    if (openInt.get(0) != 1 && p.getpCompany().equalsIgnoreCase(compName)) {
                        openString = p.toString();
                        openInt.set(0, openInt.get(0)+1);
                    }
                    break;
                case 4://amount of planes in an airline 
                    
                    if (p.getpCompany().equalsIgnoreCase(compName)) {
                        openInt.set(0, openInt.get(0)+1);
                        openString = compName + " has " + openInt.get(0) + " planes in the air.";
                    }
                    break;
                default:
                    break;
            }
        }
        if (openString.length() > 0) {
            System.out.println(openString);
        }
    }
}
=======

import java.lang.Math;
import java.util.*;

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


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 50, 12, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        for (Plane p : incomingPlanes.values()) {
            System.out.println(p.toString());
        }

        System.out.println("///////////////////////////////////////////////////////////////");

        pDetails(3, incomingPlanes, "JK Airtrains");
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

    public void pDetails(int type, TreeMap<Integer, Plane> planeList, String compName) {

        ArrayList<Integer> openInt = new ArrayList<Integer>();
        openInt.add(0);
        String openString = "";
        planeCheck:
        for (Plane p : planeList.values()) {
            switch (type) {
                case 1://all planes, one airline
                    System.out.print((p.getpCompany().equalsIgnoreCase(compName)) ? p.toString() + "\n" : "");
                    break;
                case 2://all planes passengers
                    openInt.set(0, openInt.get(0) + p.getPassengers());
                    openString = "There are " + openInt + " passengers in the air.";
                    break;
                case 3://next plane for one airline
                    if (openInt.get(0) != 1 && p.getpCompany().equalsIgnoreCase(compName)) {
                        openString = p.toString();
                        //openInt.set(0, openInt.get(0) + 1);
                        //Logic; "set it to 1 so it knows to not overwrite since it could be still looping"
                        break planeCheck;
                        // this'd stop the loop(better if the thing is found early on in the list)
                    }
                    break;
                case 4://amount of planes in an airline (Incomplete)

                    if (p.getpCompany().equalsIgnoreCase(compName)) {
                        openInt.set(0, openInt.get(0) + 1);
                        openString = compName + " has " + openInt.get(0) + " planes in the air.";
                    }
                    break;
                case 5://Find last plane for a given company
                    TreeMap<Integer, Plane> revMap = (TreeMap<Integer, Plane>) planeList.descendingMap();
                    for (Plane p1 : revMap.values()) {
                        if (openInt.get(0) != 1 && p1.getpCompany().equalsIgnoreCase(compName)) {
                            openString = p1.toString();
                            //found the plane in question, so exit out of all of it using this cool name block break thing.
                            break planeCheck;
                        }
                        
                    }
                default:
                    break;
            }
        }
        if (openString.length() > 0) {
            System.out.println(openString);
        }
    }
}
>>>>>>> AndrewCode
