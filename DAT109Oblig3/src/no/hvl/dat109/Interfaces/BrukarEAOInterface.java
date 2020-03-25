package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Brukar;

//Interface for BrukarEAO-klassen
public interface BrukarEAOInterface {

	boolean komPaEitGodtNavn(String brukernavn, String passord);
	void lagreNyBrukar(Brukar brukar);
	
}
