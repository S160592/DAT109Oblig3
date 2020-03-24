package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avfallstype database table.
 * 
 */
@Entity
@Table(name = "Avfallstype", schema = "oblig3")

@NamedQuery(name="Avfallstype.findAll", query="SELECT a FROM Avfallstype a")
public class Avfallstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typenavn;

	private String avfallsbeskrivelse;

	//bi-directional many-to-many association to Avfallsplass
	@ManyToMany
	@JoinTable(
		name="leveringsplass"
		, joinColumns={
			@JoinColumn(name="avfallstype")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Avfallsplass> avfallsplasses;

	//bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy="avfallstypeBean")
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
		return this.avfallsplasses;
	}

	public void setAvfallsplasses(List<Avfallsplass> avfallsplasses) {
		this.avfallsplasses = avfallsplasses;
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

}