package Batklubb;

public class Member {

	String m_name;
	String m_socNumber;
	
	public Member(String name, String socNumber) {
		if(name.length() >= 3 && socNumber.length() == 10){
			m_name = name;
			m_socNumber = socNumber;
		}else
			throw new IllegalArgumentException();
	}
}
