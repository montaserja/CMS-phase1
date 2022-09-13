package dao.imp;

import java.util.ArrayList;

import constants.DBConstants;
import dao.infc.CompaniesDAO;
import model.db.Company;
import sqlQuery.CompanyQuery;
import sqlQuery.CouponQuery;
import sqlQuery.QueryFactory;

public class CompaniesDBDAO implements CompaniesDAO {
	// private ConnectionPool connectionPool;

	public Boolean isCompanyExists(String email, String password) {
		return null;
	}

	public void addCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.Company)).addCompany(company);
	}

	public void updateCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.Company)).updateCompany(company);
	}

	public void deleteCompany(int companyID) {
//		DELETE FROM table_name WHERE condition;
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.Company)).deleteRow(DBConstants.Company,
				companyID);

		// connection into DB
		// execute query
		// check if happened roll up - handle exception

	}

	public ArrayList<Company> getAllCompanies() {
		// connection into DB

		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.Company))
				.selectAllData(DBConstants.Company);

		// execute query and get table of Company and save it in ResultSet
		// pass on ResultSet and convert it to Array of Customer

		return null;
	}

	public Company getOneCompany(int companyID) {
		// connection into DB

		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.Company)).selectOneRow(DBConstants.Company,
				DBConstants.ID, companyID);
		// execute query and get table of Company and save it in ResultSet

		// pass on ResultSet and convert it to Array of Customer
		return null;
	}

}
