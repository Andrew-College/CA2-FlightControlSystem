
import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class mainApp {

    public static void main(String[] args) {
        mainApp app = new mainApp();

        HashMap<String, PCompany> companyList = new HashMap<String, PCompany>();

        PCompany qatar = new PCompany("Qatar");
        PCompany AerLingus = new PCompany("AerLingus");

        //Add known planes/companies up here

        qatar.addPlane(new Plane("shortTripV45", 3000, 100, 20));
        AerLingus.addPlane(new Plane("AerDrop212", 2000, 50, 20));
        companyList.put(qatar.getName(), qatar);
        companyList.put(AerLingus.getName(), AerLingus);



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

    public static void incomingWork(HashMap<String, PCompany> cList) {
        
        LinkedList<Plane> planeQueue = new LinkedList<Plane>();
        int incomingPlanes = planeQueue.size();
        
        
        
    }
}
