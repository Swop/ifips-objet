/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;

import gestion_train.*;
import ElementsDeVoie.*;
import gestion_train.*;

/**
 *
 * @author po
 */
public abstract class Capteur {

    private Troncon position;
    protected boolean actif;
    protected Train train_detecté;
    public Capteur(Troncon p){
        this.position=p;

    }

    public Troncon getPosition(){
        return this.position;
    }

    public void setPosition(Troncon t){
        this.position=t;
    }
    
    public boolean isActif(){
        return this.actif;
    }

    public abstract void activer(Train t);
    

}
