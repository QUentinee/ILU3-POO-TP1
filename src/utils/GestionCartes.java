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
		for(int i = 0; i < indice; i++) {
			elt2 = it.next();
		}
		it.remove();
		return elt2;
	}
	
	public <T> List<T> melanger(List<T> liste) {
		for(int i = 0; i < liste.size(); i++) {
			liste.remove(i);
		}
		return liste;
	}
	
	public <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		for(int i = 0; i < liste1.size(); i++) {
			if(Collections.frequency(liste1, liste1.get(i)) != Collections.frequency(liste2, liste2.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public <T> List<T> rassembler(List<T> liste) {
		List<T> liste2 = new ArrayList<T>();
		for(ListIterator<T> it = liste.listIterator(); it.hasNext();) {
			T elt = it.next();
			for(int i = 0; i < liste2.size(); i++) {
				if(liste2.get(i) == elt) {
					liste2.add(i, elt);
				}
			}
		}
		return liste2;
	}
	
	
	public <T> boolean verifierRassemblement(List<T> liste) {
		
		for(ListIterator<T> it = liste.listIterator(); it.hasNext();) {
			T elt = it.next();
			
		}
	}
}
