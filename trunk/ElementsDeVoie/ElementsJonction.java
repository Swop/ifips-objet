/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElementsDeVoie;

/**
 *
 * @author NorTicUs
 */
public abstract class ElementsJonction extends ElementDeVoie{

    public static enum TypeJonction{ JONCTION, BUTEE, AIGUILLAGE};

    public abstract TypeJonction getType();
}
