package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import dao.infc.CouponsDAO;
import mapper.imp.MyMapperCouponImp;
import model.db.Coupon;
import model.db.CustomerVsCoupon;
import sqlQuery.CouponQuery;
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
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, new coupon is inserted", "Failed, new coupon is not inserted", true);

	}

	public void updateCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).updateCoupon(coupon);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, coupon is updated", "Failed, coupon is not updated", true);
	}

	public void deleteCoupon(int couponID) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).deleteRow(DBConstants.COUPONS,
				couponID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, coupon is deleted", "Failed, coupon is not deleted", true);

	}

	public ArrayList<Coupon> getAllCoupons() {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
				.selectAllData(DBConstants.COUPONS);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, "Succssfully, fetch all coupons", "Failed, can't fetch coupons", false);

		ArrayList<Coupon> coupons = MyMapperCouponImp.getInstance().convertResultSetToArrayListOfCoupon(rs);
		System.out.println(coupons);
		return coupons;

	}

	public Coupon getOneCoupon(int couponID) {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).selectOneRow(DBConstants.COUPONS,
				DBConstants.ID, couponID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, "Succssfully, get a coupon from CUSTOMER table",
				"Failed, we can't get a coupon form CUSTOMER table", false);

		Coupon coupon = MyMapperCouponImp.getInstance().convertResultSetToCoupon(rs);
		System.out.println(coupon);

		return coupon;

	}

	public void addCouponPurchase(int CustomerID, int copounID) {
		CustomerVsCoupon customerVsCoupon = new CustomerVsCoupon(1, CustomerID, copounID);

		String sql = ((CustomerVsCouponQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS_VS_COUPONS))
				.addCustomerVsCoupon(customerVsCoupon);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, link a coupon with customer into CUSTOMER_VS_COUPONS table",
				"Failed, we can't link a coupon with customer form CUSTOMER_VS_COUPONS table", true);

	}

	public void deleteCouponPurchase(int customerID, int couponID) {
		String sql = ((CustomerVsCouponQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS_VS_COUPONS))
				.deleteCustomerVsCouponRow(new CustomerVsCoupon(1, customerID, couponID));
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, deleted into CUSTOMER_VS_COUPONS table",
				"Failed, we can't delete form CUSTOMER_VS_COUPONS table", true);
	}

}
