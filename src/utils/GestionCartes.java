package utils;

import java.util.List;
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
		
	}
}
