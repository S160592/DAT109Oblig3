package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the avfallsplass database table.
 * 
 */
@Entity

@Table(name = "Avfallsplass", schema = "oblig3")

@NamedQuery(name="Avfallsplass.findAll", query="SELECT a FROM Avfallsplass a")
public class Avfallsplass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plassid", updatable = false, nullable = false)
	private Integer plassid;

	private BigDecimal latitude;

	private BigDecimal longitude;

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

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
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