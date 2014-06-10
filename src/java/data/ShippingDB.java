package data;

import java.sql.*;
import business.Shipping;

public class ShippingDB {
	public static Shipping insert(Shipping shipping) {
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
			
			if(ps.executeUpdate() == 1) {
				query = "SELECT LAST_INSERT_ID();";
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				if(rs.next())
					shipping.setShippingId(rs.getInt(1));				
			}
			
			return shipping;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			return shipping;
		}
		finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
}
