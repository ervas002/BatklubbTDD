package Batklubb;

import java.util.ArrayList;
import java.util.List;

public class BoatClubManager {
	
	private List<Member> m_memberList = new ArrayList<>();
	
	public List<Member> getMembers(){
		return m_memberList;
	}
	
	public void addMember(String name, String socNum){
		m_memberList.add(new Member(name, socNum));
	}
}
