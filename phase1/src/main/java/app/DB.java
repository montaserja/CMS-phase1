package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constants.sqlQueries;

public class DB {
	public static DB instance;

	public static DB getInstance() {
		if (instance == null)
			return new DB();
		return instance;
	}

	private DB() {

	}

	// create db for the project if its not exist
	public static void createDB() {
		ConnectionPool pool = null;
		Connection con = null;

		pool = ConnectionPool.getInstance();
		con = pool.getConnection();
		excute(sqlQueries.CREATE_DB, con, "Succssfully, the database is created",
				"Failed, can't create the database, db is already exists",true);
		excute(sqlQueries.CREATE_COMPANIES, con, "Succssfully, COMPANIES table is created",
				"Failed, can't create the COMPANIES table, table is already exists",true);
		excute(sqlQueries.CREATE_CUSTOMERS, con, "Succssfully, CUSTOMERS table is created",
				"Failed, can't create the CUSTOMERS table, table is already exists",true);
		initCategoriesTable(con);
		excute(sqlQueries.CREATE_COUPON, con, "Succssfully, COUPON table is created",
				"Failed, can't create the COUPON table, table is already exists",true);
		excute(sqlQueries.CREATE_CUSTOMERS_VS_COUPONS, con, "Succssfully, CUSTOMERS_VS_COUPONS table is created",
				"Failed, can't create the CUSTOMERS_VS_COUPONS table, table is already exists",true);

		System.out.println("successfully, database is created ...");

	}

	public static ResultSet excute(String sql, Connection con, String msg, String errMsg, boolean isUpdateQuery) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			if (isUpdateQuery == true) {
				stmt.executeUpdate(sql);

			} else {
				rs = stmt.executeQuery(sql);
				if (rs.next() == false) {
					System.out.println("there is no data for " + sql);
					return null;
				}
			}
			System.out.println(msg);

		} catch (SQLException e) {
			System.out.println(errMsg);

		} finally {
			if (con != null)
				ConnectionPool.getInstance().restoreConnection(con);
		}
		return rs;

	}

	public static void initCategoriesTable(Connection con) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlQueries.CREATE_CATEGORIES);
			excute(sqlQueries.CATEGORY_1, con, "Succssfully, CATEGORY1 Filed is inserted",
					"Failed, can't insert the CATEGORY1 table",true);
			excute(sqlQueries.CATEGORY_2, con, "Succssfully, CATEGORY2 Filed is inserted",
					"Failed, can't insert the CATEGORY2 table",true);
			excute(sqlQueries.CATEGORY_3, con, "Succssfully, CATEGORY3 Filed is inserted",
					"Failed, can't insert the CATEGORY3 table",true);
			excute(sqlQueries.CATEGORY_4, con, "Succssfully, CATEGORY4 Filed is inserted",
					"Failed, can't insert the CATEGORY4 table",true);
			System.out.println("init categories table successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed, can't create the CATEGORIES table, table is already exists");
		}finally {
			if (con != null)
				ConnectionPool.getInstance().restoreConnection(con);
		}
//		excute(sqlQueries.CREATE_CATEGORIES, con, "Succssfully, CATEGORIES table is created",
//				"Failed, can't create the CATEGORIES table, table is already exists",true);




	}

}
