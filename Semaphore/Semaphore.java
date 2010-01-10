/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Sens;
import gestion_train.Train;
import ElementsDeVoie.Troncon;

/**
 *
 * @author HerrChaoul
 */


public abstract class Semaphore {

	
	/**
	*Indique pour quelle direction le semaphore est visible
	*/
	private Sens SemaSens;
	
	/**
	 *Position du semaphore sur le rail
	 */
	private Troncon Position; 
	
	/**
	 * constructeur de Semaphore
	 * @param sens la direction du semaphore
	 * @param position position du semaphore sur le rail
	 */
	public Semaphore (Sens sens,Troncon position) {
		this.SemaSens=sens;
		this.Position=position;
	};
	
	/**
	 * renvoie la position du semaphore sur le rail
	 * @return position du semaphore
	 */
	public Troncon getPosition(){
		return Position;
	}

	/**
	 * renvoie la direction pour laquelle le semaphore est visible
	 * @return sens de semaphore
	 */
	public Sens getSens(){
		return SemaSens;
	}	
	
	/**
	 * modifie la position du semaphore sur le rail
	 * @param position la nouvelle position du semaphore
	 */
	public void setPosition(Troncon position){
		this.Position=position;
	}
	
	/**
	 * modifie la direction pour laquelle la semaphore est visible
	 * @param sens le nouveau sens du semaphore
	 */
	public void setSens(Sens sens){
		this.SemaSens=sens; 
	}
	
	/**
	 * modifie des caracteristique du train en fonction du semaphore utilise
	 * @param t le train a modifier
	 */
	abstract public void actionTrain(Train t);
}