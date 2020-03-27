package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Interfaces.LeveringsoversiktEAOInterface;

@Stateless
public class LeveringsoversiktEAO implements LeveringsoversiktEAOInterface{
	@PersistenceContext(name="avfall")
	EntityManager em;

	@Override
	public void addLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		em.persist(leveringsoversikt);
		
	}
	

}
