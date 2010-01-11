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
public class CapteurPosition extends Capteur{
    
    CapteurPosition(Troncon p){
        super(p);
    }


    public void activer(Train t) {
        this.train_detecté=t;
        this.actif=true;
    }
}
