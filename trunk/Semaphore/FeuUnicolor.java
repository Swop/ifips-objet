

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

/**
 *
 * @author HerrChaoul
 */


public class UniBicolor extends Semaphore {

	protected boolean Feu1;
	
	public FeuBicolor () {

		this.Feu1=false;//Feu Vert
			
	    };

	    
	    boolean isGreen(){
	    	return Feu1;
	    }
	    
	    void toGreen(){
	    	Feu1=true;
	    }

	    
}