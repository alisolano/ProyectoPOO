/*
 * Representa una ficha de alfil.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el alfil en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Alfil extends Ficha {
    
    private String nombre;
    private int equipo;
    public Alfil(String nombre, int equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) {
        int filaInicial = casillaInicial / 8;
        int columnaInicial = casillaInicial % 8;
        int filaFinal = casillaFinal / 8;
        int columnaFinal = casillaFinal % 8;

        // Verificar si el movimiento es diagonal
        return Math.abs(filaFinal - filaInicial) == Math.abs(columnaFinal - columnaInicial);
    }
  
    
    public String getRepresentation() {
        return nombre.equals("alfilNegro") ? "\u265D" : "\u2657";
    }
    
    public String getNombre() {
        return "Alfil";
    }
    
    public int getEquipo() {
        return equipo;
    }
    
}
