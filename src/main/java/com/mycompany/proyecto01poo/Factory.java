/*
 * Interfaz que define métodos para la creación de instancias de diferentes fichas de ajedrez.
 * Cada método crea y devuelve una instancia de la ficha correspondiente con el nombre especificado.
 * Utilizada para aplicar el patrón de diseño Abstract Factory y permitir la creación de fichas sin especificar su clase concreta.
 */

package com.mycompany.proyecto01poo;

public interface Factory {
    Ficha crearFichaPeon(String nombre, int equipo);
    
    Ficha crearFichaTorre(String nombre, int equipo);
    
    Ficha crearFichaCaballo(String nombre, int equipo);
    
    Ficha crearFichaAlfil(String nombre, int equipo);
    
    Ficha crearFichaReina(String nombre, int equipo);
    
    Ficha crearFichaRey(String nombre, int equipo);
}