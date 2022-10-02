package no.hvl.dat102;

public class FletteSortering {
	
	public static void Flette(Integer[] tab, int l, int m, int r) { //Why? se en video
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i = 0; i < n1; i++) {
			L[i] = tab[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = tab[m + 1 + j];
		}
		
		int i = 0, j = 0;
		int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                tab[k] = L[i];
                i++;
            }
            else {
                tab[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            tab[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            tab[k] = R[j];
            j++;
            k++;
        }
	}
	
	public static void FletteSorter(Integer[] tab, int l, int r) {
		if (l < r) {
            int m =l+ (r-l)/2;

            FletteSorter(tab, l, m);
            FletteSorter(tab, m + 1, r);

            Flette(tab, l, m, r);
        }
	}
}
