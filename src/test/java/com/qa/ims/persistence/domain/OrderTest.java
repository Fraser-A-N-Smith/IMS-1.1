package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	Order testOdr = new Order(1l,1l);
	ArrayList<Item> tstI = new ArrayList<>();
	
//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Order.class).verify();
//	}
	
	@Test 
	public void createListTest(){
		Item testitem = new Item(2,"IPad2",999);
		ArrayList<Item> testList = new ArrayList<>();
		testList.add(testitem);
		assertEquals(testOdr.createList(testitem), testList);
	}
	
	
	@Test 
	public void toStringTest() {
	String testString = testOdr.toString();
	String expected = "Order [orderId=" + 1 + ", customerId=" + 1 + "]";
	assertEquals(testString, expected);
}
}
