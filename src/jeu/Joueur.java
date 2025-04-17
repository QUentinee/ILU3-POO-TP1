package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;
	
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}
	
	
	public boolean equals(Joueur j1) {
		return j1.nom.equals(nom);
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		return sabot.piocher();
	}
}
