package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.ConnectionPool;
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
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, inserted a new company into Company table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't insert a new company form Company table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public void updateCompany(Company company) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES)).updateCompany(company);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, updated a customer into Company table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't update a new customer form Company table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public void deleteCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.deleteRow(DBConstants.COMPANIES, companyID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, deleted a customer into Company table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't delete a new customer form Company table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public ArrayList<Company> getAllCompanies() {
		// connection into DB

		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectAllData(DBConstants.COMPANIES);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no copmanies");
				return null;
			}

			ArrayList<Company> companies = MyMapperCompanyImp.getInstance().convertResultSetToArrayListOfCompany(rs);
			System.out.println(companies);
			System.out.println("Succssfully, get all customers from CUSTOMER table");
			return companies;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't get all customers form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

		return null;
	}

	public Company getOneCompany(int companyID) {
		String sql = ((CompanyQuery) QueryFactory.createInstance(DBConstants.COMPANIES))
				.selectOneRow(DBConstants.COMPANIES, DBConstants.ID, companyID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no company with ID: ");
				System.out.print(companyID);
				return null;
			}

			Company company = MyMapperCompanyImp.getInstance().convertResultSetToCompany(rs);
			System.out.println(company);
			System.out.println("Succssfully, get a customer from CUSTOMER table");
			return company;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't get a customer form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}
		return null;
	}

}
