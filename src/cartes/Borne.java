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
		return super.equals(obj) && toString().equalsIgnoreCase(((Borne)obj).toString());
	}
}
