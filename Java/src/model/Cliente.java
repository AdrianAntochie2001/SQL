package model;

public class Cliente {
	private int anno;
	private int mese;
	private int numspese;

	public Cliente(int numspese, int mese) {
		this.setNumspese(numspese);
		this.setMese(mese);
	}

	

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getMese() {
		return mese;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public int getNumspese() {
		return numspese;
	}

	public void setNumspese(int numspese) {
		this.numspese = numspese;
	}
}
