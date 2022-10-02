package no.hvl.dat102;

public class KvikkSortering {
	
	public static int partition(Integer[] tab, int start, int slutt) {
		int pivot = tab[slutt];
		int i = (start - 1);
		
		for (int j = start; j <= slutt - 1; j++) {
			if(tab[j] < pivot) {
				i++;
				int t = tab[i];
				tab[i] = tab[j];
				tab[j] = t;
			}
		}
		int t = tab[i + 1];
		tab[i + 1] = tab[slutt];
		tab[slutt] = t;
		return (i + 1);
	}
	
	public static void quickSort(Integer[] tab, int start, int slutt) {
		if(start < slutt) {
			int p = partition(tab, start, slutt);
			quickSort(tab, start, p - 1);
			quickSort(tab, p + 1, slutt);
		}
	}
	
}
