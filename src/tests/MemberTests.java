package tests;

import static org.junit.Assert.*;
import Batklubb.*;

import org.junit.Test;

public class MemberTests {

	@Test(expected=IllegalArgumentException.class)
	public void ConstructorIllegalInput() {
		new Member();
	}

}
