package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exception.DAOException;
import model.Articolo;


public class ArticoloDAO extends AbstractDAO<Articolo> {

	@Override
	protected Articolo makeBean(ResultSet rs) throws SQLException {
		return new Articolo(rs.getString("codart"), rs.getString("descrizione"), rs.getString("um"),
				rs.getString("codstat"), rs.getInt("pzcart"), rs.getInt("pesonetto"), rs.getInt("idiva"),
				rs.getInt("idstatoart"), rs.getInt("idfamass"));

	}

	public List<Articolo> getArticoli() {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			return rsReader(stmt.executeQuery(getQuery("lista_articoli")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Articolo>();
	}

	public void inserisciArticolo(Articolo articolo) throws DAOException {
		Transaction transaction = new Transaction() {
			@Override
			public void buildStatements(Connection conn) throws DAOException {
				try {
					CallableStatement cs = conn.prepareCall(getQuery("inserisci_articolo"));
					cs.setString(1, articolo.getCodart());
					cs.setString(2, articolo.getDescrizione());
					cs.setString(3, articolo.getUm());
					cs.setString(4, articolo.getCodstat());
					cs.setInt(5, articolo.getPzcart());
					cs.setInt(6, articolo.getPesonetto()); // cambia in string
					cs.setInt(7, articolo.getIdiva());
					cs.setInt(8, articolo.getIdstatoart());
					cs.setInt(9, articolo.getIdfamass());
					cs.execute();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException(e);
				}
			}
		};
		transaction.execute();
	}

	public void cancellaArticolo(Articolo articolo) throws DAOException {
		Transaction transaction = new Transaction() {
			@Override
			public void buildStatements(Connection conn) throws DAOException {
				try {
					CallableStatement pstmt = conn.prepareCall(getQuery("cancella_articolo"));
					pstmt.setString(1, articolo.getCodart());
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
