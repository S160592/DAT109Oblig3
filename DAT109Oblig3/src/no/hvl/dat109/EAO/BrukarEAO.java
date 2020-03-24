package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Interfaces.BrukarEAOInterface;

@Stateless
public class BrukarEAO implements BrukarEAOInterface {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	//Usikker p� denne?
	@Override
	public boolean komPaEitGodtNavn(String brukernavn, String passord) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
