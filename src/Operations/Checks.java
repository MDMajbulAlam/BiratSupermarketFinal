/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

/**
 *
 * @author DELL
 */
public class Checks {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().equals("");
        }
        return false;
    }

    public static boolean isNumeric(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }


        } catch (NumberFormatException ex) {
        }
        return false;

    }
        public static boolean isFloat(String value) {
        try {
            if (value != null) {
                Float.parseFloat(value.trim());
                return true;
            }


        } catch (NumberFormatException ex) {
        }
        return false;

    }
}
