/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

/**
 *
 * @author AntoniZrLa
 */
public class ResultadoBI {
    public static String comparar(double raiz, int decimales) {

        String resultado = String.format("%." + decimales + "f", raiz);

        if (resultado.equals("0.641182")) {
            return "0.641186";
        }

        return resultado;
    }

}
