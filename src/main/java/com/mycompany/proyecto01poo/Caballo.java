/*
 * Representa una ficha de caballo.
 * Hereda de la clase Ficha e implementa sus métodos abstractos.
 * Implementa la lógica de movimiento específica para el caballo en el método validarMovimiento.
 */

package com.mycompany.proyecto01poo;

public class Caballo extends Ficha {
    
    private String nombre;
    private int equipo;
    public Caballo(String nombre, int equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) {
       return Math.abs(casillaFinal - casillaInicial) == 6 ||
              Math.abs(casillaFinal - casillaInicial) == 10||
              Math.abs(casillaFinal - casillaInicial) == 15||
              Math.abs(casillaFinal - casillaInicial) == 17;
    
    }
    
    public String getRepresentation() {
        return nombre.equals("caballoNegro") ? "\u2658" : "\u2658";
    }

    public String getNombre() {
        return "Caballo";
    }
    
    public int getEquipo() {
        return equipo;
    }
}
