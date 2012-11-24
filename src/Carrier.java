
import java.util.ArrayList;


public class Carrier {
    
 private String name;
 private int numPlanes;
 private ArrayList<Plane> Planes;

    public Carrier(String name) {
        this.name = name;
        this.numPlanes = 0;
        this.Planes = new ArrayList<Plane>();
    }
    
    public void addPlane(Plane p){
        Planes.add(p);
        numPlanes++;
    }
    
    public void editPlane(Plane p){
        
    }
 
    
}
