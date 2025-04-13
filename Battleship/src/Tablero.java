import java.util.Random;
class Tablero {
    private static final int TAMANO = 10;
    private Barco[] barcos;
    private char[][] tablero;
    private static final int[] TAMANOS_BARCOS = {1, 2, 3, 4, 5};
    private static final int CANTIDAD_BARCOS = 2;

    public Tablero() {
        this.tablero = new char[TAMANO][TAMANO];
        this.barcos = new Barco[TAMANOS_BARCOS.length * CANTIDAD_BARCOS];
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
        int index = 0;
        for (int tamano : TAMANOS_BARCOS) {
            for (int i = 0; i < CANTIDAD_BARCOS; i++) {
                boolean colocado = false;
                while (!colocado) {
                    int fila = rand.nextInt(TAMANO);
                    int columna = rand.nextInt(TAMANO);
                    boolean horizontal = rand.nextBoolean();
                    if (puedeColocarBarco(fila, columna, tamano, horizontal)) {
                        barcos[index++] = new Barco(fila, columna, tamano, horizontal);
                        colocado = true;
                    }
                }
            }
        }
    }

    private boolean puedeColocarBarco(int fila, int columna, int tamano, boolean horizontal) {
        for (int i = 0; i < tamano; i++) {
            int f = horizontal ? fila : fila + i;
            int c = horizontal ? columna + i : columna;
            if (f >= TAMANO || c >= TAMANO || hayBarcoEnPosicion(f, c)) {
                return false;
            }
        }
        return true;
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
                if (barco.estaHundido()) {
                    System.out.println("¡Hundido!");
                } else {
                    System.out.println("¡Tocado!");
                }
                tablero[fila][columna] = '⛵';
                return true;
            }
        }
        System.out.println("Agua...");
        tablero[fila][columna] = '⬛';
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
            System.out.print(" " + j + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == '~') {
                    System.out.print("\uD83D\uDD00 ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}