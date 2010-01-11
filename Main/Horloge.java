
import Regulation.ElementDeRegulation;
import gestion_train.ProblemeTrain;
import gestion_train.Train;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author swop
 */
public class Horloge {
    public Horloge() {
	
    }

    public void tick() {
	for(Train t : SimulationReseauFerroviaire.trains) {
	    try {
		t.avancer();
	    } catch (ProblemeTrain ex) {
		Logger.getLogger(Horloge.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	for(ElementDeRegulation reg : SimulationReseauFerroviaire.regulateurs) {
	    reg.reguler();
	}
    }
}
