package no.hvl.dat109.hjelpeklasser;

import com.google.gson.annotations.Expose;

public class Feilmelding {
	
	@Expose
	private String feilmelding;
	
	public Feilmelding(String m) {
		feilmelding=m;
	}
	
	public String getFeilmelding() { 
		return feilmelding;
	}
	
	public void setFeilmelding(String m) {
		feilmelding=m;
	}

}
