package sqlQuery;

import constants.DBConstants;
import model.db.Company;

public class CompanyQuery extends GenQuery {

	static GenQuery _instance = null;

	public static GenQuery getInstance() {
		if (_instance == null) {
			_instance = new CompanyQuery();
		}
		return _instance;

	}

	private CompanyQuery() {
	}

	public String addCompany(Company company) {
		StringBuilder sql = new StringBuilder();
		sql.append("NSERT INTO ");
		sql.append(DBConstants.Company);
		sql.append(" (");
		sql.append(DBConstants.NAME);
		sql.append(", ");
		sql.append(DBConstants.EMAIL);
		sql.append(", ");
		sql.append(DBConstants.PASSWORD);
		sql.append(") VALUES( ");
		sql.append(company.getName());
		sql.append(", ");
		sql.append(company.getEmail());
		sql.append(", ");

		sql.append(company.getPassword());
		sql.append(")");

		return sql.toString();
	}

	public String updateCompany(Company company) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(DBConstants.Company);
		sql.append(" SET ");
		sql.append(DBConstants.NAME);
		sql.append("=");
		sql.append(company.getName());
		sql.append(", ");

		sql.append(DBConstants.EMAIL);
		sql.append("=");
		sql.append(company.getEmail());
		sql.append(", ");

		sql.append(DBConstants.PASSWORD);
		sql.append("=");
		sql.append(company.getPassword());

		return sql.toString();
	}

}
