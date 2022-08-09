package com.zee.zee5app;

import java.util.Scanner;

public class ExceptionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = division();
		System.out.println(result);
	}
	static String division()
	{
		int a = 10, b = 0;
		int c;
		try {
			c = a/b;
			return "from try";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception found");
			return "from catch";
		} finally {
			System.out.println("finally");
			return "from finally";
		}
//		System.out.println("method");
//		return "from method";
	}
}
