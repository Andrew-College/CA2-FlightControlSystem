
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mainApp {

    public static void main(String[] args) {
        HashMap<String, PCompany> companyList = new HashMap<String, PCompany>();
        
        int incomingPlanes = 0;
        
        PCompany qatar = new PCompany("Qatar");
        PCompany AerLingus = new PCompany("AerLingus");

        //Add known planes/companies up here

        qatar.addPlane(new Plane("shortTripV45", 3000, 100, 20));
        AerLingus.addPlane(new Plane("AerDrop212", 2000, 50, 20));
        companyList.put(qatar.getName(), qatar);
        companyList.put(AerLingus.getName(), AerLingus);



        /*
         * Project euler long[] a = {0,1,0}; long result = 0; while(a[0] <
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
        
        mainApp app = new mainApp();
        app.incomingWork();
    }
    public void incomingWork(){
        TreeMap<Integer,Plane> incomingPlanes = new TreeMap<Integer,Plane>();
        //adds a plane and checks if it exists, if so, remove this new plane and return the found plane
    }
}
