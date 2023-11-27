/*
 * Proporciona una base para las fichas de ajedrez.
 * Define métodos abstractos que deben implementarse en las clases hijas 
 * para validar movimientos y obtener representaciones.
 */



package com.mycompany.proyecto01poo;


public abstract class Ficha {
    public abstract boolean validarMovimiento(int casillaInicial, int casillaFinal);
    
    public abstract String getRepresentation();
    public abstract String getNombre();
    public abstract int getEquipo();
}


