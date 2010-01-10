

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


public class FeuBicolor extends FeuUnicolor {


	protected boolean Feu2;
	
	public FeuBicolor (Sens sens,Troncon position) {
		super(sens,position);
		super.Feu1=false;//Feu Vert	
		this.Feu2=true;//Feu Rouge
			
	    };

	    boolean getFeu2(){
	    	return Feu2;
	    }
	    
	    void setFeu2(boolean bool){
	    	this.Feu2=bool;
	    }
	    
	    /**
		 * Modifie la vitesse du train
		 */
		public void actionTrain(Train t) {
			
		}
	    
}