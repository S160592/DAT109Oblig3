package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Avfallsplass;

@Stateless
public class AvfallsplassEAO{
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	public List<Avfallsplass> hentAlleAvfallsplasser() {
		return em.createNamedQuery("Avfallsplass.findAll", Avfallsplass.class).getResultList();
	}

}
