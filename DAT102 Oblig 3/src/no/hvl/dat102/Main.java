package no.hvl.dat102;
import java.util.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Integer[] tab = {3, 5, 2, 1, 7, 12, 9};
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String userInput;
		boolean running = true;
		long start, finish, timeElapsed = 0;
		
		
		while (running) {
			System.out.println("Listen er '3, 5, 2, 1, 7, 12, 9'. Hva vil du gjøre?");
			System.out.println("----------------------------------------------------");
			System.out.println("A - Innsettingsortering");
			System.out.println("B - Utvalgsortering");
			System.out.println("C - Kvikksortering");
			System.out.println("D - Flettesortering");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "A":
				start = System.nanoTime();
				InnsettingSortering.sorteringVedInssetting(tab, tab.length);
				
				System.out.print("Sortert liste: ");
				for(Integer e : tab) {
					System.out.print(e + " ");
				}
				finish = System.nanoTime();
				timeElapsed = finish - start;
				System.out.println();
				System.out.println("Det tok: " + timeElapsed + "ns");
				running = false;
				break;
			
			case "B":
				start = System.nanoTime();
				UtvalgSortering.utvalgSorter(tab);
				
				System.out.print("Sortert liste: ");
				for(Integer e : tab) {
					System.out.print(e + " ");
				}
				finish = System.nanoTime();
				timeElapsed = finish - start;
				System.out.println();
				System.out.println("Det tok: " + timeElapsed + "ns");
				running = false;
				break;
				
			case "C":
				start = System.nanoTime();
				KvikkSortering.quickSort(tab, 0, tab.length - 1);
				
				System.out.print("Sortert liste: ");
				for(Integer e : tab) {
					System.out.print(e + " ");
				}
				finish = System.nanoTime();
				timeElapsed = finish - start;
				System.out.println();
				System.out.println("Det tok: " + timeElapsed + "ns");
				running = false;
				break;
			
			case "D":
				start = System.nanoTime();
				FletteSortering.FletteSorter(tab, 0, tab.length - 1);
				
				System.out.print("Sortert liste: ");
				for(Integer e : tab) {
					System.out.print(e + " ");
				}
				finish = System.nanoTime();
				timeElapsed = finish - start;
				System.out.println();
				System.out.println("Det tok: " + timeElapsed + "ns");
				running = false;
				break;
			}
		}
	}

}
