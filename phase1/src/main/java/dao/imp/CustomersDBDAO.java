package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.ConnectionPool;
import constants.DBConstants;
import dao.infc.CustomersDAO;
import mapper.imp.MyMapperCustomerImp;
import model.db.Customer;
import sqlQuery.CustomerQuery;
import sqlQuery.QueryFactory;

public class CustomersDBDAO implements CustomersDAO {
	private ConnectionPool connectionPool;

	public CustomersDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Boolean isCustomerExists(String email, String password) {
//		String sql =  CustomerQuery.getInstance().selectOneRow(DBConstants.Customer, DBConstants.ID, 0)
		return null;
	}

	public void addCustomer(Customer customer) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).addCustomer(customer);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, inserted a new customer into CUSTOMER table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't insert a new customer form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public void updateCustomer(Customer customer) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).updateCustomer(customer);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, updated a customer into CUSTOMER table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't update a new customer form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public void deleteCustomer(int customerID) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.deleteRow(DBConstants.CUSTOMERS, customerID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Succssfully, deleted a customer from CUSTOMER table");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't delete a customer form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

	}

	public ArrayList<Customer> getAllCompanies() {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectAllData(DBConstants.CUSTOMERS);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no customers");
				return null;
			}

			ArrayList<Customer> customers = MyMapperCustomerImp.getInstance().convertResultSetToArrayListOfCustomer(rs);
			System.out.println(customers);
			System.out.println("Succssfully, get all customers from CUSTOMER table");
			return customers;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed, we can't get all customers form CUSTOMER table");

		} finally {
			if (con != null)
				connectionPool.restoreConnection(con);
		}

		return null;
	}

	public Customer getOneCustomer(int customerID) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectOneRow(DBConstants.CUSTOMERS, DBConstants.ID, customerID);
		System.out.println(sql);
		Connection con = null;
		try {
			con = connectionPool.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next() == false) {
				System.out.print("Error, there is no customer with ID: ");
				System.out.print(customerID);
				return null;
			}

			Customer customer = MyMapperCustomerImp.getInstance().convertResultSetToCustomer(rs);
			System.out.println(customer);
			System.out.println("Succssfully, get a customer from CUSTOMER table");
			return customer;

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
