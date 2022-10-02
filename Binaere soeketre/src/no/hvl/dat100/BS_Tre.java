package no.hvl.dat100;

import java.util.Iterator;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {
	
	private BinaerTreNode<T> rot;
	
	public BS_Tre() {
		rot = null;
	}
	
	public BS_Tre(T element) {
		rot = new BinaerTreNode<T>(element);
	}
	
	/**
	 * S�ker etter et gitt element i treet.
	 * 
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;
	}
	public int getHogde()
	{
		return hogde(rot);
	}
	private int hogde(BinaerTreNode<T> start) {
		if(start == null)
			return 0;
		if((start.getVenstre() == null) && (start.getHogre() == null))
		{
			return 0;
		}
		else
		{
			return 1 + Math.max(hogde(start.getHogre()), hogde(start.getVenstre()));
		}
	}
	public int getNodeTal()
	{
		return tellNodar(rot);
	}
	private int tellNodar(BinaerTreNode<T> start)
	{
		if(start == null)
			return 0;
		if((start.getVenstre() == null) && (start.getHogre() == null))
		{
			return 1;
		}
		else
		{
			int v = 0;
			int h = 0;
			if(start.getHogre() != null)
				h = tellNodar(start.getHogre());
			if(start.getVenstre() != null)
				v = tellNodar(start.getVenstre());
			return 1 + v + h;
		}
	}
	/**
	 * Henter et element i treet.
	 * 
	 * @param element elementet vi leiter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {
		T svar = null;
		
		// p == null  -> tomt tre som er basistille og svar blir null
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
	}
	/**
	 * Legg eit element til treet dersom det ikkje finst fr� f�r. Elles etstattar
	 * blir det gamle elementet erstatta med det nye.
	 * 
	 * @param nyElement elementet som skal leggast til
	 * @return null om elementet ikkje finst fr� f�r. Elles det element som var i
	 *         treet fr� f�r.
	 */
	public T leggTil(T nyElement) {
		if(rot == null)
		{
			rot = new BinaerTreNode<T>(nyElement);
			return null;
		}
		T ret = this.finn(nyElement, rot);
		this.leggTil(rot, nyElement);
		return ret;
	}

	private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T element){
		if (p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if (element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTil(p.getVenstre(), element));
			} else {
				// Alternativ med to kodelinjer
				BinaerTreNode<T> q = leggTil(p.getHogre(), element);
				p.setHogre(q);
			}
		}
		return p;
	}
	/**
	 * Fjernar eit element fr� treet.
	 * 
	 * @param element elementet som skal fjernast.
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	public T fjern(T element) {
		return null;
	}

	/**
	 * Lagar ein iterator som g�r gjennom alle element i treet i inorden.
	 * 
	 * @return ein iterator som elementa i sortert rekkef�lge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}

}
