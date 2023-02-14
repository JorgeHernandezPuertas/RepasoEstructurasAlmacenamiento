/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.awt.Point;
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
        // Declaro las varibles que necesito y el objeto
        int opcion = 0;
        int tamano = 0;
        Point coordenadas = new Point();

        // Bucle del programa
        do {
            // Pido la opcion
            opcion = pedirOpcion();
            switch (opcion) {
                // Genero la matriz aleatoria
                case 1 -> {
                    tamano = pedirTamano();
                    int[][] matriz = new int[tamano][tamano];
                    rellenarAleatorio(matriz);
                    imprimirMatriz(matriz);
                    coordenadas.setLocation(encontrarEspecial(matriz));
                    imprimirCoordenada(coordenadas);
                }
                // Genero la matriz pidiendo los elementos por teclado
                case 2 -> {
                    tamano = pedirTamano();
                    int[][] matriz = new int[tamano][tamano];
                    rellenarTeclado(matriz);
                    imprimirMatriz(matriz);
                    coordenadas.setLocation(encontrarEspecial(matriz));
                    imprimirCoordenada(coordenadas);
                }
            }
        } while (opcion != 3);

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
            System.out.println("-----------------------------------------------");
            teclado.nextLine(); // Limpio el buffer
        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    // Método para rellenar la matriz de forma aleatoria sin repetir
    private static void rellenarAleatorio(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(2);
            }
        }
    }

    // Método para rellenar la matriz por teclado
    private static void rellenarTeclado(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                imprimirMatriz(matriz);
                matriz[i][j] = pedirBinario(++contador);
            }
        }
    }

    // Método para pedir un numero binario
    private static int pedirBinario(int contador) {
        int numero = -1;
        do {
            try {
                System.out.println("Introduce el elemento numero " + contador + ":");
                numero = teclado.nextInt();
                if (numero < 0 || numero > 1) {
                    System.out.println("Ese no es un numero binario.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Ese no es un entero.");
            }
            System.out.println("-----------------------------------------------");
            teclado.nextLine(); // Limpio buffer
        } while (numero < 0 || numero > 1);
        return numero;
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
            System.out.println("-----------------------------------------------");
            teclado.nextLine(); // Limpio el buffer
        } while (tamano < 1);

        return tamano;
    }

    // Método para imprimir la matriz
    private static void imprimirMatriz(int[][] matriz) {
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------------------");
    }

    // Método para encontrar el primer cero con unos en las esquinas de sus vecinas
    private static Point encontrarEspecial(int[][] matriz) {
        // Creo el objeto point para almacenar la coordenada
        // Si no lo encuentra devuelvo -1, -1
        Point coordenada = new Point(-1, -1);
        // Creo el criterio que voy a evaluar
        boolean vecinasEspeciales;

        // Recorro la matriz y busco el especial
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Compruebo que tenga vecinas completas
                if (i > 0 && i < matriz.length - 1 && j > 0 && j < matriz[i].length - 1) {
                    vecinasEspeciales
                            = matriz[i - 1][j - 1] == 1 && matriz[i - 1][j + 1] == 1
                            && matriz[i + 1][j - 1] == 1 && matriz[i + 1][j + 1] == 1;
                    // Compruebo que el elemento cumpla las condiciones para ser especial
                    if (matriz[i][j] == 0 && vecinasEspeciales) {
                        coordenada.setLocation(i, j);
                        return coordenada;
                    }
                }
            }
        }
        return coordenada;
    }
    
    // Método para imprimir la coordenada si la tiene
    private static void imprimirCoordenada(Point coordenada){
        if (coordenada.x == -1 && coordenada.y == -1){
            System.out.println("No se ha encontrado ningún elemento especial");
        } else {
            System.out.println("El elemento especial esta en la fila " 
                    + coordenada.x+1 + " y en la columna " + coordenada.y+1);
        }
    }

}
