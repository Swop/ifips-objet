

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


public class FeuBicolor extends FeuUnicolor {

	/**
	 * definition de Feu2
	 */
	protected boolean Feu2;
	
	/**
	 * constructeur de FeuBicolor
	 */
	public FeuBicolor () {
		super.Feu1=false;//Feu Vert	
		this.Feu2=true;//Feu Rouge
			
	    };

	    /**
	     * renvoie la valeur de Feu2
	     * @return valeur de Feu2 (Vrai ou Faux)
	     */
	    public boolean getFeu2(){
	    	return Feu2;
	    }
	    
	    /**
	     * modifie la valeur de Feu1
	     * @param bool nouvelle valeur de Feu1
	     */
	    public void setFeu1(boolean bool){
	    	this.Feu1=bool;
	    	this.Feu2=!bool;
	    }
	    
	    /**
	     * modifie la valeur de Feu2
	     * @param bool nouvelle valeur de Feu2
	     */
	    public void setFeu2(boolean bool){
	    	this.Feu2=bool;
	    	this.Feu1=!bool;
	    }
	   
	    public String toString(){
	    	return "feu bicolor";
	    }
	    
	    /**
		 * Modifie la vitesse du train
		 */
		public void actionTrain(Train t) {
			if(Feu1 && t.getVitesseCourante()==0)t.setVitessePourcentage((float)0.50);
			else if(Feu2) t.setVitessePourcentage(0);		
			
		}
	    
}