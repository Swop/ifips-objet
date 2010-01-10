
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


public class FeuTricolor extends FeuBicolor {

	boolean Feu3;
	
	public FeuTricolor (Sens sens,Troncon position) {
		super(sens,position);
		super.Feu1=false;
		super.Feu2=false;//Feu Orange
		this.Feu3=true;//Feu Rouge
			
	    };
	    
	    boolean getFeu3d(){
	    	return Feu3;
	    }
	    
	    
	    void setFeu3(boolean bool){
	    	this.Feu3=bool;	    	
	    }
	    
	    
	    void toOrange(){
	    	Feu1=false;
	    	Feu2=true;
	    	Feu3=false;
	    	
	    }	    
	    
	    void toRed(){
	    	Feu1=false;
	    	Feu2=false;
	    	Feu3=true;
	    }
	    
	    /**
		 * Modifie la vitesse du train
		 */
		public void actionTrain(Train t) {
			
		}
	
}