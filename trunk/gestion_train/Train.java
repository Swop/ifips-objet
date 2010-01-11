/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_train;


/**
 *
 * @author swop
 */

import Capteur.Capteur;
import ElementsDeVoie.Troncon;
import ElementsDeVoie.OutOfRail;
import Semaphore.Semaphore;
import java.util.Collection;

public class Train {
    private int id;
    private int taille;
    private int vitesseMax;
    private Troncon position;
    private Sens sensDeplacement;
    private int vitesseCourante;


    public Train(int id, int taille, int vitesseMax, Troncon position, Sens sens) {
	this.id = id;
	this.taille = taille;
	this.vitesseMax = vitesseMax;
	this.vitesseCourante = vitesseMax;
	this.position = position;
	this.sensDeplacement = sens;
    }

    public void avancer_rec(int pointMouvement) throws ProblemeTrain {
	System.out.println("PM : "+pointMouvement);
	//Capteurs
	Troncon t = this.position;
	int tailleRec = this.taille;
	while(tailleRec > 0) {
	    for(Capteur c : t.getCapteurs()) {
		c.activer(this);
	    }
	    
	    Sens sensInverse;
	    if(this.sensDeplacement == Sens.AMONT)
		sensInverse = Sens.AVAL;
	    else
		sensInverse = Sens.AMONT;
	    try {
		t = t.getNextTroncon(sensInverse);
	    } catch (OutOfRail ex) {}
	    
	    tailleRec--;
	}
	
	// Semaphore ?
	t = this.position;
	Collection<Semaphore> sems = t.getSemaphore(sensDeplacement);
	for(Semaphore sem : sems) {
	    System.out.println("Le train "+this.id+" appercois un semaphore : "+sem.toString());
	    sem.actionTrain(this);
	    if(this.vitesseCourante == 0) {
		pointMouvement = 0;
		break;
	    }
	}

	if(pointMouvement > 0) {
	    try {
		this.position = this.position.getNextTroncon(sensDeplacement);
	    } catch (OutOfRail ex) {
		if(ex.getType() == OutOfRail.TypeProbleme.BUTEE)
		    throw new ProblemeTrain("Le train "+this.id+" a depasse une butee.", ProblemeTrain.TypeProbleme.DEPASSEMENT_BUTEE);
		else
		    throw new ProblemeTrain("Le train "+this.id+" a deraille sur un aguillage.", ProblemeTrain.TypeProbleme.DERAILLER);
	    }
	    avancer_rec(pointMouvement - 1);
	}
    }

    public void avancer() throws ProblemeTrain {
	this.avancer_rec(vitesseCourante);
    }

    public int getId() {
	return id;
    }

    public Troncon getPosition() {
	return position;
    }

    public Sens getSensDeplacement() {
	return sensDeplacement;
    }

    public int getTaille() {
	return taille;
    }

    public float getVitesseCourante() {
	return vitesseCourante;
    }

    public void stop() {
	this.vitesseCourante = 0;
    }

    public void goMax() {
	this.vitesseCourante = this.vitesseMax;
    }

    public void setVitesseScalaire(int vitesse) {
	if(vitesse < this.vitesseMax)
	    this.vitesseCourante = vitesse;
	else
	    this.vitesseCourante = this.vitesseMax;
	System.out.println("Le train "+id+" change sa vitesse pour : "+this.vitesseCourante);
    }

    public void setVitessePourcentage(float pourc) {
	if(pourc < 0)
	    pourc = 0;
	else if(pourc > 1)
	    pourc = 1;

	this.vitesseCourante = (int) Math.floor(this.vitesseMax * pourc);
	System.out.println("Le train "+id+" change sa vitesse (pourcentage) pour la nouvelle vitesse : "+this.vitesseCourante);
    }


}
