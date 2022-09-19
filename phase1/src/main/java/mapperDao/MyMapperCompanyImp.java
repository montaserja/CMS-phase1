package mapperDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.DBConstants;
import model.db.Company;

public class MyMapperCompanyImp implements mapperDao.MyMapperCompanyInfc {
	public static MyMapperCompanyImp instance;

	public static MyMapperCompanyImp getInstance() {
		if (instance == null)
			return new MyMapperCompanyImp();
		return instance;
	}

	public ArrayList<Company> convertResultSetToArrayListOfCompany(ResultSet rs) {
		ArrayList<Company> companies = new ArrayList<Company>();
		try {
			do {
				companies.add(convertResultSetToCompany(rs));// first element

			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

	public Company convertResultSetToCompany(ResultSet rs) {

		try {
			return new Company(rs.getInt(DBConstants.ID.toString()), rs.getString(DBConstants.NAME.toString()),
					rs.getString(DBConstants.EMAIL.toString()), rs.getString(DBConstants.PASSWORD.toString()));
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			//System.out.println("result set is null");
		}
		return null;
	}

}
