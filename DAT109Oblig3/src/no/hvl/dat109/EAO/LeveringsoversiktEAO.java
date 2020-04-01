package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Interfaces.LeveringsoversiktEAOInterface;

@Stateless
public class LeveringsoversiktEAO{
	@PersistenceContext(name="avfall")
	EntityManager em;

	
	public void addLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		em.persist(leveringsoversikt);
		
	}


	public List<Leveringsoversikt> hentHistorikk(Brukar brukar) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
