package data;

import java.sql.*;
import business.OrderLine;

public class OrderLineDB {
	public static OrderLine insert(OrderLine orderLine) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "INSERT INTO orderline (orderID, itemID, quantity, subtotal) VALUES(?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, orderLine.getOrderId());
			ps.setInt(2, orderLine.getItem().getItemID());
			ps.setInt(3, orderLine.getQuantity());
			ps.setDouble(4, orderLine.getSubtotal());
			
			if(ps.executeUpdate() == 1) {
				query = "SELECT LAST_INSERT_ID();";
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				if(rs.next())
					orderLine.setOrderlineId(rs.getInt(1));					
			}
			
			return orderLine;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			return orderLine;
		}
		finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static int update(OrderLine orderLine) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "UPDATE orderline SET " + 
			"orderID = ?, itemID = ?, quantity = ?, subtotal = ? " +
			"WHERE orderlineID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, orderLine.getOrderId());
			ps.setInt(2, orderLine.getItem().getItemID());
			ps.setInt(3, orderLine.getQuantity());
			ps.setDouble(4, orderLine.getSubtotal());
			ps.setInt(5, orderLine.getOrderlineId());
			
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
