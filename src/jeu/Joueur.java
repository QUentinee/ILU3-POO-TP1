package jeu;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;

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
	
	public int donnerKmParcourus() {
    	int somme = 0;
    	for(Borne borne : zone.getBornes()) {
    		somme += borne.getkm();
    	}
    	return somme;
    }
	
	public void deposer(Carte c) {
		if(c instanceof Borne b) {
			zone.getBornes().add(0, b);
		}
		else if(c instanceof Limite l) {
			zone.getPileLimites().add(0, l);
		}
		else if(c instanceof Bataille bat) {
			zone.getPileBataille().add(0, bat);
		}
	}
}
