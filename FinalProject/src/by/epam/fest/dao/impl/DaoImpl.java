package by.epam.fest.dao.impl;

import by.epam.fest.dao.pool.ConnectionPool;
import by.epam.fest.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class DaoImpl {

	protected Connection connection;
	public void setConnection() {
		try {
			this.connection = ConnectionPool.INSTANCE.getConnection();
		}catch (DaoException e){
		}
	}

	protected Connection getDBConnection() throws SQLException {

		ResourceBundle rb = ResourceBundle.getBundle("db_config");
		String url = rb.getString("db.url");
		String driver = rb.getString("db.driver.name");
		String dbUser = rb.getString("db.login");
		String dbPass = rb.getString("db.pass");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
		return conn;
	}
	protected void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}