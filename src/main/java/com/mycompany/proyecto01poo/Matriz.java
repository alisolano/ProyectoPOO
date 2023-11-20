
package com.mycompany.proyecto01poo;

public class Matriz {

    private char[][] tablero;

    public Matriz() {
        // Inicializa la matriz con 8 filas y 8 columnas
        tablero = new char[8][8];

        // Llena la matriz con espacios en blanco
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Método para imprimir la matriz
    public void imprimirMatriz() {
        System.out.println("  a b c d e f g h");
        System.out.println(" +----------------");

        // Imprimir filas
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + "|");

            // Imprimir columnas
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + "|"); // Añade una barra vertical después de cada carácter
            }

            System.out.println(" " + (8 - i));
            System.out.println(" +----------------");
        }
        System.out.println("  a b c d e f g h");
    }
}
