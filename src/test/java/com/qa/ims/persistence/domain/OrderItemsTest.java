package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemsTest {

	private OrderItems oI;

//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(OrderItems.class).verify();
//	}

	@Test
	public void testConstructor() {

		oI = new OrderItems(1l, 1l);
		assertEquals(oI, new OrderItems(1l, 1l));

	}

	OrderItems oITest = new OrderItems(1l, 1l);

	@Test
	public void getItemIdTest() {
		oI = new OrderItems(1l, 1l);
		assertEquals(oITest.getItemId(), oI.getItemId());
	}

//	@Test 
//	public void getCustomerId() {
//		oI = new OrderItems(1l,1l);
//		assertEquals(oITest.getOrderId(), 0);
		
//	}
//	@Test 
//	public void setItemIdTest() {
//		oI = new OrderItems(1l, 1l);
//		oI.setItemId(null);
//		assertEquals(oITest.getItemId(), null);
//	}
	
//	@Test
//	public void setItemIdTest() {
//		oI = new OrderItems(1l, 1l);
//		oI.setItemId(2l);
//		assertEquals(2l,oI.getItemId());
//	}
	
}
