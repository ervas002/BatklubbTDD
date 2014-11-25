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
		bcm.saveMembersToDatabase();
		assertEquals(bcm.getMembersFromDatabase().size(), m_memberList.size());
	}

	
	      
	@Test(expected = IllegalArgumentException.class)
	public void TestIfMooringAvailableWithInvalidInput()
	{
		BoatClubManager bcm = new BoatClubManager();
		bcm.CheckAndSetMooring(null, null);
	}
	

	
	
	public String getNewMemberName() {
		return memberGenerator.generateValidName();
	}

	public String getNewMemberSocNumber() {
		return memberGenerator.generateValidSocNumber();
	}

	
}
