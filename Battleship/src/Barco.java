class Barco {
    private int fila, columna;
    private boolean hundido;

    public Barco(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.hundido = false;
    }

    public boolean estaEnPosicion(int fila, int columna) {
        return this.fila == fila && this.columna == columna;
    }

    public void hundir() {
        this.hundido = true;
    }

    public boolean estaHundido() {
        return hundido;
    }
}
