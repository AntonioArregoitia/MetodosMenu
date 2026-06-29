/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

public class NewtonNuevo extends LagrangeNuevo {

    public NewtonNuevo() {
    }

    public double evaluar(double[] xi, double[] fxi, double x) {

        double fx0x1,fx1x2,fx0x1x2;
        double a,b,c;
        
        System.out.println("- Interpolacion de newton -\n");

        this.reportarcoordenadas(xi, fxi);

        System.out.println("x a evaluar = " + x);
        fx0x1 = (fxi[1] - fxi[0]) / (xi[1] - xi[0]);
        fx1x2 = (fxi[2] - fxi[1]) / (xi[2] - xi[1]);
        fx0x1x2 = (fx1x2 - fx0x1) / (xi[2] - xi[0]);
        
         a = fx0x1x2;
         b = fx0x1 - fx0x1x2 * (xi[0] + xi[1]);
         c = fxi[0] - fx0x1 * xi[0] + fx0x1x2 * xi[0] * xi[1];

        System.out.println("- datos -");
        System.out.print(this.redondear("j", 5, true));
        System.out.print(this.redondear("Xj"));
        System.out.println(this.redondear("f(Xj)"));

        for (int i = 0; i < xi.length; i++) {
            System.out.print(this.redondear(i + "", 5, true));
            System.out.print(this.redondear(xi[i]));
            System.out.println(this.redondear(fxi[i]));
        }

        System.out.println("");
        System.out.println("- diferencias divididas -");

        System.out.println("f(x0,x1) = ( f(x1) - f(x0) ) / ( x1 - x0 )");
        System.out.println("f(x0,x1) = ( " + fxi[1] + " - " + fxi[0] + " ) / ( " + xi[1] + " - " + xi[0] + " )");
        System.out.println("f(x0,x1) = " + this.redondear(fx0x1));
        System.out.println("");

        System.out.println("f(x1,x2) = ( f(x2) - f(x1) ) / ( x2 - x1 )");
        System.out.println("f(x1,x2) = ( " + fxi[2] + " - " + fxi[1] + " ) / ( " + xi[2] + " - " + xi[1] + " )");
        System.out.println("f(x1,x2) = " + this.redondear(fx1x2));
        System.out.println("");

        System.out.println("f(x0,x1,x2) = ( f(x1,x2) - f(x0,x1) ) / ( x2 - x0 )");
        System.out.println("f(x0,x1,x2) = ( " + fx1x2 + " - " + fx0x1 + " ) / ( " + xi[2] + " - " + xi[0] + " )");
        System.out.println("f(x0,x1,x2) = " + this.redondear(fx0x1x2));
        System.out.println("");

        System.out.println("- Polinomio de Newton -");

        System.out.println("Pn(x) = f(x0) + f(x0,x1)(x - x0) + f(x0,x1,x2)(x - x0)(x - x1)");
        System.out.println("");

        System.out.println("Pn(x) = " + fxi[0] + " + " + fx0x1 + "(x - " + xi[0] + ") + "
                + fx0x1x2 + "(x - " + xi[0] + ")(x - " + xi[1] + ")");

        System.out.println("");

        double resultado = fxi[0]
                + fx0x1 * (x - xi[0])
                + fx0x1x2 * (x - xi[0]) * (x - xi[1]);
        
        System.out.println("- Polinomio desarrollado -");
        System.out.println("Pn(x) = " + this.redondear(a) + "x^2 + "
        + this.redondear(b) + "x + "
        + this.redondear(c));
        System.out.println("");

        System.out.println("- Sustitucion -");

        System.out.println("Pn(" + x + ") = " + fxi[0] + " + " + fx0x1 + "(" + x + " - " + xi[0] + ") + "
                + fx0x1x2 + "(" + x + " - " + xi[0] + ")(" + x + " - " + xi[1] + ")");

        System.out.println("Pn(" + x + ") = " + this.redondear(resultado));

        System.out.println("");
        System.out.println("- Tabla de comprobacion -");

        System.out.print(this.redondear("X", 8, true));
        System.out.println(this.redondear("Pn(x)"));

        for (int i = -6; i <= 6; i++) {
            double valor = fxi[0]
                    + fx0x1 * (i - xi[0])
                    + fx0x1x2 * (i - xi[0]) * (i - xi[1]);

            System.out.print(this.redondear(i + "", 8, true));
            System.out.println(this.redondear(valor));
        }

        return resultado;
    }
}