/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01poo;

/**
 *
 * @author JP113
 */
public class FichaFactory implements Factory {
    @Override
    public Ficha crearFichaPeon(String nombre) {
        //crea un peon
       return new Peon(nombre);
    }
    

    
    @Override
    public Ficha crearFichaTorre(String nombre) {
        //crea una torre
       return new Torre(nombre);
    }

    
    @Override
    public Ficha crearFichaCaballo(String nombre) {
        //crea un caballo
       return new Caballo(nombre);
    }
    

    
    @Override
    public Ficha crearFichaAlfil(String nombre) {
        //crea un alfil
       return new Alfil(nombre);
    }
    

    
    @Override
    public Ficha crearFichaReina(String nombre) {
        //crea una reina
       return new Reina(nombre);
    }
    
    
    @Override
    public Ficha crearFichaRey(String nombre) {
        //crea un rey
       return new Rey(nombre);
    }
    
}
