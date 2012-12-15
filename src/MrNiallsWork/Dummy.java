package MrNiallsWork;

import java.io.Serializable;
public class Dummy implements Serializable{
	
	public String x;
	public int y;

	public Dummy(String x, int y) 
	{
		super();
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "Dummy [x=" + x + ", y=" + y + "]";
	}
}
