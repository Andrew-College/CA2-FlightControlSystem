
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
         * Project euler 
         * long[] a = {0,1,0}; long result = 0; 
         * while(a[0] < * 4000000){
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
<<<<<<< HEAD

    public static void incomingWork(HashMap<String, Plane> cList) {
        
        LinkedList<Plane> planeQueue = new LinkedList<Plane>();
        int incomingPlanes = planeQueue.size();
        
        
        
=======
    public void incomingWork(){
        TreeMap<Integer,Plane> incomingPlanes = new TreeMap<Integer,Plane>();
        //adds a plane and checks if it exists, if so, remove this new plane and return the found plane
>>>>>>> origin/AndrewCode
    }
}
