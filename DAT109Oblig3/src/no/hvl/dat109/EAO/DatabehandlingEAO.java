package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.Interfaces.Databehandling;

@Stateless
public class DatabehandlingEAO implements Databehandling {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	@EJB
	private ProduktEAO produktEAO;

	@Override
	public List<Produkt> getAlleProdukt() {
		// TODO Auto-generated method stub
		return produktEAO.hentAlle();
	}

	@Override
	public void lagreProdukt(Produkt produkt) {
		produktEAO.lagre(produkt);
		
	}
	


}
