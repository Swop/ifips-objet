/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import gestion_train.Train;

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
    /**
     * Compteur des IDs des aiguillages
     */
    private static int compteurId = 0;
    /**
     * ID de l'aiquillage
     */
    private int id;

    public Aiguillage(LinkedList<Rail> amont, LinkedList<Rail> aval) {
	this.amont = amont;
	this.aval = aval;
	this.id = compteurId;
	compteurId ++;
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
     *	    Numéro du rail amont désiré
     * @param numRailAval
     *	    Numéro du rail aval désiré
     * @throws TrainSurAiguillage
     *	    Si le train est sur l'aiguillage
     */
    public void setLien(int numRailAmont, int numRailAval)throws TrainSurAiguillage {
	for(Train t : Main.trains){
	    for(int i = t.getTaille(); i>0; i--){
		switch(t.getSensDeplacement()){
		    case AMONT : t.getPosition().getSuivant()
		}
	    }
	}
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
