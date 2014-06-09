package data;

import java.sql.*;
import business.Billing;

public class BillingDB {
	public static int insert(Billing billing) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = 
			"INSERT INTO billing ( " +
				"orderID, email, cardHolderName, cardNumber, " + 
				"expirationMonth, expirationYear, secureCode" + 
			") VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, billing.getOrderId());
			ps.setString(2, billing.getEmail());
			ps.setString(3, billing.getCardHolderName());
			ps.setString(4, billing.getCardNumber());
			ps.setString(5, billing.getExpirationMonth());
			ps.setString(6, billing.getExpirationYear());
			ps.setString(7, billing.getSecureCode());
			
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
	
	public static int update(Billing billing) {
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		
		String query = "UPDATE billing SET " +
			"orderID = ?, " + 
			"email = ?, " + 
			"cardHolderName = ?, " + 
			"cardNumber = ?, " +
			"expirationMonth = ?, " + 
			"expirationYear = ?, " + 
			"secureCode = ? " +
			"WHERE billingID = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, billing.getOrderId());
			ps.setString(2, billing.getEmail());
			ps.setString(3, billing.getCardHolderName());
			ps.setString(4, billing.getCardNumber());
			ps.setString(5, billing.getExpirationMonth());
			ps.setString(6, billing.getExpirationYear());
			ps.setString(7, billing.getSecureCode());
			ps.setInt(8, billing.getBillingId());
			
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
