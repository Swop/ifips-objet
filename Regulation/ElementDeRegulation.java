/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regulation;

import java.util.ArrayList;
import ElementsDeVoie.*;
import Semaphore.*;
import Capteur.*;

/**
 *
 * @author po
 */
public abstract class ElementDeRegulation {
    private ArrayList<Aiguillage> aguillages;
    private ArrayList<Capteur> capteurs;
    private ArrayList<Semaphore> semaphores;

    public void addAiguillage(Aiguillage a){
        this.aguillages.add(a);
    }

    public void addCapteur(Capteur c){
        this.capteurs.add(c);
    }

    public void addSemaphore(Semaphore s){
        this.semaphores.add(s);
    }

    public ArrayList<Aiguillage> getAguillages(){
        return this.aguillages;
    }

    public ArrayList<Capteur> getCapteurs(){
        return this.capteurs;
    }

    public ArrayList<Semaphore> getSemaphore(){
        return this.semaphores;
    }

    public abstract void reguler();
}
