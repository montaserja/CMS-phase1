package sqlQuery;

import constants.DBConstants;
import constants.sqlQueries;
import model.db.Customer;

public class CustomerQuery extends GenQuery {

	static GenQuery _instance = null;

	public static GenQuery getInstance() {
		if (_instance == null) {
			_instance = new CustomerQuery();
		}
		return _instance;

	}

	private CustomerQuery() {
	}

	public String updateCustomer(Customer customer) {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS);
		sql.append(" SET ");
		sql.append(DBConstants.FIRST_NAME);
		sql.append("='");
		sql.append(customer.getFirstName());
		sql.append("', ");

		sql.append(DBConstants.LAST_NAME);
		sql.append("='");
		sql.append(customer.getLastName());
		sql.append("', ");

		sql.append(DBConstants.EMAIL);
		sql.append("='");
		sql.append(customer.getEmail());
		sql.append("', ");

		sql.append(DBConstants.PASSWORD);
		sql.append("='");
		sql.append(customer.getPassword());
		sql.append("' where ");
		sql.append(DBConstants.ID);
		sql.append("=");
		sql.append(customer.getId());

		sql.append(";");

		return sql.toString();
	}

	public String addCustomer(Customer customer) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS);
		sql.append(" (");
		sql.append(DBConstants.FIRST_NAME);
		sql.append(", ");
		sql.append(DBConstants.LAST_NAME);
		sql.append(", ");
		sql.append(DBConstants.EMAIL);
		sql.append(", ");
		sql.append(DBConstants.PASSWORD);
		sql.append(") VALUES( '");
		sql.append(customer.getFirstName());
		sql.append("', '");
		sql.append(customer.getLastName());
		sql.append("', '");
		sql.append(customer.getEmail());
		sql.append("', '");
		sql.append(customer.getPassword());
		sql.append("');");

		return sql.toString();

	}

}
