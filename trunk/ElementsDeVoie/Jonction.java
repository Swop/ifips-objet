/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

/**
 *
 * @author NorTicUs
 */
public class Jonction extends ElementsJonction{

    private Rail amont;
    private Rail aval;

    public Jonction(Rail amont, Rail aval) {
	this.amont = amont;
	this.aval = aval;
    }

    public Rail getAmont() {
	return amont;
    }

    public void setAmont(Rail amont) {
	this.amont = amont;
    }

    public Rail getAval() {
	return aval;
    }

    public void setAval(Rail aval) {
	this.aval = aval;
    }

}
