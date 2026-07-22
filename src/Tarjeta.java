import java.time.LocalDate;

/**
 * Clase Tarjeta
 * Relación: 1 Cliente -> * Tarjeta ; 1 Cuenta -> * Tarjeta
 */
public class Tarjeta {

    private int numTarjeta;
    private int numCuenta;
    private int numCliente;
    private LocalDate fechaExpiracion;

    public Tarjeta(int numTarjeta, int numCuenta, int numCliente, LocalDate fechaExpiracion) {
        this.numTarjeta = numTarjeta;
        this.numCuenta = numCuenta;
        this.numCliente = numCliente;
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean estaVigente() {
        return LocalDate.now().isBefore(fechaExpiracion);
    }

    //Getters y Setters

    public int getNumTarjeta() { return numTarjeta; }
    public void setNumTarjeta(int numTarjeta) { this.numTarjeta = numTarjeta; }

    public int getNumCuenta() { return numCuenta; }
    public void setNumCuenta(int numCuenta) { this.numCuenta = numCuenta; }

    public int getNumCliente() { return numCliente; }
    public void setNumCliente(int numCliente) { this.numCliente = numCliente; }

    public LocalDate getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(LocalDate fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    @Override
    public String toString() {
        return "Tarjeta{numTarjeta=" + numTarjeta + ", numCuenta=" + numCuenta +
                ", expira=" + fechaExpiracion + "}";
    }
}
