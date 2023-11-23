package com.mycompany.proyecto01poo;

import java.util.ArrayList;

public class Tablero {
    
    
   private Ficha[][] tablero;
   private boolean turnoBlancas;
   private ArrayList<Ficha> fichasBlancas;
   private ArrayList<Ficha> fichasNegras;
   private ArrayList<Ficha> caballos;

    public Tablero() {
        tablero = new Ficha[8][8];
        this.fichasBlancas = new ArrayList<>();
        this.fichasNegras = new ArrayList<>();
        this.caballos = new ArrayList<>();
        turnoBlancas = true;
    }
    
   void iniciarTablero(Factory fichaFactory) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = null;
            }
        }

        Factory FichaFactory = new FichaFactory();
        
        Ficha peonNegro = FichaFactory.crearFichaPeon("peonNegro");
        Ficha peonBlanco = FichaFactory.crearFichaPeon("peonBlanco");
        fichasNegras.add(peonNegro);
        fichasBlancas.add(peonBlanco);
        
        Ficha torreNegro = FichaFactory.crearFichaTorre("torreNegro");
        Ficha torreBlanco = FichaFactory.crearFichaTorre("torreBlanco");
        fichasNegras.add(torreNegro);
        fichasBlancas.add(torreBlanco);
        
        Ficha caballoNegro = FichaFactory.crearFichaCaballo("caballoNegro");
        Ficha caballoBlanco = FichaFactory.crearFichaCaballo("caballoBlanco");
        fichasNegras.add(caballoNegro);
        fichasBlancas.add(caballoBlanco);
        caballos.add(caballoNegro);
        caballos.add(caballoBlanco);
        
        Ficha alfilNegro = FichaFactory.crearFichaAlfil("alfilNegro");
        Ficha alfilBlanco = FichaFactory.crearFichaAlfil("alfilBlanco");
        fichasNegras.add(alfilNegro);
        fichasBlancas.add(alfilBlanco);
        
        Ficha reinaNegro = FichaFactory.crearFichaReina("reinaNegro");
        Ficha reinaBlanco = FichaFactory.crearFichaReina("reinaBlanco");
        fichasNegras.add(reinaNegro);
        fichasBlancas.add(reinaBlanco);
        
        Ficha reyNegro = FichaFactory.crearFichaRey("reyNegro");
        Ficha reyBlanco = FichaFactory.crearFichaRey("reyBlanco");
        fichasNegras.add(reyNegro);
        fichasBlancas.add(reyBlanco);
        
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = peonNegro;
            tablero[6][i] = peonBlanco;
        }
        fichasNegras.add(peonNegro);
        fichasBlancas.add(peonBlanco);

        
        tablero[0][0] = torreNegro;
        tablero[0][1] = caballoNegro;
        tablero[0][2] = alfilNegro;
        tablero[0][3] = reinaNegro;
        tablero[0][4] = reyNegro;
        tablero[0][5] = alfilNegro;
        tablero[0][6] = caballoNegro;
        tablero[0][7] = torreNegro;

        tablero[7][0] = torreBlanco;
        tablero[7][1] = caballoBlanco;
        tablero[7][2] = alfilBlanco;
        tablero[7][3] = reinaBlanco;
        tablero[7][4] = reyBlanco;
        tablero[7][5] = alfilBlanco;
        tablero[7][6] = caballoBlanco;
        tablero[7][7] = torreBlanco;
    }
    
    public void imprimirTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getRepresentation() + " ");
                } else {
                    // Si la casilla está vacía, imprimir un espacio en blanco
                    System.out.print("  ");
                }
            }
            System.out.println(); // Nueva línea al final de cada fila
        }
    }
    
    public static int obtenerCasilla(int fila, int columna) {
        return fila * 8 + columna;
    }
    
    public void moverFicha(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        // Obtener la ficha de la posición inicial
        Ficha ficha = tablero[filaInicial][columnaInicial];

        // Verificar si la posición final está ocupada
        if (tablero[filaFinal][columnaFinal] != null) {
            System.out.println("Error: La casilla final está ocupada");
            return;
        }

        // Imprimir coordenadas antes del movimiento
        System.out.println("Moviendo ficha desde: [" + filaInicial + "][" + columnaInicial + "]");

        // Mover la ficha a la nueva posición
        tablero[filaFinal][columnaFinal] = ficha;
        tablero[filaInicial][columnaInicial] = null;

        // Imprimir coordenadas después del movimiento
        System.out.println("Hasta: [" + filaFinal + "][" + columnaFinal + "]");
    }
    
    public boolean esTurnoCorrecto(Ficha ficha) {
        if (turnoBlancas && fichasBlancas.contains(ficha)) {
            return true;
        } else if (!turnoBlancas && fichasNegras.contains(ficha)) {
            return true;
        }
        return false;
    }
    
    public void cambiarTurno(){
        if (turnoBlancas){
            turnoBlancas = false;
        } else {
            turnoBlancas = true;
        }
    }
    
    public Ficha obtenerFichaEnCoordenada(int fila, int columna) {
        return tablero[fila][columna];
    }
    
    /*public void capturaRegular(int filaFinal, int casillaFinal){
        if (ficha != null && esTurnoCorrecto(ficha)){
    }*/
    public boolean casillasIntermediasVacias(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        if (!caballos.contains(ficha)){
        // Verificar si el movimiento es vertical, horizontal o diagonal
            if (filaInicial == filaFinal && columnaInicial != columnaFinal) {
                // Movimiento horizontal
                int direccion = (columnaFinal - columnaInicial) / Math.abs(columnaFinal - columnaInicial);

                for (int columna = columnaInicial + direccion; columna != columnaFinal; columna += direccion) {
                    if (tablero[filaInicial][columna] != null) {
                        return false; // Hay una ficha en una casilla intermedia
                    }
                }
            } else if (columnaInicial == columnaFinal && filaInicial != filaFinal) {
                // Movimiento vertical
                int direccion = (filaFinal - filaInicial) / Math.abs(filaFinal - filaInicial);

                for (int fila = filaInicial + direccion; fila != filaFinal; fila += direccion) {
                    if (tablero[fila][columnaInicial] != null) {
                        return false; // Hay una ficha en una casilla intermedia
                    }
                }
            } else if (Math.abs(filaFinal - filaInicial) == Math.abs(columnaFinal - columnaInicial)) {
                // Movimiento diagonal
                int diferenciaFilas = filaFinal - filaInicial;
                int direccionFila = (diferenciaFilas != 0) ? diferenciaFilas / Math.abs(diferenciaFilas) : 0;

                int diferenciaColumnas = columnaFinal - columnaInicial;
                int direccionColumna = (diferenciaColumnas != 0) ? diferenciaColumnas / Math.abs(diferenciaColumnas) : 0;


                for (int i = 1; i < Math.abs(filaFinal - filaInicial); i++) {
                    int fila = filaInicial + i * direccionFila;
                    int columna = columnaInicial + i * direccionColumna;

                    if (tablero[fila][columna] != null) {
                        return false; // Hay una ficha en una casilla intermedia
                    }
                }
            }

            return true; // Todas las casillas intermedias están vacías
        } else {
            return true;
        }
    }


    
    public boolean validarMovimiento(Ficha ficha, int casillaInicial, int casillaFinal) {
        if (ficha != null && esTurnoCorrecto(ficha)) {
            return ficha.validarMovimiento(casillaInicial, casillaFinal);
        }
        return false; // Si no hay ficha en la casilla inicial, el movimiento no es válido
    }
    
    public void realizarMovimiento(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        int casillaInicial = obtenerCasilla(filaInicial, columnaInicial);
        int casillaFinal = obtenerCasilla(filaFinal, columnaFinal);

        if (ficha != null && validarMovimiento(ficha, casillaInicial, casillaFinal)) {
            moverFicha(filaInicial, columnaInicial, filaFinal, columnaFinal);
            System.out.println("Ficha movida");
        } else {
            // El movimiento no es válido
            System.out.println("Movimiento no válido");
        }
    }
    
    public boolean capturaRegular(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal){
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        Ficha fichaFinal = obtenerFichaEnCoordenada(filaFinal, columnaFinal);
        int equipoEnemigo;// 0 para blanco, 1 para negro
        if(fichasBlancas.contains(ficha)){// si ficha es blanca
            equipoEnemigo = 1;// enemigo es negro
        } else {
            equipoEnemigo = 0;// si ficha es negra, enemigo es blanco
        }
        
        if (equipoEnemigo == 0){
            if (fichasBlancas.contains(fichaFinal)){
                tablero[filaFinal][columnaFinal] = null;
                System.out.println("Captura negro a blanco");
                return true;
            } else {
                return false;
            }
        } else {
            if (fichasNegras.contains(fichaFinal)){
                tablero[filaFinal][columnaFinal] = null;
                System.out.println("Captura blanco a negro");
                return true;
            } else {
                return false;
            }
        }
    }
     
}
