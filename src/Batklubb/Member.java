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

	public void addBoat(Boat a_boat) {
		if(a_boat == null)
			throw new IllegalArgumentException();
		m_boats.add(a_boat);
	}

	public Boat getBoat(int a_index) {
		if(a_index >= 0)
		{
			return m_boats.get(a_index);
		}
		throw new IllegalArgumentException();
	}
	
	public List<Boat> getBoats(){
		return m_boats;
	}
}
