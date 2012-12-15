package MrNiallsWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Utility methods to store ANY type of storage container
 * e.g. LinkedList<TreeMap<A, B>>
 * 				or
 * 		TreeMap<A, HashMap<B, C>>
 * */
public class SerializationUtility
{
	//use with ANY storage type i.e. List, Map, or Set
	@SuppressWarnings("unused")
	public static void store(String fileName, Object object)
	{	
		try
		{
			//open file to write
			FileOutputStream fileOut = new FileOutputStream(fileName);
			//open stream to file
		    ObjectOutputStream out = new ObjectOutputStream(fileOut);			    
		    //write contents
			out.writeObject(object);
			//close file streams
			fileOut.close();
			out.close();
		}
		catch(Exception e)
		{
		}
	}
		
	//use with ANY storage type i.e. List, Map, or Set
	@SuppressWarnings("unused")
	public static Object load(String fileName)
	{	
		try
		{
			//open file to read
			FileInputStream fileIn = new FileInputStream(fileName);
			//open stream to file
			ObjectInputStream in = new ObjectInputStream(fileIn);
			//read contents and cast as specific data type
			Object map = in.readObject();
			//close file streams
			in.close();
			fileIn.close();
			//return loaded data
			return map;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//fail
		return null;
	}
}
