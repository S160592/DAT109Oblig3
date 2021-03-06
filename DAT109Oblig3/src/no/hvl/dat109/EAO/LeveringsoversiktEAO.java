package no.hvl.dat109.EAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Avfallstype;
import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.Interfaces.LeveringsoversiktEAOInterface;

@Stateless
public class LeveringsoversiktEAO {
	@PersistenceContext(name = "avfall")
	EntityManager em;

	public void addLeveringsoversikt(Leveringsoversikt leveringsoversikt) {
		em.persist(leveringsoversikt);

	}

	public List<Leveringsoversikt> hentHistorikk(Brukar brukar) {
		List<Leveringsoversikt> alle = em.createNamedQuery("Leveringsoversikt.findAll", Leveringsoversikt.class).getResultList();
		List<Leveringsoversikt> historikk;
		historikk = alle.stream()
				.filter((x) -> x.getBrukar().getTelefon().equals(brukar.getTelefon()))
				.filter((x) -> x.getLevert() == true)
				.collect(Collectors.toList());
		
		return historikk;
	}
	public List<Leveringsoversikt> hentAlleLeveringsoversikter() {
		return em.createNamedQuery("Leveringsoversikt.findAll", Leveringsoversikt.class).getResultList();
	}

	


	public List<Leveringsoversikt> hentProduktForLevering(Brukar brukar, List<Avfallstype> type) {
		List<String> typeNavn = type.stream()
				.map(x -> x.getTypenavn())
				.collect(Collectors.toList());
		
		List<Leveringsoversikt> alle = em.createNamedQuery("Leveringsoversikt.findAll", Leveringsoversikt.class).getResultList();
		List<Leveringsoversikt> produktForLevering;
		produktForLevering = alle.stream()
				.filter((x) -> x.getBrukar().getTelefon().equals(brukar.getTelefon()))
				.filter((x) -> x.getLevert() == false)
				.filter((x) -> typeNavn.contains(x.getProdukt().getAvfallstypeBean().getTypenavn()))
				.collect(Collectors.toList());
	

		return produktForLevering;

	}
	
	public void leverProdukt(List<Leveringsoversikt> tilLevering) {
		List<Integer> ID = tilLevering.stream()
				.map(x -> x.getId())
				.collect(Collectors.toList());
		
		
		List<Leveringsoversikt> alle = em.createNamedQuery("Leveringsoversikt.findAll", Leveringsoversikt.class).getResultList();
		alle.stream()
		.filter(x -> ID.contains(x.getId()))
		.forEach(x -> x.setLevert(true));
		
		em.persist(alle);
		em.flush();
	}

	public List<Leveringsoversikt> hentProduktListe(List<String> leveringsoversiktID) {
		List<Leveringsoversikt> alle = hentAlleLeveringsoversikter();
		List<Leveringsoversikt> ut;
		
		List<Integer> id = new ArrayList<Integer>();
		leveringsoversiktID.forEach(x -> id.add(Integer.parseInt(x)));
		
		ut = alle.stream()
				.filter(x -> id.contains(x.getId()))
				.collect(Collectors.toList());
		
		
		return ut;
	}


}
