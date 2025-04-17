package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;


public class MainJoueur {
	private List<Carte> cartes;

    public MainJoueur() {
        this.cartes = new ArrayList<>();
    }

    public void prendre(Carte carte) {
    	cartes.add(carte);
    }

    public void jouer(Carte carte) {
    	if (!cartes.contains(carte)) {
    	    throw new IllegalArgumentException("La carte n'y est pas");
    	  }
    	cartes.remove(carte);
    }
    
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for(ListIterator<Carte> it = cartes.listIterator(); it.hasNext();) {
        	st.append(it.next().toString());
        }
        
        return st.toString();
    }
}
