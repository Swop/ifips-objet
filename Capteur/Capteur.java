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
        this.train_detectés=new ArrayList<Train>();
    }

    public Troncon getPosition(){
        return this.position;
    }

    public void setPosition(Troncon t){
        this.position=t;
    }
    /**
     * Dit si au moins un train est passé pendant l'unité de temps.
     * /!\Attention/!\ REINITIALISE LE CAPTEUR A INACTIF /!\Attention/!\
     * @return boolean
     */
    public boolean isActif(){
        if (this.actif){
            this.actif=false;
            
            return true;
        }
        else return false;
        
    }

    public abstract void activer(Train t);

    

}
