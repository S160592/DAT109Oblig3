package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historikk database table.
 * 
 */
@Entity
@NamedQuery(name="Historikk.findAll", query="SELECT h FROM Historikk h")
public class Historikk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Bruker
	@ManyToOne
	@JoinColumn(name="brukerid")
	private Bruker bruker;

	//bi-directional many-to-one association to Produkt
	@ManyToOne
	@JoinColumn(name="produktnr")
	private Produkt produkt;

	public Historikk() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bruker getBruker() {
		return this.bruker;
	}

	public void setBruker(Bruker bruker) {
		this.bruker = bruker;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}