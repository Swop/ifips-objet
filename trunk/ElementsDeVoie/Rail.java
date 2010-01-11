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

    private Troncon premierTroncon;
    private Troncon dernierTroncon;
    private ElementsJonction amont;
    private ElementsJonction aval;
    private LinkedList<Semaphore> semaphoresAmont;
    private LinkedList<Semaphore> semaphoresAval;

    public Rail(int taille, Troncon premierTroncon, Troncon dernierTroncon, ElementsJonction amont, ElementsJonction aval, LinkedList<Semaphore> semaphoresAmont, LinkedList<Semaphore> semaphoresAval) {
	this.longueur = taille;
	this.premierTroncon = premierTroncon;
	this.dernierTroncon = dernierTroncon;
	this.amont = amont;
	this.aval = aval;
	this.semaphoresAmont = semaphoresAmont;
	this.semaphoresAval = semaphoresAval;
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

    public Troncon getDernierTroncon() {
	return dernierTroncon;
    }

    public void setDernierTroncon(Troncon dernierTroncon) {
	this.dernierTroncon = dernierTroncon;
    }

    public Troncon getPremierTroncon() {
	return premierTroncon;
    }

    public void setPremierTroncon(Troncon premierTroncon) {
	this.premierTroncon = premierTroncon;
    }

}
