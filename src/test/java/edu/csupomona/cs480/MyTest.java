package edu.csupomona.cs480;

import org.junit.Assert;
import org.junit.Test;

import edu.csupomona.cs480.data.User;

public class MyTest {
	
	@Test
	public void testSetUserName()
	{
		User user = new User();
		user.setName("MyName");
		
		String test = user.getName();
		String name = "MyName";
		Assert.assertEquals(test, name);
	}

}
