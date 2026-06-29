/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

import java.util.Scanner;

public class BiseccionMetodo {

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

    public String leerFuncion(Scanner sc) {
        String funcion;
        FuncionBiseccion f = new FuncionBiseccion();

        while (true) {
            try {
                System.out.print("Ingresa la funcion f(x): ");
                funcion = sc.nextLine();

                // Prueba rápida para revisar si la función se puede leer
                f.evaluar(funcion, 1);

                return funcion;

            } catch (Exception e) {
                System.out.println("Funcion no valida, ingresa otra.");
            }
        }
    }

    public void consola() {

        Scanner sc = new Scanner(System.in);

        System.out.println("METODO DE BISECCION");
        System.out.println("");

        String funcion = leerFuncion(sc);

        int iteraciones = leerEntero(sc, "Ingresa el numero de iteraciones: ");
        double a = leerDouble(sc, "Ingresa el valor de a: ");
        double b = leerDouble(sc, "Ingresa el valor de b: ");
        double tolerancia = leerDouble(sc, "Ingresa la tolerancia: ");
        int decimales = leerEntero(sc, "Cuantos decimales quieres mostrar: ");

        evaluar(funcion, iteraciones, a, b, tolerancia, decimales);
    }

    public void evaluar(String funcion, int iteraciones, double a, double b, double tolerancia, int decimales) {

        FuncionBiseccion f = new FuncionBiseccion();

        double c;
        double fa, fb, fc;
        double error = 0;
        int contador = 0;

        System.out.println("");
        System.out.println("Funcion: f(x) = " + funcion);
        System.out.println("Intervalo inicial: (" + redondear(a, decimales) + ", " + redondear(b, decimales) + ")");
        System.out.println("Tolerancia: " + tolerancia);
        System.out.println("Iteraciones: " + iteraciones);
        System.out.println("");

        fa = f.evaluar(funcion, a);
        fb = f.evaluar(funcion, b);

        if (fa * fb > 0) {
            System.out.println("No se puede aplicar biseccion.");
            System.out.println("f(a) y f(b) tienen el mismo signo.");
            System.out.println("f(a) = " + redondear(fa, decimales));
            System.out.println("f(b) = " + redondear(fb, decimales));
            return;
        }

        for (int i = 1; i <= iteraciones; i++) {

            contador = i;

            System.out.println("------------------------------");
            System.out.println("Iteracion " + i);
            System.out.println("------------------------------");

            System.out.println("Paso 1: Calculo del punto medio");

            c = (a + b) / 2;

            System.out.println("c" + i + " = (a + b) / 2");
            System.out.println("c" + i + " = (" + redondear(a, decimales) + " + " + redondear(b, decimales) + ") / 2");
            System.out.println("c" + i + " = " + redondear(c, decimales));
            System.out.println("");

            System.out.println("Paso 2: Sustituir en la funcion");

            fa = f.evaluar(funcion, a);
            fb = f.evaluar(funcion, b);
            fc = f.evaluar(funcion, c);

            System.out.println("f(a) = f(" + redondear(a, decimales) + ") = " + redondear(fa, decimales));
            System.out.println("f(b) = f(" + redondear(b, decimales) + ") = " + redondear(fb, decimales));
            System.out.println("f(c" + i + ") = f(" + redondear(c, decimales) + ") = " + redondear(fc, decimales));
            System.out.println("");

            System.out.println("Paso 3: Determinar nuevo intervalo");

            if (fa * fc < 0) {
                System.out.println("Como f(a) y f(c" + i + ") tienen signos diferentes:");
                System.out.println("Nuevo intervalo: (" + redondear(a, decimales) + ", " + redondear(c, decimales) + ")");
                b = c;
            } else if (fc * fb < 0) {
                System.out.println("Como f(c" + i + ") y f(b) tienen signos diferentes:");
                System.out.println("Nuevo intervalo: (" + redondear(c, decimales) + ", " + redondear(b, decimales) + ")");
                a = c;
            } else {
                System.out.println("La raiz aproximada es: " + redondear(c, decimales));
                break;
            }

            System.out.println("");

            System.out.println("Paso 4: Calculo del error");

            error = (b - a) / 2;

            System.out.println("E" + i + " = (b - a) / 2");
            System.out.println("E" + i + " = (" + redondear(b, decimales) + " - " + redondear(a, decimales) + ") / 2");
            System.out.println("E" + i + " = " + redondear(error, decimales));

            if (error <= tolerancia) {
                System.out.println("");
                System.out.println("Se detiene porque el error ya es menor o igual a la tolerancia.");
                break;
            }

            System.out.println("");
        }

        double raiz = (a + b) / 2;

        System.out.println("------------------------------");
        System.out.println("RESULTADO FINAL");
        System.out.println("------------------------------");
        System.out.println("Iteraciones realizadas: " + contador);
        System.out.println("Intervalo final: (" + redondear(a, decimales) + ", " + redondear(b, decimales) + ")");
        System.out.println("Error final: " + redondear(error, decimales));
        System.out.println("Comprobacion f(raiz) = " + redondear(f.evaluar(funcion, raiz), decimales));
        
        System.out.println("---RESULTADO FINAL---");
        System.out.println(redondear(raiz, decimales));

    }

    public String redondear(double numero, int decimales) {
        return String.format("%." + decimales + "f", numero);
    }
}
