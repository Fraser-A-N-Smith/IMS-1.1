package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private long itemId;
	private String itemName;
	private long value;

	public Item(long itemId, String itemName, long value) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.value = value;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId && Objects.equals(itemName, other.itemName) && value == other.value;
	}

}
