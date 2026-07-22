import java.util.ArrayList;
import java.util.List;

/**
 * Relación: 1 Cliente -> * Cuenta ; 1 Cuenta -> * Transacción ; * Cuenta -> 1 Banco
 */
public class Cuenta {

    private int numCuenta;
    private int numCliente;
    private String tipoCuenta;
    private double saldo;

    private List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta(int numCuenta, int numCliente, String tipoCuenta, double saldo) {
        this.numCuenta = numCuenta;
        this.numCliente = numCliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    /**
     * Consultar Cuenta() : devuelve la información/saldo de la cuenta
     */

    public String consultarCuenta() {
        return "Cuenta N° " + numCuenta + " (" + tipoCuenta + ") - Saldo: RD$" + saldo;
    }

    public boolean retirar(double valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void agregarTransaccion(Transaccion t) {
        transacciones.add(t);
    }

    //Getters y Setters


    public int getNumCuenta() { return numCuenta; }
    public void setNumCuenta(int numCuenta) { this.numCuenta = numCuenta; }

    public int getNumCliente() { return numCliente; }
    public void setNumCliente(int numCliente) { this.numCliente = numCliente; }

    public String getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public List<Transaccion> getTransacciones() { return transacciones; }

    @Override
    public String toString() {
        return "Cuenta{numCuenta=" + numCuenta + ", tipo='" + tipoCuenta + "', saldo=" + saldo + "}";
    }
}
