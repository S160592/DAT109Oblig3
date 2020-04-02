package no.hvl.dat109.hjelpeklasser;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		GPSUtils gps = new GPSUtils();
		double lat1 = 53.32055555555556;
		double lat2 = 53.31861111111111;
		double lon1 = -1.7297222222222221;
		double lon2 = -1.6997222222222223;
		
		System.out.println("Distance: " + gps.distance(lat1, lat2, lon1, lon2));
		System.out.println();
		
		
		String[] tabell = {"produkt1", "produkt2", "produkt3", "produkt4", "produkt5"};
		for (int i = 0; i < tabell.length; i++) {
			System.out.println(tabell[i]);
		}
		
		
		System.out.println();
		List<String> liste = Arrays.asList(tabell);
		liste.forEach(x -> System.out.println(x));
		
	}

}
