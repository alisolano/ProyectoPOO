/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01poo;
/**
 *
 * @author JP113
 */
public interface Factory {
    Ficha crearFichaPeon(String nombre);
    
    Ficha crearFichaTorre(String nombre);
    
    Ficha crearFichaCaballo(String nombre);
    
    Ficha crearFichaAlfil(String nombre);
    
    Ficha crearFichaReina(String nombre);
    
    Ficha crearFichaRey(String nombre);
}