package Batklubb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentManager {

	Map<Member,Boat> m_payedList = new HashMap<Member,Boat>();
	
	public void makePayment(Member a_member, Boat a_boat) {
		 
		if(!ValidMemberCheck(a_member) || a_boat == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			m_payedList.put(a_member,a_boat);
		}
		
	}

	public boolean hasPayed(Member a_member, Boat a_boat) {
		
		if(!ValidMemberCheck(a_member)|| a_boat == null)
		{
			throw new IllegalArgumentException();
		}
		else if(m_payedList.containsKey(a_member));
		{
			if(m_payedList.get(a_member) == a_boat)
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean ValidMemberCheck(Member a_member)
	{
		BoatClubManager bcm = new BoatClubManager();
		if(a_member == null)
		{
			return false;
		}
		for(Member m : bcm.getMembersFromDatabase())
		{
			if(m.getSocNum().equals(a_member.getSocNum()))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
