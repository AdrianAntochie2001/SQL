package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.DAOException;
import model.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {

	@Override
	protected Cliente makeBean(ResultSet rs) throws SQLException {
		return null;
	}

	public void premioFidelity(Cliente cliente) throws DAOException {
		Transaction transaction = new Transaction() {
			@Override
			public void buildStatements(Connection conn) throws DAOException {
				try {
					CallableStatement pstmt = conn.prepareCall(getQuery("premio_fidelity"));
					pstmt.setInt(1, cliente.getAnno());
					pstmt.setInt(2, cliente.getMese());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException(e);
				}
			}
		};
		transaction.execute();
	}
	public void couponFidelity(Cliente cliente) throws DAOException {
		Transaction transaction = new Transaction() {
			@Override
			public void buildStatements(Connection conn) throws DAOException {
				try {
					CallableStatement pstmt = conn.prepareCall(getQuery("cuopon_fidelity"));
					pstmt.setInt(1, cliente.getNumspese());
					pstmt.setInt(2, cliente.getMese());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException(e);
				}
			}
		};
		transaction.execute();
	}
	
	
}
