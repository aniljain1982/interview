package com.automation.testng.parameterization;

import org.testng.annotations.Factory;

public class TestNGFactoryDif {
	@Factory
	public Object[] empFactoryMethod() {
		return new Object[] { new TestNGFactory(), new TestNGFactory() };
	}
}
