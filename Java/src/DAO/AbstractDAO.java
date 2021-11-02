package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import Exception.DAOException;
import Exception.DBManagerException;

public abstract class AbstractDAO<T> {

	private DBManager dbManager;

	public abstract class Transaction {
		private List<PreparedStatement> statements;
		private Connection conn = null;

		public void execute() throws DAOException {
			try {
				conn = getConnection();
				boolean autocommit = conn.getAutoCommit();
				int isolation = conn.getTransactionIsolation();

				conn.setAutoCommit(false);
				conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

				buildStatements(conn);

				conn.commit();
				conn.setAutoCommit(autocommit);
				conn.setTransactionIsolation(isolation);
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					if (conn != null)
						conn.rollback();
					throw new DAOException(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DAOException(e1);
				}
			} finally {

				try {
					if (statements != null) {
						for (PreparedStatement st : statements) {
							st.close();
						}
					}
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (statements != null)
					statements.clear();
			}
		}

		public PreparedStatement getPreparedStatement(String query) throws DAOException {
			if (statements == null)
				statements = new ArrayList<PreparedStatement>();
			PreparedStatement statement;

			try {
				statement = conn.prepareStatement(query);
				statements.add(statement);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e);
			}
			return statement;
		}

		protected abstract void buildStatements(Connection conn) throws DAOException;
	}

	public AbstractDAO() {
		try {
			dbManager = DBManager.getInstance();
		} catch (DBManagerException e) {
			System.err.println("AbstractDAO:" + e.getMessage());
		}
	}

	protected Connection getConnection() throws SQLException {
		if (dbManager != null) {
			return dbManager.getConnection();
		}
		return null;
	}

	protected PreparedStatement prepareStatement(Connection conn, String queryId) throws SQLException {
		return conn.prepareStatement(dbManager.getQuery(queryId));
	}

	protected List<T> rsReader(ResultSet rs) throws SQLException {
		ArrayList<T> beans = new ArrayList<>();
		while (rs.next())
			beans.add(makeBean(rs));
		return beans;
	}

	protected String getQuery(String queryId) {
		return dbManager.getQuery(queryId);
	}

	protected abstract T makeBean(ResultSet rs) throws SQLException;

}