package no.hvl.dat109.EAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Interfaces.Databehandling;

@Stateless
public class DatabehandlingEAO implements Databehandling {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	@EJB
	private ProduktEAO produktEAO;


}
