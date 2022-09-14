package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.ConnectionPool;
import constants.DBConstants;
import dao.infc.CouponsDAO;
import mapper.imp.MyMapperCouponImp;
import model.db.Coupon;
import model.db.Customer;
import model.db.CustomerVsCoupon;
import sqlQuery.CouponQuery;
import sqlQuery.CustomerQuery;
import sqlQuery.CustomerVsCouponQuery;
import sqlQuery.QueryFactory;

public class CouponsDBDAO implements CouponsDAO {
	private ConnectionPool connectionPool;

	public CouponsDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public void addCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).addCoupon(coupon);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, inserted a new coupon into COUPONS table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't insert a new coupon form COUPONS table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}
	}

	public void updateCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).updateCoupon(coupon);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, updated a new coupon into COUPONS table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't update a new coupon form COUPONS table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}
	}

	public void deleteCoupon(int couponID) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).deleteRow(DBConstants.COUPONS,
				couponID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, deleted a new coupon into COUPONS table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't delete a new coupon form COUPONS table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public ArrayList<Coupon> getAllCoupons() {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
				.selectAllData(DBConstants.COUPONS);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no coupons");
				return null;
			}

			ArrayList<Coupon> coupons = MyMapperCouponImp.getInstance().convertResultSetToArrayListOfCoupon(rs);
			System.out.println(coupons);
			System.out.println("Succssfully, get all coupons from CUSTOMER table");
			return coupons;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't get all coupons form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

		return null;
	}

	public Coupon getOneCoupon(int couponID) {
		// connection into DB

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).selectOneRow(DBConstants.COUPONS,
				DBConstants.ID, couponID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no coupon with ID: ");
				System.out.print(couponID);
				return null;
			}

			Coupon coupon = MyMapperCouponImp.getInstance().convertResultSetToCoupon(rs);
			System.out.println(coupon);
			System.out.println("Succssfully, get a coupon from CUSTOMER table");
			return coupon;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't get a coupon form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}
		return null;
	}

	public void addCouponPurchase(int CustomerID, int copounID) {
		CustomerVsCoupon customerVsCoupon = new CustomerVsCoupon(1, CustomerID, copounID);

		String sql = ((CustomerVsCouponQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS_VS_COUPONS))
				.addCustomerVsCoupon(customerVsCoupon);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			if (st.execute(sql))
				System.out.println("Succssfully, link a coupon with customer into CUSTOMER_VS_COUPONS table");

		} catch (SQLException e) {
			System.out.print("We have duplicate ");
			System.out.println("Failed, we can't link a coupon with customer form CUSTOMER_VS_COUPONS table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public void deleteCouponPurchase(int customerID, int couponID) {
		String sql = ((CustomerVsCouponQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS_VS_COUPONS))
				.deleteCustomerVsCouponRow(new CustomerVsCoupon(1, customerID, couponID));
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);

			System.out.println("Succssfully, deleted into CUSTOMER_VS_COUPONS table");

		} catch (SQLException e) {

			System.out.println("Failed, we can't delete form CUSTOMER_VS_COUPONS table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

}
