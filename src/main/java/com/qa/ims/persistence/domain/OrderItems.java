package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {

	private Long itemId;
	private Long orderId;

	public OrderItems(Long itemId, Long orderId) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		return "OrderItems [itemId=" + itemId + ", orderId=" + orderId + "]";
	}

}
