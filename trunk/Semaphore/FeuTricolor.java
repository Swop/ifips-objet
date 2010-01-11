
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
	
	/**
	 * definition de Feu3
	 */
	boolean Feu3;
	
	/**
	 * constructeur de FeuTricolor
	 * @param sens sens du semaphore
	 * @param position position du semaphore
	 */
	public FeuTricolor (Sens sens,Troncon position) {
		super(sens,position);
		super.Feu1=false;
		super.Feu2=false;//Feu Orange
		this.Feu3=true;//Feu Rouge
			
	    };
	    
	    /**
	     * renvoie la valeur de Feu3
	     * @return valeur de Feu3 (Vrai ou Faux)
	     */
	    public boolean getFeu3d(){
	    	return Feu3;
	    }
	    
	    /**
	     * modifie la valeur de Feu1, puis Feu2 et Feu3 en conséquent
	     * @param bool nouvelle valeur de Feu1
	     */
	    public void setFeu1(boolean bool){
	    	if(bool==false && bool!=Feu1){
	    		this.Feu1=bool;
	    		this.Feu2=!bool;
	    		this.Feu3=bool;
	    	}
	    	else if(bool==true && bool!=Feu1){
	    		this.Feu1=bool;
	    		this.Feu2=!bool;
	    		this.Feu3=!bool;
	    	}
	    	
	    }
	    
	    /**
	     * modifie la valeur de Feu2, puis Feu1 et Feu3 en conséquent
	     * @param bool nouvelle valeur de Feu2
	     */
	    public void setFeu2(boolean bool){
	    	if(bool==false && bool!=Feu2){
	    		this.Feu1=bool;
	    		this.Feu2=bool;
	    		this.Feu3=!bool;
	    	}
	    	else if(bool==true && bool!=Feu2){
	    		this.Feu1=!bool;
	    		this.Feu2=bool;
	    		this.Feu3=!bool;
	    	}
	    }
	    
	    /**
	     * modifie la valeur de Feu3, puis Feu1 et Feu2 en conséquent
	     * @param bool nouvelle valeur de Feu3
	     */
	    public void setFeu3(boolean bool){
	    	if(bool==false && bool!=Feu3){
	    		this.Feu1=!bool;
	    		this.Feu2=bool;
	    		this.Feu3=bool;
	    	}
	    	else if(bool==true && bool!=Feu3){
	    		this.Feu1=!bool;
	    		this.Feu2=!bool;
	    		this.Feu3=bool;
	    	}    	
	    }
	   
	    
	    /**
		 * Modifie la vitesse du train
		 */
		public void actionTrain(Train t) {
			if(Feu1 && t.getVitesseCourante()==0)t.setVitessePourcentage((float)0.50);
			else if(Feu2) t.setVitessePourcentage((float)0.01);
			else if(Feu3)t.setVitessePourcentage(0);
		}
	
}