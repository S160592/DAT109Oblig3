package no.hvl.dat109.EAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Produkt;

@Stateless
public class ProduktEAO  {
	@PersistenceContext(name = "avfall")
	private EntityManager em;

	public List<Produkt> hentAlle() {
		return em.createNamedQuery("Produkt.findAll", Produkt.class).getResultList();
	}
	

	
	public Produkt hentProdukt(String strekkode) {
		return em.find(Produkt.class, strekkode);
	}
	
	public List<Produkt> hentProduktListe(List<String> strekkoder){
		List<Produkt> alle = hentAlle();
		List<Produkt> ut;
		
		ut = alle.stream()
				.filter(x -> strekkoder.contains(x.getStrekkode()))
				.collect(Collectors.toList());
		
		
		return ut;
	}
	
	public List<Produkt> hentProduktListeDummy(List<String> strekkoder, List<Produkt> produkter){
		List<Produkt> ut;
		
		ut = produkter.stream()
				.filter(x -> strekkoder.contains(x.getStrekkode()))
				.collect(Collectors.toList());
		
		
		return ut;
	}
	
}
