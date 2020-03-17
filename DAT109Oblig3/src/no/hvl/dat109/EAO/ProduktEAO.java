package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Produkt;

@Stateless
public class ProduktEAO  {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public List<Produkt> hentAlle() {
		return em.createNamedQuery("Produkt.findAll", Produkt.class).getResultList();
	}
}
