/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_train;

/**
 *
 * @author swop
 */
public class ProblemeTrain extends Exception {

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
}
