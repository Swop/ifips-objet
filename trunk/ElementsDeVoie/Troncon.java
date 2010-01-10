/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import Capteur.Capteur;
import ElementsDeVoie.ElementsJonction.TypeJonction;
import ElementsDeVoie.OutOfRail.TypeProbleme;
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
	if(this.equals(parent.getTroncons().getLast())){
	    switch(sens){
		case AMONT : return parent.getTroncons().get(parent.getTroncons().size() - 2);
		case AVAL : if(parent.getAval().getType().equals(TypeJonction.BUTEE)){
				throw new OutOfRail("T'es buté mec !", TypeProbleme.BUTEE);
			    }
			    if(parent.getAval().getType().equals(TypeJonction.AIGUILLAGE)){
				throw new OutOfRail("On t'as mal renseigné !", TypeProbleme.AIGUILLAGE_FAIL);
			    }
			    return ((Jonction)(parent.getAval())).getAval().getUnTroncon(0);
		default : return this;
	    }
	}
	else{
	    switch(sens){
		case AMONT : return parent.getUnTroncon(parent.getTroncons().indexOf(this)-1);
		case AVAL : return parent.getUnTroncon(parent.getTroncons().indexOf(this)-1);
		default : return this;
	    }
	}
    }



}
