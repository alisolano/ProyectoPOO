package com.mycompany.proyecto01poo;

public class Tablero {
    
    
   private Ficha[][] tablero;

    public Tablero() {
        tablero = new Ficha[8][8];
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
        
        
        Ficha torreNegro = FichaFactory.crearFichaTorre("torreNegro");
        Ficha torreBlanco = FichaFactory.crearFichaTorre("torreBlanco");
        
        Ficha caballoNegro = FichaFactory.crearFichaCaballo("caballoNegro");
        Ficha caballoBlanco = FichaFactory.crearFichaCaballo("caballoBlanco");
        
        Ficha alfilNegro = FichaFactory.crearFichaAlfil("alfilNegro");
        Ficha alfilBlanco = FichaFactory.crearFichaAlfil("alfilBlanco");
        
        Ficha reinaNegro = FichaFactory.crearFichaReina("reinaNegro");
        Ficha reinaBlanco = FichaFactory.crearFichaReina("reinaBlanco");
        
        Ficha reyNegro = FichaFactory.crearFichaRey("reyNegro");
        Ficha reyBlanco = FichaFactory.crearFichaRey("reyBlanco");
        
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = peonNegro;
            tablero[6][i] = peonBlanco;
        }

        
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
    
    
    //private Matriz casillas;
    private boolean casillaOcupada;
    private boolean turnoBlanca;
    private Ficha fichas;

    public Tablero(boolean casillaOcupada, boolean turnoBlanca) {
       //this.casillas = casillas;
        this.casillaOcupada = casillaOcupada;
        this.turnoBlanca = turnoBlanca;
    }

    public boolean getCasillaOcupada() {
        return casillaOcupada;
    }

    public void setCasillaOcupada(boolean casillaOcupada) {//el parametro deberia ser la casilla?
        this.casillaOcupada = casillaOcupada;
    }

    public boolean getTurnoBlanca() {
        return turnoBlanca;
    }

    public void setTurnoBlanca(boolean turnoBlanca) {
        this.turnoBlanca = turnoBlanca;
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
    
    
}
