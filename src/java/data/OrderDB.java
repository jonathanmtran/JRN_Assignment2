package data;

import java.sql.*;
import business.Order;

public class OrderDB {
	public static int insert(Order order) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "INSERT INTO `order`(total, date) VALUES(?, NOW());";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setDouble(1, order.getTotal());
			
			int orderId = 0;
			
			if(ps.executeUpdate() == 1) {
				query = "SELECT LAST_INSERT_ID();";
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				if(rs.next())
					orderId = rs.getInt(1);
			}
			
			return orderId;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			
			return 0;
		}
		finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	
	public static int update(Order order) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "UPDATE `order` SET " +
			"total = ?, date = ? " +
			"WHERE orderID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setDouble(1, order.getTotal());
			ps.setDate(2, order.getDate());
			
			return ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			return 0;
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
