package data;

import java.sql.*;
import business.Shipping;

public class ShippingDB {
	public static int insert(Shipping shipping) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;	

		String query = "INSERT INTO shipping " + 
			"(orderID, name, street, city, state, zip) " + 
			"VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, shipping.getOrderId());
			ps.setString(2, shipping.getName());
			ps.setString(3, shipping.getStreet());
			ps.setString(4, shipping.getCity());
			ps.setString(5, shipping.getState());
			ps.setString(6, shipping.getZip());
			
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
	
	public static int update(Shipping shipping) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;	

		String query = "UPDATE shipping SET " + 
			"orderID = ?, name = ?, street = ?, city = ?, state = ?, zip = ? " + 
			"WHERE shippingID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, shipping.getOrderId());
			ps.setString(2, shipping.getName());
			ps.setString(3, shipping.getStreet());
			ps.setString(4, shipping.getCity());
			ps.setString(5, shipping.getState());
			ps.setString(6, shipping.getZip());
			ps.setInt(7, shipping.getShippingId());
			
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
