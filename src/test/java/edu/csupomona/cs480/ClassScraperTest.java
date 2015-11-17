package edu.csupomona.cs480;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;


public class ClassScraperTest {
	
	@Test
	public void testGetClassNames() {
		ClassScraper cs = ClassScraper.getInstance();
		try {
            ArrayList<String> classes = cs.getClassNames();
            Assert.assertNotNull(classes);
		} catch (Exception e) {
			System.out.println("Exception caught while testing ClassScraper");
		}
	}

}
