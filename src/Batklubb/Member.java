package Batklubb;

import java.util.ArrayList;
import java.util.List;

public class Member {

	String m_name;
	String m_socNumber;
	List<Boat> m_boats = new ArrayList<Boat>();
	
	public String getName()
	{
		return m_name;
	}

	public String getSocNum()
	{
		return m_socNumber;
	}
	
	public Member(String name, String socNumber) {
		if(name.length() >= 3 && socNumber.length() == 10){
			m_name = name;
			m_socNumber = socNumber;
		}else
			throw new IllegalArgumentException();
	}

	public void addBoat(Boat boat) 
	{
		m_boats.add(boat);
	}
}
