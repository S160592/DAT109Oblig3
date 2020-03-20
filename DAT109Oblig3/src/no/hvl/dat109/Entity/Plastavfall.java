package no.hvl.dat109.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Plast")
public class Plastavfall extends Avfallstype {
	public Plastavfall() {
		super();
		setTypenavn("Plast");
	}
}
