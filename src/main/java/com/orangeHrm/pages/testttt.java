package com.orangeHrm.pages;

import org.testng.annotations.Test;

public class testttt {

	@Test
	void test1() {
		System.out.println("hi");
	}
	
	@Test(priority=0)
	void test2() {
		System.out.println("hi1");
	}
	
	@Test(priority=2)
	void test3() {
		System.out.println("hi3");
	}
	@Test
	void test4() {
		System.out.println("hi4");
	}
}
