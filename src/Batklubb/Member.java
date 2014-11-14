package Batklubb;

public class Member {

	String m_name;
	String m_socNumber;
	
	public Member(String name, String socNumber) {
		if(name != "Robert" || socNumber != "9202171519")
			throw new IllegalArgumentException();
	}
}
