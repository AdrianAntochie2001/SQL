package model;

import java.sql.Date;

public class Articolo {

	private String codart;
	private String descrizione;
	private String um;
	private String codstat;
	private int pzcart;
	private int pesonetto;
	private int idiva;
	private int idstatoart;
	private Date datacreazione;
	private int idfamass;

	public Articolo(String codart, String descrizione, String um, String codstat, int pzcart, int pesonetto, int idiva,
			int idstatoart, int idfamass) {
		this.setCodart(codart);
		this.setDescrizione(descrizione);
		this.setUm(um);
		this.setCodstat(codstat);
		this.setPzcart(pzcart);
		this.setPesonetto(pesonetto);
		this.setIdiva(idiva);
		this.setIdstatoart(idstatoart);
		this.setIdfamass(idfamass);
	}

	public Articolo(String codart) {
		this.setCodart(codart);
	}

	public String getCodart() {
		return codart;
	}

	public void setCodart(String codart) {
		this.codart = codart;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public String getCodstat() {
		return codstat;
	}

	public void setCodstat(String codstat) {
		this.codstat = codstat;
	}

	public int getPesonetto() {
		return pesonetto;
	}

	public void setPesonetto(int pesonetto) {
		this.pesonetto = pesonetto;
	}

	public int getIdiva() {
		return idiva;
	}

	public void setIdiva(int idiva) {
		this.idiva = idiva;
	}

	public int getIdstatoart() {
		return idstatoart;
	}

	public void setIdstatoart(int idstatoart) {
		this.idstatoart = idstatoart;
	}

	public Date getDatacreazione() {
		return datacreazione;
	}

	public void setDatacreazione(Date datacreazione) {
		this.datacreazione = datacreazione;
	}

	public int getIdfamass() {
		return idfamass;
	}

	public void setIdfamass(int idfamass) {
		this.idfamass = idfamass;
	}

	public int getPzcart() {
		return pzcart;
	}

	public void setPzcart(int pzcart) {
		this.pzcart = pzcart;
	}

}
