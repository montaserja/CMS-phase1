package mapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.DBConstants;
import model.db.Coupon;

public class MyMapperCouponImp implements mapper.infc.MyMapperCouponInfc {
	public static MyMapperCouponImp instance;

	public static MyMapperCouponImp getInstance() {
		if (instance == null)
			return new MyMapperCouponImp();
		return instance;
	}

	public ArrayList<Coupon> convertResultSetToArrayListOfCoupon(ResultSet rs) {
		ArrayList<Coupon> Coupons = new ArrayList<Coupon>();
		try {
			do {
				Coupons.add(convertResultSetToCoupon(rs));// first element

			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			//do nothing
		}
		return Coupons;
	}

	public Coupon convertResultSetToCoupon(ResultSet rs) {
		try {
			return new Coupon(rs.getInt(DBConstants.ID.toString()), rs.getInt(DBConstants.COMPANY_ID.toString()),
					rs.getInt(DBConstants.CATEGORY_ID.toString()), rs.getString(DBConstants.TITLE.toString()),
					rs.getString(DBConstants.DESCRIPTION.toString()), rs.getString(DBConstants.START_DATE.toString()),
					rs.getString(DBConstants.END_DATE.toString()), rs.getInt(DBConstants.AMOUNT.toString()),
					rs.getDouble(DBConstants.PRICE.toString()), rs.getString(DBConstants.IMAGE.toString()));

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			// do nothing
		}
		return null;
	}

}
