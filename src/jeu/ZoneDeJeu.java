package jeu;

import java.util.LinkedList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.DebutLimite;
import cartes.Limite;

public class ZoneDeJeu {
    private LinkedList<Limite> pileLimites;
    private LinkedList<Bataille> pileBataille;
    private List<Borne> bornes;
    
    public int donnerLimitationVitesse() {
    	if(!pileLimites.isEmpty() && pileLimites.get(0) instanceof DebutLimite) {
    		return 50;
    	}
    	
    	return 200;
    }
    
    public int donnerKmParcourus() {
    	int somme = 0;
    	for(Borne borne : getBornes()) {
    		somme += borne.getkm();
    	}
    	return somme;
    }

	public List<Borne> getBornes() {
		return bornes;
	}
    
	public void deposer(Carte c) {
		
	}
    
}
