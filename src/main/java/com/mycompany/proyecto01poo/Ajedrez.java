/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01poo;

import java.awt.event.ActionEvent;
import GUI.VistaTablero;
import javax.swing.JButton;
import javax.swing.JLabel;


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
        this.factory = new FichaFactory();
        this.tablero = new Tablero();
        tablero.iniciarTablero(fichaFactory);
        tablero.imprimirTablero();
        VistaTablero vista = new VistaTablero("","");
        vista.setVisible(true);
    }
    
    // Método para obtener la instancia única de Ajedrez
    public static Ajedrez obtenerInstancia() {
        if (instancia == null) {
            instancia = new Ajedrez();
        }
        return instancia;
    }
    
    //La instancia del singleton se obtendra de la siguiente manera: Ajedrez juegoDeAjedrez = Ajedrez.obtenerInstancia();
    

   
    
    public boolean validarMovimiento(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = tablero.obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        int casillaInicial = tablero.obtenerCasilla(filaInicial, columnaInicial);
        int casillaFinal = tablero.obtenerCasilla(filaFinal, columnaFinal);
        return ficha != null && tablero.validarMovimiento(ficha, casillaInicial, casillaFinal)&& tablero.esTurnoCorrecto(ficha)
                        && tablero.casillasIntermediasVacias(filaInicial, columnaInicial, filaFinal, columnaFinal);
    }
    
    public boolean validarCaptura(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal){
        return tablero.capturaRegular(filaInicial, columnaInicial, filaFinal, columnaFinal);
    }


    
    public void intentarRealizarMovimiento(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        if (validarMovimiento(filaInicial, columnaInicial, filaFinal, columnaFinal)) {
            tablero.capturaRegular(filaInicial, columnaInicial, filaFinal, columnaFinal);
            tablero.realizarMovimiento(filaInicial, columnaInicial, filaFinal, columnaFinal);
            tablero.cambiarTurno();
            tablero.imprimirTablero();
            return;
        } else {
            System.out.println("Movimiento no válido");
            return;
        }
    }
    
    
}
