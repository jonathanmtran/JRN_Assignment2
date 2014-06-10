package data;

import java.sql.*;
import business.Billing;

public class BillingDB {
	public static Billing insert(Billing billing) {
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
			
			if(ps.executeUpdate() == 1) {
				query = "SELECT LAST_INSERT_ID();";
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				if(rs.next())
					billing.setBillingId(rs.getInt(1));				
			}
			
			return billing;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			return billing;
		}
		finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
}
