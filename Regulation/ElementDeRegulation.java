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
    protected ArrayList<Aiguillage> aguillages;
    protected ArrayList<Capteur> capteurs;
    protected ArrayList<Semaphore> semaphores;

    public ElementDeRegulation(){
        this.aguillages = new ArrayList<Aiguillage>();
        this.capteurs = new ArrayList<Capteur>();
        this.semaphores = new ArrayList<Semaphore>();
    }

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
