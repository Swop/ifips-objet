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

    /**
     * Premier tronçon du rail
     */
    private Troncon premierTroncon;
    /**
     * Dernier tronçon du rail
     */
    private Troncon dernierTroncon;
    /**
     * Jonction en amont
     */
    private ElementsJonction amont;
    /**
     * Jonction en aval
     */
    private ElementsJonction aval;
    /**
     * Sémaphores pour les trains allant en amont
     */
    private LinkedList<Semaphore> semaphoresAmont;
    /**
     * Sémaphores pour les trains allant en aval;
     */
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

    public Rail(int taille){
	Troncon t1 = new Troncon(this);
	this.premierTroncon = t1;
	t1.setPrecedent(null);
	for(int i=1; i<taille; i++){
	    Troncon t2 = new Troncon(this);
	    t1.setSuivant(t2);
	    t2.setPrecedent(t1);
	    t1 = t2;
	}
	this.dernierTroncon = t1;
	this.amont = null;
	this.aval = null;
	this.semaphoresAmont = new LinkedList();
	this.semaphoresAval = new LinkedList();

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

    public void addSemaphoreAmont(Semaphore sem){
	this.semaphoresAmont.add(sem);
    }

    public LinkedList<Semaphore> getSemaphoresAval() {
	return semaphoresAval;
    }

    public void setSemaphoresAval(LinkedList<Semaphore> semaphoresAval) {
	this.semaphoresAval = semaphoresAval;
    }

    public void addSemaphoreAval(Semaphore sem){
	this.semaphoresAval.add(sem);
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
