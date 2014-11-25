package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import Batklubb.IOmanager;
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
	
	
	
}
