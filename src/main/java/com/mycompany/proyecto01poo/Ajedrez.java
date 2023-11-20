/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01poo;

import java.awt.event.ActionEvent;
import GUI.VistaTablero;
import javax.swing.JButton;


/**
 *
 * @author JP113
 */
public class Ajedrez {
    private static Ajedrez instancia = null;
    private Factory factory;
    private char turnoJugador = 'A';
    private String posicionAntigua = null;
    private String posicionNueva = null;
    private String posicionActual;
    public static String fichaElegida;
    
    //instancias de tablero y factory para la generacion de tablero
    Tablero tablero = new Tablero();
    Factory fichaFactory = new FichaFactory();

    public Ajedrez() {
        // Puedes inicializar el factory aquí o pasarlo como parámetro al constructor
        this.factory = new FichaFactory();
        this.tablero = new Tablero(false, true);
        tablero.iniciarTablero(fichaFactory);
               
        tablero.imprimirTablero(); // Imprime el tablero después de la inicialización

        VistaTablero vista = new VistaTablero();
        vista.setVisible(true);
        //añadirActionEvents();
        //movimientos = new Movimientos();A
    }
    
    // Método para obtener la instancia única de Ajedrez
    public static Ajedrez obtenerInstancia() {
        if (instancia == null) {
            instancia = new Ajedrez();
        }
        return instancia;
    }
    
    //La instancia del singleton se obtendra de la siguiente manera: Ajedrez juegoDeAjedrez = Ajedrez.obtenerInstancia();
    
    
    //@Override
    public void actionPerformed(ActionEvent ae) {
        if (turnoJugador == 'A') {
            posicionActual = getBotonPosicionString(ae.getSource());

            if (comprobarSiLaFichaEsBlanca(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = posicionActual;
                   // cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    //turnoMaquina();
                    //comprobarJaqueMateHaciaBlancas();
            }
        }
    }
    
    private boolean comprobarSiLaFichaEsBlanca(String posicion) {
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        return true;
    }
    
   private String getBotonPosicionString(Object boton) {

        return null;
    }
     /*
    private void cambiarFichas(String posAntigua, String posNueva) {
        cambiarEnString(posAntigua, posNueva);
        cambiarEnPantalla(posAntigua, posNueva);

    }
    
    private void cambiarEnString(String posAntigua, String posNueva) {

    }

    private void cambiarEnPantalla(String posAntigua, String posNueva) {
        boton(posNueva).setIcon(boton(posAntigua).getIcon());
        boton(posAntigua).setIcon(null);
    }
    */
}
