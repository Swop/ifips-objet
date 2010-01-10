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

    private LinkedList<Rail> amont;
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

}
