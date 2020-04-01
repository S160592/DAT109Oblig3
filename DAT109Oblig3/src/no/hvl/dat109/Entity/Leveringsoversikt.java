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
	private Brukar brukarBean;

	//bi-directional many-to-one association to Produkt
	@Expose
	@ManyToOne
	@JoinColumn(name="produkt")
	private Produkt produktBean;

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

	public Brukar getBrukarBean() {
		return this.brukarBean;
	}

	public void setBrukarBean(Brukar brukarBean) {
		this.brukarBean = brukarBean;
	}

	public Produkt getProduktBean() {
		return this.produktBean;
	}

	public void setProduktBean(Produkt produktBean) {
		this.produktBean = produktBean;
	}

}