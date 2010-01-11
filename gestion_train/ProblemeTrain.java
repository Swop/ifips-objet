package gestion_train;

/**
 * Exception generee due a un depassement de butee d'un train ou un deraillement de celui-ci.
 * @author swop
 */
public class ProblemeTrain extends Exception {
    /**
     * Type du probleme (deraillement ou depassement de butee)
     */
    public static enum TypeProbleme { DERAILLER, DEPASSEMENT_BUTEE };
    private TypeProbleme type;

    /**
     * Creates a new instance of <code>ProblemeTrain</code> without detail message.
     */
    public ProblemeTrain(TypeProbleme type) {
	this.type = type;
    }


    /**
     * Constructs an instance of <code>ProblemeTrain</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ProblemeTrain(String msg, TypeProbleme type) {
        super(msg);
	this.type = type;
    }

    public TypeProbleme getType() {
	return type;
    }

}
