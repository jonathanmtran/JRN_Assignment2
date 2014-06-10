package data;

import java.sql.*;
import business.Order;

public class OrderDB {
	public static Order insert(Order order) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "INSERT INTO `order`(total, date) VALUES(?, NOW());";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setDouble(1, order.getTotal());
			
			if(ps.executeUpdate() == 1) {
				query = "SELECT LAST_INSERT_ID();";
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				if(rs.next())
					order.setOrderId(rs.getInt(1));
			}
			
			return order;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			
			return order;
		}
		finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	
	public static Order fetch(int orderId) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
		Order order = null;
		
		String query = "SELECT * FROM `order` WHERE orderID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, orderId);
			
			rs = ps.executeQuery();
		
			if(rs.next()) {
				int id = rs.getInt("orderID");
				double total = rs.getDouble("total");
				Date date = rs.getDate("date");
				
				order = new Order(id, total, date);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);			
		}
		
		return order;		
	}
}
