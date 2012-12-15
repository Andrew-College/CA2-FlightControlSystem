
import MrNiallsWork.SerializationUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Math;
import java.util.*;

public class mainApp {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        mainApp app = new mainApp();

        HashMap<String, Plane> companyList = new HashMap<String, Plane>();


        //Add known planes/companies up here

        Plane shortTripV45 = new Plane("shortTripV45", 3000, "Dead Air", 100, 20);
        Plane AerDrop212 = new Plane("AerDrop212", 2000, "JK Airtrains", 50, 20);
        Plane FlyAway = new Plane("FlyAway", 3000, "Saints Air", 70, 50);
        companyList.put(shortTripV45.getName(), shortTripV45);
        companyList.put(AerDrop212.getName(), AerDrop212);
        companyList.put(FlyAway.getName(), FlyAway);


        SerializationUtility.store("AirPlanes.txt", companyList);
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


        app.incomingWork(/*
                 * companyList----
                 */);
    }

    public void incomingWork(/*HashMap<String, Plane> cList not needed*/) {
        HashMap<String, Plane> cList = (HashMap<String, Plane>) SerializationUtility.load("AirPlanes.txt");
        TreeMap<Integer, Plane> incomingPlanes = new TreeMap<Integer, Plane>();


        //adds a plane and checks if it exists, if so, remove this adjust plane with the found plane

        Plane p1 = addPlane("AerDrop212", 2000, "Dead Air", 50, 11, 2012, 11, 25, 11, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 11, 25, 12, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV56", 5000, "Dead Air", 50, 11, 2012, 11, 25, 13, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);


        p1 = addPlane("shortTripV456", 5000, "JK Airtrains", 200, 3, 2012, 11, 25, 14, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 11, 25, 15, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("FlyAway", 1000, "Saints Air", 150, 50, 2012, 11, 25, 16, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("Flyer", 2500, "Saints Air", 200, 11, 2012, 11, 25, 17, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("Long 'un", 4000, "Saints Air", 50, 11, 2012, 11, 25, 18, cList);
        incomingPlanes.put(p1.gettimeLimitBeforeLand(), p1);

        do {
            //for (Plane p : incomingPlanes.values()) {
            //  System.out.println(p.toString());
            //}
            //create GUI here
            System.out.println("//////////////////////////////////////////////////////////////");
            System.out.println("///              D.A.A Controlled F.C.S                    ///");
            System.out.println("///    1.Add a plane                                       ///");
            System.out.println("///    2.Remove a Plane                                    ///");
            System.out.println("///    3.Print the Planes for one Airline                  ///");
            System.out.println("///    4.Print the total number of Passengers              ///");
            System.out.println("///    5.Print the next Plane                              ///");
            System.out.println("///    6.Print the last Plane                              ///");
            System.out.println("///    7.Print the company with the most Planes incoming   ///");
            System.out.println("///    8.Print list of overdue Planes                      ///");
            System.out.println("///    9.Exit                                              ///");
            System.out.println("//////////////////////////////////////////////////////////////");

            int choice = 0;
            while (choice == 0) {
                try {
                    choice = keyboard.nextInt(); //end GUI 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type");
                    choice = 0;
                }
                keyboard.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.println("Name;");
                    String name = keyboard.nextLine();
                    System.out.println("AirlineName;");
                    String aName = keyboard.nextLine();
                    System.out.println("Fuel;");
                    int fuel = keyboard.nextInt();
                    System.out.println("Fuel Consumption;");
                    int fuelCon = keyboard.nextInt();
                    System.out.println("No. Passengers;");
                    int passengers = keyboard.nextInt();
                    System.out.println("Year of arrival;");
                    int aYear = keyboard.nextInt();
                    System.out.println("Month of Arrival;");
                    int aMonth = keyboard.nextInt();
                    System.out.println("Day of arrival;");
                    int aDay = keyboard.nextInt();
                    System.out.println("Hour of Arrival;");
                    int aHour = keyboard.nextInt();
                    Plane temp = addPlane(name, fuel, aName, fuelCon, passengers, aYear, aMonth, aDay, aHour, cList);
                    incomingPlanes.put(temp.gettimeLimitBeforeLand(), temp);
                    break;
                case 2://Remove plane if exists
                    System.out.println("Name of Plane?");
                    name = keyboard.nextLine();
                    System.out.println("Name of Airline?");
                    aName = keyboard.nextLine();
                    //System.out.println(name + " " + aName);
                    for (Plane p : incomingPlanes.values()) {
                        if (p.getName().equalsIgnoreCase(name)
                        &&  p.getpCompany().equalsIgnoreCase(aName)) {
                            incomingPlanes.remove(p);
                            break;
                        }
                    }
                    System.out.println("Plane not found, no changes occurred");
                    break;
                case 3://all P one A
                    System.out.println("Name of Airline?");
                    aName = keyboard.nextLine();
                    pDetails(1, incomingPlanes, aName);
                    break;
                case 4:

                    pDetails(2, incomingPlanes, null);
                    break;
                case 5:
                    System.out.println("Which airline?");
                    aName = keyboard.nextLine();
                    pDetails(3, incomingPlanes, aName);
                    break;
                case 6:
                    System.out.println("Name of Airline?");
                    aName = keyboard.nextLine();
                    pDetails(5, incomingPlanes, aName);

                    break;

                case 7:
                    pDetails(4, incomingPlanes, null);
                    break;
                case 8:
                    System.out.println("Name of Airline?");
                    aName = keyboard.nextLine();
                    pDetails(6, incomingPlanes, aName);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("---ERROR - INVALID INPUT---");
                    break;
            }
            //pDetails(6,incomingPlanes,"Saints Air"); 
        } while (true);

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
        TreeMap<Integer, Plane> arrangedList = new TreeMap<Integer, Plane>();
        planeCheck:
        try {
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
                    case 4://amount of planes in an airline
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
                    case 6://Print by specified airline, by overdue

                        arrangedList.put(((p.getpCompany().equalsIgnoreCase(compName)) ? p.isOverdue(p.getArrivalTime()) : 0), p);
                        openInt++;

                    //Youve reached the last time the company exists, arrangedList now gets stuck into openString


                    default:
                        break;
                }
            }
            //if case 6 is run
            if (!arrangedList.isEmpty()) {
                openString = new ArrayList<String>();

                //openString.set(0, arrangedList.get(0).getName());
                for (Plane p : arrangedList.values()) {
                    openString.add(p.toString());
                }
            }
            //If case 4 is run
            if (!companies.isEmpty()) {
                //Runs the mostCompanies method after finding out a list of company Names
                openString = new ArrayList<String>();
                openString.add(theMostPlanes(companies, planeList));
            }
            //If openString is given any input
            if (!openString.isEmpty()) {
                for (int i = 0; i < openString.size(); i++) {
                    System.out.println(openString.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Sorry, That isn't working as expected, returning to the main program");
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
            result = " have the most, with " + amountOfPlanes[i] + " planes incoming";
            if (amountOfPlanes[i] > amountOfPlanes[i - 1]) {
                //System.out.println(companyList.get(i) + " has the most, with " + amountOfPlanes[i] + " planes incoming");
                result = companyList.get(i) + " has the most, with " + amountOfPlanes[i] + " planes incoming";
            } else if (amountOfPlanes[i] == amountOfPlanes[i - 1]) {
                if (!result.contains(companyList.get(i))) {
                    result = companyList.get(i) + " and " + companyList.get(i - 1) + result;
                } else {
                    result = companyList.get(i) + " and " + result;
                }
            } else {
                result = companyList.get(i - 1) + " has the most, with " + amountOfPlanes[i - 1] + " planes incoming";
            }
        }

        return result;

    }
}