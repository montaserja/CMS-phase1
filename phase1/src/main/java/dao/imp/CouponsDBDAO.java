package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import constants.MsgLog;
import constants.OperationCRUD;
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
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Inserted),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Inserted), true);

	}

	public void updateCoupon(Coupon coupon) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).updateCoupon(coupon);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Updated),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Updated), true);
	}

	public void deleteCoupon(int couponID) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).deleteRow(DBConstants.COUPONS,
				couponID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Deleted),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Deleted), true);

	}

	public ArrayList<Coupon> getAllCoupons() {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
				.selectAllData(DBConstants.COUPONS);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.COUPONS, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.COUPONS, OperationCRUD.Fteched), false);

		ArrayList<Coupon> coupons = MyMapperCouponImp.getInstance().convertResultSetToArrayListOfCoupon(rs);
		System.out.println(coupons);
		return coupons;

	}
	
	public ArrayList<Coupon> getAllCoupons(DBConstants client ,int ID) {//insert table and company or customer id --> DBConstant.COUPONS when you need company

		String sql = null;
		
		if(client.equals(DBConstants.Customer)) {
			//SELECT * FROM cms.coupons INNER JOIN cms.customers_vs_coupons ON cms.coupons.ID = cms.customers_vs_coupons.COUPON_ID AND cms.customers_vs_coupons.CUSTOMER_ID =1;

			sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
				.selectOneRowInnerJoin(DBConstants.COUPONS ,DBConstants.CUSTOMERS_VS_COUPONS,DBConstants.ID
						,DBConstants.COUPON_ID, DBConstants.CUSTOMER_ID , ID);

		}
		else if(client.equals(DBConstants.Company)) {
			sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
					.selectOneRow(DBConstants.COUPONS, DBConstants.COMPANY_ID , ID);
		}
		else {
			System.out.println("client type not supported");
			return null;
		}
		
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.COUPONS, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.COUPONS, OperationCRUD.Fteched), false);
		
		
		ArrayList<Coupon> coupons = MyMapperCouponImp.getInstance().convertResultSetToArrayListOfCoupon(rs);

		return coupons;
	}
	
	
	public ArrayList<Coupon> getAllCoupons(double maxPrice , int CompanyID) {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS))
				.selectSmallerThanVal(DBConstants.COUPONS , DBConstants.COMPANY_ID,CompanyID ,DBConstants.PRICE, maxPrice);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.COUPONS, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.COUPONS, OperationCRUD.Fteched), false);

		ArrayList<Coupon> coupons = MyMapperCouponImp.getInstance().convertResultSetToArrayListOfCoupon(rs);
		//System.out.println(coupons);
		return coupons;
	}
	

	public Coupon getOneCoupon(int couponID) {

		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).selectOneRow(DBConstants.COUPONS,
				DBConstants.ID, couponID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Fteched),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Fteched), false);

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
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Purchase),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Purchase), true);

	}

	public void deleteCouponPurchase(int customerID, int couponID) {
		String sql = ((CustomerVsCouponQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS_VS_COUPONS))
				.deleteCustomerVsCouponRow(new CustomerVsCoupon(1, customerID, couponID));
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.DeletePurchase),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.DeletePurchase), true);
	}
	
	public Coupon getCouponByNameAndComId(String title, int CompanyID) {
		String sql = ((CouponQuery) QueryFactory.createInstance(DBConstants.COUPONS)).selectOneRowTwoCondsIntStr(DBConstants.COUPONS,
				DBConstants.COMPANY_ID, CompanyID , DBConstants.TITLE , title);
		System.out.println(sql);
		
		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, MsgLog.msgSuccss(DBConstants.Coupon, OperationCRUD.Selected),
				MsgLog.msgError(DBConstants.Coupon, OperationCRUD.Selected), false);
		
		Coupon coupon = MyMapperCouponImp.getInstance().convertResultSetToCoupon(rs);
		
		return coupon;
		
	}

}
