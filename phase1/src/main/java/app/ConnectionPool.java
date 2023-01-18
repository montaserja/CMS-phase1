package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConnectionPool {
	private Set<Connection> connections;
	private final String DB_URL;
	private final String USER;
	private final String PASS;
	public final static int MAX_CONNECTIONS = 10;

	private static ConnectionPool PoolInstance = null;

	private ConnectionPool() {

		this.DB_URL = "jdbc:mysql://localhost/";
		this.USER = "root";
		this.PASS = "1234";
		connections = new HashSet<Connection>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for (int i = 0; i < MAX_CONNECTIONS; ++i) {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				connections.add(conn);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("mostly pom.xml misses connector/j " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// Singleton instance
	public static ConnectionPool getInstance()  {
		if (PoolInstance == null)
			PoolInstance = new ConnectionPool();

		return PoolInstance;
	}

	// return connection if it have one free otherwise makes the thread wait
	public Connection getConnection() {

		synchronized (connections) {
			while (connections.size() == 0) {
				try {
					connections.wait();
				} catch (InterruptedException e) {
					System.out.println("thread waiting interupted , " + e.getMessage());
				}
			}
		}
		Connection conn = null;
		Iterator<Connection> it = connections.iterator();
		if (it.hasNext()) {
			// System.out.println(connections.size());
			conn = it.next();
			connections.remove(conn);
		}

		return conn;
	}

	// return connection to the set of connections and notify threads
	public void restoreConnection(Connection connection) {
		synchronized (connections) {
			connections.add(connection);
			connections.notifyAll();
		}
	}

	public void closeAllConnections() {
		for (Iterator<Connection> iterator = connections.iterator(); iterator.hasNext();) {
			Connection connection = (Connection) iterator.next();
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("couldn't close the connection , " + e.getMessage());
			}

		}
	}

}
