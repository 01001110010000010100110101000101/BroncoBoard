package edu.csupomona.cs480;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;


public class Tests {
	
	@Test
	public void testGetStringURL() {
		ClassScraper cs = ClassScraper.getInstance();
		String url=cs.getURL();
		
	}

}
