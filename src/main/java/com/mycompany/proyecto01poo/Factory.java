/*
 * Interfaz que define métodos para la creación de instancias de diferentes fichas de ajedrez.
 * Cada método crea y devuelve una instancia de la ficha correspondiente con el nombre especificado.
 * Utilizada para aplicar el patrón de diseño Abstract Factory y permitir la creación de fichas sin especificar su clase concreta.
 */

package com.mycompany.proyecto01poo;

public interface Factory {
    Ficha crearFichaPeon(String nombre);
    
    Ficha crearFichaTorre(String nombre);
    
    Ficha crearFichaCaballo(String nombre);
    
    Ficha crearFichaAlfil(String nombre);
    
    Ficha crearFichaReina(String nombre);
    
    Ficha crearFichaRey(String nombre);
}