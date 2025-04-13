class Barco {
    private int fila, columna, tamano;
    private boolean horizontal;
    private boolean[] partesImpactadas;

    public Barco(int fila, int columna, int tamano, boolean horizontal) {
        this.fila = fila;
        this.columna = columna;
        this.tamano = tamano;
        this.horizontal = horizontal;
        this.partesImpactadas = new boolean[tamano];
    }

    public boolean estaEnPosicion(int fila, int columna) {
        for (int i = 0; i < tamano; i++) {
            int f = horizontal ? this.fila : this.fila + i;
            int c = horizontal ? this.columna + i : this.columna;
            if (f == fila && c == columna) {
                partesImpactadas[i] = true;
                return true;
            }
        }
        return false;
    }

    public boolean estaHundido() {
        for (boolean parte : partesImpactadas) {
            if (!parte) {
                return false;
            }
        }
        return true;
    }
}
