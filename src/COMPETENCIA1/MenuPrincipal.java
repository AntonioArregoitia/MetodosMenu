/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----------- MENU PRINCIPAL------------");
            System.out.println("----------------------------------------");

            System.out.println("1 Programas de errores");
            System.out.println("2 Metodo de Biseccion");
            System.out.println("3 Metodo de Interpolacion de Newton");
            System.out.println("4 Metodo de Gauss Jordan");
            System.out.println("5 Metodo de Gauss Seidel");
            System.out.println("6 Metodo de Interpolacion de Lagrange");           
            System.out.println("0 Salir");
            System.out.print("Elige una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        MenuErrores.mostrar(sc);
                        break;
                    case 2:
                        MetodoMAINBiseccion.main(null);
                            if (!preguntarRegreso(sc)) {
                                opcion = 0;
                                   }
                          break;
                    case 3:
                        metodoMAINNewton.main(null);
                            if (!preguntarRegreso(sc)) {
                              opcion = 0;
                                   }
                        break;
    
                    case 4:
                        Metodoprincipal.main(null);
                            if (!preguntarRegreso(sc)) {
                                opcion = 0;
                                    }
                         break;
                    case 5:
                        MAIN.main(null);
                            if (!preguntarRegreso(sc)) {
                                opcion = 0;
                        }
                        break;
    
                    case 6:
                        metodoMAINLagrange.main(null);
                            if (!preguntarRegreso(sc)) {
                                opcion = 0;
                            }
                        break;
                    case 0:
                        System.out.println("Programa finalizado");
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
    public static boolean preguntarRegreso(Scanner sc) {
    int opcion;

    do {
        System.out.println("\nque deseas hacer");
        System.out.println("1 Regresar al menu principal");
        System.out.println("0 Salir");
        System.out.print("Elige una opcion: ");

        try {
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                return true;
            } else if (opcion == 0) {
                System.out.println("Programa finalizado");
                return false;
            } else {
                System.out.println("Opcion incorrecta intenta otra vez");
            }

        } catch (NumberFormatException e) {
            System.out.println("Opcion incorrecta intenta otra vez");
        }

    } while (true);
}
}
