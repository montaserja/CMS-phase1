package mapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.DBConstants;
import model.db.Company;
import model.db.Coupon;

public class MyMapperCompanyImp implements mapper.infc.MyMapperCompanyInfc {
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
			ArrayList<Coupon> coupons = null;
			return new Company(rs.getInt(DBConstants.ID.toString()), rs.getString(DBConstants.NAME.toString()),
					rs.getString(DBConstants.EMAIL.toString()), rs.getString(DBConstants.PASSWORD.toString()), coupons);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			//System.out.println("result set is null");
		}
		return null;
	}

}
