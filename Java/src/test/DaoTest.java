
package test;

import DAO.ArticoloDAO;
import DAO.ClienteDAO;
import Exception.DAOException;
import model.Cliente;

public class DaoTest {

	public static void main(String[] args) {

		ArticoloDAO articoloDAO = new ArticoloDAO();
		/*
		 * for (Articolo articolo : articoloDAO.getArticoli()) {
		 * System.out.println(articolo.getCodart());
		 * System.out.println(articolo.getDescrizione());
		 * System.out.println(articolo.getUm());
		 * System.out.println(articolo.getCodstat());
		 * System.out.println(articolo.getPesonetto());
		 * System.out.println(articolo.getIdiva());
		 * System.out.println(articolo.getIdstatoart());
		 * System.out.println(articolo.getDatacreazione());
		 * System.out.println(articolo.getIdfamass());
		 * 
		 * }
		 */

		ClienteDAO clienteDAO = new ClienteDAO();

		try {

			/*
			 * clienteDAO.premioFidelity(new Cliente(2017,7));
			 */

			clienteDAO.couponFidelity(new Cliente(25, 7));

			/*
			 * articoloDAO.inserisciArticolo(new Articolo("178150", "GATTO AL FORNO", "PZ",
			 * "", 5, 1, 22, 1, 15));
			 * 
			 * 
			 * articoloDAO.cancellaArticolo(new Articolo("178150"));
			 */

		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
