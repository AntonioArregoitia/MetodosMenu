/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import javax.swing.JOptionPane;

public class Error__Logico {

    public static void ejecutar() {
        float num = 95, residuo;

        System.out.println("\nCodigo:");
        System.out.println("float num = 95, residuo;");
        System.out.println("residuo = num / 10;");

        residuo = num / 10;

        System.out.println("El modulo de la division es: " + residuo);

        JOptionPane.showMessageDialog(null,
                "Error logico: el programa se ejecuta, pero la operacion esta mal.\n"
                + "Se queria sacar el modulo, pero se uso division.\n"
                + "Lo correcto seria usar: residuo = num % 10;");
    }
}