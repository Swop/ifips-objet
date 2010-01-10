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
}
