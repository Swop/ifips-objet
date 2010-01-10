/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import Semaphore.*;

/**
 *
 * @author NorTicUs
 */
public class Rail extends ElementDeVoie{

    private LinkedList<Troncon> troncons;
    private ElementsJonction amont;
    private ElementsJonction aval;
    private LinkedList<Semaphore> semaphoresAmont;
    private LinkedList<Semaphore> semaphoresAval;

    public Rail(LinkedList<Troncon> troncons, ElementsJonction amont, ElementsJonction aval) {
	this.troncons = troncons;
	this.amont = amont;
	this.aval = aval;
    }

    public ElementsJonction getAmont() {
	return amont;
    }

    public void setAmont(ElementsJonction amont) {
	this.amont = amont;
    }

    public ElementsJonction getAval() {
	return aval;
    }

    public void setAval(ElementsJonction aval) {
	this.aval = aval;
    }

    public LinkedList<Semaphore> getSemaphoresAmont() {
	return semaphoresAmont;
    }

    public void setSemaphoresAmont(LinkedList<Semaphore> semaphoresAmont) {
	this.semaphoresAmont = semaphoresAmont;
    }

    public LinkedList<Semaphore> getSemaphoresAval() {
	return semaphoresAval;
    }

    public void setSemaphoresAval(LinkedList<Semaphore> semaphoresAval) {
	this.semaphoresAval = semaphoresAval;
    }

    public LinkedList<Troncon> getTroncons() {
	return troncons;
    }

    public void setTroncons(LinkedList<Troncon> troncons) {
	this.troncons = troncons;
    }


}
