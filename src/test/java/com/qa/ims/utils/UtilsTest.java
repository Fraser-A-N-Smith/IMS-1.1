package com.qa.ims.utils;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class UtilsTest {

	Utils ut = new Utils();
	
	@Test
	public void ScannerTest() {
		Scanner scanner = new Scanner(System.in);
	}
	
	@Test
	public void getLongTest() {
		Long input = 1l;
		
		//assertEquals(ut.getLong(), 1l);
				
	}
}
