package cartes;

public class Borne extends Carte {
	private int km;
	
	
	public Borne(int km) {
		super();
		this.setKm(km);
	}


	public int getKm() {
		return km;
	}


	public void setKm(int km) {
		this.km = km;
	}

}
