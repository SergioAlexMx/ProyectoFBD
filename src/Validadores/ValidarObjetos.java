package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ValidarObjetos es una clase que contendra diferentes metodos staticos que nos permitiran validar los datos de entrada
 * los accesos deben de ser <<public>>
 */

public class ValidarObjetos {
    /*
     * isEmail - Verifica si el email es valido o no
     * @return boolean
     */
    public static boolean isEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
}
