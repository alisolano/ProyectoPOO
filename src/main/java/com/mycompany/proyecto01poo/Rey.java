/*
 * Representa una ficha de rey.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el rey en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Rey extends Ficha {
    
    private String nombre;
    
    public Rey(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) <= 9;         
    }   
    
    public String getRepresentation() {
        return nombre.equals("reyNegro") ? "♚" : "♔";
    }
    
    public String getNombre() {
        return "Rey";
    }
}

