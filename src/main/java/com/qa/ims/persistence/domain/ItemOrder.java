package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.utils.Utils;

public class ItemOrder {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private Utils utils;
	
	private ArrayList<Item> orderitemsId;
	private int orderId;
	private int customerId;

	public ItemOrder(ArrayList<Item> orderitemsId, int orderId, int customerId) {
		super();
		this.orderitemsId = orderitemsId;
		this.orderId = orderId;
		this.customerId = customerId;
	}

	public void setOrderitemsId(ArrayList<Item> orderitemsId) {
		this.orderitemsId = orderitemsId;
	}

	public ArrayList<Long> getOrderitemsId() {
		LOGGER.info("Please enter the id of the item you wish to add to your order");
		ArrayList<Long> getOrderitemsIds = null;
		Long orderItemId = utils.getLong();
		getOrderitemsIds.add(orderItemId);
		return getOrderitemsIds;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, orderId, orderitemsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrder other = (ItemOrder) obj;
		return customerId == other.customerId && orderId == other.orderId && orderitemsId == other.orderitemsId;
	}

	@Override
	public String toString() {
		return "ItemOrder [orderitemsId=" + orderitemsId + ", orderId=" + orderId + ", customerId=" + customerId + "]";
	}

}
