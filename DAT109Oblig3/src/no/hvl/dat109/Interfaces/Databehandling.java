package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Produkt;

public interface Databehandling {

	public List<Produkt> getAlleProdukt();

	public Produkt getProdukt(String barcode);

	public void lagreNyBrukar(Brukar brukar);
	
}
