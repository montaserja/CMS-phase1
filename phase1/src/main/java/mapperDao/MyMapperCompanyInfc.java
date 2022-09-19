package mapperDao;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.db.Company;

public interface MyMapperCompanyInfc {
	public ArrayList<Company> convertResultSetToArrayListOfCompany(ResultSet rs);

	public Company convertResultSetToCompany(ResultSet rs);

}
