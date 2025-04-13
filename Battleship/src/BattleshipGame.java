import java.util.Scanner;
public class BattleshipGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        Jugador jugador1 = new Jugador(scanner.nextLine());
        Jugador jugador2 = new Maquina();

        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (!jugador1.haPerdido() && !jugador2.haPerdido()) {
            System.out.println("\nTurno de " + actual.getNombre());
            actual.mostrarTablero();

            int fila, columna;
            if (actual instanceof Maquina) {
                int[] ataque = ((Maquina) actual).generarAtaque();
                fila = ataque[0];
                columna = ataque[1];
                System.out.println("La máquina ataca en: (" + fila + ", " + columna + ")");
            } else {
                while (true) {
                    try {
                        System.out.print("Ingrese fila (0-9): ");
                        fila = scanner.nextInt();
                        System.out.print("Ingrese columna (0-9): ");
                        columna = scanner.nextInt();
                        if (fila >= 0 && fila < 10 && columna >= 0 && columna < 10) {
                            break;
                        }
                        System.out.println("Entrada inválida. Ingrese valores entre 0 y 9.");
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Ingrese un número válido.");
                        scanner.next(); // Limpiar buffer
                    }
                }
            }

            if (!oponente.getTablero().posicionAtacada(fila, columna)) {
                if (actual.atacar(oponente, fila, columna)) {
                    System.out.println("¡Impacto!");
                } else {
                    System.out.println("Agua...");
                }
            } else {
                System.out.println("Ya has atacado esta posición. Pierdes tu turno.");
            }

            if (oponente.haPerdido()) {
                System.out.println("¡" + actual.getNombre() + " ha ganado!");
                break;
            }

            Jugador temp = actual;
            actual = oponente;
            oponente = temp;
        }
        scanner.close();
    }
}