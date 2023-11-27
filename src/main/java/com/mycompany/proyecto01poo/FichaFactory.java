/*
 * Implementa la interfaz Factory para la creación de fichas de ajedrez.
 * Proporciona métodos para crear diferentes tipos de fichas.
 */

package com.mycompany.proyecto01poo;


public class FichaFactory implements Factory {
    @Override
    public Ficha crearFichaPeon(String nombre, int equipo) {
        //crea un peon
       return new Peon(nombre, equipo);
    }
    

    
    @Override
    public Ficha crearFichaTorre(String nombre, int equipo) {
        //crea una torre
       return new Torre(nombre, equipo);
    }

    
    @Override
    public Ficha crearFichaCaballo(String nombre, int equipo) {
        //crea un caballo
       return new Caballo(nombre, equipo);
    }
    

    
    @Override
    public Ficha crearFichaAlfil(String nombre, int equipo) {
        //crea un alfil
       return new Alfil(nombre, equipo);
    }
    

    
    @Override
    public Ficha crearFichaReina(String nombre, int equipo) {
        //crea una reina
       return new Reina(nombre, equipo);
    }
    
    
    @Override
    public Ficha crearFichaRey(String nombre, int equipo) {
        //crea un rey
       return new Rey(nombre, equipo);
    }
    
}
