/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_train;

//import ElementsDeVoie.Troncon;

/**
 *
 * @author swop
 */

import ElementsDeVoie.Troncon;

public class Train {
    private int id;
    private int taille;
    private int vitesseMax;
    private Troncon position;
    private Sens sensDeplacement;
    private int vitesseCourante;

    public Train(int id, int taille, int vitesseMax, Troncon position) {
	this.id = id;
	this.taille = taille;
	this.vitesseMax = vitesseMax;
	this.position = position;
    }

    public void avancer() throws ProblemeTrain {
	int i = this.vitesseCourante;
	while(i > 0) {
	    // Avancer le train, test butee
	    try {
		Troncon t = this.position.getSuivant(this.sensDeplacement);
		if(this.sensDeplacement == Sens.AMONT)
		    t.getParent().getSemaphoresAmont();
		else
		    t.getParent().getSemaphoresAval();
	    } catch(OutOfRail ex) {
		if(ex.type == OutOfRail.type.Butee)
		    throw new ProblemeTrain(ProblemeTrain.TypeProbleme.DEPASSEMENT_BUTEE);
		else
		    throw new ProblemeTrain(ProblemeTrain.TypeProbleme.DERAILLER);
	    }
	    this.deraillerAguillageAuMilieuDuTrain();

	}
    }

    private void deraillerAguillageAuMilieuDuTrain() throws ProblemeTrain {
	Troncon t = this.position;
	int i = this.taille;

	Sens sensInverse;
	if(this.sensDeplacement == Sens.AMONT)
	    sensInverse = Sens.AVAL;
	else
	    sensInverse = Sens.AMONT;

	while(i > 0) {
	    try {
		t = t.getSuivant(sensInverse);
	    } catch(OutOfRail ex) {
		throw new ProblemeTrain(ProblemeTrain.TypeProbleme.DERAILLER);
	    }
	}
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
    }

    public void setVitessePourcentage(float pourc) {
	if(pourc < 0)
	    pourc = 0;
	else if(pourc > 1)
	    pourc = 1;

	this.vitesseCourante = (int) Math.floor(this.vitesseMax / pourc);
    }


}
