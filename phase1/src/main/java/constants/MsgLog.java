package constants;

public class MsgLog {
	public static String msgSuccss(DBConstants subject, OperationCRUD operation) {
		StringBuilder res = new StringBuilder();
		res.append("Succssfully,");
		res.append(subject);
		res.append(" ");
		res.append(operation);

		return res.toString();
	}

	public static String msgError(DBConstants subject, OperationCRUD operation) {
		StringBuilder res = new StringBuilder();
		res.append("Failed,");
		res.append(subject);
		res.append(" ");
		res.append(operation);

		return res.toString();
	}

}
