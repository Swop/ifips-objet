

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
	
	/**
	 * constructeur de FeuUnicolor
	 * @param sens sens du FeuUnicolor	
	 * @param position position du FeuUnicolor
	 */
	public FeuUnicolor (Sens sens,Troncon position) {
		super(sens,position);
		this.Feu1=false;//Feu Vert
			
	    };

	    /**
	     * retourne la valeur de Feu 1
	     * @return valeur (vrai ou faux) de Feu1
	     */
	    public boolean getFeu1(){
	    	return Feu1;
	    }
	    
	    /**
	     * modifie la valeur du Feu1
	     * @param bool nouvelle valeur du Feu1
	     */
	    public void setFeu1(boolean bool){
	    	this.Feu1=bool;
	    }


		/**
		 * Modifie la vitesse du train en fonction de la valeur de Feu1
		 */
		public void actionTrain(Train t) {
			if(!Feu1)t.setVitessePourcentage(0);
			else if(t.getVitesseCourante()==0) t.setVitessePourcentage((float) 0.50);
			
		}
	    
}