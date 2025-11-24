package conversor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<String> monedas = Arrays.asList(
            "USD", "EUR", "ARS", "GBP", "BRL", "JPY", "CHF", "CAD", "AUD", "CNY"
    );
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Muestra el listado numerado de monedas y la opción 0 para salir. */
    public void mostrarOpciones() {
        System.out.println("\n--- Seleccione una moneda ---");
        for (int i = 0; i < monedas.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, monedas.get(i));
        }
        System.out.println(" 0) Salir");
    }

    /**
     * Pide al usuario elegir una moneda mostrando un prompt.
     * Devuelve el código (ej. "USD") o null si el usuario elige 0 (salir).
     */
    public String elegirMoneda(String prompt) {
        while (true) {
            System.out.println(prompt);
            mostrarOpciones();
            String linea = scanner.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("Entrada vacía. Ingrese el número de la opción.");
                continue;
            }

            try {
                int opcion = Integer.parseInt(linea);
                if (opcion == 0) return null;
                if (opcion >= 1 && opcion <= monedas.size()) {
                    return monedas.get(opcion - 1);
                } else {
                    System.out.println("Opción fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese el número de la opción.");
            }
        }
    }

    /**
     * Pide y valida el monto a convertir.
     * Reemplaza comas por puntos, valida que sea número y no negativo.
     */
    public double pedirMonto(String prompt) {
        while (true) {
            System.out.println(prompt);
            String linea = scanner.nextLine().trim().replace(",", ".");
            if (linea.isEmpty()) {
                System.out.println("Entrada vacía. Ingrese un monto numérico.");
                continue;
            }
            try {
                double monto = Double.parseDouble(linea);
                if (monto < 0) {
                    System.out.println("El monto no puede ser negativo.");
                    continue;
                }
                return monto;
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Ejemplo válido: 123.45");
            }
        }
    }
}
