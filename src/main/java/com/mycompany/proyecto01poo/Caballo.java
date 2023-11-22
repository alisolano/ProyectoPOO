package com.mycompany.proyecto01poo;

public class Caballo extends Ficha {
    
    private String nombre;
    public Caballo(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public boolean validarMovimiento(int casillaInicial, int casillaFinal) {
       return Math.abs(casillaFinal - casillaInicial) == 6 ||
              Math.abs(casillaFinal - casillaInicial) == 10||
              Math.abs(casillaFinal - casillaInicial) == 15||
              Math.abs(casillaFinal - casillaInicial) == 17;
    
    }
    
    public String getRepresentation() {
        return nombre.equals("caballoNegro") ? "♞" : "♘";
    }

    public String getNombre() {
        return "Caballo";
    }
}
