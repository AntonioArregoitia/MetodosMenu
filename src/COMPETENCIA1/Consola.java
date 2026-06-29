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

public class Consola {
    private Scanner scanner;

    public Consola() {
        scanner = new Scanner(System.in);
    }

    public String getCadena(String mensaje) {
        System.out.println(mensaje + ": ");
        return scanner.nextLine();
    }

    public double getNumero(String mensaje) {
        System.out.println(mensaje + ": ");
        return scanner.nextDouble();
    }

    public int getEntero(String mensaje, int defecto) {
        System.out.println(mensaje + " (default " + defecto + "): ");
        String input = scanner.next();
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return defecto;
        }
    }

    public boolean getBoolean(String mensaje) {
        System.out.println(mensaje + " (true/false): ");
        return scanner.nextBoolean();
    }

    public void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}