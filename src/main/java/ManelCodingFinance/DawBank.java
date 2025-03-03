package ManelCodingFinance;

import java.util.*;

public class DawBank {
    static ArrayList<Cliente> usuariosRegistrados = new ArrayList<>();

    public static void main(String[] args) {

        usuariosRegistrados.add(new Cliente("admin", "admin@dmin.com", "admin", "admin"));

        System.out.println("""
                
                  __  __                  _    ____          _ _               _____ _                           \s
                 |  \\/  | __ _ _ __   ___| |  / ___|___   __| (_)_ __   __ _  |  ___(_)_ __   __ _ _ __   ___ ___\s
                 | |\\/| |/ _` | '_ \\ / _ \\ | | |   / _ \\ / _` | | '_ \\ / _` | | |_  | | '_ \\ / _` | '_ \\ / __/ _ \\
                 | |  | | (_| | | | |  __/ | | |__| (_) | (_| | | | | | (_| | |  _| | | | | | (_| | | | | (_|  __/
                 |_|  |_|\\__,_|_| |_|\\___|_|  \\____\\___/ \\__,_|_|_| |_|\\__, | |_|   |_|_| |_|\\__,_|_| |_|\\___\\___|
                                                                       |___/                                     \s
                """);
        System.out.println("Bienvenido a DawBank, su dinero, y sobretodo, el nuestro.\n");

        System.out.println("Esta usted registrado?\n");

        Scanner sc = new Scanner(System.in);
        boolean menuVal1 = true;
        String menuOption1;

        do {
            if (!menuVal1)
                System.out.println("Introudzca una opción válida (1 o 2).");
            if (menuVal1) {
                System.out.println("1. Estoy registrado -> Iniciar sesión.\n2. No lo estoy -> Registrarme.\n");
                menuVal1 = false;
            }
            menuOption1 = sc.nextLine();
        } while (!menuOption1.matches("[1-2]"));

        switch (menuOption1) {
            case "1":
                comprobarUsuario();
                break;
            case "2":
                registrarUsuario();
                break;

        }
    }

    public static void comprobarUsuario() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            boolean breakVal = false;
            System.out.println("Usuario: ");
            String DNI = sc.nextLine();
            System.out.println("Contraseña: ");
            String contrasena = sc.nextLine();
            for (Cliente usuReg : usuariosRegistrados) {
                if (usuReg.getDNI().equals(DNI) && usuReg.getContrasena().equals(contrasena)) {
                    System.out.println("\nBienvenido " + usuReg.getNombre() + "!\n");
                    breakVal = true;
                    break;
                } else {
                    System.out.println("\nUsuario o Contraseña incorrectos, le quedan " + (2 - i) + " intentos\n");
                }
            }
            if (breakVal)
                break;
        }
    }

    public static void registrarUsuario() {
        Scanner sc = new Scanner(System.in);
        String DNI;
        String contrasena;
        String nombre;
        String correo;

        boolean datosVal1 = true;
        do {
            if (!datosVal1)
                System.out.println("Introudzca un DNI válido.\n");
            if (datosVal1) {
                System.out.println("Introduzca su DNI: ");
                datosVal1 = false;
            }
            DNI = sc.nextLine();
        } while (!Cliente.comprobarDNI(DNI));

        for (Cliente usuReg : usuariosRegistrados) {
            while (usuReg.getDNI().equals(DNI)) {
                System.out.println("El DNI" + usuReg.getDNI() + " ya está registrado, por favor, introduzca otro DNI: ");
                DNI = sc.nextLine();
            }
        }

        boolean datosVal2 = true;
        do {
            if (!datosVal2)
                System.out.println("Introudzca una contraseña válida.\n");
            if (datosVal2) {
                System.out.println("Introduzca una contraseña (minimo 8 caracteres): ");
                datosVal2 = false;
            }
            contrasena = sc.nextLine();
        } while (contrasena.length() < 8);

        System.out.println("Introduzca su nombre completo: ");
        nombre = sc.nextLine().toUpperCase();

        boolean datosVal3 = true;
        do {
            if (!datosVal3)
                System.out.println("Introudzca una correo válido.\n");
            if (datosVal3) {
                System.out.println("Introduzca un correo electronico: ");
                datosVal3 = false;
            }
            correo = sc.nextLine();
        } while (!correo.matches("^[^@]+@[^@]+\\.[^@]+$"));

        usuariosRegistrados.add(new Cliente(nombre, correo, DNI, contrasena));

    }
}