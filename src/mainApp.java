
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

        Plane p1 = addPlane("AerDrop212", 2000, "Dead Air", 50, 12, 2012, 12, 25, 12, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV56", 5000, "Dead Air", 50, 12, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 12, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("FlyAway", 1000, "Saints Air", 150, 50, 2012, 12, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("Flyer", 2500, "Saints Air", 200, 12, 2012, 12, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);
         

        for (Plane p : incomingPlanes.values()) {
            System.out.println(p.toString());
        }

        System.out.println("///////////////////////////////////////////////////////////////");

        pDetails(4, incomingPlanes, null);
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

        int openInt = 0;
        LinkedList<String> companies = new LinkedList<String>();
        ArrayList<String> openString = new ArrayList<String>();
        openString.add("");
        planeCheck:
        for (Plane p : planeList.values()) {
            switch (type) {
                case 1://all planes, one airline
                    openString.add((p.getpCompany().equalsIgnoreCase(compName)) ? p.toString() + "\n" : "");
                    break;
                case 2://all planes passengers
                    openInt += p.getPassengers();
                    openString.set(0, "There are " + openInt + " passengers in the air.");
                    break;
                case 3://next plane for one airline
                    if (p.getpCompany().equalsIgnoreCase(compName)) {
                        openString.set(0, p.toString());
                        //openInt.set(0, openInt.get(0) + 1);
                        //Logic; "set it to 1 so it knows to not overwrite since it could be still looping"
                        break planeCheck;
                        // this'd stop the loop(better if the thing is found early on in the list 
                        //and since this if is nested)
                    }
                    break;
                case 4://amount of planes in an airline (Incomplete)
                    //loop through the company, then through planes for each, then next company


                    for (int i = 0; i < companies.size(); i++) {

                        if (companies.get(i).equalsIgnoreCase(p.getpCompany())) {
                            companies.remove(i);
                        }
                    }
                    companies.add(p.getpCompany());
                    break;
                case 5://Find last plane for a given company
                    TreeMap<Integer, Plane> revMap = (TreeMap<Integer, Plane>) planeList.descendingMap();
                    for (Plane p1 : revMap.values()) {
                        if (p1.getpCompany().equalsIgnoreCase(compName)) {
                            openString.set(0, p.toString());
                            //found the plane in question, so exit out of all of it using this cool name block break thing.
                            break planeCheck;
                        }

                    }
                default:
                    break;
            }
        }
        if (!companies.isEmpty()) {
            //Runs the mostCompanies method after finding out a list of company Names
            openString.set(0, theMostPlanes(companies, planeList));
        }
        if (!openString.isEmpty()) {
            for (int i = 0; i < openString.size(); i++) {
                System.out.println(openString);
            }
        }
    }

    public static String theMostPlanes(LinkedList<String> companyList, TreeMap<Integer, Plane> pList) {
        int[] amountOfPlanes = new int[companyList.size()];
        String result = "";

        //fill out who has what planes
        for (Plane p : pList.values()) {
            for (int i = 0; i < amountOfPlanes.length; i++) {
                if (companyList.get(i).equalsIgnoreCase(p.getpCompany())) {
                    //Goes through each plane, checks if it matches one of companyLists, if so increments relevant "amountOfPlanes"
                    amountOfPlanes[i]++;
                }
            }
        }

        //who has most
        for (int i = 1; i < amountOfPlanes.length; i++) {

            if (amountOfPlanes[i] > amountOfPlanes[i - 1]) {
                System.out.println(companyList.get(i) + " has the most, with " + amountOfPlanes[i] + " planes incoming");
                result = companyList.get(i) + " has the most, with " + amountOfPlanes[i] + " planes incoming";
            } else if (amountOfPlanes[i] == amountOfPlanes[i - 1]) {
                //todo; what if multiple companies have the same number?
                //please god I dont have to bother with substrings................
            } else {
                result = companyList.get(i - 1) + " has the most, with " + amountOfPlanes[i - 1] + " planes incoming";
            }
        }

        return result;

    }
}