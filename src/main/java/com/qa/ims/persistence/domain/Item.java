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
	

	public Item(String itemName, long value) {
		super();
		this.itemName = itemName;
		this.value = value;
	}


//	public Item(String itemName2, Double itemValue) {
//		this.itemName = itemName2;
//		this.value = itemValue;
//		// TODO Auto-generated constructor stub
//	}


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
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
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
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (value != other.value)
			return false;
		return true;
	}



}
