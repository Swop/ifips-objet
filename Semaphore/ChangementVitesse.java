

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Sens;
import gestion_train.Train;
import ElementsDeVoie.Rail;

/**
 *
 * @author HerrChaoul
 */


public class ChangementVitesse extends Semaphore {

	/**
	 * definition de Vitesse
	 */
	protected int Vitesse; 
	
	/**
	 * constructeur de ChangementVitesse
	 * @param sens sens du ChangementVitesse	
	 * @param rail rail du ChangementVitesse
	 * @param vitesse vitesse indiqu� par le panneau
	 */
	public ChangementVitesse(Sens sens, Rail rail,int vitesse) {
		super(sens, rail);
		if(vitesse<0)this.Vitesse=0;
		else this.Vitesse=vitesse;
	}


	    /**
	     * retourne la valeur de Vitesse
	     * @return valeur (int) de vitesse
	     */
	    public int getVitesse(){
	    	return Vitesse;
	    }
	    
	    /**
	     * modifie la valeur de Vitesse
	     * @param vitesse nouvelle valeur de Vitesse
	     */
	    public void setVitesse(int vitesse){
	    	this.Vitesse=vitesse;
	    }


		/**
		 * Modifie la vitesse du train en fonction de la valeur de Vitesse
		 */
		public void actionTrain(Train t) {
			 t.setVitesseScalaire(Vitesse);
		}
	    
}