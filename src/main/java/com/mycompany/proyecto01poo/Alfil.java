/*
 * Representa una ficha de alfil.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el alfil en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Alfil extends Ficha {
    
    private String nombre;
    public Alfil(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) % 9 == 0 || 
               Math.abs(casillaFinal - casillaInicial) % 7 == 0;
    }   
    
    public String getRepresentation() {
        return nombre.equals("alfilNegro") ? "\u265D" : "\u2657";
    }
    
    public String getNombre() {
        return "Alfil";
    }
}
