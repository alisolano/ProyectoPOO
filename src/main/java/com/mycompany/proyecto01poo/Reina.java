/*
 * Representa una ficha de reina.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para la reina en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Reina extends Ficha { 
    
    private String nombre;

    public Reina (String nombre) {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) % 8 == 0 ||
               Math.abs(casillaFinal - casillaInicial) % 9 == 0 || 
               Math.abs(casillaFinal - casillaInicial) % 7 == 0 || 
               Math.abs(casillaFinal - casillaInicial) <= 7;
    } 
    
    public String getRepresentation() {
        return nombre.equals("reinaNegro") ? "♛" : "♕";
    }
    
    public String getNombre() {
        return "Reina";
    }
}
