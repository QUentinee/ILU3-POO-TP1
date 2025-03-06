package utils;

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
		T elt = it.remove(elt2);
		return elt;
	}
}
