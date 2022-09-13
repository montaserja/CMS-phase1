package sqlQuery;

import constants.DBConstants;

public class QueryFactory {

	public static GenQuery createInstance(DBConstants nameTable) {

		if (nameTable == DBConstants.Customer) {
			return CustomerQuery.getInstance();

		} else if (nameTable == DBConstants.Company) {
			return CompanyQuery.getInstance();
		}
		return CouponQuery.getInstance();

	}
}
