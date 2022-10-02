package no.hvl.dat102;

public class UtvalgSortering {
	
	public static void utvalgSorter(Integer[] tab) {
		
		for (int i = 0; i < tab.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < tab.length; j++) {
				if(tab[j] < tab[index]) {
					index = j;
				}
			}
			int mindreTall = tab[index];
			tab[index] = tab[i];
			tab[i] = mindreTall;
		}
        
	}
}
