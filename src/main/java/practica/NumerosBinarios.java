/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jorge
 */
public class NumerosBinarios {
    public static void main(String[] args) {
        int opcion = 0;

        do {
            opcion = pedirOpcion();
            if (opcion == 1) {
                
            }
        } while (opcion != 2);

    }
    
    // Atributos de clase
    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();
    
    // Método para pedir la opción
    private static int pedirOpcion() {
        int opcion = 0;
        String menu = """
                      ------------------------------------------------
                      |      1. Generar matriz NxN aleatoria.        |
                      |      2. Generar matriz NxN por teclado.      |
                      |      3. Salir.                               |
                      ------------------------------------------------
                      | Introduce el número de la opción que quieras |
                      ------------------------------------------------
                      """;
        do {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Elige una opción válida.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un numero.");
            }
            teclado.nextLine(); // Limpio el buffer
        } while (opcion < 1 || opcion > 3);
        
        return opcion;
    }
    
    // Método para rellenar la matriz de forma aleatoria sin repetir
    private static void rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(2);
            }
        }
    }
    
    // Método para rellenar la matriz por teclado
    private static void rellenarTeclado(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                do{
                    
                }while();
            }
        }
    }
}
