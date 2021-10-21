package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	Statement statement;
//	@Override
//	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
//		Long itemId = resultSet.getLong("Item id");
//		String itemName = resultSet.getString("itemName");
//		Long value = resultSet.getLong("value");
//		return new Item(itemId, itemName, value);
//	}

	@Override
	public List<Item> readAll() {
		
		try {Connection connection = DBUtils.getInstance().getConnection();
		
			statement = connection.createStatement();
			
			String query = "SELECT * FROM items";
			
			statement.execute(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Item read(Long id) {
		try {Connection connection = DBUtils.getInstance().getConnection();
		} catch(SQLException e) {
			
		}
				
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		
		try {Connection connection = DBUtils.getInstance().getConnection();
			
		}catch(SQLException e) {
			
		}
		return null;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		try {Connection connection = DBUtils.getInstance().getConnection();
		
		}catch(SQLException e) {
			
		}
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		try {Connection connection = DBUtils.getInstance().getConnection();
		
		}catch(SQLException e) {
			
		}
		return 0;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
