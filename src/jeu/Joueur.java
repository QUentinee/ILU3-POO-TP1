package jeu;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}
	
	
	public boolean equals(Joueur j1) {
		return j1.nom.equals(nom);
	}
	
	
	
}
