package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;


import Batklubb.*;

public class BoatClubManagerTests {
	
	@Test
	public void testAddMember(){
		BoatClubManager bcm = new BoatClubManager();
		IOmanager iom = mock(IOmanager.class);
		when(iom.getNameInput()).thenReturn("kisskorv");
		when(iom.getSocNumInput()).thenReturn("9205121337");
		bcm.addMember(iom.getNameInput(), iom.getSocNumInput());
		assertEquals(1, bcm.getMembers().size());
	}
}
