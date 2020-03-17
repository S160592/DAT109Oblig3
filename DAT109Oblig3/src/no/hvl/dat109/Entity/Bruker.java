package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bruker database table.
 * 
 */
@Entity
@NamedQuery(name="Bruker.findAll", query="SELECT b FROM Bruker b")
public class Bruker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String telefon;

	private String etternavn;

	private String fornavn;

	//bi-directional many-to-one association to Historikk
	@OneToMany(mappedBy="bruker")
	private List<Historikk> historikks;

	public Bruker() {
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return this.fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public List<Historikk> getHistorikks() {
		return this.historikks;
	}

	public void setHistorikks(List<Historikk> historikks) {
		this.historikks = historikks;
	}

	public Historikk addHistorikk(Historikk historikk) {
		getHistorikks().add(historikk);
		historikk.setBruker(this);

		return historikk;
	}

	public Historikk removeHistorikk(Historikk historikk) {
		getHistorikks().remove(historikk);
		historikk.setBruker(null);

		return historikk;
	}

}