import java.time.LocalDate;

/**
 * Relación: * Transacción -> 1 Cuenta ; * Transacción -> 1 Cajero
 */
public class Transaccion {

    private LocalDate fecha;
    private String descripcion;
    private String tipo;
    private double valor;

    public Transaccion(String descripcion, String tipo, double valor) {
        this.fecha = LocalDate.now();
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Registrar() : registra la transacción realizada
     */
    public void registrar() {
        System.out.println("[Transacción] " + fecha + " | " + tipo + " | " + descripcion + " | RD$" + valor);
    }

    //=============================================================================
    // Getters y Setters

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Transaccion{" + tipo + ", valor=" + valor + ", fecha=" + fecha + "}";
    }
}
