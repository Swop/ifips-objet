

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


public class ChangementVitesse extends Semaphore {

	/**
	 * definition de Vitesse
	 */
	protected int vitesse;
	
	/**
	 * constructeur de ChangementVitesse
	 * @param vitesse vitesse indiqué par le panneau
	 */
	public ChangementVitesse(int vitesse) {
		if(vitesse<0)this.vitesse=0;
		else this.vitesse=vitesse;
	}


	    /**
	     * retourne la valeur de Vitesse
	     * @return valeur (int) de vitesse
	     */
	    public int getVitesse(){
	    	return vitesse;
	    }
	    
	    /**
	     * modifie la valeur de Vitesse
	     * @param vitesse nouvelle valeur de Vitesse
	     */
	    public void setVitesse(int vitesse){
	    	this.vitesse=vitesse;
	    }


		/**
		 * Modifie la vitesse du train en fonction de la valeur de Vitesse
		 */
		public void actionTrain(Train t) {
			 t.setVitesseScalaire(vitesse);
		}
		
		@Override
		public String toString(){
	    	return "changement vitesse";
	    }
	    
}