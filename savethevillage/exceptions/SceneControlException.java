/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.exceptions;

/**
 *
 * @author micha
 */
public class SceneControlException extends Exception
{
    public SceneControlException() {
    }

    public SceneControlException(String string) {
        super(string);
    }

    public SceneControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public SceneControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public SceneControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}