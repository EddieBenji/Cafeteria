/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author equipo1
 */
public class ParserDeFechas {

    public static String obtenerFechaSinEstampaDeTiempo(Date date) {
        DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
        return outputFormatter.format(date); // Output : 01/20/2012
    }
}
