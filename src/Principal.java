package conversor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        conversor.Menu menu = new conversor.Menu(scanner);
        conversor.ConversorMoneda conversor = new conversor.ConversorMoneda();

        System.out.println("--- Conversor de Monedas ---");

        while (true) {

            // 1. Elegir moneda origen
            String origen = menu.elegirMoneda("Seleccione la moneda de ORIGEN:");
            if (origen == null) {
                System.out.println("Fin del programa.");
                break;
            }

            // 2. Elegir moneda destino
            String destino = menu.elegirMoneda("Seleccione la moneda de DESTINO:");
            if (destino == null) {
                System.out.println("Fin del programa.");
                break;
            }

            if (origen.equals(destino)) {
                System.out.println("Las monedas no pueden ser iguales. Intente nuevamente.\n");
                continue;
            }

            // 3. Monto
            double monto = menu.pedirMonto("Ingrese el monto a convertir:");

            // 4. Petición a la API
            try {
                double resultado = conversor.convertir(origen, destino, monto);
                System.out.printf(
                        "%n%.2f %s equivalen a %.2f %s%n%n",
                        monto, origen, resultado, destino
                );
            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

