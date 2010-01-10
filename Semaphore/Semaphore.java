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
	*Indique emplacement du semaphore sur le rail
	*Le semaphore est visible pour les trains sur le rail auquel appartient le semaphore
	*/
	
	private Sens SemaSens;
	
	/**
	 *Position du semaphore sur le rail
	 */
	
	private Troncon Position; 
	
	public Semaphore (Sens sens,Troncon position) {
		this.SemaSens=sens;
		this.Position=position;
	};
	
	public Troncon getPosition(){
		return Position;
	}

	public Sens getSens(){
		return SemaSens;
	}	
	
	public void setPosition(Troncon position){
		this.Position=position;
	}
	
	public void setSens(Sens sens){
		this.SemaSens=sens; 
	}
	
	abstract public void actionTrain(Train t);
}