package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.security.SecureRandom;
import java.util.ArrayList;

import Batklubb.*;

import org.junit.Before;
import org.junit.Test;

public class MemberTests {

	MemberGenerator memberGenerator;
	@Before public void initialize() {
		memberGenerator = new MemberGenerator();
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void ConstructorIllegalInput() {
		new Member("", "0");
		//new Member();
	}
	
	@Test
	public void ConstructorCorrectInput() {
		for(int i = 0; i < 100; i++){
			String name = memberGenerator.generateValidName();
			String socNum = memberGenerator.generateValidSocNumber();			
			//System.out.println(name + " " + socNum);
			new Member(name, socNum);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddNullBoat(){		
		Member m = memberGenerator.generateMember();
		m.addBoat(null);
		//new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM)
	}

	@Test
	public void testAddBoat(){		
		Member m = memberGenerator.generateMember();
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM);
		m.addBoat(b);
		assertEquals(b, m.getBoat(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetBoatNegativeIllegalInput(){		
		Member m = memberGenerator.generateMember();
		m.getBoat(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetBoatIllegalInput(){		
		Member m = memberGenerator.generateMember();
		m.getBoat(4);
	}
	
	@Test
	public void testGetBoats(){
		Member m = memberGenerator.generateMember();
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
		String name = memberGenerator.generateValidName();
		String socNum = memberGenerator.generateValidSocNumber();
		Member m = new Member(name, socNum);
		assertEquals(m.getName(), name);
		assertEquals(m.getSocNum(), socNum);
	}
	
}
