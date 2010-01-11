package Main;

import ElementsDeVoie.*;
import Regulation.ElementDeRegulation;
import Semaphore.ChangementVitesse;
import Semaphore.FeuTricolor;
import Semaphore.PanneauRalentissement;
import gestion_train.Sens;
import java.util.ArrayList;
import gestion_train.Train;
/**
 *  Classe principale du programme
 * @author swop
 */
public class SimulationReseauFerroviaire {
    /**
     * Liste des trains
     */
    public static ArrayList<Train> trains;
    /**
     * Liste des regulateurs d'elements
     */
    public static ArrayList<ElementDeRegulation> regulateurs;

    /**
     * Point d'entree du programme
     * @param args
     *	Arguments de la ligne de commande
     */
    public static void main(String args[]) {

	trains = new ArrayList<Train>();
	regulateurs = new ArrayList<ElementDeRegulation>();


	// ******* Initialisation du reseau //
	Rail r1 = new Rail(50);
	Rail r2 = new Rail(50);

	r2.addSemaphoreAmont(new ChangementVitesse(7));

	Jonction j1 = new Jonction();
	j1.setAmont(r2);
	j1.setAval(r1);

	Aiguillage a1 = new Aiguillage();


	Rail r3 = new Rail(50);
	a1.addAval(r3);
	a1.addAval(r2);

	Rail r4 = new Rail(50);
	Rail r5 = new Rail(50);
	a1.addAmont(r4);
	a1.addAmont(r5);
	try {
	    a1.setLien(0, 1);
	} catch (TrainSurAiguillage ex) {
	    //Logger.getLogger(SimulationReseauFerroviaire.class.getName()).log(Level.SEVERE, null, ex);
	}

	Aiguillage a2 = new Aiguillage();
	a2.addAval(r3);


	Rail r6 = new Rail(50);
	Rail r7 = new Rail(50);
	r7.addSemaphoreAval(new FeuTricolor());
	a2.addAmont(r6);
	a2.addAmont(r7);
	try {
	    a2.setLien(0, 0);
	} catch (TrainSurAiguillage ex) {
	    //Logger.getLogger(SimulationReseauFerroviaire.class.getName()).log(Level.SEVERE, null, ex);
	}

	Jonction j2 = new Jonction();
	j2.setAval(r7);

	Rail r8 = new Rail(50);
	r8.addSemaphoreAmont(new PanneauRalentissement((float)0.5));
	j2.setAmont(r8);

	Aiguillage a3 = new Aiguillage();
	a3.addAval(r8);
	a3.addAval(r6);
	a3.addAval(r5);

	Rail r9 = new Rail(50);
	Butee b = new Butee();
	b.setRail(r9);
	r9.setAmont(b);

	a3.addAmont(r9);

	Rail r10 = new Rail(50);
	r10.addSemaphoreAmont(new FeuTricolor());
	a3.addAmont(r10);
	try {
	    a3.setLien(1, 1);
	} catch (TrainSurAiguillage ex) {
	    //Logger.getLogger(SimulationReseauFerroviaire.class.getName()).log(Level.SEVERE, null, ex);
	}

	Aiguillage a4 = new Aiguillage();
	a4.addAval(r10);
	a4.addAval(r4);
	a4.addAmont(r1);
	try {
	    a4.setLien(0, 0);
	} catch (TrainSurAiguillage ex) {
	    //Logger.getLogger(SimulationReseauFerroviaire.class.getName()).log(Level.SEVERE, null, ex);
	}

	// ******* Initialisation des trains //

	Train t1 = new Train(1, 3, 10, r2.getPremierTroncon(), Sens.AMONT);
	trains.add(t1);

	// ******* Horloge //


	Horloge clock = new Horloge();
	int i = 0;
	while(i < 3) {
	    clock.tick();
	    i++;
	}
    }
}