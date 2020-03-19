package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the avfallstype database table.
 * 
 */
@Entity
@Table(name = "Avfallstype", schema = "oblig3")
@DiscriminatorColumn(name="typenavn", 
discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name="Avfallstype.findAll", query="SELECT a FROM Avfallstype a")
public class Avfallstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typenavn;

	private String beskrivelse;

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

	public String getBeskrivelse() {
		return this.beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
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