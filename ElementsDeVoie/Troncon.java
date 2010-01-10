/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

import java.util.LinkedList;
import Capteur.Capteur;

/**
 *
 * @author NorTicUs
 */
public class Troncon {

    private Rail parent;
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
}
