/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jorge
 */
public class Trenes {

    public static void main(String[] args) {
        // Matriz de prueba
        int[][] matrizTrenes = {
            {1, 30, 40, 50, 0, 0, 0},
            {2, 24, 42, 10, 75, 0, 0},
            {3, 1, 1, 1, 1, 1, 0},
            {4, 5, 5, 5, 0, 0, 0},
            {5, 2, 2, 2, 2, 2, 2},
            {6, 0, 0, 0, 0, 0, 0}
        };

        // Creo la estructura map vacia
        Map trenes = new TreeMap();

        // Relleno el map con el array
        rellenarMap(matrizTrenes, trenes);

        // Imprimo el array y el map para ver el resultado
        System.out.println("La matriz es:");
        System.out.println("--------------------------------------------------");
        imprimirMatriz(matrizTrenes);
        System.out.println("--------------------------------------------------");
        System.out.println("El Map generado a partir de la matriz anterior es:");
        System.out.println("--------------------------------------------------");
        trenes.forEach((k, v) -> System.out.println("Id: " + k + " Tren: " + v));
        System.out.println("--------------------------------------------------");
    }

    // Método para rellenar el map de trenes a partir de la matriz
    private static void rellenarMap(int[][] matriz, Map trenes) {
        for (int i = 0; i < matriz.length; i++) {
            // Añado cada tren con sus dados correspondientes
            trenes.put(matriz[i][0], new Tren(matriz[i][0],
                    recuentoVagones(matriz, i),
                    recuentoPasajeros(matriz, i)));
        }
    }

    // Método complementario para saber los vagones del tren
    private static int recuentoVagones(int[][] matriz, int i) {
        int numVagones = 0;
        // Me salto la primera columna porque son las ids y reviso la fila que toque
        for (int j = 1; j < matriz[i].length; j++) {
            // Si hay un 0 es que ya no hay mas vagones
            if (matriz[i][j] == 0) {
                break;
            } else {
                numVagones++;
            }
        }
        return numVagones;
    }

    // Método complementario que calcula los pasajeros totales del tren
    private static int recuentoPasajeros(int[][] matriz, int i) {
        int pasajeros = 0;
        // Me salto la primera columna porque son las ids y reviso la fila que toque
        for (int j = 1; j < matriz[i].length; j++) {
            // Si hay un 0 es que ya no hay mas vagones
            if (matriz[i][j] == 0) {
                break;
            } else {
                pasajeros += matriz[i][j];
            }
        }
        return pasajeros;
    }

    // Método para imprimir el array
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
