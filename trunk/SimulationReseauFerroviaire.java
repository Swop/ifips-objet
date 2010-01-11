/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import ElementsDeVoie.*;
import Regulation.ElementDeRegulation;
import Semaphore.FeuTricolor;
import java.util.ArrayList;
import gestion_train.Train;
/**
 *
 * @author swop
 */
public class SimulationReseauFerroviaire {
    public static ArrayList<Train> trains;
    public static ArrayList<ElementDeRegulation> regulateurs;

    public static void main(String args[]) {
	initReseau();
	
	Horloge clock = new Horloge();
	while(true)
	    clock.tick();
    }

    private static void initReseau() {
	// init

	Rail r1 = new Rail(5);
	Rail r2 = new Rail(5);
	r2.addSemaphoreAmont(new ChangementVitesse());

	Jonction j1 = new Jonction();
	j1.setAmont(r2);
	j1.setAval(r1);

	Aiguillage a1 = new Aiguillage();

	Rail r3 = new Rail(5);
	a1.addAval(r3);
	a1.addAval(r2);

	Rail r4 = new Rail(5);
	Rail r5 = new Rail(5);
	a1.addAmont(r4);
	a1.addAmont(r5);
	
	Aiguillage a2 = new Aiguillage();
	a2.addAval(r3);
	
	Rail r6 = new Rail(5);
	Rail r7 = new Rail(5);
	r7.addSemaphoreAval(new FeuTricolor());
	a2.addAmont(r6);
	a2.addAmont(r7);
	
	Jonction j2 = new Jonction();
	j2.setAval(r7);
	
	Rail r8 = new Rail(5);
	r8.addSemaphoreAmont(new PanneauRalentissement());
	j2.setAmont(r8);
	
	Aiguillage a3 = new Aiguillage();
	a3.addAval(r8);
	a3.addAval(r6);
	a3.addAval(r5);
	
	Rail r9 = new Rail(5);
	Butee b = new Butee();
	b.setRail(r9);

	a3.addAmont(r9);

	Rail r10 = new Rail(5);
	r10.addSemaphoreAmont(new FeuTricolore());
	a3.addAmont(r10);
	
	Aiguillage a4 = new Aiguillage();
	a4.addAval(r10);
	a4.addAval(r4);
	a4.addAmont(r1);
    }
}
