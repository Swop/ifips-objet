
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Sens;
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
	    
	    boolean isRed(){
	    	return Feu3;
	    }
	    
	    boolean isOrange(){
	    	return Feu2;
	    }
	      
	    void toGreen(){
	    	Feu1=true;
	    	Feu2=false;
	    	Feu3=false;
	    	
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
	
	
}