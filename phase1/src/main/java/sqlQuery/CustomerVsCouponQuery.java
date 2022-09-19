package sqlQuery;

import constants.DBConstants;
import constants.sqlQueries;
import model.db.CustomerVsCoupon;

public class CustomerVsCouponQuery extends GenQuery {
	static CustomerVsCouponQuery _instance = null;

	public static CustomerVsCouponQuery getInstance() {
		if (_instance == null) {
			_instance = new CustomerVsCouponQuery();
		}
		return _instance;

	}

	private CustomerVsCouponQuery() {
	}

	public String addCustomerVsCoupon(CustomerVsCoupon CustomerVsCoupon) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(" (");
		sql.append(DBConstants.CUSTOMER_ID);
		sql.append(", ");
		sql.append(DBConstants.COUPON_ID);

		sql.append(") VALUES( ");
		sql.append(CustomerVsCoupon.getCustomerID());
		sql.append(", ");
		sql.append(CustomerVsCoupon.getCouponID());
		sql.append(");");

		return sql.toString();

	}
	
	public String checkCustomerVsCoupon(CustomerVsCoupon CustomerVsCoupon) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(" WHERE ");
		sql.append(DBConstants.CUSTOMER_ID);
		sql.append(" = ");
		sql.append(CustomerVsCoupon.getCustomerID());
		sql.append(" AND ");
		sql.append(DBConstants.COUPON_ID);
		sql.append(" = ");
		sql.append(CustomerVsCoupon.getCouponID());

		return sql.toString();

	}
	public String deleteCustomerVsCouponRow(CustomerVsCoupon CustomerVsCoupon) {// -1 means we don't have id
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(" WHERE ");
		if(CustomerVsCoupon.getCustomerID() != -1) {
		sql.append(DBConstants.CUSTOMER_ID);
		sql.append("=");
		sql.append(CustomerVsCoupon.getCustomerID());
		}
		
		if(CustomerVsCoupon.getCustomerID() != -1 && CustomerVsCoupon.getCouponID() != -1)
			sql.append(" AND ");
		
		if(CustomerVsCoupon.getCouponID() != -1) {
		sql.append(DBConstants.COUPON_ID);
		sql.append("=");
		sql.append(CustomerVsCoupon.getCouponID());
		}
		sql.append(";");

		return sql.toString();		

	}
	
}
