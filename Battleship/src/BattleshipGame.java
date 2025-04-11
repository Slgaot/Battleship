import java.util.Scanner;
public class BattleshipGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        Jugador jugador1 = new Jugador(scanner.nextLine());
        System.out.print("Ingrese el nombre del Jugador 2: ");
        Jugador jugador2 = new Jugador(scanner.nextLine());

        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (!jugador1.haPerdido() && !jugador2.haPerdido()) {
            System.out.println("\nTurno de " + actual.getNombre());
            actual.mostrarTablero();

            System.out.print("Ingrese fila (0-4): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese columna (0-4): ");
            int columna = scanner.nextInt();

            if (actual.atacar(oponente, fila, columna)) {
                System.out.println("¡Impacto!");
            } else {
                System.out.println("Agua...");
            }

            if (oponente.haPerdido()) {
                System.out.println("¡" + actual.getNombre() + " ha ganado!");
                break;
            }

            // Cambiar turno
            Jugador temp = actual;
            actual = oponente;
            oponente = temp;
        }
        scanner.close();
    }
}
