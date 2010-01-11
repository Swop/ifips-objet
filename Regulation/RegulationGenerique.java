/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regulation;

import Capteur.Capteur;
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

    public RegulationGenerique(){
        this.ia = new Random();
    }
    public void reguler() {

        for (Aiguillage a : this.aguillages){
            try {
                a.setLien(ia.nextInt(a.getAmont().size()-1), ia.nextInt(a.getAval().size()-1));
            } catch (TrainSurAiguillage ex) {
                return;
            }
            for (Capteur c : this.capteurs)
                if (c.isActif())
                    System.out.println("Oulalala ya un train en "+c.getPosition().toString());
                else System.out.println("j'ai testé le capteur "+c.getPosition().toString());
            System.out.println("Echange des liens et tentative de mise à jour feu");

            for (Semaphore s : a.getLienAmont().getSemaphoresAval()) {
                ((FeuUnicolor)s).setFeu1(false);
                this.addSemaphore(s);
            }
            /*
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
            }*/
            
        }
    }

}
