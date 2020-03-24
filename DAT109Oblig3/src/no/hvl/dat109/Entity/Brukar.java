package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brukar database table.
 * 
 */
@Entity
@Table(name = "Brukar", schema = "oblig3")
@NamedQuery(name="Brukar.findAll", query="SELECT b FROM Brukar b")
public class Brukar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String telefon;

	private String etternavn;

	private String fornavn;

	private String passord;

	//bi-directional many-to-one association to Leveringsoversikt
	@OneToMany(mappedBy="brukarBean")
	private List<Leveringsoversikt> leveringsoversikts;

	public Brukar() {
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

	public String getPassord() {
		return this.passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public List<Leveringsoversikt> getLeveringsoversikts() {
		return this.leveringsoversikts;
	}

	public void setLeveringsoversikts(List<Leveringsoversikt> leveringsoversikts) {
		this.leveringsoversikts = leveringsoversikts;
	}

	public Leveringsoversikt addLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		getLeveringsoversikts().add(leveringsoversikt);
		leveringsoversikt.setBrukarBean(this);

		return leveringsoversikt;
	}

	public Leveringsoversikt removeLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		getLeveringsoversikts().remove(leveringsoversikt);
		leveringsoversikt.setBrukarBean(null);

		return leveringsoversikt;
	}

}