
import java.util.HashMap;
import java.util.Map;

public class mainApp {

    public static void main(String[] args) {
        HashMap<String, PCompany> companyList = new HashMap<String, PCompany>();
        
        PCompany pC1 =  new PCompany("Qatar");
        Plane p1 = new Plane("shortTripV45", 3000, 20, 2012, 11, 25, 12);
        pC1.addPlane(p1);
        companyList.put(pC1.getName(), pC1);
        
        

    }
}
