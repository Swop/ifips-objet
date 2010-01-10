/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

/**
 *
 * @author NorTicUs
 */
public class Butee extends ElementsJonction{

    private Rail rail;

    public Butee(Rail rail) {
	this.rail = rail;
    }

    public Rail getRail() {
	return rail;
    }

    public void setRail(Rail rail) {
	this.rail = rail;
    }

}
