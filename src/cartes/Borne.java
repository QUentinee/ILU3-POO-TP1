package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	
	public String toString() {
		return this.km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne carte = (Borne) obj;
			return toString().equalsIgnoreCase(carte.toString());
		}
		return false;
	}
}
