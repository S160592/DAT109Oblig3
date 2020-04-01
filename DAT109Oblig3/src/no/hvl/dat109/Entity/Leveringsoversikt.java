package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;



/**
 * The persistent class for the leveringsoversikt database table.
 * 
 */
@Entity

@Table(name = "Leveringsoversikt", schema = "oblig3")
@NamedQuery(name="Leveringsoversikt.findAll", query="SELECT l FROM Leveringsoversikt l")
public class Leveringsoversikt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Expose
	private Boolean levert;

	//bi-directional many-to-one association to Brukar
	@ManyToOne
	@JoinColumn(name="brukar")
	private Brukar brukar;

	//bi-directional many-to-one association to Produkt
	@Expose
	@ManyToOne
	@JoinColumn(name="produkt")
	private Produkt produkt;

	public Leveringsoversikt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getLevert() {
		return this.levert;
	}

	public void setLevert(Boolean levert) {
		this.levert = levert;
	}

	public Brukar getBrukar() {
		return this.brukar;
	}

	public void setBrukar(Brukar brukar) {
		this.brukar = brukar;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}