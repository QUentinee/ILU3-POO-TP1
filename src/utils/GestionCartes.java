package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	private static Random random = new Random();
	
	private GestionCartes() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static <T> T extraire(List<T> liste) {
		int i = random.nextInt(liste.size());
		T elt = liste.get(i);
		liste.remove(elt);
		return elt;
	}

	public static <T> T extraireIt(List<T> liste) {
		int indice = random.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator(indice);
		T elt2 = it.next();
		it.remove();
		return elt2;
	}

	public static <T> List<T> melanger(List<T> liste) {
		int taille = liste.size();
		List<T> liste2 = new ArrayList<>();
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
		List<T> listeRassemble = new ArrayList<>();
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

	private static <T> boolean elementReapparaitApresIndice(List<T> liste, T element, int indiceDepart) {
		for(ListIterator<T> it = liste.listIterator(indiceDepart); it.hasNext();)
			if (it.next().equals(element)) {
              return true; 
          }
        return false;
    }


    public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste.isEmpty()) return true;
        ListIterator<T> it = liste.listIterator();
        T precedent = it.next();
        while (it.hasNext()) {
            T courant = it.next();
            if (!courant.equals(precedent)) {
                int indexSuivant = it.nextIndex(); 
                if (elementReapparaitApresIndice(liste, precedent, indexSuivant)) {
                    return false;
                }
            }

            precedent = courant;
        }

        return true;
    }

}
