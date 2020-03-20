package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produkt database table.
 * 
 */
@Entity
@Table(name = "Produkt", schema = "oblig3")
@NamedQuery(name="Produkt.findAll", query="SELECT p FROM Produkt p")
public class Produkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String barcode;

	private String navn;

	//bi-directional many-to-one association to Historikk
	@OneToMany(mappedBy="produkt")
	private List<Historikk> historikks;

	//bi-directional many-to-one association to Avfallstype
	@ManyToOne
	@JoinColumn(name="avfallstype")
	private Avfallstype avfallstypeBean;

	public Produkt() {
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<Historikk> getHistorikks() {
		return this.historikks;
	}

	public void setHistorikks(List<Historikk> historikks) {
		this.historikks = historikks;
	}

	public Historikk addHistorikk(Historikk historikk) {
		getHistorikks().add(historikk);
		historikk.setProdukt(this);

		return historikk;
	}

	public Historikk removeHistorikk(Historikk historikk) {
		getHistorikks().remove(historikk);
		historikk.setProdukt(null);

		return historikk;
	}

	public Avfallstype getAvfallstypeBean() {
		return this.avfallstypeBean;
	}

	public void setAvfallstypeBean(Avfallstype avfallstypeBean) {
		this.avfallstypeBean = avfallstypeBean;
	}

	@Override
	public String toString() {
		return "Produkt [barcode=" + barcode + ", navn=" + navn + "]";
	}
	
	

}