package no.hvl.dat109.hjelpeklasser;

import no.hvl.dat109.Entity.Avfallsplass;
import no.hvl.dat109.Entity.Avfallstype;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;

public class Melding {
	private Brukar brukar;
	private Produkt produkt;
	private Avfallsplass avfallsplass;
	private Avfallstype avfallstype;
	private Leveringsoversikt leveringsoversikt;
	
	
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
	public Leveringsoversikt getLeveringsoversikt() {
		return leveringsoversikt;
	}
	public void setLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		this.leveringsoversikt = leveringsoversikt;
	}
	
	
	
	


}
