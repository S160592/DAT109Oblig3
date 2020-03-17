package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avfallsplass database table.
 * 
 */
@Entity
@NamedQuery(name="Avfallsplass.findAll", query="SELECT a FROM Avfallsplass a")
public class Avfallsplass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer plassid;

	private String navn;

	//bi-directional many-to-many association to Avfallstype
	@ManyToMany(mappedBy="avfallsplasses")
	private List<Avfallstype> avfallstypes;

	public Avfallsplass() {
	}

	public Integer getPlassid() {
		return this.plassid;
	}

	public void setPlassid(Integer plassid) {
		this.plassid = plassid;
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<Avfallstype> getAvfallstypes() {
		return this.avfallstypes;
	}

	public void setAvfallstypes(List<Avfallstype> avfallstypes) {
		this.avfallstypes = avfallstypes;
	}

}