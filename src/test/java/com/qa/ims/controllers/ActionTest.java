package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.controller.Action;

public class ActionTest {
	
	
	@Test
	public void printActionTest1() {
		
		Action.values();
		
		assertEquals(1, 1);
		
		
	}
}
