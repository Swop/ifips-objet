

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


public class PanneauRalentissement extends Semaphore {

	/**
	 * definition de diminution
	 */
	protected float Diminution; 
	
	/**
	 * constructeur de PanneauRalentissement
	 * @param diminution diminution de vitesse indiquée par PanneauRalentissement
	 */
	public PanneauRalentissement(float diminution) {
		if(diminution<0)this.Diminution=0;
		else if(diminution>1)this.Diminution=1;
		else this.Diminution=diminution;
	}


	    /**
	     * retourne la valeur de Diminution
	     * @return valeur (float) de Diminution
	     */
	    public float getDiminution(){
	    	return Diminution;
	    }
	    
	    /**
	     * modifie la valeur du Diminution
	     * @param dimi nouvelle valeur de Diminution
	     */
	    public void setDiminution(float dimi){
	    	this.Diminution=dimi;
	    }
	    
	    public String toString(){
	    	return "panneau ralentissement";
	    }

		/**
		 * Modifie la vitesse du train en fonction de la valeur de Diminution
		 */
		public void actionTrain(Train t) {
			 t.setVitessePourcentage(Diminution);	
		}
	    
}