/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import Capteur.Capteur;
import ElementsDeVoie.ElementsJonction.TypeJonction;
import ElementsDeVoie.OutOfRail.TypeProbleme;
import Semaphore.Semaphore;
import gestion_train.Sens;

/**
 *
 * @author NorTicUs
 */
public class Troncon {

    /**
     * Rail contenant le tronçon
     */
    private Rail parent;
    /**
     * Capteurs présents sur le tronçon
     */
    private LinkedList<Capteur> capteurs;
    /**
     * Tronçon suivant
     */
    private Troncon suivant;
    /**
     * Tronçon précédent
     */
    private Troncon precedent;

    public Troncon(Rail parent) {
	this.parent = parent;
    }

    public Rail getParent() {
	return parent;
    }

    public void setParent(Rail parent) {
	this.parent = parent;
    }

    public LinkedList<Capteur> getCapteurs() {
	return capteurs;
    }

    public void setCapteurs(LinkedList<Capteur> capteurs) {
	this.capteurs = capteurs;
    }

    public void addCapteurs(Capteur capteur){
	capteurs.add(capteur);
    }

    /**
     * Envoie le tronçon suivant
     * @param sens
     *	    Sens du train
     * @return
     *	    Le tronçon suivant
     * @throws OutOfRail
     *	    En cas de déraillement
     */
    public Troncon getNextTroncon(Sens sens) throws OutOfRail{
	    switch(sens){
		case AMONT : if(precedent.equals(null)){
				if(parent.getAmont().getType().equals(TypeJonction.BUTEE)){
				    throw new OutOfRail("T'es buté mec !", TypeProbleme.BUTEE);
				}
				if(parent.getAmont().getType().equals(TypeJonction.AIGUILLAGE)){
				    if(((Aiguillage)(parent.getAmont())).getLienAmont().equals(null)){
					throw new OutOfRail("On t'as mal renseigné !", TypeProbleme.AIGUILLAGE_FAIL);
				    }
				    else{
					((Aiguillage)(parent.getAmont())).getLienAmont().getDernierTroncon();
				    }
				}
				return ((Jonction)(parent.getAmont())).getAmont().getDernierTroncon();
			    }
			    else{
				return precedent;
			    }
		case AVAL : if(suivant.equals(null)){
				if(parent.getAval().getType().equals(TypeJonction.BUTEE)){
				    throw new OutOfRail("T'es buté mec !", TypeProbleme.BUTEE);
				}
				if(parent.getAval().getType().equals(TypeJonction.AIGUILLAGE)){
				     if(((Aiguillage)(parent.getAval())).getLienAval().equals(null)){
					throw new OutOfRail("On t'as mal renseigné !", TypeProbleme.AIGUILLAGE_FAIL);
				    }
				    else{
					((Aiguillage)(parent.getAval())).getLienAval().getPremierTroncon();
				    }
				}
				return ((Jonction)(parent.getAval())).getAval().getPremierTroncon();
			     }
			    else{
				return suivant;
			    }
		default : return null;
	    }
    }

    public LinkedList<Semaphore> testSemaphore(Sens sens){
	switch(sens){
	    case AMONT : if(precedent.equals(null)){
				return parent.getSemaphoresAmont();
			}; break;
	    case AVAL : if(suivant.equals(null)){
			    return parent.getSemaphoresAval();
			};break;
	}
	return new LinkedList<Semaphore>();
    }

}
