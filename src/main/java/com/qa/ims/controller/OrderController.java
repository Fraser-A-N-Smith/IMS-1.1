package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	private Utils utils;
	private OrderDAO orderDAO;

	public static final Logger LOGGER = LogManager.getLogger();

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
		
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter an order id:");
		int orderId = (int) Math.toIntExact(utils.getLong());
		LOGGER.info("Pease enter an item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter an item id");
		int itemId = (int) Math.toIntExact(utils.getLong());
		LOGGER.info("Please enter a value");
		Long value = utils.getLong();
		LOGGER.info("Please enter a customer Id");
		int customerId = (int) Math.toIntExact(utils.getLong());
		ArrayList<Item> items = new ArrayList<>();
		Item item = new Item(itemName,value);
		items.add(item);
		Order order = orderDAO.create(new Order(orderId, customerId,items));
//		LOGGER.info("Item Created");
//		return order;
//		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete:");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
