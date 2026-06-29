/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

public class LagrangeInterpolacion extends LagrangeMetodo {

    public double evaluar(double[] xi, double[] fxi, double x) {

        double l0, l1, l2;
        double resultado;

        double a0, b0, c0;
        double a1, b1, c1;
        double a2, b2, c2;

        double aFinal, bFinal, cFinal;

        System.out.println("INTERPOLACION DE LAGRANGE\n");

        this.reportarcoordenadas(xi, fxi);

        System.out.println("x a evaluar = " + x);
        System.out.println("");

        System.out.println("Formula:");
        System.out.println("P(x) = f(x0)L0(x) + f(x1)L1(x) + f(x2)L2(x)");
        System.out.println("");

        System.out.println("Li(x) = Producto de (x - xj) / (xi - xj)");
        System.out.println("donde j es diferente de i");
        System.out.println("");

        System.out.println("ITERACION 0");
        System.out.println("i = 0");
        System.out.println("j = 1, 2");

        System.out.println("L0(x) = ((x - x1)(x - x2)) / ((x0 - x1)(x0 - x2))");
        System.out.println("L0(x) = ((x - " + xi[1] + ")(x - " + xi[2] + ")) / (("
                + xi[0] + " - " + xi[1] + ")(" + xi[0] + " - " + xi[2] + "))");

        double den0 = (xi[0] - xi[1]) * (xi[0] - xi[2]);

        a0 = 1 / den0;
        b0 = -(xi[1] + xi[2]) / den0;
        c0 = (xi[1] * xi[2]) / den0;

        System.out.println("L0(x) = " + a0 + "x^2 + " + b0 + "x + " + c0);
        System.out.println("");

        System.out.println("ITERACION 1");
        System.out.println("i = 1");
        System.out.println("j = 0, 2");

        System.out.println("L1(x) = ((x - x0)(x - x2)) / ((x1 - x0)(x1 - x2))");
        System.out.println("L1(x) = ((x - " + xi[0] + ")(x - " + xi[2] + ")) / (("
                + xi[1] + " - " + xi[0] + ")(" + xi[1] + " - " + xi[2] + "))");

        double den1 = (xi[1] - xi[0]) * (xi[1] - xi[2]);

        a1 = 1 / den1;
        b1 = -(xi[0] + xi[2]) / den1;
        c1 = (xi[0] * xi[2]) / den1;

        System.out.println("L1(x) = " + a1 + "x^2 + " + b1 + "x + " + c1);
        System.out.println("");

        System.out.println("ITERACION 2");
        System.out.println("i = 2");
        System.out.println("j = 0, 1");

        System.out.println("L2(x) = ((x - x0)(x - x1)) / ((x2 - x0)(x2 - x1))");
        System.out.println("L2(x) = ((x - " + xi[0] + ")(x - " + xi[1] + ")) / (("
                + xi[2] + " - " + xi[0] + ")(" + xi[2] + " - " + xi[1] + "))");

        double den2 = (xi[2] - xi[0]) * (xi[2] - xi[1]);

        a2 = 1 / den2;
        b2 = -(xi[0] + xi[1]) / den2;
        c2 = (xi[0] * xi[1]) / den2;

        System.out.println("L2(x) = " + a2 + "x^2 + " + b2 + "x + " + c2);
        System.out.println("");

        System.out.println("POLINOMIO DE LAGRANGE");

        System.out.println("P(x) = f(x0)L0(x) + f(x1)L1(x) + f(x2)L2(x)");

        System.out.println("P(x) = " + fxi[0] + "(" + a0 + "x^2 + " + b0 + "x + " + c0 + ") + "
                + fxi[1] + "(" + a1 + "x^2 + " + b1 + "x + " + c1 + ") + "
                + fxi[2] + "(" + a2 + "x^2 + " + b2 + "x + " + c2 + ")");

        aFinal = (fxi[0] * a0) + (fxi[1] * a1) + (fxi[2] * a2);
        bFinal = (fxi[0] * b0) + (fxi[1] * b1) + (fxi[2] * b2);
        cFinal = (fxi[0] * c0) + (fxi[1] * c1) + (fxi[2] * c2);

        System.out.println("");
        System.out.println("POLINOMIO FINAL");
        System.out.println("P(x) = " + aFinal + "x^2 + " + bFinal + "x + " + cFinal);

        resultado = (aFinal * x * x) + (bFinal * x) + cFinal;

        System.out.println("");
        System.out.println("SUSTITUCION");
        System.out.println("P(" + x + ") = " + aFinal + "(" + x + ")^2 + " + bFinal + "(" + x + ") + " + cFinal);
        System.out.println("P(" + x + ") = " + resultado);

        return resultado;
    }
}