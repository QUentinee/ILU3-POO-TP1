package jeu;

import java.util.LinkedList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Type;

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
	
	public List<Limite> getPileLimites() {
		return pileLimites;
	}
	
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
    
	public void deposer(Carte c) {
		if(c instanceof Borne b) {
			bornes.add(0, b);
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
	
	public boolean estDepotFeuVertAutorise() {
		String contenu = pileBataille.get(0).toString();
		
		return pileBataille.isEmpty() || contenu.equals(Type.FEU.getAttaque()) || !contenu.equals(Type.FEU.getParade());
	}
	
	public boolean estDepotBorneAutorise(Borne borne) {
		int somme = 0;
		for(Borne b : bornes) {
			somme += b.getkm();
		}
		
		return this.peutAvancer() && borne.getkm() <= 50 && somme < 1000;
	}
	
	public boolean estDepotLimiteAutorise(Limite limite) {
		boolean a = limite instanceof DebutLimite && (pileLimites.get(0) instanceof FinLimite || pileLimites.isEmpty());
		boolean b = limite instanceof FinLimite && pileLimites.get(0) instanceof DebutLimite;
		return a || b;
	}
	
	public boolean estDepotBatailleAutorise(Bataille bataille) {
		boolean attaque = bataille instanceof Attaque;
		boolean a = bataille instanceof  
	}
	
}
