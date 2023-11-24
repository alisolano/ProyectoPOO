/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01poo;

import java.awt.event.ActionEvent;
import GUI.VistaTablero;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author JP113
 */
public class Ajedrez {
    private static Ajedrez instancia = null;

    public static Ajedrez getInstancia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Factory factory;
    private Tablero tablero;
    private char turnoJugador = 'A';
    private String posicionAntigua = null;
    private String posicionNueva = null;
    private String posicionActual;
    public static String fichaElegida;
    
    //instancias de tablero y factory para la generacion de tablero
    Factory fichaFactory = new FichaFactory();
    private ArrayList<VistaTablero> vistatablero;
    private ArrayList<Tablero> Tablero;

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
    
    public boolean validarPromocion(int filaInicial, int columnaInicial, int filaFinal){
        return tablero.promocionPeon(filaInicial, columnaInicial, filaFinal);
    }
    
    
    public ArrayList<String> obtenerListaCapturaNegras() {
        ArrayList<String> listaCapturaNegras = tablero.getCapturaNegras();
        ArrayList<String> listaCapturaNegrasStrings = new ArrayList<>();

        for (String ficha : listaCapturaNegras) {
            listaCapturaNegrasStrings.add(ficha.toString());
        }

    return listaCapturaNegrasStrings;
    }
    
    public ArrayList<String> obtenerListaCapturaBlancas() {
        ArrayList<String> listaCapturaBlancas = tablero.getCapturaBlancas();
        ArrayList<String> listaCapturaBlancasStrings = new ArrayList<>();

        for (String ficha : listaCapturaBlancas) {
            listaCapturaBlancasStrings.add(ficha.toString());
        }

    return listaCapturaBlancasStrings;
    }
    public Ajedrez CargarDatos() throws IOException, ClassNotFoundException{
        
        try {
            ObjectInputStream lecturaVistaTablero = new ObjectInputStream(new FileInputStream("vistatablero.dat") );
            ObjectInputStream lecturaTablero = new ObjectInputStream(new FileInputStream("Tablero.dat") );
            
            
            this.vistatablero = (ArrayList <VistaTablero>)lecturaVistaTablero.readObject();
            this.Tablero = (ArrayList <Tablero>)lecturaTablero.readObject();
            
            
            lecturaVistaTablero.close();
            lecturaTablero.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ajedrez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    public VistaTablero getVistaTablero(int index) {
        if (index >= 0 && index < vistatablero.size()) {
            return vistatablero.get(index);
        }
        return null; //devuelve null si el índice está fuera de rango
    }
    
    public Tablero getTablero(int index) {
        if (index >= 0 && index < Tablero.size()) {
            return Tablero.get(index);
        }
        return null; //devuelve null si el índice está fuera de rango
    }
    
 
    
    public void GuardarDatos(){
        try {
            ObjectOutputStream escrituraVistaTablero = new ObjectOutputStream(new FileOutputStream("vistatablero.dat") );
            ObjectOutputStream escrituraTablero = new ObjectOutputStream(new FileOutputStream("Tablero.dat") );
            
            
            escrituraVistaTablero.writeObject(vistatablero);
            escrituraTablero.writeObject(Tablero);
            
            
            escrituraVistaTablero.flush();
            escrituraTablero.flush();
            
            
            escrituraVistaTablero.close();
            escrituraTablero.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<VistaTablero> getVistaTablero() {
        return vistatablero;
    }

    public ArrayList<Tablero> getTablero() {
        return Tablero;
    }

   
 
    
     @Override
    public String toString(){
        String res = "";
        res+="-VistaTablero-\n";
        for(VistaTablero VistaTablero:this.vistatablero){
            res+=VistaTablero.toString()+"\n";
        }
        res+="-Utensilios-\n";
        for(Tablero Tablero:this.Tablero){
            res+=Tablero.toString()+"\n";
        }
        
        
        
        return res;
        
    }

}
