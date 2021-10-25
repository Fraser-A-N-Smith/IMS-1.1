package com.qa.ims.persistence.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long id) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE orderId = ?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return null;
	}

	
//	public Order create(Order order, int itemId,String itemName, Long itemValue) {
//		try {
//			Connection connection = DBUtils.getInstance().getConnection();
//			PreparedStatement statement = connection
//					.prepareStatement("INSERT INTO orders (orderId,items,customerId) VALUES (?,?,?)");
//			statement.setInt(1, order.getOrderId());
//			statement.setArray(2, (Array) order.getItems(new Item(itemId, itemName, itemValue)));
//			statement.setInt(3, order.getCustomerId());
//			
//			return order;
//		} catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//
//		}
//		return null;
//	}

	public Order create(Order order) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO orders (orderId,items,customerId) VALUES (?,?,?)");
			statement.setInt(1, order.getOrderId());
			statement.setArray(2, (Array) order.getItems());
			statement.setInt(3, order.getCustomerId());
			
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return null;
	}
	
	public Order addTo(Order order) {

		try {
			Connection connection = DBUtils.getInstance().getConnection();
			 PreparedStatement statement = connection.prepareStatement("UPDATE orders SET items = ? WHERE orderId = ?");
			 statement.setArray(1, null);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}

		return null;
	}

	@Override
	public Order update(Order order) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE orders SET orderId = ?, items = ?, customerId = ? WHERE orderId = ?");
			statement.setInt(1, order.getOrderId());
			statement.setArray(2, (Array) order.getItems());
			statement.setInt(3, order.getCustomerId());

		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}

		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE orderId = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		int orderId = resultSet.getInt("id");
		int customerId = resultSet.getInt("customerId");
		List<Item> items = (List<Item>) resultSet.getArray(null);
		return new Order(orderId, customerId, items);
	}

}
