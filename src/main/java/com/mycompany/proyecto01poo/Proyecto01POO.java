package com.mycompany.proyecto01poo;


public class Proyecto01POO {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Matriz tableroAjedrez = new Matriz();
        //tableroAjedrez.imprimirMatriz();
        
        Tablero tablero = new Tablero();
        Factory fichaFactory = null;
        tablero.iniciarTablero(fichaFactory);
        tablero.realizarMovimiento(0, 0, 2, 0);
        //int casilla = tablero.obtenerCasilla(7,7);
        //System.out.println("Casilla en [7,7] " + casilla);
        //tablero.moverFicha(1, 0, 2, 0);
        /*
        Ficha fichaEnCoordenada = tablero.obtenerFichaEnCoordenada(0, 3);

        if (tablero.obtenerFichaEnCoordenada(0, 3) != null) {
            System.out.println("Ficha en la coordenada 0,3: " + tablero.obtenerFichaEnCoordenada(0, 3).getNombre());
        } else {
            System.out.println("No hay ficha en la coordenada 0,3");
        }
        
        int casillaInicial = tablero.obtenerCasilla(0, 3); 
        int casillaFinal = tablero.obtenerCasilla(4,3);   

        if (tablero.validarMovimiento(fichaEnCoordenada, casillaInicial, casillaFinal)) {
            tablero.moverFicha(0,3,4,3);
            System.out.println("Ficha movida");
        } else {
            // El movimiento no es válido
            System.out.println("Movimiento no válido");
        }*/
        
        
       /* tablero.moverFicha(0,0,5,0);
        Ficha fichaEnCoordenada1 = tablero.obtenerFichaEnCoordenada(5,0);

        if (fichaEnCoordenada1 != null) {
            System.out.println("Ficha en la coordenada 5,0: " + fichaEnCoordenada1.getNombre());
        } else {
            System.out.println("No hay ficha en la coordenada 0,0");
        }
        
        Ficha fichaEnCoordenada2 = tablero.obtenerFichaEnCoordenada(0,0);

        if (fichaEnCoordenada2 != null) {
            System.out.println("Ficha en la coordenada 0,0: " + fichaEnCoordenada2.getNombre());
        } else {
            System.out.println("No hay ficha en la coordenada 0,0");
        }*/
        
    }
    
}
