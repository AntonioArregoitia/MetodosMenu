/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

public class GaussJordan extends Gauss {

    public double[][] evaluar(double[][] matriz, boolean pivote_parcial) {

        double[][] matriz_original = clonar(matriz);
        int n = matriz.length;
        double[] x = new double[n];


        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS-JORDAN-----------");
        System.out.println("--------------------------------------------------");

        System.out.println("\n Matriz inicial:");
        reportarMatriz(matriz);

        for (int k = 0; k < n; k++) {

            // Hacer el pivote 1
            double pivote = matriz[k][k];
            System.out.println("F" + (k+1) + " = F" + (k+1) + " / " + pivote);

            for (int j = 0; j <= n; j++) {
                matriz[k][j] = matriz[k][j] / pivote;
            }

            reportarMatriz(matriz);

            // Hacer ceros arriba y abajo
            for (int i = 0; i < n; i++) {

                if (i != k) {
                    double factor = matriz[i][k];

                    System.out.println("F" + (i+1) + " = F" + (i+1) + " - (" + factor + ") * F" + (k+1));

                    for (int j = 0; j <= n; j++) {
                        matriz[i][j] = matriz[i][j] - factor * matriz[k][j];
                    }

                    reportarMatriz(matriz);
                }
            }
        }
        System.out.println("----------------------");
        System.out.println("----- RESULTADOS -----");
        System.out.println("----------------------");

        for (int i = 0; i < n; i++) {
            x[i] = matriz[i][n];
        }
double xx = Math.floor(x[0] * 1000000) / 1000000;
double yy = Math.floor(x[1] * 1000000) / 1000000;
double zz = Math.floor(x[2] * 1000000) / 1000000;

System.out.printf("X = %.6f%n", xx);
System.out.printf("Y = %.6f%n", yy);
System.out.printf("Z = %.6f%n", zz);
        return matriz;
    }
}
