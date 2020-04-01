package no.hvl.dat109.hjelpeklasser;

import java.util.List;

import com.google.gson.annotations.Expose;

import no.hvl.dat109.Entity.Avfallsplass;
import no.hvl.dat109.Entity.Avfallstype;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;

public class Melding {
	@Expose
	private Brukar brukar;
	@Expose
	private Produkt produkt;
	@Expose
	private Avfallsplass avfallsplass;
	@Expose
	private Avfallstype avfallstype;
	@Expose
	private List<Leveringsoversikt> leveringsoversikt;
	
	@Expose
	private Meldingstype meldingstype;
	public Melding(Meldingstype meldingstype) {
		this.meldingstype = meldingstype;
	}
	
	public Brukar getBrukar() {
		return brukar;
	}
	public void setBrukar(Brukar brukar) {
		this.brukar = brukar;
	}
	public Produkt getProdukt() {
		return produkt;
	}
	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}
	public Avfallsplass getAvfallsplass() {
		return avfallsplass;
	}
	public void setAvfallsplass(Avfallsplass avfallsplass) {
		this.avfallsplass = avfallsplass;
	}
	public Avfallstype getAvfallstype() {
		return avfallstype;
	}
	public void setAvfallstype(Avfallstype avfallstype) {
		this.avfallstype = avfallstype;
	}

	public List<Leveringsoversikt> getLeveringsoversikt() {
		return leveringsoversikt;
	}

	public void setLeveringsoversikt(List<Leveringsoversikt> leveringsoverik) {
		this.leveringsoversikt = leveringsoverik;
	}

	public Meldingstype getMeldingstype() {
		return meldingstype;
	}

	public void setMeldingstype(Meldingstype meldingstype) {
		this.meldingstype = meldingstype;
	}

	
	
	
	


}
