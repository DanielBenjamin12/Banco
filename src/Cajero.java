import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Relación: 1 Banco -> * Cajero ; 1 Cajero -> * Transacción
 * También interactúa con el actor externo "Banco" (representado por
 * la clase Banco, que valida cuenta / saldo / transacción).
 */
public class Cajero {

    private String clave;
    private Banco banco;
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cajero(String clave, Banco banco) {
        this.clave = clave;
        this.banco = banco;
    }

    /** Mostrar Opciones() : despliega el menú de operaciones al cliente */
    public void mostrarOpciones() {
        System.out.println("\n===== CAJERO AUTOMÁTICO =====");
        System.out.println("1. Retirar");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Salir");
        System.out.println("==============================");
    }

    /** Solicitar Clave() : pide al cliente su clave y la compara con la tarjeta */
    public boolean solicitarClave(String claveIngresada, Tarjeta tarjeta) {
        System.out.println("[Cajero] Solicitando clave...");
        boolean valida = claveIngresada != null && claveIngresada.equals(this.clave) && tarjeta.estaVigente();
        System.out.println("[Cajero] Clave " + (valida ? "correcta." : "incorrecta o tarjeta vencida."));
        return valida;
    }

    /** Verifica Banco() : el cajero se comunica con el banco para validar la operación */
    public boolean verificaBanco(Cuenta cuenta, double valor) {
        System.out.println("[Cajero] Verificando con el banco...");
        Cuenta cuentaValida = banco.verificarCuenta(cuenta.getNumCuenta());
        if (cuentaValida == null) return false;
        return banco.verificarSaldo(cuentaValida, valor);
    }

    /** Dar Respuesta() : entrega el resultado final de la operación al cliente */
    public void darRespuesta(String mensaje) {
        System.out.println("[Cajero] >> " + mensaje);
    }

    /** Operación completa de retiro, integrando todas las clases del diagrama */
    public void realizarRetiro(Cliente cliente, Tarjeta tarjeta, Cuenta cuenta, double valor) {
        mostrarOpciones();
        Scanner sc = new Scanner(System.in);

        String claveIngresada = cliente.ingresarClave(clave); // simulado
        if (!solicitarClave(claveIngresada, tarjeta)) {
            darRespuesta("Operación cancelada: clave inválida.");
            return;
        }

        cliente.elegirOpciones("Retirar");
        cliente.indicarValorARetirar(valor);

        if (!verificaBanco(cuenta, valor)) {
            darRespuesta("Operación rechazada: fondos insuficientes o cuenta inválida.");
            return;
        }

        Transaccion t = new Transaccion("Retiro en cajero " + this.hashCode(), "RETIRO", valor);
        if (!banco.verificarTransaccion(t)) {
            darRespuesta("Operación rechazada: transacción inválida.");
            return;
        }

        cuenta.retirar(valor);
        t.registrar();
        cuenta.agregarTransaccion(t);
        transacciones.add(t);

        darRespuesta("Retiro exitoso. Nuevo saldo: RD$" + cuenta.getSaldo());
    }

    // Getters y Setters

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public Banco getBanco() { return banco; }
    public void setBanco(Banco banco) { this.banco = banco; }

    public List<Transaccion> getTransacciones() { return transacciones; }
}
