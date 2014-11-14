package Batklubb;

public class Member {

	String m_name;
	String m_socNumber;
	
	public Member(String name, String socNumber) {
		if((name.equals("Robert") && socNumber.equals("9202171519")) ||
		   (name.equals("CuntDestroyer") && socNumber.equals("1337001337"))){
			
		}else
			throw new IllegalArgumentException();
	}
}
