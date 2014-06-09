package data;

import java.sql.*;
import business.OrderLine;

public class OrderLineDB {
	public static int insert(OrderLine orderLine) {
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
