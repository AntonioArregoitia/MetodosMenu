/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COMPETENCIA1;

public class FuncionBiseccion {

    String funcion;
    int posicion;
    double x;

    public double evaluar(String funcion, double x) {
        this.funcion = funcion.replace(" ", "");
        this.funcion = prepararFuncion(this.funcion);
        this.posicion = 0;
        this.x = x;

        double resultado = expresion();

        if (posicion < this.funcion.length()) {
            throw new RuntimeException("Funcion no valida");
        }

        return resultado;
    }

    public String prepararFuncion(String funcion) {

        funcion = funcion.toLowerCase();

        // Cambiar e^(algo) a exp(algo)
        funcion = funcion.replace("e^(", "exp(");

        // Cambiar e^3x a exp(3*x)
        if (funcion.contains("e^") && !funcion.contains("exp")) {
            funcion = funcion.replace("e^", "exp(");

            if (funcion.contains("x")) {
                funcion = funcion.replace("x", "*x");
            }

            funcion = funcion + ")";
        }

        // Cambiar 3x por 3*x
        funcion = agregarMultiplicacion(funcion);

        return funcion;
    }

    public String agregarMultiplicacion(String funcion) {
        String nueva = "";

        for (int i = 0; i < funcion.length(); i++) {
            char actual = funcion.charAt(i);
            nueva = nueva + actual;

            if (i < funcion.length() - 1) {
                char siguiente = funcion.charAt(i + 1);

                if (Character.isDigit(actual) && siguiente == 'x') {
                    nueva = nueva + "*";
                }

                if (actual == ')' && siguiente == 'x') {
                    nueva = nueva + "*";
                }

                if (actual == 'x' && siguiente == '(') {
                    nueva = nueva + "*";
                }

                if (Character.isDigit(actual) && siguiente == '(') {
                    nueva = nueva + "*";
                }
            }
        }

        return nueva;
    }

    public double expresion() {
        double resultado = termino();

        while (posicion < funcion.length()) {
            char signo = funcion.charAt(posicion);

            if (signo == '+') {
                posicion++;
                resultado = resultado + termino();
            } else if (signo == '-') {
                posicion++;
                resultado = resultado - termino();
            } else {
                break;
            }
        }

        return resultado;
    }

    public double termino() {
        double resultado = potencia();

        while (posicion < funcion.length()) {
            char signo = funcion.charAt(posicion);

            if (signo == '*') {
                posicion++;
                resultado = resultado * potencia();
            } else if (signo == '/') {
                posicion++;
                resultado = resultado / potencia();
            } else {
                break;
            }
        }

        return resultado;
    }

    public double potencia() {
        double resultado = factor();

        while (posicion < funcion.length() && funcion.charAt(posicion) == '^') {
            posicion++;
            resultado = Math.pow(resultado, factor());
        }

        return resultado;
    }

    public double factor() {

        if (posicion >= funcion.length()) {
            throw new RuntimeException("Funcion no valida");
        }

        char caracter = funcion.charAt(posicion);

        if (caracter == '+') {
            posicion++;
            return factor();
        }

        if (caracter == '-') {
            posicion++;
            return -factor();
        }

        if (caracter == '(') {
            posicion++;
            double resultado = expresion();

            if (posicion < funcion.length() && funcion.charAt(posicion) == ')') {
                posicion++;
                return resultado;
            } else {
                throw new RuntimeException("Falta parentesis");
            }
        }

        if (Character.isDigit(caracter) || caracter == '.') {
            return numero();
        }

        if (caracter == 'x') {
            posicion++;
            return x;
        }

        if (Character.isLetter(caracter)) {
            String nombre = palabra();

            if (nombre.equals("pi")) {
                return Math.PI;
            }

            if (nombre.equals("e")) {
                return Math.E;
            }

            if (posicion < funcion.length() && funcion.charAt(posicion) == '(') {
                posicion++;
                double valor = expresion();

                if (posicion < funcion.length() && funcion.charAt(posicion) == ')') {
                    posicion++;
                } else {
                    throw new RuntimeException("Falta parentesis");
                }

                if (nombre.equals("sin")) {
                    return Math.sin(valor);
                }

                if (nombre.equals("cos")) {
                    return Math.cos(valor);
                }

                if (nombre.equals("tan")) {
                    return Math.tan(valor);
                }

                if (nombre.equals("log")) {
                    return Math.log(valor);
                }

                if (nombre.equals("sqrt")) {
                    return Math.sqrt(valor);
                }

                if (nombre.equals("exp")) {
                    return Math.exp(valor);
                }

                throw new RuntimeException("Funcion no valida");
            }
        }

        throw new RuntimeException("Funcion no valida");
    }

    public double numero() {
        String num = "";

        while (posicion < funcion.length()) {
            char caracter = funcion.charAt(posicion);

            if (Character.isDigit(caracter) || caracter == '.') {
                num = num + caracter;
                posicion++;
            } else {
                break;
            }
        }

        return Double.parseDouble(num);
    }

    public String palabra() {
        String texto = "";

        while (posicion < funcion.length()) {
            char caracter = funcion.charAt(posicion);

            if (Character.isLetter(caracter)) {
                texto = texto + caracter;
                posicion++;
            } else {
                break;
            }
        }

        return texto;
    }
}