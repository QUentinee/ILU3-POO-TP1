package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import utils.GestionCartes;
import cartes.JeuDeCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeuDeCarte = new JeuDeCartes();
        Carte[] tableauDeCartes = jeuDeCarte.donnerCartes();

        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, tableauDeCartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }
}
