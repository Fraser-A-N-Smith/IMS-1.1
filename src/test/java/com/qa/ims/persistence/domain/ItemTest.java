package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Item.class).verify();
//	}
	Item item = new Item("IPad",399);
	
	@Test
	public void testSetItemId() {
		 item.setItemId(2l);
		 assertEquals(2l, item.getItemId());
	}
	
	@Test
	public void testSetItemName() {
		item.setItemName("hi");
		assertEquals("hi", item.getItemName());
	}
	
	@Test
	public void testSetItemValue() {
		item.setValue(110l);
		assertEquals(110l, item.getValue());
	}
}
