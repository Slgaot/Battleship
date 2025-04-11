import java.util.Random;
class Tablero {
    private static final int TAMANO = 5;
    private Barco[] barcos;
    private char[][] tablero;

    public Tablero() {
        this.tablero = new char[TAMANO][TAMANO];
        this.barcos = new Barco[3];
        inicializarTablero();
        colocarBarcosAleatorios();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = '~';
            }
        }
    }

    private void colocarBarcosAleatorios() {
        Random rand = new Random();
        for (int i = 0; i < barcos.length; i++) {
            int fila, columna;
            do {
                fila = rand.nextInt(TAMANO);
                columna = rand.nextInt(TAMANO);
            } while (hayBarcoEnPosicion(fila, columna));
            barcos[i] = new Barco(fila, columna);
        }
    }

    public boolean hayBarcoEnPosicion(int fila, int columna) {
        for (Barco barco : barcos) {
            if (barco != null && barco.estaEnPosicion(fila, columna)) { // Evitar acceder a barcos null
                return true;
            }
        }
        return false;
    }


    public boolean disparar(int fila, int columna) {
        for (Barco barco : barcos) {
            if (barco.estaEnPosicion(fila, columna)) {
                barco.hundir();
                tablero[fila][columna] = 'X';
                return true;
            }
        }
        tablero[fila][columna] = 'O';
        return false;
    }

    public boolean todosHundidos() {
        for (Barco barco : barcos) {
            if (!barco.estaHundido()) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
