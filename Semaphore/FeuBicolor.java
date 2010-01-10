

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FeuBicolor;

/**
 *
 * @author HerrChaoul
 */


public class FeuBicolor extends Semaphore {

	protected boolean Feu1;
	protected boolean Feu2;
	
	public FeuBicolor () {

		this.Feu1=false;//Feu Vert	
		this.Feu2=true;//Feu Rouge
			
	    };

	    
	    boolean isGreen(){
	    	return Feu1;
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