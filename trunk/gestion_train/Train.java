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
	th
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


}
