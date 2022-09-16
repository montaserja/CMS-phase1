package sqlQuery;

import constants.DBConstants;
import constants.sqlQueries;
public abstract class GenQuery {

	public String selectAllData(DBConstants nameTable) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECt * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(";");
		return sql.toString();
	}

	public String selectOneRow(DBConstants nameTable, DBConstants nameCol, int valCol) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(nameCol);
		sql.append("=");
		sql.append(valCol);
		sql.append(";");
		return sql.toString();

	}
	
	public String selectSmallerThanVal(DBConstants nameTable, DBConstants nameCol1, int valCol1, DBConstants nameCol2, double valCol2) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(nameCol1);
		sql.append("=");
		sql.append(valCol1);
		sql.append(" AND ");
		sql.append(nameCol2);
		sql.append("<=");
		sql.append(valCol2);
		return sql.toString();

	}
	
	public String selectOneRowStrVal(DBConstants nameTable, DBConstants nameCol, String valCol) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(nameCol);
		sql.append("='");
		sql.append(valCol);
		sql.append("';");
		return sql.toString();

	}
	
	public String selectOneRowTwoConds(DBConstants nameTable, DBConstants nameCol1,DBConstants nameCol2,  String valCol1 , String valCol2) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(nameCol1);
		sql.append("='");
		sql.append(valCol1);
		sql.append("' AND ");
		sql.append(nameCol2);
		sql.append("='");
		sql.append(valCol2);
		sql.append("';");
		return sql.toString();

	}
	
	public String selectOneRowTwoCondsIntStr(DBConstants nameTable, DBConstants nameCol1, int valCol1,DBConstants nameCol2 , String valCol2) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(nameCol1);
		sql.append("=");
		sql.append(valCol1);
		sql.append(" AND ");
		sql.append(nameCol2);
		sql.append("='");
		sql.append(valCol2);
		sql.append("';");
		return sql.toString();

	}

	public String deleteRow(DBConstants nameTable, int valCol) {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(nameTable);
		sql.append(" WHERE ");
		sql.append(DBConstants.ID);
		sql.append("=");
		sql.append(valCol);
		sql.append(";");

		return sql.toString();
	}

}
