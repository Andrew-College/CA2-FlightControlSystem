/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Andmin
 */
public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, testPlane> treeTest = new TreeMap<Integer, testPlane>();
        HashMap<Integer, testPlane> hashTest = new HashMap<Integer, testPlane>();
        //For some reason the treemap will not print the second input
        HashMap<String, testPlane> testList = new HashMap<String, testPlane>();
        testPlane p1 = addPlane("AerDrop212", 2000, "JK Airtrains", 50, 12, 2012, 12, 25, 12, testList);


        treeTest.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV456", 5000, "JK Airtrains1", 50, 12, 2012, 12, 25, 13, testList);

        treeTest.put(p1.gettimeLimitBeforeLand(), p1);

        p1 = addPlane("shortTripV45", 3000, "Dead Air", 100, 20, 2012, 12, 25, 13, testList);

        treeTest.put(p1.gettimeLimitBeforeLand(), p1);
        
        
        for(testPlane tP: treeTest.values()){
            System.out.println(tP.toString());
        }
    }

    public static testPlane addPlane(String name, int fuel, String pCompany, int fuelConsumption, int passengers, int year, int month, int day, int hour, HashMap<String, testPlane> rList) {

        testPlane p1 = new testPlane(name, fuel, pCompany, fuelConsumption, passengers, year, month, day, hour);

        for (testPlane t : rList.values()) {
            if (t.getName().equalsIgnoreCase(p1.getName()) && t.getpCompany().equalsIgnoreCase(p1.getpCompany())) {
                p1.setSerial(t.getSerial());
                t.decNumPlanes();
                break;
            }
        }
        return p1;
    }
}