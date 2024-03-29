/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;

import gestion_train.*;
import ElementsDeVoie.*;
import java.util.ArrayList;

/**
 *
 * @author po
 */
public abstract class Capteur {

    private Troncon position;
    protected boolean actif;
    
    public Capteur(Troncon p){
        this.position=p;
        p.addCapteurs(this);
       
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
     * Doit être appelé une fois par unité de temps
     * @return boolean
     */
    public boolean isActif(){
        if (this.actif){
            this.actif=false;
            
            return true;
        }
        else return false;
        
    }

    /**
     * Fonction générique pour activer un capteur dès qu'un train passe dessus
     * @param t le train qui passe, permet de récuperer des informations qui peuvent êtres nécéssaire au capteur
     */
    public abstract void activer(Train t);

    

}
