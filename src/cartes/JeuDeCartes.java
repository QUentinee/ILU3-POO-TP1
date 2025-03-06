package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1), };

	public String affichageJeuCartes() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			builder.append(typesDeCartes[i].getNbExemplaires() + " ");
			builder.append(typesDeCartes[i].getCarte());
			builder.append("\n");
		}
		return builder.toString();
	}

	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			nbCartes += typesDeCartes[i].getNbExemplaires();
		}

		Carte[] cartes = new Carte[nbCartes];
		for (int i = 0, k = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].nbExemplaires; j++, k++) {
				cartes[k] = typesDeCartes[i].getCarte();
			}
		}

		return cartes;
	}
	
	public boolean checkCount() {
		int nbcartes = 0;
		Carte[] donnercartes = donnerCartes();
		for(int i = 0; i < typesDeCartes.length; i++) {
			Carte carte = typesDeCartes[i].getCarte();
			for(int j = 0; j < donnercartes.length; j++) {
				if(donnercartes[j].equals(carte)) {
					nbcartes += 1;
				}
			}
			if(typesDeCartes[i].nbExemplaires != nbcartes) {
				return false;
			}
			nbcartes = 0;
		}
		return true;
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
