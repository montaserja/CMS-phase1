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
		sql.append("SELECt * FROM ");
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
