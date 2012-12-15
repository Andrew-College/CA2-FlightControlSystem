package MrNiallsWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* NOTE: 
 * If you intend to store a user-defined objcet (e.g. Airplane, Dummy)
 *  then that class (e.g. Airplane) MUST implement Serializable
 * */
public class MainAppNiall 
{	
	public static void main(String[] args) 
	{
		MainAppNiall theApp = new MainAppNiall();
		theApp.startTestA(); 
		theApp.startTestB(); 
	}
	
	//simple test to store and load HashMap
	private void startTestB()
	{
		TreeMap<Integer, LinkedList<Dummy>>  saveMap = new TreeMap<Integer, LinkedList<Dummy>>();
		
		LinkedList<Dummy> list1 = new LinkedList<Dummy>();
		list1.push(new Dummy("d", 90));
		list1.push(new Dummy("b", 21));
		list1.push(new Dummy("a", 14));
		list1.push(new Dummy("c", 18));
		
		saveMap.put(new Integer(5), list1);
		
		LinkedList<Dummy> list2 = new LinkedList<Dummy>();
		list2.push(new Dummy("z", 56));
		list2.push(new Dummy("x", 234));
		list2.push(new Dummy("y", 78));
		
		saveMap.put(new Integer(2), list2);
		
		System.out.println("------------------------ startTestB::save ------------------------");
		print(saveMap);
		SerializationUtility.store("saveAdvanced.txt", saveMap);
		
		System.out.println("------------------------ startTestB::load ------------------------");
		//Look what type the SerializationUtility::load() method returns - Since it's Object we need to cast
		TreeMap<String, LinkedList<Dummy>> loadMap = (TreeMap<String, LinkedList<Dummy>>)SerializationUtility.load("saveAdvanced.txt");
		print(loadMap);
	}
	
	//advanced test to store and load a TreeMap with LinkedList 
	private void startTestA()
	{
		HashMap<String, Dummy>  saveMap = new HashMap<String, Dummy>();
		saveMap.put("a", new Dummy("d", 1));
		saveMap.put("b", new Dummy("a", 2));
		saveMap.put("a", new Dummy("b", 3));
		saveMap.put("c", new Dummy("d", 4));
		
		System.out.println("------------------------ startTestA::save ------------------------");
		print(saveMap);
		SerializationUtility.store("saveSimple.txt", saveMap);
		
		System.out.println("------------------------ startTestA::load ------------------------");
		//Look what type the SerializationUtility::load() method returns - Since it's Object we need to cast
		HashMap<String, Dummy> loadMap = (HashMap<String, Dummy>)SerializationUtility.load("saveSimple.txt");
		print(loadMap);
	}
	
	
	
	//use with TreeMap or HashMap 
	private <K, V> void print(Map<K, V> theMap)
	{
		for(Map.Entry theEntry : theMap.entrySet())
			System.out.println(theEntry.getValue());
	}
	
	
}
