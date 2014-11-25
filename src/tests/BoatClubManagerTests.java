package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Batklubb.*;

public class BoatClubManagerTests {

	private IOmanager iom;
	private MemberGenerator memberGenerator;

	@Before
	public void initialize() {
		iom = mock(IOmanager.class);
		memberGenerator = new MemberGenerator();
	}

	@Test
	public void testAddMember() {
		BoatClubManager bcm = new BoatClubManager();

		when(iom.getNameInput()).thenReturn(getNewMemberName());
		when(iom.getSocNumInput()).thenReturn(getNewMemberSocNumber());
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		assertEquals(1, bcm.getMembers().size());
	}

	@Test
	public void testSaveMembers()
	{
		BoatClubManager bcm = new BoatClubManager();
		List<Member> m_memberList = new ArrayList<>();
		for(int i = 0; i < 5; i++)
		{
			when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
			when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
			
			bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
			m_memberList.add(new Member(iom.getNameInput(), iom.getSocNumInput()));
		}
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);
		bcm.getMembers().get(0).addBoat(b);
		b.setMooring(1);
		bcm.saveMembersToDatabase();
		assertEquals(bcm.getMembersFromDatabase().size(), m_memberList.size());
	}

	

	      
	@Test(expected = IllegalArgumentException.class)
	public void TestIfMooringAvailableWithInvalidInput()
	{
		BoatClubManager bcm = new BoatClubManager();
		bcm.CheckAndSetMooring(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestMooringWithUnregisterdMember(){
		BoatClubManager bcm = new BoatClubManager();
		
		
		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
		
		Member m = new Member(iom.getNameInput(), iom.getSocNumInput());
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		m.addBoat(b);
		
		bcm.CheckAndSetMooring(m, b);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestMooringWithUnregisterdBoat(){
		BoatClubManager bcm = new BoatClubManager();
		
		
		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
		
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		 
		
		bcm.CheckAndSetMooring(m, b);
	}
	
	@Test
	public void TestSetMooringOnValidInput(){
		BoatClubManager bcm = new BoatClubManager();
		
		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
		
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		m.addBoat(b);
		
		bcm.CheckAndSetMooring(m, b);
		// If the number we get from b.getMooring is larger than 0, then we have been assigned a mooring(skriver man så?)
		assertTrue(b.getMooring()> 0);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void TestSetMooringOnValidInputButWithTooManyBoats(){
		BoatClubManager bcm = new BoatClubManager();
		
		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
		
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		for(int i = 0; i < 50; i++)
		{
			Boat ba = new Boat(BoatType.MotorBoatTits, BoatSize.SMALL);	
			Boat bb = new Boat(BoatType.MotorBoatTits, BoatSize.MEDIUM);
			Boat bc = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);
			m.addBoat(ba);
			m.addBoat(bb);
			m.addBoat(bc);
		}
		for(Boat b : m.getBoats())
		{
			bcm.CheckAndSetMooring(m, b);
		}
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void TestSetMooringOnInvalidBoat(){
		BoatClubManager bcm = new BoatClubManager();
		
		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
		
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
			
		bcm.CheckAndSetMooring(m, null);
	}
	
	public String getNewMemberName() {
		return memberGenerator.generateValidName();
	}

	public String getNewMemberSocNumber() {
		return memberGenerator.generateValidSocNumber();
	}

	
}
