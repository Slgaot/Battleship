class Jugador {
    private String nombre;
    private Tablero tablero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean atacar(Jugador oponente, int fila, int columna) {
        return oponente.tablero.disparar(fila, columna);
    }

    public boolean haPerdido() {
        return tablero.todosHundidos();
    }

    public void mostrarTablero() {
        tablero.mostrarTablero();
    }
}
