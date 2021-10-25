package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	
	@Override
	public Item create() {
		LOGGER.info("Please enter an item name:");
		String itemName = utils.getString();
		LOGGER.info("Please enter a value");
		Long value = utils.getLong();
		Item item = itemDAO.create(new Item(itemName,value));
		LOGGER.info("Item Created");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete:");
		Long id = utils.getLong();
		return itemDAO.delete(id);
		
	}

	@Override
	public List<Item> readAll() {
		
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a name for the item:");
		String itemName = utils.getString();
		LOGGER.info("Please enter a value for the item");
		Long value = utils.getLong();
		Item item = itemDAO.update(new Item(itemId,itemName,value));
		LOGGER.info("Item Updated");
		return item;
	}
}
