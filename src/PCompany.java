import java.util.ArrayList;

public class PCompany {

    private String name;
    private int numPlanes;
    private ArrayList<Plane> Planes;

    public PCompany(String name) {
        this.name = name;
        this.numPlanes = 0;
        this.Planes = new ArrayList<Plane>();
    }

    public void addPlane(Plane p) {
        Planes.add(p);
        numPlanes++;
    }

    public ArrayList<Plane> getPlanes() {
        return Planes;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPlanes() {
        return numPlanes;
    }

    public void setNumPlanes(int numPlanes) {
        this.numPlanes = numPlanes;
    }
}