/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regulation;

import ElementsDeVoie.*;
import Semaphore.FeuUnicolor;
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
            System.out.println("Echange des liens et tentative de mise à jour feu");
            for (Semaphore s : a.getLienAmont().getSemaphoresAval()) {
                ((FeuUnicolor)s).setFeu1(false);
                this.addSemaphore(s);
            }
            for (Semaphore s : a.getLienAval().getSemaphoresAmont()) {
                ((FeuUnicolor)s).setFeu1(false);
                this.addSemaphore(s);
            }
            for (Rail ram : a.getAmont()){
                for (Semaphore sam : ram.getSemaphoresAval())
                    if (!this.getSemaphore().contains(sam))
                        ((FeuUnicolor)sam).setFeu1(true);

            }
            for (Rail ram : a.getAval()){
                for (Semaphore sam : ram.getSemaphoresAmont())
                    if (!this.getSemaphore().contains(sam))
                        ((FeuUnicolor)sam).setFeu1(true);
            }
        }
    }

}
