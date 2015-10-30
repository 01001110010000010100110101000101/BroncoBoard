package edu.csupomona.cs480;

import org.junit.Assert;
import org.junit.Test;
import edu.csupomona.cs480.data.Message;

public class Testing {

	@Test
	public void testMessage() {
		Message messageObject = new Message();
		messageObject.setMessage("Currently testing");
		
		String myMessage = messageObject.getMessage();
		String comparison = "Currently testing";
		Assert.assertEquals(myMessage, comparison);
	}

}
