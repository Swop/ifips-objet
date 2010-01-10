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

    @Override
    public TypeJonction getType() {
	return TypeJonction.AIGUILLAGE;
    }

}
