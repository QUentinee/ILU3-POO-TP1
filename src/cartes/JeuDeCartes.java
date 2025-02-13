package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = new Configuration[19];
	
	public void affichageJeuDeCartes() {
		StringBuilder builder = new StringBuilder("JEU : \n");
		for(int i = 0; i < 19; i++) {
			builder.append(typesDeCartes[i].getNbExemplaires() + " ");
			builder.append(typesDeCartes[i].getCarte());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public Carte[] donnerCartes() {
		typesDe
	}
	
	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
		
	}
}
