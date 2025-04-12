import java.util.Random;
class Jugador {
    protected String nombre;
    protected Tablero tablero;
    protected Random random;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
        this.random = new Random();
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

class Maquina extends Jugador {
    public Maquina() {
        super("Maquina");
    }

    public int[] generarAtaque() {
        return new int[]{random.nextInt(5), random.nextInt(5)};
    }
}
