package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * The persistent class for the avfallstype database table.
 * 
 */
@Entity
@Table(name = "Avfallstype", schema = "oblig3")

@NamedQuery(name = "Avfallstype.findAll", query = "SELECT a FROM Avfallstype a")
public class Avfallstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Expose
	private String typenavn;
	@Expose
	private String avfallsbeskrivelse;

	// bi-directional many-to-many association to Avfallsplass
	@ManyToMany
	@JoinTable(name = "leveringsplass", schema = "oblig3", joinColumns = { @JoinColumn(name = "avfallstype") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	@Expose
	private List<Avfallsplass> avfallsplass;

	// bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy = "avfallstype")
	private List<Produkt> produkts;

	public Avfallstype() {
	}

	public String getTypenavn() {
		return this.typenavn;
	}

	public void setTypenavn(String typenavn) {
		this.typenavn = typenavn;
	}

	public String getAvfallsbeskrivelse() {
		return this.avfallsbeskrivelse;
	}

	public void setAvfallsbeskrivelse(String avfallsbeskrivelse) {
		this.avfallsbeskrivelse = avfallsbeskrivelse;
	}

	public List<Avfallsplass> getAvfallsplasses() {
		return this.avfallsplass;
	}

	public void setAvfallsplasses(List<Avfallsplass> avfallsplasses) {
		this.avfallsplass = avfallsplasses;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

	public Produkt addProdukt(Produkt produkt) {
		getProdukts().add(produkt);
		produkt.setAvfallstypeBean(this);

		return produkt;
	}

	public Produkt removeProdukt(Produkt produkt) {
		getProdukts().remove(produkt);
		produkt.setAvfallstypeBean(null);

		return produkt;
	}

	@Override
	public String toString() {
		return "Avfallstype [typenavn=" + typenavn + ", avfallsbeskrivelse=" + avfallsbeskrivelse + ", avfallsplass="
				+ avfallsplass + ", produkts=" + produkts + "]";
	}
	

}