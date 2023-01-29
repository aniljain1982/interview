package com.automation.testng.parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PassByParameters {
	@Test
	@Parameters({"username", "password"})
	public void testngParameters(String username,String password) {
		System.out.println(username);
		System.out.println(password);
	}
	

}
