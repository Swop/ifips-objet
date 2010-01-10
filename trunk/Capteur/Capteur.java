/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;

import gestion_train.Train;
import ElementsDeVoie.*;
import gestion_train.*;

/**
 *
 * @author po
 */
public abstract class Capteur {

    private Troncon position;

    public Capteur(Troncon p){
        this.position=p;
    }

    public Troncon getPosition(){
        return this.position;
    }

    public void setPosition(Troncon t){
        this.position=t;
    }
    
    public void activer(Train t){
        
    }
    

}
