package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
    private LinkedList<Limite> pileLimites = new LinkedList<>();
    private LinkedList<Bataille> pileBataille = new LinkedList<>();
    private Collection<Borne> bornes = new ArrayList<>();
    
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

	public Collection<Borne> getBornes() {
		return bornes;
	}
	
	public List<Limite> getPileLimites() {
		return pileLimites;
	}
	
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
    
	public void deposer(Carte c) {
		if(c instanceof Borne b) {
			bornes.add(b);
		}
		else if(c instanceof Limite l) {
			pileLimites.add(0, l);
		}
		else if(c instanceof Bataille bat) {
			pileBataille.add(0, bat);
		}
	}
    
	public boolean peutAvancer() {
		return pileBataille.isEmpty() || pileBataille.get(0).toString().equals("Feu vert");
	}
	
	private boolean estDepotFeuVertAutorise() {
		String contenu = pileBataille.get(0).toString();
		
		return pileBataille.isEmpty() || contenu.equals(Type.FEU.getAttaque()) || !contenu.equals(Type.FEU.getParade());
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		int somme = 0;
		for(Borne b : bornes) {
			somme += b.getkm();
		}
		
		return this.peutAvancer() && borne.getkm() <= 50 && somme < 1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		boolean a = limite instanceof DebutLimite && (pileLimites.get(0) instanceof FinLimite || pileLimites.isEmpty());
		boolean b = limite instanceof FinLimite && pileLimites.get(0) instanceof DebutLimite;
		return a || b;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		boolean attaque = bataille instanceof Attaque;
	    boolean parade = bataille instanceof Parade;

	    if (attaque) {
	        return peutAvancer(); 
	    }

	    if (parade) {
	        Parade p = (Parade) bataille;
	        if (bataille.getType() == Type.FEU && bataille.toString().equals("Feu Vert")) {
	            return pileBataille.isEmpty();
//	                || pileBataille.peek() instanceof FeuRouge
//	                || (pileBataille.peek() instanceof Parade && !(pileBataille.peek() instanceof FeuVert));
	        } else {
	            return !pileBataille.isEmpty()
	                && pileBataille.peek() instanceof Attaque;
//	                && pileBataille.peek().getClass().equals(p.getAttaqueCorrespondante());
	        }
	    }

	    return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte.toString().equals("Feu Vert")) {
			return estDepotFeuVertAutorise();
		}
		else if(carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		else if(carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		else {
			Bataille bataille = (Bataille) carte;
			return estDepotBatailleAutorise(bataille);
		}
	}
	
}
