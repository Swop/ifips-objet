/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regulation;

import ElementsDeVoie.*;
import Semaphore.Semaphore;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author po
 */
public class RegulationGenerique extends ElementDeRegulation {

    Random ia;
    public void reguler() {
        for (Aiguillage a : this.aguillages){
            try {
                a.setLien(ia.nextInt(a.getAmont().size()), ia.nextInt(a.getAval().size()));
            } catch (TrainSurAiguillage ex) {
                return;
            }

        }
    }

}
