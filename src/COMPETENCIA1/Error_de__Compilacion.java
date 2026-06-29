/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import javax.swing.JOptionPane;

public class Error_de__Compilacion {

    public static void ejecutar() {
        System.out.println("\nCodigo con error:");
        System.out.println("int num1 = 60, num2 = 20;");
        System.out.println("int Rest = num1 - num2;");
        System.out.println("System.out.println(\"La resta es: \" + rest);");

        JOptionPane.showMessageDialog(null,
                "Error de compilacion: la variable 'rest' no existe.\nLa variable correcta era 'Rest'.");
    }
}