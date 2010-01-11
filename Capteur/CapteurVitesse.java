/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;
import ElementsDeVoie.*;
import gestion_train.Train;
import java.util.ArrayList;
/**
 *
 * @author po
 */
public class CapteurVitesse extends Capteur {
    protected ArrayList<Float> vitesses_detectees;
    CapteurVitesse(Troncon p){
        super(p);
        this.vitesses_detectees = new ArrayList<Float>();
    }


    public void activer(Train t) {
        this.vitesses_detectees.add(t.getVitesseCourante());
        this.actif=true;
    }
    /**
     * Calcul la vitesse et reinitialise la liste de vitesses detectés
     *
     * @return la vitesse moyenne detectée pendant l'unité de temps
     * 0 si aucun train detecté
     */
    public float getVitesse(){
        float v = 0;
        for (float t : vitesses_detectees){
            v+= t;
        }
        v/=vitesses_detectees.size();
        this.vitesses_detectees.clear();
        return v;
    }
  
}
