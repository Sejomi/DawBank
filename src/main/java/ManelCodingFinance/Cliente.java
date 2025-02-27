package ManelCodingFinance;

public class Cliente {
    private String nombre;
    private String correo;
    private String DNI;
    private String usuario;
    private String contraseña;

    public Cliente(String nombre, String correo, String DNI, String usuario, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.usuario = usuario;
        this.contraseña = contraseña;
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

    public void printCliente() {
        System.out.println("Nombre: " + nombre + "\nCorreo: " + correo + "\nDNI: " + DNI);
    }
}
