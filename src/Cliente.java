import java.util.ArrayList;
import java.util.List;

/*
 * Relación 1..* con Tarjeta y 1..* con Cuenta.
 */
public class Cliente {

    private int numCliente;
    private int identificacion;
    private String nombre;
    private String direccion;
    private int telefono;

    // Relaciones (1 Cliente -> * Tarjeta, 1 Cliente -> * Cuenta)
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Cuenta> cuentas = new ArrayList<>();

    public Cliente(int numCliente, int identificacion, String nombre, String direccion, int telefono) {
        this.numCliente = numCliente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // -------- Métodos del diagrama --------

    /** Ingresar Clave() : el cliente digita la clave de su tarjeta en el cajero */
    public String ingresarClave(String clave) {
        System.out.println("[Cliente] Ingresando clave...");
        return clave;
    }

    /** Elegir Opciones() : el cliente selecciona una opción del menú del cajero */
    public String elegirOpciones(String opcion) {
        System.out.println("[Cliente] Opción elegida: " + opcion);
        return opcion;
    }

    /** Indicar valor a Retirar() : el cliente indica el monto a retirar */
    public double indicarValorARetirar(double valor) {
        System.out.println("[Cliente] Valor a retirar: RD$" + valor);
        return valor;
    }

    // Utilidades de relación 

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    //Getters y Setters

    public int getNumCliente() { return numCliente; }
    public void setNumCliente(int numCliente) { this.numCliente = numCliente; }

    public int getIdentificacion() { return identificacion; }
    public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    public List<Tarjeta> getTarjetas() { return tarjetas; }
    public List<Cuenta> getCuentas() { return cuentas; }

    @Override
    public String toString() {
        return "Cliente{numCliente=" + numCliente + ", nombre='" + nombre + "'}";
    }
}
