/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

/**
 *
 * @author NorTicUs
 */
public class OutOfRail extends Exception {

    /**
     * Enumération des types de problèmes
     */
    public static enum TypeProbleme { BUTEE, AIGUILLAGE_FAIL };

    /**
     * type du problème
     */
    private TypeProbleme type;

    /**
     * Constructeur type only
     * @param type
     *	    Type du problème
     */
    public OutOfRail(TypeProbleme type){
	this.type = type;
    }

    /**
     * Constructeur type + message
     * @param msg
     *	    Message de l'exception
     * @param type
     *	    Type du problème
     */
    public OutOfRail(String msg, TypeProbleme type){
	super(msg);
	this.type = type;
    }


}
