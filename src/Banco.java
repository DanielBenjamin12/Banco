import java.util.ArrayList;
import java.util.List;

/**
 * Relación: 1 Banco -> * Cajero ; 1 Banco -> * Cuenta
 */
public class Banco {

    private int numBanco;
    private String nombre;
    private String direccion;
    private int telefono;

    private List<Cuenta> cuentas = new ArrayList<>();
    private List<Cajero> cajeros = new ArrayList<>();

    public Banco(int numBanco, String nombre, String direccion, int telefono) {
        this.numBanco = numBanco;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /** Verificar Transacción() : valida que la transacción pueda procesarse */
    public boolean verificarTransaccion(Transaccion t) {
        boolean valido = t.getValor() > 0;
        System.out.println("[Banco] Verificando transacción... " + (valido ? "OK" : "RECHAZADA"));
        return valido;
    }

    /** Verificar Cuenta() : busca y valida la existencia de la cuenta */
    public Cuenta verificarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumCuenta() == numCuenta) {
                System.out.println("[Banco] Cuenta " + numCuenta + " encontrada.");
                return c;
            }
        }
        System.out.println("[Banco] Cuenta " + numCuenta + " NO encontrada.");
        return null;
    }

    /** Verificar Saldo() : valida que la cuenta tenga fondos suficientes */
    public boolean verificarSaldo(Cuenta cuenta, double valor) {
        boolean suficiente = cuenta != null && cuenta.getSaldo() >= valor;
        System.out.println("[Banco] Verificando saldo... " + (suficiente ? "SUFICIENTE" : "INSUFICIENTE"));
        return suficiente;
    }

    // Utilidades de relación

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void agregarCajero(Cajero cajero) {
        cajeros.add(cajero);
    }

    //Getters y Setters

    public int getNumBanco() { return numBanco; }
    public void setNumBanco(int numBanco) { this.numBanco = numBanco; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    public List<Cuenta> getCuentas() { return cuentas; }
    public List<Cajero> getCajeros() { return cajeros; }
}
