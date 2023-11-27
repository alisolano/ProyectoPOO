/*
 * Representa una ficha de torre.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para la torre en el método validarMovimiento.
 */


package com.mycompany.proyecto01poo;

public class Torre extends Ficha {
    
    private String nombre;
    private int equipo;
    public Torre(String nombre, int equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) % 8 == 0 || Math.abs(casillaFinal - casillaInicial) <= 7;
    }   
    
    public String getRepresentation() {
        return nombre.equals("torreNegro") ? "♜" : "♖";
    }
    
    public String getNombre() {
        return "Torre";
    }

    public int getEquipo() {
        return equipo;
    }
}
