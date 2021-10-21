package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

	private int customerId;
	private ArrayList<Item> items;

	public Order(int customerId, ArrayList<Item> items) {
		super();
		this.customerId = customerId;
		this.items = items;
	}

	public int getCustomerId() {
		return customerId;
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
		return "Order [customerId=" + customerId + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, items);
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
		return customerId == other.customerId && Objects.equals(items, other.items);
	}

}
