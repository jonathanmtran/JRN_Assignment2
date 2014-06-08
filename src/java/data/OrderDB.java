package data;

import java.sql.*;
import business.Order;

public class OrderDB {
	public static int insert(Order order) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "INSERT INTO order(total, date) VALUES(?, ?))";
		
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
	
	public static int update(Order order) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "UPDATE order SET " +
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
}
