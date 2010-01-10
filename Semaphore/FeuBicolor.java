

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

/**
 *
 * @author HerrChaoul
 */


public class FeuBicolor extends FeuUnicolor {


	protected boolean Feu2;
	
	public FeuBicolor () {

		super.Feu1=false;//Feu Vert	
		this.Feu2=true;//Feu Rouge
			
	    };

	    boolean isRed(){
	    	return Feu2;
	    }
	    
	    void toGreen(){
	    	Feu1=true;
	    	Feu2=false;
	    }
	    
	    void toRed(){
	    	Feu1=false;
	    	Feu2=true;
	    }
	    
}