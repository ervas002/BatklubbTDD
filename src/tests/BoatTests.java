package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Batklubb.*;

public class BoatTests {

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorIllegalInput(){		
		new Boat();
	}
}