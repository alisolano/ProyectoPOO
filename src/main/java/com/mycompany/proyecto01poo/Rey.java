/*
 * Representa una ficha de rey.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el rey en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Rey extends Ficha {
    
    private String nombre;
    private int equipo;
    public Rey(String nombre, int equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) <= 9;         
    }   
    
    public String getRepresentation() {
        return nombre.equals("reyNegro") ? "R" : "R";
    }
    
    public String getNombre() {
        return "Rey";
    }
    
    public int getEquipo() {
        return equipo;
    }
}

