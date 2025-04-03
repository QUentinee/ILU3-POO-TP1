package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	public static <T> T extraire(List<T> liste) {
		Random rand = new Random();
		int i = rand.nextInt(liste.size());
		T elt = liste.get(i);
		liste.remove(elt);
		return elt;
	}

	public static <T> T extraireIt(List<T> liste) {
		Random rand = new Random();
		int indice = rand.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator();
		T elt2 = liste.get(0);
		for (int i = 0; i < indice; i++) {
			elt2 = it.next();
		}
		it.remove();
		return elt2;
	}

	public static <T> List<T> melanger(List<T> liste) {
		int taille = liste.size();
		List<T> liste2 = new ArrayList<T>();
		for (int i = 0; i < taille; i++) {
			liste2.add(extraire(liste));
		}
		return liste2;
	}

	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		for (T elt : liste1) {
			if (Collections.frequency(liste1, elt) != Collections.frequency(liste2, elt)) {
				return false;
			}
		}
		for (T elt : liste2) {
			if (Collections.frequency(liste2, elt) != Collections.frequency(liste1, elt)) {
				return false;
			}
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> listeRassemble = new ArrayList<T>();
		for (T elt : liste) {
			int nbExemplaire = Collections.frequency(liste, elt);
			if (!listeRassemble.contains(elt)) {
				for (int i = 0; i < nbExemplaire; i++) {
					listeRassemble.add(elt);
				}
			}
		}
		return listeRassemble;
	}

	private static<T> boolean TrouverFinDeListe(List<T> liste, T elt, int i) {
		boolean fin = false;
		for (ListIterator<T> it = liste.listIterator(i); it.hasNext();) {
			T elt2 = it.next();
			if (elt.equals(elt2)) {
				fin = true;
			}
		}
		return fin;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		T elemPrecedant = null;
		for (ListIterator<T> it = liste.listIterator(); it.hasNext();) {
			T elemSuivant = it.next();
			if (elemPrecedant != null && !elemPrecedant.equals(elemSuivant)) {
				if (TrouverFinDeListe(liste, elemSuivant, it.nextIndex())) {
					return false;
				}
			}
			elemPrecedant = elemSuivant;

		}
		return true;
	}

}
