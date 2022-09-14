package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import dao.infc.CompaniesDAO;
import mapper.imp.MyMapperCompanyImp;
import model.db.Company;
import sqlQuery.CompanyQuery;
import sqlQuery.QueryFactory;

public class CompaniesDBDAO implements CompaniesDAO {
	private ConnectionPool connectionPool;

	public CompaniesDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Boolean isCompanyExists(String email, String password) {
		return null;
	}

	public void addCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).addCompany(company);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, a new company is inserted", "Failed, a new company is not inserted", true);

	}

	public void updateCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).updateCompany(company);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, the copmany is updated", "Failed, the copmany is not updated", true);

	}

	public void deleteCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.deleteRow(DBConstants.COMPANIES, companyID);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, the company is deleted", "Failed, the company is not deleted", true);

	}

	public ArrayList<Company> getAllCompanies() {

		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectAllData(DBConstants.COMPANIES);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, "Succssfully, get all customers from CUSTOMER table",
				"Failed, we can't get all customers form CUSTOMER table", false);

		ArrayList<Company> companies = MyMapperCompanyImp.getInstance().convertResultSetToArrayListOfCompany(rs);
		System.out.println(companies);
		System.out.println("Succssfully, get all customers from CUSTOMER table");
		return companies;

	}

	public Company getOneCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectOneRow(DBConstants.COMPANIES, DBConstants.ID, companyID);
		System.out.println(sql);
		Connection con = null;

		con = this.connectionPool.getConnection();
		ResultSet rs = DB.excute(sql, con, "Succssfully, get all customers from CUSTOMER table",
				"Failed, we can't get all customers form CUSTOMER table", false);

		Company company = MyMapperCompanyImp.getInstance().convertResultSetToCompany(rs);
		System.out.println(company);
		System.out.println("Succssfully, get a customer from CUSTOMER table");
		return company;

	}

}
