package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import Batklubb.*;

public class BoatClubManagerTests {
	
	private IOmanager iom;
	private MemberGenerator memberGenerator;
	
	@Before public void initialize() {
		iom = mock(IOmanager.class);
		memberGenerator = new MemberGenerator();
    }
	
	@Test
	public void testAddMember(){
		BoatClubManager bcm = new BoatClubManager();
		
		when(iom.getNameInput()).thenReturn(getNewMemberName());
		when(iom.getSocNumInput()).thenReturn(getNewMemberSocNumber());
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		assertEquals(1, bcm.getMembers().size());
	}
	
	//@Test
	public void testSaveMembers()
	{
//		BoatClubManager bcm = new BoatClubManager();
//		when(iom.getNameInput()).thenReturn(memberGenerator.generateValidName());
//		when(iom.getSocNumInput()).thenReturn(memberGenerator.generateValidSocNumber());
//		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
//		
//		
	}

	
	
	
	
	
	
	
	// HELP METHODS
	public String getNewMemberName()
	{
		return memberGenerator.generateValidName();
	}
	
	public String getNewMemberSocNumber()
	{
		return memberGenerator.generateValidSocNumber();
	}
	
	
}
