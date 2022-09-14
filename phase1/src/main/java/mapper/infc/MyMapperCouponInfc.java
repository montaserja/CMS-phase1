package mapper.infc;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.db.Coupon;

public interface MyMapperCouponInfc {
	public ArrayList<Coupon> convertResultSetToArrayListOfCoupon(ResultSet rs);

	public Coupon convertResultSetToCoupon(ResultSet rs);
}
