package ManelCodingFinance;

import java.util.HashMap;

public class Cliente {
    private String nombre;
    private String correo;
    private String DNI;
    private String contrasena;

    public Cliente(String nombre, String correo, String DNI, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.contrasena = contrasena;
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

    public void printCliente() {
        System.out.println("Nombre: " + nombre + "\nCorreo: " + correo + "\nDNI: " + DNI);
    }

    public static boolean comprobarDNI(String DNI) {
        if (!DNI.matches("^[0-9]{8}[A-Z]$"))
            return false;
        HashMap<Integer, Character> dniMap = new HashMap<>();

        dniMap.put(0, 'T');
        dniMap.put(1, 'R');
        dniMap.put(2, 'W');
        dniMap.put(3, 'A');
        dniMap.put(4, 'G');
        dniMap.put(5, 'M');
        dniMap.put(6, 'Y');
        dniMap.put(7, 'F');
        dniMap.put(8, 'P');
        dniMap.put(9, 'D');
        dniMap.put(10, 'X');
        dniMap.put(11, 'B');
        dniMap.put(12, 'N');
        dniMap.put(13, 'J');
        dniMap.put(14, 'Z');
        dniMap.put(15, 'S');
        dniMap.put(16, 'Q');
        dniMap.put(17, 'V');
        dniMap.put(18, 'H');
        dniMap.put(19, 'L');
        dniMap.put(20, 'C');
        dniMap.put(21, 'K');
        dniMap.put(22, 'E');

       int dniNoLetra = Integer.parseInt(DNI.substring(0, 8));

       return DNI.charAt(8) == dniMap.get(dniNoLetra % 23);
    }
}
