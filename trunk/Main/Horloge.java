
package Main;

import Regulation.ElementDeRegulation;
import gestion_train.ProblemeTrain;
import gestion_train.Train;

/**
 * Gestion de l'horloge
 * @author swop
 */
public class Horloge {
    /**
     * Contructeur de l'horloge
     */
    public Horloge() {}

    /**
     * Fait avancer le temps d'une unite, et lance les deplacement des trains et lance les actions des regulateurs d'elements
     */
    public void tick() {
	for(Train t : SimulationReseauFerroviaire.trains) {
	    try {
		t.avancer();
	    } catch (ProblemeTrain ex) {
		System.out.println(ex.getMessage());
	    }
	}

	for(ElementDeRegulation reg : SimulationReseauFerroviaire.regulateurs) {
	    reg.reguler();
	}
    }
}
