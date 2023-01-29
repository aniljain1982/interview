package com.automation.java;

public class StringProgram {

	public void totalCharCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				count++;
			}
		}
		System.out.println("String length is " + count);
	}
	
	public static void main(String[] args) {
		new StringProgram().totalCharCount("rfsa dfare");
	}

}
