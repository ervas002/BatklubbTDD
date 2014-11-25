package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import Batklubb.Boat;
import Batklubb.BoatClubManager;
import Batklubb.BoatSize;
import Batklubb.BoatType;
import Batklubb.IOmanager;
import Batklubb.Member;
import Batklubb.PaymentManager;

public class PaymentManagerTests {

	private IOmanager m_iom;
	private PaymentManager m_pManager;
	private MemberGenerator m_memberGenerator;
	
	
	@Before
	public void initialize() {
		m_iom = mock(IOmanager.class);
		m_pManager = new PaymentManager();
		m_memberGenerator = new MemberGenerator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void MakePaymentOnInvalidInput()
	{
		m_pManager.makePayment(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void MakePaymentOnNotSavedMember()
	{
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		Member m = new Member(m_iom.getNameInput(), m_iom.getSocNumInput());
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		m.addBoat(b);
		
		m_pManager.makePayment(m, b);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void MakePaymentOnValidMemberButInvalidBoat()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		
	
		bcm.saveMembersToDatabase();
		m_pManager.makePayment(m, null);
	}
	
	
	@Test
	public void MakePaymentOnValidMemberCheckIfHasPayed()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		m.addBoat(b);
		bcm.saveMembersToDatabase();
		m_pManager.makePayment(m, b);
		assertTrue(m_pManager.hasPayed(m, b));
	}
	

	 
	
	@Test(expected = IllegalArgumentException.class)
	public void MakePaymentOnSavedMemberButNotBoat()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		bcm.saveMembersToDatabase();
		m_pManager.makePayment(m, null);
		
		 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HasPaymentOnNullBoat()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		bcm.saveMembersToDatabase();
		m_pManager.hasPayed(m, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHasPayedOnNullMember()
	{
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);	
		
		m_pManager.hasPayed(null, b);
	}
	
	@Test
	public void testHasPayedOnValidMemberInvalidBoat()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		bcm.saveMembersToDatabase();
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);
		assertFalse(m_pManager.hasPayed(m, b));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHasPayedOnNotSavedMember()
	{
		BoatClubManager bcm = new BoatClubManager();
		when(m_iom.getNameInput()).thenReturn(m_memberGenerator.generateValidName());
		when(m_iom.getSocNumInput()).thenReturn(m_memberGenerator.generateValidSocNumber());
		
		bcm.addMember(m_iom.getNameInput(), m_iom.getSocNumInput());
		Member m = bcm.getMembers().get(0);
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);
		m.addBoat(b);
		m_pManager.hasPayed(m, b);
	}

	
}
