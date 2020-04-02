package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

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
	@Expose
	private String strekkode;
	@Expose
	private String produktnavn;
	@Expose
	private String produkttype;
	@Expose
	private String produsent;

	//bi-directional many-to-one association to Leveringsoversikt
	@OneToMany(mappedBy="produkt")
	private List<Leveringsoversikt> leveringsoversikt;

	//bi-directional many-to-one association to Avfallstype
	@ManyToOne
	@JoinColumn(name="avfallstype")
	@Expose
	private Avfallstype avfallstype;

	public Produkt() {
	}
	

	public Produkt(String strekkode, String produktnavn, String produkttype) {
		super();
		this.strekkode = strekkode;
		this.produktnavn = produktnavn;
		this.produkttype = produkttype;
	}


	public String getStrekkode() {
		return this.strekkode;
	}

	public void setStrekkode(String strekkode) {
		this.strekkode = strekkode;
	}

	public String getProduktnavn() {
		return this.produktnavn;
	}

	public void setProduktnavn(String produktnavn) {
		this.produktnavn = produktnavn;
	}

	public String getProdukttype() {
		return this.produkttype;
	}

	public void setProdukttype(String produkttype) {
		this.produkttype = produkttype;
	}

	public String getProdusent() {
		return this.produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public List<Leveringsoversikt> getLeveringsoversikts() {
		return this.leveringsoversikt;
	}

	public void setLeveringsoversikt(List<Leveringsoversikt> leveringsoversikt) {
		this.leveringsoversikt = leveringsoversikt;
	}

	public Leveringsoversikt addLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		getLeveringsoversikts().add(leveringsoversikt);
		leveringsoversikt.setProdukt(this);

		return leveringsoversikt;
	}
	

	public Leveringsoversikt removeLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		getLeveringsoversikts().remove(leveringsoversikt);
		leveringsoversikt.setProdukt(null);

		return leveringsoversikt;
	}

	public Avfallstype getAvfallstypeBean() {
		return this.avfallstype;
	}

	public void setAvfallstypeBean(Avfallstype avfallstypeBean) {
		this.avfallstype = avfallstypeBean;
	}
	

}