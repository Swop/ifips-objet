/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;

import gestion_train.*;
import ElementsDeVoie.*;
import gestion_train.*;
import java.util.ArrayList;

/**
 *
 * @author po
 */
public abstract class Capteur {

    private Troncon position;
    protected boolean actif;
    protected ArrayList<Train> train_detectés;
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
        if (this.actif){
            this.actif=false;
            
            return true;
        }
        else return false;
        
    }

    public abstract void activer(Train t);

    

}