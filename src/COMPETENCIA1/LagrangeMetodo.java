/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

/**
 *
 * @author AntoniZrLa
 */
import java.util.Scanner;

public class LagrangeMetodo {

    public String separar(double valor) {
        return valor + "\t\t";
    }

    public String separar(String valor) {
        return valor + "\t\t";
    }

    public void reportarcoordenadas(double[] xi, double[] fxi) {

        System.out.println("Datos:");

        for (int i = 0; i < xi.length; i++) {
            System.out.println("x(" + i + ") = " + xi[i]);
            System.out.println("f(x(" + i + ")) = " + fxi[i]);
        }

        System.out.println("");
    }

    public double leerDouble(Scanner sc, String mensaje) {

        double numero;

        while (true) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(sc.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Dato no valido ingresa otro");
            }
        }
    }

    public void consola() {

        Scanner sc = new Scanner(System.in);
        System.out.println("---Interpolacion de Lagrange----\n");

        double[] xi = new double[3];
        double[] fxi = new double[3];

        System.out.println("Ingresa los valores de x");

        for (int i = 0; i < 3; i++) {
            xi[i] = leerDouble(sc, "x(" + i + "): ");
        }

        System.out.println("");
        System.out.println("Ingresa los valores de f(x)");

        for (int i = 0; i < 3; i++) {
            fxi[i] = leerDouble(sc, "f(x(" + i + ")): ");
        }

        System.out.println("");
        double x = leerDouble(sc, "Ingresa el valor de x para evaluar: ");

        System.out.println("");

        LagrangeInterpolacion metodo = new LagrangeInterpolacion();
        metodo.evaluar(xi, fxi, x);
    }
}
