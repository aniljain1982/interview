package com.automation.testng.parameterization;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	public class Student {
		String name;
		int age;

		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}

	// Single value
	@DataProvider(name = "data-provider-1")
	public Object[][] singleValue() {
		return new Object[][] { { "Value1" }, { "Value2" } };
	}

	@Test(dataProvider = "data-provider-1")
	public void test_1(String value) {
		System.out.println("test_1: " + value);
	}

	// Multiple value
	@DataProvider(name = "data-provider-2")
	public Object[][] multipleValue() {
		return new Object[][] { { 2, 3, 5 }, { 4, 5, 9 } };
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	@Test(dataProvider = "data-provider-2")
	public void test_2(int a, int b, int result) {
		Assert.assertEquals(result, add(a, b));
	}

	// Method name as argument in data provider
	@DataProvider(name = "data-provider-3")
	public Object[][] basedOnMethod(Method m) {
		switch (m.getName()) {
		case "addition":
			return new Object[][] { { 2, 3, 5 }, { 4, 5, 9 } };
		case "substraction":
			return new Object[][] { { 5, 3, 2 }, { 9, 5, 4 } };
		}
		return null;
	}

	@Test(dataProvider = "data-provider-3")
	public void addition(int a, int b, int result) {
		Assert.assertEquals(result, add(a, b));
	}

	@Test(dataProvider = "data-provider-3")
	public void substraction(int a, int b, int result) {
		Assert.assertEquals(result, sub(a, b));
	}

	// User defined object
	@DataProvider(name = "data-provider-4")
	public Object[][] getUserDefinedObject() {
		return new Object[][] { { new Student("John", 23) }, { new Student("Karl", 32) } };
	}

	@Test(dataProvider = "data-provider-4")
	public void test_4(Student object) {
		System.out.println(object.getName() + ", " + object.getAge());
	}

}
