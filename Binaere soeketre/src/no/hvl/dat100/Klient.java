package no.hvl.dat100;
import no.hvl.dat100.BS_Tre;
import java.util.*;

public class Klient {
	private static int antalNodarGenerert = 0x3ff;
	private static int antalTreGenerert = 1000;
	public static void main(String[] args) {
	int minsteHogde = Integer.MAX_VALUE;
	int stysteHogde = -1;
	double gjennomsnittHogde = -1;
		// TODO Auto-generated method stub
		BS_Tre<Integer> tre = new BS_Tre<>();
		Random terning = new Random();
		for(int v = 0; v < antalTreGenerert; v++)
		{
			tre = new BS_Tre<>();
			for(int i = 0; i < antalNodarGenerert; i++)
			{
				tre.leggTil(terning.nextInt());
			}
			if(tre.getHogde() > stysteHogde)
				stysteHogde = tre.getHogde();
			if(tre.getHogde() < minsteHogde)
				minsteHogde = tre.getHogde();
			if(gjennomsnittHogde == -1)
				gjennomsnittHogde = tre.getHogde();
			else
			{
				gjennomsnittHogde = (gjennomsnittHogde*v + tre.getHogde())/(v+1);
			}
		}
		System.out.printf("trea var mellom %d og %d og hadde i gjennomsnitt %2.2f Nodar etter %d  genererte Tre generert med Lengde %d \n"
				, minsteHogde, stysteHogde, gjennomsnittHogde, antalTreGenerert, antalNodarGenerert);
	}
	
	
	/*
	 * C med 0x3ff tal = 21,14*log2(0x3ff) = 295
	 * C med 0x1fff tal = 29,4*log2(0x1fff) = 500
	 * 
	 * 
	 */

}
