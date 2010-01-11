

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
	protected float diminution;
	
	/**
	 * constructeur de PanneauRalentissement
	 * @param diminution diminution de vitesse indiqu�e par PanneauRalentissement
	 */
	public PanneauRalentissement(float diminution) {
		if(diminution<0)this.diminution=0;
		else if(diminution>1)this.diminution=1;
		else this.diminution=diminution;
	}


	    /**
	     * retourne la valeur de Diminution
	     * @return valeur (float) de Diminution
	     */
	    public float getDiminution(){
	    	return diminution;
	    }
	    
	    /**
	     * modifie la valeur du Diminution
	     * @param dimi nouvelle valeur de Diminution
	     */
	    public void setDiminution(float dimi){
	    	this.diminution=dimi;
	    }
	    
	    @Override
    	    public String toString(){
	    	return "panneau ralentissement";
	    }

		/**
		 * Modifie la vitesse du train en fonction de la valeur de Diminution
		 */
		public void actionTrain(Train t) {
			 t.setVitessePourcentage(diminution);
		}
	    
}