package MrNiallsWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainApp12 
{
	private HashMap<String, Vehicle> vehicleMap;
//	public static void main(String[] args) 
//	{
//		MainApp app = new MainApp();
//		app.start();
//	}
	public void start()
	{
		this.vehicleMap = new HashMap<String, Vehicle>();


		
		for(Map.Entry theEntry : vehicleMap.entrySet())
			System.out.println(theEntry.getValue());
		
		//edit a specific vehicle
		Vehicle searchVehicle = vehicleMap.get("m.jones");
		System.out.println(searchVehicle);
		searchVehicle.setDiesel(true);
		searchVehicle.setEngineSize((float)1.8);
		
		System.out.println("\n--------- EDIT ------------\n");
		for(Map.Entry theEntry : vehicleMap.entrySet())
			System.out.println(theEntry.getValue());
		
		Vehicle removeVehicle = vehicleMap.get("t.rex");
		vehicleMap.remove(removeVehicle);
		
		
		System.out.println("\n--------- REMOVE ------------\n");
		for(Map.Entry theEntry : vehicleMap.entrySet())
			System.out.println(theEntry.getValue());
		
		System.out.println("\n--------- SORT ------------\n");
		//copy the map into a list
		List<Vehicle> list = new ArrayList<Vehicle>(vehicleMap.values());
		
		Collections.sort(list); //at this point we sort the list
		
		for(Vehicle v : list)
			System.out.println(v);
		
	}
}




















