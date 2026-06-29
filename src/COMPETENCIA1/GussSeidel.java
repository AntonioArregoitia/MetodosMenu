/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import java.util.Scanner;

public class GussSeidel extends GAUSSS {

    public int leerEntero(Scanner sc, String mensaje) {
        int numero;

        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());

                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Dato no valido, ingresa otro.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Dato no valido, ingresa otro.");
            }
        }
    }

    public double leerDouble(Scanner sc, String mensaje) {
        double numero;

        while (true) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(sc.nextLine());
                return numero;

            } catch (NumberFormatException e) {
                System.out.println("Dato no valido, ingresa otro.");
            }
        }
    }

    public void consola() {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n------- GAUSS SEIDEL -------");

        int n = leerEntero(sc, "tamano del sistema: ");

        double[][] matriz = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            System.out.println("---- fila " + (i + 1) + " ----");

            for (int j = 0; j < n; j++) {
                matriz[i][j] = leerDouble(sc, "ingresa x" + (j + 1) + ": ");
            }

            matriz[i][n] = leerDouble(sc, "resultado: ");
        }

        double[] X = new double[n];

        System.out.println("---- valores iniciales ----");

        for (int i = 0; i < n; i++) {
            X[i] = leerDouble(sc, "valor inicial de X" + (i + 1) + ": ");
        }

        double tol = leerDouble(sc, "tolerancia: ");

        int iter = leerEntero(sc, "numero de iteraciones: ");

        evaluar(matriz, X, tol, iter);
    }

    public void evaluar(double[][] matriz, double[] X, double tol, int iter) {

        int n = matriz.length;
        double[] Xprev = new double[n];

        System.out.println("\n----------------------------");
        System.out.println("\n------- GAUSS SEIDEL -------");
        System.out.println("\n----------------------------");

        reportarMatriz(matriz);

        for (int k = 0; k < iter; k++) {

            System.out.println("-----------------------------");
            System.out.println("--------- Iteracion ----------" + (k + 1));
            System.out.println("------------------------------");

            for (int i = 0; i < n; i++) {
                Xprev[i] = X[i];
            }

            for (int i = 0; i < n; i++) {

                double suma = 0;

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += matriz[i][j] * X[j];
                    }
                }

                double nuevo = (matriz[i][n] - suma) / matriz[i][i];

                System.out.println(
                        "X" + (i + 1) + " = (" + matriz[i][n] + " - " + suma + ") / " + matriz[i][i] + " = " + nuevo
                );

                X[i] = nuevo;
            }

            System.out.print("Xa = [");
            for (int i = 0; i < n; i++) {
                System.out.print(X[i] + (i < n - 1 ? ", " : ""));
            }
            System.out.println("]");

            System.out.print("Xp = [");
            for (int i = 0; i < n; i++) {
                System.out.print(Xprev[i] + (i < n - 1 ? ", " : ""));
            }
            System.out.println("]");

            boolean cumple = true;

            System.out.print("Errores: [");
            for (int i = 0; i < n; i++) {
                double error = Math.abs((X[i] - Xprev[i]) / X[i]);
                System.out.print(error + (i < n - 1 ? ", " : ""));

                if (error > tol) {
                    cumple = false;
                }
            }
            System.out.println("]");

            if (cumple) {
                System.out.println("\nConvergio por tolerancia.");
                break;
            }

            System.out.println();
        }

        System.out.println("\n---------------------------");
        System.out.println("\n----- RESULTADO FINAL -----");
        System.out.println("\n---------------------------");

        if (n >= 1) {
            System.out.println("X = " + X[0]);
        }
        if (n >= 2) {
            System.out.println("Y = " + X[1]);
        }
        if (n >= 3) {
            System.out.println("Z = " + X[2]);
        }
    }
}

