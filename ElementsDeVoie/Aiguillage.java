/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import gestion_train.Train;
import Main.SimulationReseauFerroviaire;

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
     * ID de l'aiguillage
     */
    private int id;

    public Aiguillage(LinkedList<Rail> amont, LinkedList<Rail> aval) {
	this.amont = amont;
	this.aval = aval;
	this.id = compteurId;
	this.lien = new LinkedList();
	compteurId ++;
    }

    public Aiguillage(){
	this.amont = new LinkedList<Rail>();
	this.aval = new LinkedList<Rail>();
	this.id = compteurId;
	this.lien = new LinkedList();
	compteurId ++;
    }

    public LinkedList<Rail> getAmont() {
	return amont;
    }

    public void setAmont(LinkedList<Rail> amont) {
	this.amont = amont;
    }

    public void addAmont(Rail amont){
	this.amont.add(amont);
	amont.setAval(this);
    }

    public LinkedList<Rail> getAval() {
	return aval;
    }

    public void setAval(LinkedList<Rail> aval) {
	this.aval = aval;
    }

    public void addAval(Rail aval){
	this.aval.add(aval);
	aval.setAmont(this);
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
	for(Train t : SimulationReseauFerroviaire.trains){
	    Troncon position = t.getPosition();
	    for(int i = t.getTaille(); i>0; i--){
		switch(t.getSensDeplacement()){
		    case AMONT : if(position.getSuivant().equals(null)){
				    if(position.getSuivant().getParent().getAmont().equals(this)){
					throw new TrainSurAiguillage("Il y a un train !");
				    }
				    else{
					switch(position.getParent().getAmont().getType()){
					    case BUTEE : continue;
					    case JONCTION : position = ((Jonction)(position.getParent().getAmont())).getAmont().getDernierTroncon();
							    continue;
					    case AIGUILLAGE : position = ((Aiguillage)(position.getParent().getAmont())).getLienAmont().getDernierTroncon();
								continue;
					}
				    }
				 }
				 position = position.getSuivant();
				 break;
		    case AVAL : if(position.getPrecedent().equals(null)){
				    if(position.getPrecedent().getParent().getAval().equals(this)){
					throw new TrainSurAiguillage("Il y a un train !");
				    }
				    else{
					switch(position.getParent().getAval().getType()){
					    case BUTEE : continue;
					    case JONCTION : position = ((Jonction)(position.getParent().getAval())).getAval().getPremierTroncon();
							    continue;
					    case AIGUILLAGE : position = ((Aiguillage)(position.getParent().getAval())).getLienAval().getPremierTroncon();
								continue;
					}
				    }
				 }
				 position = position.getPrecedent();
				 break;
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
