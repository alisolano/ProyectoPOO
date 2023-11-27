/*
 * Representa el tablero del juego.
 * Contiene la lógica para inicializar el tablero, realizar movimientos,
 * imprimir el tablero, cambiar el turno, gestionar capturas y promociones de peones.
 * Se utiliza la interfaz Factory para crear instancias de las fichas.
 * Se manejan listas separadas para diferentes tipos de fichas (peones, caballos) y para las capturas de cada equipo.
 * Se verifica el tipo de ficha en varios métodos para realizar acciones específicas según el tipo de ficha.
 * Se utilizan nombres de las fichas y coordenadas para identificarlas y realizar operaciones.
*/

package com.mycompany.proyecto01poo;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero implements Serializable {
    
    
   private Ficha[][] tablero;
   private boolean turnoBlancas;
   private ArrayList<Ficha> fichasBlancas;
   private ArrayList<Ficha> fichasNegras;
   private ArrayList<Ficha> caballos;
   private ArrayList<Ficha> peones;
   private ArrayList<String> capturaNegras;
   private ArrayList<String> capturaBlancas;

    public Tablero() {
        tablero = new Ficha[8][8];
        this.fichasBlancas = new ArrayList<>();
        this.fichasNegras = new ArrayList<>();
        this.caballos = new ArrayList<>();
        this.peones = new ArrayList<>();
        this.capturaNegras = new ArrayList<>();
        this.capturaBlancas = new ArrayList<>();
        turnoBlancas = true;
    }
    
   void iniciarTablero(Factory fichaFactory) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = null;
            }
        }

        Factory FichaFactory = new FichaFactory();
       
        Ficha peonNegro = FichaFactory.crearFichaPeon("peonNegro",1);
        Ficha peonBlanco = FichaFactory.crearFichaPeon("peonBlanco",0);
        fichasNegras.add(peonNegro);
        fichasBlancas.add(peonBlanco);
        
        Ficha torreNegro = FichaFactory.crearFichaTorre("torreNegro",1);
        Ficha torreBlanco = FichaFactory.crearFichaTorre("torreBlanco",0);
        fichasNegras.add(torreNegro);
        fichasBlancas.add(torreBlanco);
        
        Ficha caballoNegro = FichaFactory.crearFichaCaballo("caballoNegro",1);
        Ficha caballoBlanco = FichaFactory.crearFichaCaballo("caballoBlanco",0);
        fichasNegras.add(caballoNegro);
        fichasBlancas.add(caballoBlanco);
        caballos.add(caballoNegro);
        caballos.add(caballoBlanco);
        
        Ficha alfilNegro = FichaFactory.crearFichaAlfil("alfilNegro",1);
        Ficha alfilBlanco = FichaFactory.crearFichaAlfil("alfilBlanco",0);
        fichasNegras.add(alfilNegro);
        fichasBlancas.add(alfilBlanco);
        
        Ficha reinaNegro = FichaFactory.crearFichaReina("reinaNegro",1);
        Ficha reinaBlanco = FichaFactory.crearFichaReina("reinaBlanco",0);
        fichasNegras.add(reinaNegro);
        fichasBlancas.add(reinaBlanco);
        
        Ficha reyNegro = FichaFactory.crearFichaRey("reyNegro",1);
        Ficha reyBlanco = FichaFactory.crearFichaRey("reyBlanco",0);
        fichasNegras.add(reyNegro);
        fichasBlancas.add(reyBlanco);
        
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = peonNegro;
            tablero[6][i] = peonBlanco;
        }
        fichasNegras.add(peonNegro);
        fichasBlancas.add(peonBlanco);
        peones.add(peonNegro);
        peones.add(peonBlanco);

        
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
    
    private void moverFicha(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
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
    
    private void moverFichaCapturaPeon(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = tablero[filaInicial][columnaInicial];

        // Verificar si la posición final está ocupada
        if (tablero[filaFinal][columnaFinal] != null) {
            System.out.println("Error: La casilla final está ocupada");
            return;
        }

        //imprimir coordenadas antes del movimiento
        System.out.println("Moviendo ficha desde: [" + filaInicial + "][" + columnaInicial + "]");

        //mover la ficha a la nueva posición
        tablero[filaFinal][columnaFinal] = ficha;
        tablero[filaInicial][columnaInicial] = null;
        tablero[filaInicial][columnaInicial-1] = null;

        //imprimir coordenadas después del movimiento
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
    
    public boolean getTurno(){
        return turnoBlancas;
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
   
    public boolean casillasIntermediasVacias(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        if (!caballos.contains(ficha)){
        //verificar si el movimiento es vertical, horizontal o diagonal
            if (filaInicial == filaFinal && columnaInicial != columnaFinal) {
                //movimiento horizontal
                int direccion = (columnaFinal - columnaInicial) / Math.abs(columnaFinal - columnaInicial);

                for (int columna = columnaInicial + direccion; columna != columnaFinal; columna += direccion) {
                    if (tablero[filaInicial][columna] != null) {
                        return false; //hay una ficha en una casilla intermedia
                    }
                }
            } else if (columnaInicial == columnaFinal && filaInicial != filaFinal) {
                //movimiento vertical
                int direccion = (filaFinal - filaInicial) / Math.abs(filaFinal - filaInicial);

                for (int fila = filaInicial + direccion; fila != filaFinal; fila += direccion) {
                    if (tablero[fila][columnaInicial] != null) {
                        return false; //hay una ficha en una casilla intermedia
                    }
                }
            } else if (Math.abs(filaFinal - filaInicial) == Math.abs(columnaFinal - columnaInicial)) {
                //movimiento diagonal
                int diferenciaFilas = filaFinal - filaInicial;
                int direccionFila = (diferenciaFilas != 0) ? diferenciaFilas / Math.abs(diferenciaFilas) : 0;

                int diferenciaColumnas = columnaFinal - columnaInicial;
                int direccionColumna = (diferenciaColumnas != 0) ? diferenciaColumnas / Math.abs(diferenciaColumnas) : 0;


                for (int i = 1; i < Math.abs(filaFinal - filaInicial); i++) {
                    int fila = filaInicial + i * direccionFila;
                    int columna = columnaInicial + i * direccionColumna;

                    if (tablero[fila][columna] != null) {
                        return false; //hay una ficha en una casilla intermedia
                    }
                }
            }

            return true; //todas las casillas intermedias están vacías
        } else {
            return true;
        }
    }

    public boolean capturaPeon(int casillaInicial, int casillaFinal, int filaInicial, int columnaInicial) {
        Ficha fichaInicial = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        Ficha fichaFinal = obtenerFichaEnCoordenada(filaInicial, columnaInicial);

        if (fichaInicial == null || fichaFinal == null) {
            return false; // Agrega esta verificación para evitar NullPointerException
        }

        if (turnoBlancas && filaInicial == 3) {
            if (Math.abs(casillaFinal - casillaInicial) % 9 == 0 ||
                Math.abs(casillaFinal - casillaInicial) % 7 == 0) {
                if (fichaFinal.getEquipo() != fichaInicial.getEquipo() &&
                    peones.contains(fichaFinal)) {
                    return true;
                }
            }
        } else if (!turnoBlancas && filaInicial == 4) {
            if (Math.abs(casillaFinal - casillaInicial) % 9 == 0 ||
                Math.abs(casillaFinal - casillaInicial) % 7 == 0) {
                if (fichaFinal.getEquipo() != fichaInicial.getEquipo() &&
                    peones.contains(fichaFinal)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean validarMovimiento(Ficha ficha, int casillaInicial, int casillaFinal, int filaInicial, int columnaInicial) {
        boolean peon = capturaPeon(casillaInicial, casillaFinal, filaInicial, columnaInicial);
        if (peon) {
            return true;
        }  else if (ficha != null && esTurnoCorrecto(ficha)) {
            return ficha.validarMovimiento(casillaInicial, casillaFinal);
        }
        return false;
    }
    
    public void realizarMovimiento(int casillaInicial, int casillaFinal, int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        boolean peon = capturaPeon(casillaInicial, casillaFinal, filaInicial, columnaInicial);
        if (peon){
            moverFichaCapturaPeon(filaInicial, columnaInicial, filaFinal, columnaFinal);
        } else if (ficha != null) {
            moverFicha(filaInicial, columnaInicial, filaFinal, columnaFinal);
            System.out.println("Ficha movida");
        } else {
            //el movimiento no es válido
            System.out.println("Movimiento no válido");
        }
    }
    
    public boolean capturaRegular(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        Ficha fichaInicial = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        Ficha fichaFinal = obtenerFichaEnCoordenada(filaFinal, columnaFinal);

        if (fichaInicial == null || fichaFinal == null) {
            return false; // Agrega esta verificación para evitar NullPointerException
        }

        int equipoEnemigo; // 0 para blanco, 1 para negro
        if (fichasBlancas.contains(fichaInicial)) { // si ficha es blanca
            equipoEnemigo = 1; // enemigo es negro
        } else {
            equipoEnemigo = 0; // si ficha es negra, enemigo es blanco
        }

        if (equipoEnemigo == 0) {
            if (fichasBlancas.contains(fichaFinal) && fichasNegras.contains(fichaFinal) &&
                fichaFinal.getEquipo() != fichaInicial.getEquipo()) {
                capturaBlancas.add(tablero[filaFinal][columnaFinal].getNombre());
                tablero[filaFinal][columnaFinal] = null;
                System.out.println("Captura negro a blanco");
                return true;
            } else {
                return false;
            }
        } else {
            if (fichasNegras.contains(fichaFinal) && fichasBlancas.contains(fichaFinal) &&
                fichaFinal.getEquipo() != fichaInicial.getEquipo()) {
                capturaNegras.add(tablero[filaFinal][columnaFinal].getNombre());
                tablero[filaFinal][columnaFinal] = null;
                System.out.println("Captura blanco a negro");
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean promocionPeon(int filaInicial, int columnaInicial, int filaFinal){
        Ficha ficha = obtenerFichaEnCoordenada(filaInicial, columnaInicial);
        if (peones.contains(ficha)){
            if (fichasNegras.contains(ficha) && filaFinal == 7){
               System.out.println("Promocion peon negro");
               return true;
            } else if(fichasBlancas.contains(ficha) && filaFinal == 0){
                System.out.println("Promocion peon blanco");
                return true;
            } else{
                return false;
            }
        } else {
            return false;
        }
    }
    
    
    public ArrayList<String> getCapturaNegras() {
        return capturaNegras;
    }
        
    public ArrayList<String> getCapturaBlancas() {
        return capturaBlancas;
    }
     
        public void finalPromocionNegras(int filaFinal, int columnaFinal, int eleccion, Factory fichaFactory) {
            if (eleccion == 0) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha alfilNegro = fichaFactory.crearFichaAlfil("alfilNegro",1);
                fichasNegras.add(alfilNegro);               
                tablero[filaFinal][columnaFinal] = alfilNegro;

            }
            if (eleccion == 1) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha caballoNegro = fichaFactory.crearFichaCaballo("caballoNegro",1);
                fichasNegras.add(caballoNegro);               
                tablero[filaFinal][columnaFinal] = caballoNegro;

            }
            if (eleccion == 2) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha reinaNegro = fichaFactory.crearFichaReina("reinaNegro",1);
                fichasNegras.add(reinaNegro);               
                tablero[filaFinal][columnaFinal] = reinaNegro;

            }
            if (eleccion == 3) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha torreNegro = fichaFactory.crearFichaTorre("torreNegro",1);
                fichasNegras.add(torreNegro);               
                tablero[filaFinal][columnaFinal] = torreNegro;

            }
    }
        
    public void finalPromocionBlancas(int filaFinal, int columnaFinal, int eleccion, Factory fichaFactory) {
            if (eleccion == 0) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha alfilBlanco = fichaFactory.crearFichaAlfil("alfilBlanco",0);
                fichasBlancas.add(alfilBlanco);               
                tablero[filaFinal][columnaFinal] = alfilBlanco;

            }
            if (eleccion == 1) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha caballoBlanco = fichaFactory.crearFichaCaballo("caballoBlanco",0);
                fichasBlancas.add(caballoBlanco);               
                tablero[filaFinal][columnaFinal] = caballoBlanco;

            }
            if (eleccion == 2) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha reinaBlanco = fichaFactory.crearFichaReina("reinaBlanco",0);
                fichasBlancas.add(reinaBlanco);               
                tablero[filaFinal][columnaFinal] = reinaBlanco;

            }
            if (eleccion == 3) {

                tablero[filaFinal][columnaFinal] = null;
                Ficha torreBlanco = fichaFactory.crearFichaTorre("torreBlanco",0);
                fichasBlancas.add(torreBlanco);               
                tablero[filaFinal][columnaFinal] = torreBlanco;

            }
    }
    
    
    public int getFila(Ficha ficha) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == ficha) {
                    return i;
                }
            }
        }
        return -1; //valor de retorno cuando la ficha no se encuentra en el tablero
    }

    public int getColumna(Ficha ficha) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == ficha) {
                    return j;
                }
            }
        }
        return -1; //valor de retorno cuando la ficha no se encuentra en el tablero
    }
    
    
    public boolean estaEnJaque() {
        int filaReyBlanco = -1;
        int columnaReyBlanco = -1;
        int filaReyNegro = -1;
        int columnaReyNegro = -1;

        //buscar la posición del rey blanco
        for (Ficha ficha : fichasBlancas) {
            if (ficha.getNombre().equals("Rey")) {
                filaReyBlanco = getFila(ficha);
                columnaReyBlanco = getColumna(ficha);
                break; // Una vez encontrado, salimos del bucle
            }
        }

        //buscar la posición del rey negro
        for (Ficha ficha : fichasNegras) {
            if (ficha.getNombre().equals("Rey")) {
                filaReyNegro = getFila(ficha);
                columnaReyNegro = getColumna(ficha);
                break; // Una vez encontrado, salimos del bucle
            }
        }

        if (filaReyBlanco == -1 || columnaReyBlanco == -1 || filaReyNegro == -1 || columnaReyNegro == -1) {
            System.out.println("Fallo crítico: No se encontró la posición de algun rey");
            return false;
        }        
        
        

        //verificar si alguna ficha enemiga puede capturar al rey blanco
        ArrayList<Ficha> enemigosBlancos = fichasNegras;

        for (Ficha enemigo : enemigosBlancos) {
            int casillaInicial = obtenerCasilla(getFila(enemigo), getColumna(enemigo));
            int casillaFinal = obtenerCasilla(filaReyBlanco, columnaReyBlanco);

            if (validarMovimientoJaque(enemigo, casillaInicial, casillaFinal, getFila(enemigo), getColumna(enemigo), filaReyBlanco, columnaReyBlanco)) {
                // Si alguna ficha enemiga puede capturar al rey blanco, está en jaque
                System.out.println("Posición " + enemigo.getNombre() + ": [" + getFila(enemigo) + "][" + getColumna(enemigo) + "]");
                System.out.println("¡Jaque al Rey Blanco!");
                return true;
            }
        }

        //verificar si alguna ficha enemiga puede capturar al rey negro
        ArrayList<Ficha> enemigosNegros = fichasBlancas;

        for (Ficha enemigo : enemigosNegros) {
            int casillaInicial = obtenerCasilla(getFila(enemigo), getColumna(enemigo));
            int casillaFinal = obtenerCasilla(filaReyNegro, columnaReyNegro);

            if (validarMovimientoJaque(enemigo, casillaInicial, casillaFinal, getFila(enemigo), getColumna(enemigo), filaReyNegro, columnaReyNegro)) {
                System.out.println("Posición " + enemigo.getNombre() + ": [" + getFila(enemigo) + "][" + getColumna(enemigo) + "]");
                System.out.println("¡Jaque al Rey Negro!");
                return true;
            }
        }

        return false;
    }

    public boolean estaEnJaqueMate() {
        int filaReyBlanco = -1;
        int columnaReyBlanco = -1;
        int filaReyNegro = -1;
        int columnaReyNegro = -1;

        // Buscar la posición del rey blanco
        for (Ficha ficha : fichasBlancas) {
            if (ficha.getNombre().equals("Rey")) {
                filaReyBlanco = getFila(ficha);
                columnaReyBlanco = getColumna(ficha);
                break; // Una vez encontrado, salimos del bucle
            }
        }

        // Buscar la posición del rey negro
        for (Ficha ficha : fichasNegras) {
            if (ficha.getNombre().equals("Rey")) {
                filaReyNegro = getFila(ficha);
                columnaReyNegro = getColumna(ficha);
                break; // Una vez encontrado, salimos del bucle
            }
        }

        if (filaReyBlanco == -1 || columnaReyBlanco == -1 || filaReyNegro == -1 || columnaReyNegro == -1) {
            System.out.println("Fallo crítico: No se encontró la posición de algún rey");
            return false;
        }

        if (estaEnJaque()) {
            // Verificar jaque mate para el rey blanco
            for (int i = filaReyBlanco - 1; i <= filaReyBlanco + 1; i++) {
                for (int j = columnaReyBlanco - 1; j <= columnaReyBlanco + 1; j++) {
                    if (i >= 0 && i < 8 && j >= 0 && j < 8) {
                        Ficha fichaEnPosicion = tablero[i][j];
                        if (fichaEnPosicion == null || fichasNegras.contains(fichaEnPosicion)) {
                            // Intentar mover el rey blanco a la posición (i, j)
                            if (!movimientoDejaEnJaque(tablero[filaReyBlanco][columnaReyBlanco], filaReyBlanco, columnaReyBlanco, i, j)) {
                                // Si el movimiento no deja al rey blanco en jaque, entonces no es jaque mate
                                return false;
                            }
                        }
                    }
                }
            }

            //verificar jaque mate para el rey negro
            for (int i = filaReyNegro - 1; i <= filaReyNegro + 1; i++) {
                for (int j = columnaReyNegro - 1; j <= columnaReyNegro + 1; j++) {
                    if (i >= 0 && i < 8 && j >= 0 && j < 8) {
                        Ficha fichaEnPosicion = tablero[i][j];
                        if (fichaEnPosicion == null || fichasBlancas.contains(fichaEnPosicion)) {
                            //intentar mover el rey negro a la posición (i, j)
                            if (!movimientoDejaEnJaque(tablero[filaReyNegro][columnaReyNegro], filaReyNegro, columnaReyNegro, i, j)) {
                                //si el movimiento no deja al rey negro en jaque, entonces no es jaque mate
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    
    private boolean movimientoDejaEnJaque(Ficha ficha, int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
    //realizar el movimiento temporalmente
        Ficha fichaTemp = tablero[filaFinal][columnaFinal];
        tablero[filaFinal][columnaFinal] = ficha;
        tablero[filaInicial][columnaInicial] = null;

        //verificar si el rey queda en jaque después del movimiento
        boolean enJaque = estaEnJaque();

        //deshacer el movimiento
        tablero[filaInicial][columnaInicial] = ficha;
        tablero[filaFinal][columnaFinal] = fichaTemp;

        return !enJaque;
    }

    public boolean validarMovimientoJaque(Ficha ficha, int casillaInicial, int casillaFinal, int filaInicial, int columnaInicial, int filaFinal, int columnaFinal){
        boolean peon = capturaPeon(casillaInicial, casillaFinal, filaInicial, columnaInicial);
        if (peon){
            return true;
            
            
        } else if (filaInicial == 7 && columnaInicial == 2 && filaFinal == 0 && columnaFinal == 4 ) {
            return false;
        } 
        
        else if (ficha != null && !esTurnoCorrecto(ficha)) {
            return ficha.validarMovimiento(casillaInicial, casillaFinal);
        } return false;
    }
    
    
}
