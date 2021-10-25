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

import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.utils.DBUtils;

public class ItemOrderDAO implements Dao<ItemOrder>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public List<ItemOrder> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderItems");) {
			List<ItemOrder> itemOrders = new ArrayList<>();
			while (resultSet.next()) {
				itemOrders.add(modelFromResultSet(resultSet));
			}
			return itemOrders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();

	}

	@Override
	public ItemOrder read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderItems WHERE orderItemsId = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder create(ItemOrder itemOrder) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderItems(orderItemsId, orderId, customerId) VALUES (?, ?)");) {
			statement.setArray(1, (Array) itemOrder.getOrderitemsId());
			statement.setInt(2, itemOrder.getOrderId());
			statement.setInt(3, itemOrder.getCustomerId());
			statement.executeUpdate();
			return itemOrder;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder update(ItemOrder t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemOrder modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ItemOrder modelFromResultSet(ResultSet resultSet) throws SQLException {
//		// TODO Auto-generated method stub
//		Long id = resultSet.getorderItemsId();
//		String orderId = resultSet.getString("orderId");
//		Long customerId = resultSet.getLong("customerId");
//		return new ItemOrder(orderItemsId, orderId, customerId);
//	}


	
	
	
	

}
