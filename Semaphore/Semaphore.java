/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Sens;
import gestion_train.Train;
import ElementsDeVoie.Rail;

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
	private Rail SemaRail; 
	
	/**
	 * constructeur de Semaphore

	 */
	public Semaphore () {
	};
	
	/**
	 * renvoie la position du semaphore sur le rail
	 * @return position du semaphore
	 */
	public Rail getPosition(){
		return SemaRail;
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
	public void setPosition(Rail rail){
		this.SemaRail=rail;
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