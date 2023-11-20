package com.mycompany.proyecto01poo;

public class Torre extends Ficha {
    
    private String nombre;
    public Torre(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) { 
        return Math.abs(casillaFinal - casillaInicial) % 8 == 0 || Math.abs(casillaFinal - casillaInicial) <= 7;
    }   
    
    public String getRepresentation() {
        return nombre.equals("torreNegro") ? "♜" : "♖";
    }
}
