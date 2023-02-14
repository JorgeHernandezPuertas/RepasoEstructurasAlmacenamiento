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
public class MatrizAleatorios {

    public static void main(String[] args) {
        int opcion = 0;

        do {
            opcion = pedirOpcion();
            if (opcion == 1) {
                int tamano = pedirTamano();
                int[][] matriz = new int[tamano][tamano];
                rellenarMatriz(matriz);
                imprimirMatriz(matriz);
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
                      |         1. Generar matriz NxN.               |
                      |         2. Salir.                            |
                      ------------------------------------------------
                      | Introduce el número de la opción que quieras |
                      ------------------------------------------------
                      """;
        do {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                if (opcion < 1 || opcion > 2) {
                    System.out.println("Elige una opción válida.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un numero.");
            }
            teclado.nextLine(); // Limpio el buffer
        } while (opcion < 1 || opcion > 2);
        
        return opcion;
    }

    // Método para rellenar la matriz de forma aleatoria sin repetir
    private static void rellenarMatriz(int[][] matriz) {
        Set<Integer> noRepetidos = new HashSet<>();
        int numAleatorio = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                do {
                    numAleatorio = aleatorio.nextInt(1, (int) Math.pow(matriz.length, 2) + 1);
                } while (noRepetidos.contains(numAleatorio));
                noRepetidos.add(numAleatorio);
                matriz[i][j] = numAleatorio;
            }
        }
    }

    // Método para pedir el tamaño de la matriz NxN
    private static int pedirTamano() {
        int tamano = 0;
        do {
            try {
                System.out.println("Introduce el tamaño de la matriz cuadrada:");
                tamano = teclado.nextInt();
                if (tamano < 1) {
                    System.out.println("Introduce un numero positivo.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Eso no es un numero.");
            }
            teclado.nextLine(); // Limpio el buffer
        } while (tamano < 1);
        
        return tamano;
    }

    // Método para imprimir la matriz
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
