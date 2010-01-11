/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;

/**
 *
 * @author NorTicUs
 */
public class Aiguillage extends ElementsJonction{

    /**
     * Liste des rails sortants de l'aiguillage
     */
    private LinkedList<Rail> amont;

    /**
     * Liste des rails entrant de l'aiguillage
     */
    private LinkedList<Rail> aval;
    /**
     * Lien actuel de l'aiguillage
     */
    private LinkedList<Rail> lien;

    public Aiguillage(LinkedList<Rail> amont, LinkedList<Rail> aval) {
	this.amont = amont;
	this.aval = aval;
    }

    public LinkedList<Rail> getAmont() {
	return amont;
    }

    public void setAmont(LinkedList<Rail> amont) {
	this.amont = amont;
    }

    public LinkedList<Rail> getAval() {
	return aval;
    }

    public void setAval(LinkedList<Rail> aval) {
	this.aval = aval;
    }

    public Rail getLienAmont() {
	return lien.get(0);
    }

    public Rail getLienAval() {
	return lien.get(1);
    }

    /**
     * Relie deux rails par l'aiguillage
     * @param numRailAmont
     *	    Numéro du rail amont désir?
     * @param numRailAval
     *	    Numéro du rail aval désiré
     */
    public void setLien(int numRailAmont, int numRailAval) {
	if(numRailAmont >= 0 && numRailAmont < amont.size()){
	   if(numRailAval >= 0 && numRailAval < aval.size()){
		this.lien.clear();
		this.lien.add(amont.get(numRailAmont));
		this.lien.add(aval.get(numRailAval));
	    }
	}
    }

    @Override
    public TypeJonction getType() {
	return TypeJonction.AIGUILLAGE;
    }

}
