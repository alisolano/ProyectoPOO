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
        return nombre.equals("alfilNegro") ? "♝" : "♗";
    }
    
    public String getNombre() {
        return "Alfil";
    }
}
