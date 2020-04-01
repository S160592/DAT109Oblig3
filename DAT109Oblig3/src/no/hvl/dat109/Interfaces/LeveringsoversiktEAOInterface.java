package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Brukar;
import no.hvl.dat109.Entity.Leveringsoversikt;

public interface LeveringsoversiktEAOInterface {

	void addLeveringsoversikt(Leveringsoversikt leveringsoversikt);
	
	Leveringsoversikt hentHistorikk(Brukar brukar);

}
