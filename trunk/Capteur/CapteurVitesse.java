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
    protected ArrayList<Float> vitesses_detectés;
    CapteurVitesse(Troncon p){
        super(p);
        this.vitesses_detectés = new ArrayList<Float>();
    }


    public void activer(Train t) {
        this.vitesses_detectés.add(t.getVitesseCourante());
        this.actif=true;
    }
    /**
     * Calcul la vitesse et reinitialise la liste de trains detectés
     *
     * @return la vitesse moyenne detectée pendant l'unité de temps
     * 0 si aucun train detecté
     */
    public float getVitesse(){
        float v = 0;
        for (float t : vitesses_detectés){
            v+= t;
        }
        v/=vitesses_detectés.size();
        this.vitesses_detectés.clear();
        return v;
    }
  
}
