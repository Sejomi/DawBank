package ManelCodingFinance;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String correo;
    private String DNI;
    private String contrasena;
    private ArrayList<CuentaBancaria> cuentas;

    public Cliente(String nombre, String correo, String DNI, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public void printCliente() {
        System.out.println("\nNombre: " + nombre + "\nCorreo: " + correo + "\nDNI: " + DNI + "\nCuentas: " + cuentas);
    }

}
