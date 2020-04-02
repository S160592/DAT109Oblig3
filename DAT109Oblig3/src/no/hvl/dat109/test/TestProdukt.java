package no.hvl.dat109.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.EAO.ProduktEAO;
import no.hvl.dat109.Entity.Produkt;

public class TestProdukt {
	
	@EJB
	ProduktEAO produktEAO;
	
	
//	@Before
//	public List<Produkt> initProduktListe() {
//		List<Produkt> produkter = null;
//		
//		Produkt p1 = new Produkt("6953070946249", "EasyWipe - Dry Erase Marker - Rød", "Penn");
//		Produkt p2 = new Produkt("7037610050531", "Moussaka", "Middag");
//		Produkt p3 = new Produkt("7030019531885", "Fatøl 0.5L", "Øl");
//		Produkt p4 = new Produkt("8003807000879", "Borgogno Dolcetto dAlba 2017", "Vin");
//		Produkt p5 = new Produkt("7037710037173", "Laban", "Godteri");
//		
//		produkter.add(p1);
//		produkter.add(p2);
//		produkter.add(p3);
//		produkter.add(p4);
//		produkter.add(p5);
//		
//		
//		return produkter;
//	}
	
	
	@Test
	public void testHentProduktListe() {
		
		List<Produkt> produkter = new ArrayList<>();
		
		Produkt p1 = new Produkt("6953070946249", "EasyWipe - Dry Erase Marker - Rød", "Penn");
		Produkt p2 = new Produkt("7037610050531", "Moussaka", "Middag");
		Produkt p3 = new Produkt("7030019531885", "Fatøl 0.5L", "Øl");
		Produkt p4 = new Produkt("8003807000879", "Borgogno Dolcetto dAlba 2017", "Vin");
		Produkt p5 = new Produkt("7037710037173", "Laban", "Godteri");
		
		produkter.add(p1);
		produkter.add(p2);
		produkter.add(p3);
		produkter.add(p4);
		produkter.add(p5);
		
		List<String> listeParam = new ArrayList<>();
		listeParam.add("6953070946249");
		listeParam.add("7037610050531");
		listeParam.add("7030019531885");
		listeParam.add("8003807000879");
		listeParam.add("7037710037173");
		
		List<Produkt> produkterUT = produktEAO.hentProduktListeDummy(listeParam, produkter);
		
		assertEquals(listeParam.size(), produkterUT.size());
		
		
	}

}
