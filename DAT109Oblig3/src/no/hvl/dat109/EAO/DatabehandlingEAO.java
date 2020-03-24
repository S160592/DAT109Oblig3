package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.Interfaces.ProduktEAOInterface;

@Stateless
public class DatabehandlingEAO implements Databehandling {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	@EJB
	ProduktEAOInterface produktEAO;
	


	@Override
	public List<Produkt> getAlleProdukt() {
		// TODO Auto-generated method stub
		return produktEAO.hentAlle();
	}


	

	@Override
	public Produkt getProdukt(String barcode) {
		// TODO Auto-generated method stub
		return produktEAO.getProdukt(barcode);
	}




	@Override
	public void lagreNyBrukar(Brukar brukar) {
		// TODO Auto-generated method stub
		
	}
	


}
