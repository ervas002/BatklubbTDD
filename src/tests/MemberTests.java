package tests;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import java.security.SecureRandom;
import java.util.ArrayList;

import Batklubb.*;

import org.junit.Test;

public class MemberTests {

	@Test(expected=IllegalArgumentException.class)
	public void ConstructorIllegalInput() {
		new Member("", "0");
		//new Member();
	}
	
	@Test
	public void ConstructorCorrectInput() {
		for(int i = 0; i < 100; i++){
			String name = generateValidName();
			String socNum = generateValidSocNumber();			
			//System.out.println(name + " " + socNum);
			new Member(name, socNum);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddNullBoat(){		
		Member m = generateMember();
		m.addBoat(null);
		//new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM)
	}

	@Test
	public void testAddBoat(){		
		Member m = generateMember();
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM);
		m.addBoat(b);
		assertEquals(b, m.getBoat(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetBoatIllegalInput(){		
		Member m = generateMember();
		m.getBoat(-1);
	}
	
	@Test
	public void testGetBoats(){
		Member m = generateMember();
		ArrayList<Boat> bList = new ArrayList<>();
		Boat b1 = new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM);
		Boat b2 = new Boat(BoatType.BorgarBåt, BoatSize.LARGE);
		Boat b3 = new Boat(BoatType.Canoe, BoatSize.SMALL);
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		m.addBoat(b1);
		m.addBoat(b2);
		m.addBoat(b3);
		assertEquals(bList, m.getBoats());
	}
	
	@Test
	public void testGetMemberInfo(){
		String name = generateValidName();
		String socNum = generateValidSocNumber();
		Member m = new Member(name, socNum);
		assertEquals(m.getName(), name);
		assertEquals(m.getSocNum(), socNum);
	}
	
	private Member generateMember(){
		return new Member(generateValidName(), generateValidSocNumber());
	}
	
	private String generateValidName(){
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		int nameLength = 3 + random.nextInt(20);
		for(int i = 0; i < nameLength; i++){
			sb.append((char)(random.nextInt(26) + 'a'));
		}
		return sb.toString();
	}
	
	private String generateValidSocNumber(){
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		//Year
		String year = String.valueOf(1 + random.nextInt(98));
		if(year.length() < 2)
			year = "0" + year;
		sb.append(year);
		//Month
		String month = String.valueOf(1 + random.nextInt(11));
		if(month.length() < 2)
			month = "0" + month;
		sb.append(month);
		//Day
		String day = String.valueOf(1 + random.nextInt(30));
		if(day.length() < 2)
			day = "0" + day;
		sb.append(day);
		//LastFour		
		String lastFour = String.valueOf(random.nextInt(9999));
		while(lastFour.length() < 4)
			lastFour += "0";
		sb.append(lastFour);
		return sb.toString();
	}
}
