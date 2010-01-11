/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Capteur;
import ElementsDeVoie.*;
import gestion_train.Train;
/**
 *
 * @author po
 */
public class CapteurVitesse extends Capteur {

    CapteurVitesse(Troncon p){
        super(p);
    }


    public void activer(Train t) {
        this.train_detectés.add(t);
        this.actif=true;
    }

    public void getVitesse(){
        float v = 0;
        for (Train t : train_detectés){
            v+= t.getVitesseCourante();
        }
        v/=train_detectés.size();
        this.train_detectés.clear();
    }
  
}
