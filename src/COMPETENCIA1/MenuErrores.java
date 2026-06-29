/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import java.util.Scanner;

public class MenuErrores {

    public static void mostrar(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--------PROGRAMAS DE ERRORES--------\n");
            System.out.println("1 error de ejecucion");
            System.out.println("2. Error de compilacion");
            System.out.println("3 error logico");
            System.out.println("0. regresar al menu principal");
            System.out.print("elige una opcion ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        Error_de__Ejecucion.ejecutar();
                        break;
                    case 2:
                        Error_de__Compilacion.ejecutar();
                        break;
                    case 3:
                        Error__Logico.ejecutar();
                        break;
                    case 0:
                        System.out.println("Regresando al menu principal");
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intenta otra vez");
                }

            } catch (NumberFormatException e) {
                System.out.println("Opcion incorrecta, intenta otra vez");
                opcion = -1;
            }

        } while (opcion != 0);
    }
}