package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Produkt;

public interface ProduktEAOInterface {
	
	public List<Produkt> hentAlle();
	public Produkt getProdukt(String strekkode);

}
