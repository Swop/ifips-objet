
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FeuTricolor;

/**
 *
 * @author HerrChaoul
 */


public class FeuTricolor extends FeuBicolor {

	boolean Feu3;
	
	public FeuTricolor () {

		super.Feu1=false;//Feu Vert
		super.Feu2=false;//Feu Orange
		this.Feu3=true;//Feu Rouge
			
	    };

	    
	    boolean isGreen(){
	    	return Feu1;
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