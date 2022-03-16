package restassured;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class junit {
	@Before
	public void BT()
	{
		String Name = "Sunil";
		String SName = "Nishchith";
		Assert.assertEquals(SName, Name);
	}
	
	@Test
	public void testcase1()
	{
		System.out.print("This is my first teestcase1");
	}
	
	@After
	public void AT()
	{
		System.out.println("This is After test");
	}
}
