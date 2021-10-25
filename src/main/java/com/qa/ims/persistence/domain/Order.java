package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

	private int orderId;
	private int customerId;
	private ArrayList<Item> items;

	public Order(int customerId, ArrayList<Item> items) {
		super();
		this.customerId = customerId;
		this.items = items;
	}

	public Order(int orderId, int customerId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.items = (ArrayList<Item>) items;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, items, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return customerId == other.customerId && Objects.equals(items, other.items) && orderId == other.orderId;
	}

}
