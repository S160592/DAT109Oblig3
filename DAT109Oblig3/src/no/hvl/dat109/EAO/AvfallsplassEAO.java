package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Avfallsplass;
import no.hvl.dat109.Entity.Brukar;

@Stateless
public class AvfallsplassEAO{
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	public List<Avfallsplass> hentAlleAvfallsplasser() {
		return em.createNamedQuery("Avfallsplass.findAll", Avfallsplass.class).getResultList();
	}
	
	public Avfallsplass hentAvfallsplass(int id) {
		return em.find(Avfallsplass.class, id);
	}

}
