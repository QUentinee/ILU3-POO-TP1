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
    
        
}
