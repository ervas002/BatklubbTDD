package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Batklubb.*;

public class BoatTests {

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorIllegalInput(){		
		new Boat(null,null);
		}
	
	@Test
	public void testBoatGets(){
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);
		assertEquals(BoatType.MotorBoatTits, b.getBoatType());
		assertEquals(BoatSize.LARGE, b.getBoatSize());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMooringIllegalInput(){
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);		
		b.setMooring(0);
	}
	
	@Test
	public void testSetMooring(){
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);		
		b.setMooring(1);
		assertEquals(1, b.getMooring());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetMooringEmpty(){
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);		
		b.getMooring();
	}
	
	@Test
	public void testGetExpiryDate(){
		Boat b = new Boat(BoatType.MotorBoatTits, BoatSize.LARGE);		
		b.setMooring(1);
		assertNotNull(b.getExpiryDate());
	}
}