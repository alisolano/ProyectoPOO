/*
 * Representa una ficha de peon.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el peon en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Peon extends Ficha {
    
    private String nombre;
    
    public Peon(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) {
       return Math.abs(casillaFinal - casillaInicial) % 8 == 0 &&
              Math.abs(casillaFinal - casillaInicial) < 17 ; 
    }
    
    public String getRepresentation() {
        return nombre.equals("peonNegro") ? "♟P" : "PE";
    }
    
    public String getNombre() {
        return "Peon";
    }
    
    
}



