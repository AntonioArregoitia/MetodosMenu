package COMPETENCIA1;

import java.util.Scanner;

public class LagrangeNuevo {

    public String redondear(double valor) {
        return valor + "\t\t";
    }

    public String redondear(String valor) {
        return valor + "\t\t";
    }

    public String redondear(String valor, int espacio, boolean izq) {
        return valor + "\t";
    }

    public String redondear(double valor, int espacio, boolean izq) {
        return valor + "\t";
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

    public void reportarcoordenadas(double[] xi, double[] fxi) {
        System.out.println("Datos:");

        for (int i = 0; i < xi.length; i++) {
            System.out.println("x[" + i + "] = " + xi[i] + " | f(x[" + i + "]) = " + fxi[i]);
        }

        System.out.println("");
    }

    public void consola() {

        Scanner sc = new Scanner(System.in);

        double[] xi = new double[3];
        double[] fxi = new double[3];

        
                System.out.println("--- Interpolacion de newton ---\n");

        System.out.println("Ingresa los valores de x");

        for (int i = 0; i < 3; i++) {
            xi[i] = leerDouble(sc, "x[" + i + "]: ");
        }

        System.out.println("");
        System.out.println("Ingresa los valores de f(x)");

        for (int i = 0; i < 3; i++) {
            fxi[i] = leerDouble(sc, "f(x[" + i + "]): ");
        }

        System.out.println("");

        double x = leerDouble(sc, "Ingresa el valor de x a evaluar: ");

        System.out.println("");

        NewtonNuevo metodo = new NewtonNuevo();
        metodo.evaluar(xi, fxi, x);
    }
}
