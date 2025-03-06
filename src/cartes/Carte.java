package cartes;

public abstract class Carte {
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			Carte carte = (Carte) obj;
			return this.getClass() == carte.getClass();
		}
		return false;
	}
}
