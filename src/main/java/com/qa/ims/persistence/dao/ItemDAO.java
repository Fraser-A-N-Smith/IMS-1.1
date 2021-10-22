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

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	Statement statement;

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("itemId");
		String itemName = resultSet.getString("itemName");
		Long value = resultSet.getLong("value");
		return new Item(itemId, itemName, value);
	}

	@Override
	public List<Item> readAll() {

		try {
			Connection connection = DBUtils.getInstance().getConnection();

			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM items");

			ArrayList<Item> items = new ArrayList<>();

			while (resultset.next()) {
				items.add(modelFromResultSet(resultset));
			}
			return items;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Item read(Long id) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");

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

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub

		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO items(itemName,itemId,value) VALUES (?,?,?)");
			statement.setString(1, item.getItemName());
			statement.setLong(2, item.getItemId());
			statement.setLong(3, item.getValue());
			statement.executeUpdate();
			return item; // insert added item
		} catch (SQLException e) {

		}
		return null;
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE items SET itemName = ?, value = ? WHERE itemId = ?");
			statement.setString(1, item.getItemName());
			statement.setLong(2, item.getValue());
			statement.setLong(3, item.getItemId());
			statement.executeUpdate();
			return item;

		} catch (SQLException e) {

		}
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE itemId = ?");
			statement.setLong(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return 0;
	}

//	@Override
//	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
