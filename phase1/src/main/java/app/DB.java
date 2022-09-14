package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import constants.sqlQueries;

public class DB {

	// create db for the project if its not exist
	public static void createDB() {
		ConnectionPool pool = null;
		Connection conn = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			excute(sqlQueries.CREATE_DB, conn);
			excute(sqlQueries.CREATE_COMPANIES, conn);
			excute(sqlQueries.CREATE_CUSTOMERS, conn);
//			excute(sqlQueries.CREATE_CATEGORIES, conn);
			initCategoriesTable();
			excute(sqlQueries.CREATE_COUPON, conn);
			excute(sqlQueries.CREATE_CUSTOMERS_VS_COUPONS, conn);

			System.out.println("database created successfully...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pool != null)
				pool.restoreConnection(conn);
		}

	}

	public static void excute(String sql, Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);

	}

	public static void initCategoriesTable() {
		ConnectionPool pool = null;
		Connection conn = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();

			excute(sqlQueries.CREATE_CATEGORIES, conn);
			excute(sqlQueries.CATEGORY_1, conn);
			excute(sqlQueries.CATEGORY_2, conn);
			excute(sqlQueries.CATEGORY_3, conn);
			excute(sqlQueries.CATEGORY_4, conn);

			System.out.println("init categories table successfully...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pool != null)
				pool.restoreConnection(conn);
		}
	}

}
