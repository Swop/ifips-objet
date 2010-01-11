/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regulation;

import ElementsDeVoie.*;
import Semaphore.Semaphore;


/**
 *
 * @author po
 */
public class RegulationGenerique extends ElementDeRegulation {


    public void reguler() {
        for (Aiguillage a : this.aguillages){
            for (Rail r : a.getAmont()){

                    for (Semaphore s : r.getSemaphoresAval()){
                        if a.getLienAmont().equals(r) s.
                    }

            }
            for (Rail r : a.getAval()){
                for (Semaphore s : r.getSemaphoresAmont()){

                }
            }

        }
    }

}
