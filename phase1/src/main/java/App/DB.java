package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	// create db for the project if its not exist
	public static void createDB() {
		ConnectionPool pool = null;
		Connection conn = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			excute(sqlSheltot.CREATE_DB, conn);
			excute(sqlSheltot.CREATE_COMPANIES, conn);
			excute(sqlSheltot.CREATE_CUSTOMERS, conn);
			excute(sqlSheltot.CREATE_CATEGORIES, conn);
			excute(sqlSheltot.CREATE_COUPON, conn);
			excute(sqlSheltot.CREATE_CUSTOMERS_VS_COUPONS, conn);
			System.out.println("database created successfully...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pool != null)
				pool.restoreConnection(conn);
		}

	}
	
	public static void excute(String Shelta, Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Shelta);

	}

}
