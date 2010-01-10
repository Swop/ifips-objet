

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


public class FeuUnicolor extends Semaphore {

	/**
	 * definition du Feu1
	 */
	protected boolean Feu1;
	
	public FeuUnicolor (Sens sens,Troncon position) {
		super(sens,position);
		this.Feu1=false;//Feu Vert
			
	    };

	    
	    boolean getFeu1(){
	    	return Feu1;
	    }
	    
	    void setFeu1(boolean bool){
	    	this.Feu1=bool;
	    }


		/**
		 * Modifie la vitesse du train
		 */
		public void actionTrain(Train t) {
			//if(!Feu1)
		}
	    
}