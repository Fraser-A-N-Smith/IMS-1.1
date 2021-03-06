package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
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

	public Order create(Order order) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (customerId) VALUES (?)");

			statement.setFloat(1, order.getCustomerId());
			statement.executeUpdate();

			/// If something goes wrong delete this section
//			try {
//				Statement state = connection.createStatement("");
//				
//			}catch(SQLException e) {
//				LOGGER.debug(e);
//				LOGGER.error(e.getMessage());
//				
//			}
			///

			return order;
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
					.prepareStatement("UPDATE orders SET customerId = ? WHERE orderId = ?");
			statement.setFloat(2, order.getOrderId());
			statement.setFloat(1, order.getCustomerId());
			statement.executeUpdate();
			return read(order.getOrderId());

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
		Long orderId = resultSet.getLong("orderId");
		Long customerId = resultSet.getLong("customerId");
		return new Order(orderId, customerId);
	}

	public int addToOrder(OrderItems orderItem) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO orderItems (ItemsId,orderId) VALUES (?,?)");
			statement.setLong(1, orderItem.getItemId());
			statement.setLong(2, orderItem.getOrderId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public int calcCosts(Long num) {
		// use (SELECT COUNT(*) AS count_items FROM orderitems WHERE orderId = ?;)
		try {
			////////////// Find Number of items
//			Connection connection = DBUtils.getInstance().getConnection();
//			PreparedStatement statement = connection
//					.prepareStatement("SELECT COUNT(*) AS count_items FROM orderitems WHERE orderId = ?;");
//			statement.setLong(1, num);
//
//			ResultSet resultSet = statement.executeQuery();
//			resultSet.next();
//			int ItemNumber = resultSet.getInt("count_items");
//			/////////// 
//			Connection connection1 = DBUtils.getInstance().getConnection();
//			PreparedStatement statement1 = connection1
//					.prepareStatement("SELECT value FROM items JOIN orderitems ON items.itemId = orderitems.itemsId WHERE orderId = ?;");
//			statement1.setLong(1, num);
//			
//			int cost = 0;
//			ResultSet costSet = statement.executeQuery();
//			while(costSet.next()) {
//				int temp = costSet.getInt("value");
//				cost = cost + temp;
//			}
//			
//			int ItemPrice = ItemNumber*399;
//			
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT SUM(value) AS total FROM items JOIN orderItems AS oI ON items.itemId = oI.itemsId WHERE orderId =  ?;");
			statement.setLong(1, num);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int ItemNumber = resultSet.getInt("total");

			return ItemNumber;// ItemPrice;

		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;

	}

	public int removeFromOrder(OrderItems orderItems) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM orderItems WHERE orderId = ? AND ItemsId = ?");
			statement.setLong(1, orderItems.getItemId());
			statement.setLong(2, orderItems.getOrderId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return 0;

	}

}
