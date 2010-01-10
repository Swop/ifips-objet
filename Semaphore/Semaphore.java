/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Semaphore;

import gestion_train.Sens;
import ElementsDeVoie.Troncon;

/**
 *
 * @author HerrChaoul
 */


public class Semaphore {

	private Sens SemaSens;
	private Troncon Position; 
	
	public Semaphore (Sens sens,Troncon position) {
		this.SemaSens=sens;
		this.Position=position;
	};
	
	public Troncon getPosition(){
		return Position;
	}

	public Sens getSens(){
		return SemaSens;
	}	
	
	public void setPosition(Troncon position){
		this.Position=position;
	}
	
	public void setSens(Sens sens){
		this.SemaSens=sens; 
	}
}