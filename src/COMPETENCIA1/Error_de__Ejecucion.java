/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import javax.swing.JOptionPane;

public class Error_de__Ejecucion {

    public static void ejecutar() {
        try {
            int num1 = 15, num2 = 0;
            int res;

            System.out.println("\nCodigo:");
            System.out.println("int num1 = 15, num2 = 0;");
            System.out.println("res = num1 / num2;");

            res = num1 / num2;

            System.out.println("La division es: " + res);

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null,
                    "Error de ejecucion: no se puede dividir entre cero.");
            System.out.println("Error de ejecucion detectado: " + e.getMessage());
        }
    }
}