import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ---- 1. Crear el Banco ----
        Banco banco = new Banco(1, "Banco Popular Dominicano", "Av. Winston Churchill, Santo Domingo", 8095551);

        // ---- 2. Crear un Cajero perteneciente al Banco ----
        Cajero cajero = new Cajero("1234", banco);
        banco.agregarCajero(cajero);

        // ---- 3. Crear un Cliente ----
        Cliente cliente = new Cliente(101, 402123456, "Daniel Benjamin", "Santo Domingo Este", 8091234);

        // ---- 4. Crear una Cuenta asociada al Cliente y al Banco ----
        Cuenta cuenta = new Cuenta(5001, cliente.getNumCliente(), "Ahorros", 15000.0);
        cliente.agregarCuenta(cuenta);
        banco.agregarCuenta(cuenta);

        // ---- 5. Crear una Tarjeta asociada al Cliente y la Cuenta ----
        Tarjeta tarjeta = new Tarjeta(9001, cuenta.getNumCuenta(), cliente.getNumCliente(),
                LocalDate.now().plusYears(3));
        cliente.agregarTarjeta(tarjeta);

        System.out.println("========================================");
        System.out.println(" Bienvenido al sistema bancario");
        System.out.println(" Cliente: " + cliente.getNombre());
        System.out.println(" Cuenta:  " + cuenta.consultarCuenta());
        System.out.println("========================================");

        // ---- 6. Simular un retiro (flujo completo Cliente -> Cajero -> Banco) ----
        cajero.realizarRetiro(cliente, tarjeta, cuenta, 3000.0);

        // ---- 7. Consultar saldo final ----
        System.out.println("\n" + cuenta.consultarCuenta());

        // ---- 8. Intento de retiro con fondos insuficientes ----
        System.out.println("\n--- Intentando un segundo retiro mayor al saldo disponible ---");
        cajero.realizarRetiro(cliente, tarjeta, cuenta, 50000.0);
    }
}