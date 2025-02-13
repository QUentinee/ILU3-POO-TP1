package jeu;

import cartes.Carte;

public class Sabot {
	private Carte[] cartes;
	private int nbCartes;
	
	public Sabot(Carte[] cartes, int nbCartes) {
		this.cartes = cartes;
		this.nbCartes = nbCartes;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
}
