import java.util.Random;
class Tablero {
    private static final int TAMANO = 10;
    private Barco[] barcos;
    private char[][] tablero;

    public Tablero() {
        this.tablero = new char[TAMANO][TAMANO];
        this.barcos = new Barco[5]; // Aumentar el número de barcos
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
        int i = 0;
        while (i < barcos.length) {
            int fila = rand.nextInt(TAMANO);
            int columna = rand.nextInt(TAMANO);
            if (!hayBarcoEnPosicion(fila, columna)) {
                barcos[i] = new Barco(fila, columna);
                i++;
            }
        }
    }

    public boolean hayBarcoEnPosicion(int fila, int columna) {
        for (Barco barco : barcos) {
            if (barco != null && barco.estaEnPosicion(fila, columna)) {
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
        System.out.print("  ");
        for (int j = 0; j < TAMANO; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}