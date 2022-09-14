package sqlQuery;

import constants.DBConstants;

public class QueryFactory {

	public static GenQuery createInstance(DBConstants nameTable) {

		if (nameTable == DBConstants.CUSTOMERS) {
			return CustomerQuery.getInstance();

		} else if (nameTable == DBConstants.COMPANIES) {
			return CompanyQuery.getInstance();
		} else if (nameTable == DBConstants.COUPONS) {
			return CouponQuery.getInstance();
		}
		return CustomerVsCouponQuery.getInstance();

	}
}
