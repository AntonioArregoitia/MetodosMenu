package COMPETENCIA1;

import java.util.Scanner;

public class Gauss {

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

    public double[][] evaluar(double[][] matriz, boolean pivote_parcial) {
        int n = matriz.length;

        for (int k = 0; k < n - 1; k++) {

            for (int i = k + 1; i < n; i++) {

                if (matriz[k][k] != 0) {
                    double factor = matriz[i][k] / matriz[k][k];
                    System.out.println("F" + (i + 1) + " = F" + (i + 1) + " - (" + factor + ") * F" + (k + 1));

                    for (int j = k; j <= n; j++) {
                        matriz[i][j] = matriz[i][j] - factor * matriz[k][j];
                    }

                    reportarMatriz(matriz);
                }
            }
        }

        return matriz;
    }

    public void consola() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------METODO DE GAUSS-JORDAN-----------");


        int n = leerEntero(sc, "Ingrese el tamano de la matriz: ");

        double[][] matriz = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            System.out.println("----- Fila " + (i + 1) + " -----");

            for (int j = 0; j < n; j++) {
                matriz[i][j] = leerDouble(sc, "Ingresa x" + (j + 1) + ": ");
            }

            matriz[i][n] = leerDouble(sc, "Resultado: ");
        }

        GaussJordan gj = new GaussJordan();
        gj.evaluar(matriz, false);
    }

    public void reportarMatriz(double[][] matriz) {
        System.out.println("Matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    public double[][] clonar(double[][] matriz) {
        double[][] copia = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                copia[i][j] = matriz[i][j];
            }
        }

        return copia;
    }
}