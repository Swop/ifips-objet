package gestion_train;


/**
 * Classe de gestion du train
 * @author swop
 */

import Capteur.Capteur;
import ElementsDeVoie.Troncon;
import ElementsDeVoie.OutOfRail;
import Semaphore.Semaphore;
import java.util.Collection;

public class Train {
    /**
     * Id du train
     */
    private int id;
    /**
     * Taille du train (en nombre de troncons)
     */
    private int taille;
    /**
     * Vitesse maximale du train
     */
    private int vitesseMax;
    /**
     * Position de la locomotive
     */
    private Troncon position;
    /**
     * Sens de deplacement du train
     */
    private Sens sensDeplacement;
    /**
     * Vitesse courante du train
     */
    private int vitesseCourante;

    /**
     * Contructeur du train
     * @param id
     * Identifiant du train
     * @param taille
     * Taille du train
     * @param vitesseMax
     * Vitesse max du train
     * @param position
     * Position de la locomotive du train
     * @param sens
     * Sens de deplacement du train
     */
    public Train(int id, int taille, int vitesseMax, Troncon position, Sens sens) {
	this.id = id;
	this.taille = taille;
	this.vitesseMax = vitesseMax;
	this.vitesseCourante = vitesseMax;
	this.position = position;
	this.sensDeplacement = sens;
    }
    /**
     * Avancement unitaire du train
     * @param pointMouvement
     *	Point de mouvement restant
     * @throws ProblemeTrain
     * Lorsque le train deraille ou depasse une butee
     */
    public void avancer_rec(int pointMouvement) throws ProblemeTrain {
	System.out.println("PM : "+pointMouvement);
	// Activation des eventuels capteurs tout le long du train *********
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
	
	// Actiovation des actions des semaphores qui modifieront le train s'il sont sur le troncon de la locomotive
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

	// S'il reste des points de mouvement, on bouge le train d'une unite
	if(pointMouvement > 0) {
	    try {
		this.position = this.position.getNextTroncon(sensDeplacement);
	    } catch (OutOfRail ex) {
		if(ex.getType() == OutOfRail.TypeProbleme.BUTEE)
		    throw new ProblemeTrain("Le train "+this.id+" a depasse une butee.", ProblemeTrain.TypeProbleme.DEPASSEMENT_BUTEE);
		else
		    throw new ProblemeTrain("Le train "+this.id+" a deraille sur un aguillage.", ProblemeTrain.TypeProbleme.DERAILLER);
	    }
	    // Appel recursif
	    avancer_rec(pointMouvement - 1);
	}
    }

    /**
     * Avancement global du train
     * @throws ProblemeTrain
     * Lorsque le train deraille ou depasse une butee
     */
    public void avancer() throws ProblemeTrain {
	this.avancer_rec(vitesseCourante);
    }
    /**
     * Retourner l'id du train
     * @return
     *	L'id du train
     */
    public int getId() {
	return id;
    }
    /**
     * Retourne la position du train
     * @return
     * La position du train
     */
    public Troncon getPosition() {
	return position;
    }
    /**
     * Retourne la position de la locomotive du train
     * @return
     * La position de la loco
     */
    public Sens getSensDeplacement() {
	return sensDeplacement;
    }
    /**
     * Retourne la taille du train
     * @return
     * La taille du train
     */
    public int getTaille() {
	return taille;
    }
    /**
     * Recupere la valeur de la vitesse courante du train
     * @return
     * La vitesse courante du train
     */
    public float getVitesseCourante() {
	return vitesseCourante;
    }
    /**
     * Stoppe le train
     */
    public void stop() {
	this.vitesseCourante = 0;
    }
    /**
     * Fait avancer le train a sa vitesse maximale
     */
    public void goMax() {
	this.vitesseCourante = this.vitesseMax;
    }
    /**
     * Regle la vitesse du train a une certaine vitesse (ou a sa vitesse max dans le cas d'une vitesse trop elevee pour le regime du train)
     * @param vitesse
     * La nouvelle vitesse du train
     */
    public void setVitesseScalaire(int vitesse) {
	if(vitesse < this.vitesseMax)
	    this.vitesseCourante = vitesse;
	else
	    this.vitesseCourante = this.vitesseMax;
	System.out.println("Le train "+id+" change sa vitesse pour : "+this.vitesseCourante);
    }
    /**
     * Regle la vitesse du train a une certaine vitesse, en applicant un pourcentage a sa vitesse precedente.
     * @param pourc
     * Un pourcentage, entre 0 et 1
     */
    public void setVitessePourcentage(float pourc) {
	if(pourc < 0)
	    pourc = 0;
	else if(pourc > 1)
	    pourc = 1;

	this.vitesseCourante = (int) Math.floor(this.vitesseMax * pourc);
	System.out.println("Le train "+id+" change sa vitesse (pourcentage) pour la nouvelle vitesse : "+this.vitesseCourante);
    }
}
