/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Train;

/**
 *
 * @author HerrChaoul
 */


public abstract class Semaphore {

	
	
	/**
	 * constructeur de Semaphore

	 */
	public Semaphore () {
	};
	
	
	/**
	 * modifie des caracteristique du train en fonction du semaphore utilise
	 * @param t le train a modifier
	 */
	abstract public void actionTrain(Train t);
}