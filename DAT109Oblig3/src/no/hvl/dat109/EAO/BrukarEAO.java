package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Interfaces.BrukarEAOInterface;

@Stateless
public class BrukarEAO {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	//Usikker p� denne?
	
	public boolean komPaEitGodtNavn(String brukernavn, String passord) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void lagreNyBrukar(Brukar brukar) {
		em.persist(brukar);
		// TODO Auto-generated method stub
		
	}

	
	public Brukar hentBrukar(String telefon) {
		return em.find(Brukar.class, telefon);
	}
	

}
