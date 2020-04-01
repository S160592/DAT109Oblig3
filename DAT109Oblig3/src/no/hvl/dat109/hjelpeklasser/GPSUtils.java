package no.hvl.dat109.hjelpeklasser;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;

import no.hvl.dat109.EAO.AvfallsplassEAO;
import no.hvl.dat109.Entity.Avfallsplass;

public class GPSUtils {

	


	public int distance(double lat1, double lat2, double lon1, double lon2) {

		// The math module contains a function 
		// named toRadians which converts from 
		// degrees to radians. 
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula  
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. 
		double r = 6371;

		// calculate the result 
		return (int) ((c * r)*1000);
	}

	public List<Avfallsplass> finnNermaste(double lat1, double lon1, List<Avfallsplass> avfallsplasser) {


//		List<Avfallsplass> alle = avfallsplassEAO.hentAlleAvfallsplasser();
//		alle.sort((a, b) -> distance(lat1, a.getLatitude().doubleValue(), lon1, a.getLongitude().doubleValue()) - distance(lat1, b.getLatitude().doubleValue(), lon1, b.getLongitude().doubleValue()));
		List<Avfallsplass> nermaste;
		nermaste = avfallsplasser.stream().sorted(
				(a, b) -> distance(lat1, a.getLatitude().doubleValue(), lon1, a.getLongitude().doubleValue())
						- distance(lat1, b.getLatitude().doubleValue(), lon1, b.getLongitude().doubleValue()))
				.collect(Collectors.toList());

		return nermaste;
	}
	
	public boolean sjekkAvstand(double lat1, double lon1, Avfallsplass a) {
		int avstand = distance(lat1, a.getLatitude().doubleValue(), lon1, a.getLongitude().doubleValue());
		return avstand > 100;
	}

}
