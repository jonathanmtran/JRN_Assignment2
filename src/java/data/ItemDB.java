package data;

import business.Item;
import java.sql.*;
import java.util.ArrayList;

public class ItemDB {
	
	public static Item selectItem(int itemId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
		
		String query = "SELECT * FROM item WHERE itemID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, itemId);
			rs = ps.executeQuery();
			
			Item item = null;
			
			if(rs.next()) {
				item = new Item();
				item.setItemID(rs.getInt("itemID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setSpecs(rs.getString("specification"));
				item.setImageLoc(rs.getString("photoName"));
				item.setPrice(rs.getDouble("price"));
			}
			
			return item;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);			
		}
	}
	
	public static ArrayList<Item> fetchAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement s = null;
        ResultSet rs = null;		
		ArrayList<Item> items = new ArrayList<>();
		
		String query = "SELECT * FROM item";
		
		try {
			s = connection.createStatement();
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt("itemID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setSpecs(rs.getString("specification"));
				item.setImageLoc(rs.getString("photoName"));
				item.setPrice(rs.getDouble("price"));
				
				items.add(item);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(s);
            pool.freeConnection(connection);			
		}
		
		return items;
	}
}
