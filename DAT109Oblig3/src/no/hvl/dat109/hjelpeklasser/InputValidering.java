package no.hvl.dat109.hjelpeklasser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputValidering {

	private List<Feilmelding> feilmeldingar;
	private HashMap<String, String> input;
	private HashMap<String, String> validated_data;
	private boolean erGyldig;
		
	public InputValidering(HashMap<String, String> data) {
		input = data;
		feilmeldingar = new ArrayList<Feilmelding>();
		validated_data = new HashMap<String, String>();
		erGyldig=true;
	}
	
	public HashMap<String, String> validerLogInn() {
		validerTelefon(input.get("telefon"));
		validerPassord(input.get("passord"));
		return validated_data;
	}
	
	public HashMap<String, String> validerNyBrukar() {
		validerTelefon(input.get("telefon"));
		validerFornavn(input.get("fornavn"));
		validerEtternavn(input.get("etternavn"));
		validerPassord(input.get("passord"));
		validerPassordRepetert(input.get("passord"), input.get("passordRepetert"));
		return validated_data;
	}
	
	public void validerTelefon(String nummer) {
		if(nummer.length()==0) {
			feilmeldingar.add(new Feilmelding("Mobilnummer er ikkje fyllt ut!"));
			erGyldig=false;
		} else {	
			if(!nummer.matches("^[0-9]{8}$")) {
				feilmeldingar.add(new Feilmelding("Mobilnummer er ikkje 8 siffer!"));
				erGyldig=false;
			}
		}
		validated_data.put("telefon", nummer);
	}
	
	public void validerFornavn(String fornavn) {
		if(fornavn.length()==0) {
			feilmeldingar.add(new Feilmelding("Fornavn er ikkje fyllt ut!"));
			erGyldig=false;
		}
		validated_data.put("fornavn", fornavn);
	}
	
	public void validerEtternavn(String etternavn) {
		if(etternavn.length()==0) {
			feilmeldingar.add(new Feilmelding("Etternavn er ikkje fyllt ut!"));
			erGyldig=false;
		}
		validated_data.put("etternavn", etternavn);
	}
	
	public void validerPassord(String passord) {
		if(passord.length()==0) {
			feilmeldingar.add(new Feilmelding("Passord er ikkje fyllt ut!"));
			erGyldig=false;
		}
		validated_data.put("passord", passord);
	}
	
	public void validerPassordRepetert(String passord, String repetert) {
		if(!passord.equals(repetert)) {
			feilmeldingar.add(new Feilmelding("Repetert passord er ikkje lik passord!"));
			erGyldig=false;
		}
		validated_data.put("passordRepetert", repetert);
	}
	
	public List<Feilmelding> getFeilmeldingar() {
		return feilmeldingar;
	}
	
	public boolean erGyldig() {
		return erGyldig;
	}

}
