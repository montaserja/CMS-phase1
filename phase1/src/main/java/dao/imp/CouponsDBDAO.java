package dao.imp;

import java.util.ArrayList;

import constants.DBConstants;
import dao.infc.CouponsDAO;
import model.db.Coupon;
import model.db.Customer;
import sqlQuery.CouponQuery;
import sqlQuery.CustomerQuery;
import sqlQuery.QueryFactory;

public class CouponsDBDAO implements CouponsDAO {
	// private ConnectionPool connectionPool;

	public void addCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).addCoupon(coupon);
		// connection and execute
	}

	public void updateCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).updateCoupon(coupon);
	}

	public void deleteCoupon(int couponID) {
//		DELETE FROM table_name WHERE condition;
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).deleteRow(DBConstants.Coupon,
				couponID);

		// connection into DB
		// execute query
		// check if happened roll up - handle exception

	}

	public ArrayList<Coupon> getAllCoupons() {
		// connection into DB

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).selectAllData(DBConstants.Coupon);

		// execute query and get table of Company and save it in ResultSet
		// pass on ResultSet and convert it to Array of Customer

		return null;
	}

	public Coupon getOneCoupon(int couponID) {
		// connection into DB

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).selectOneRow(DBConstants.Coupon,
				DBConstants.ID, couponID);
		// execute query and get table of Company and save it in ResultSet

		// pass on ResultSet and convert it to Array of Customer
		return null;
	}

	public void addCouponPurchase(int CustomerID, int copounID) {
//		String sqlCoupon = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon));
		String sqlGetCustomer = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer)).selectOneRow(null,
				DBConstants.ID, CustomerID);
		// ResultSet
		// Convert to Customer
		Customer customer = null;
		String sqlCustomer = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer)).addCustomer(customer);
	}

	public void deleteCouponPurchase(int customerID, int couponID) {
		String sqlCoupon = ((CouponQuery) QueryFactory.createInstance(DBConstants.Coupon)).deleteRow(DBConstants.Coupon,
				couponID);
		String sqlCustomer = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer))
				.deleteRow(DBConstants.Customer, customerID);

	}

}
