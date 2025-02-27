package ManelCodingFinance;

import java.util.*;

public class DawBank {
    public static void main(String[] args) {
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

        HashMap<String, String> usuariosRegistrados = new HashMap<String, String>();
        usuariosRegistrados.put("admin", "admin");

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
                comprobarUsuario(usuariosRegistrados);
                break;
            case "2":
                registrarUsuario(usuariosRegistrados);
                break;

        }
    }

    public static void comprobarUsuario(Map<String, String> usuariosRegistrados) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            boolean breakVal = false;
            System.out.println("Usuario: ");
            String usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = sc.nextLine();
            for (Map.Entry<String, String> entry : usuariosRegistrados.entrySet()) {
                if (entry.getKey().equals(usuario) && entry.getValue().equals(contraseña)) {
                    System.out.println("\nBienvenido " + usuario + "!\n");
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

    public static void registrarUsuario(Map<String, String> usuariosRegistrados) {
        Scanner sc = new Scanner(System.in);
        String usuario;
        String contraseña;

        boolean datosVal1 = true;
        do {
            if (!datosVal1)
                System.out.println("Introudzca un usuario válido.\n");
            if (datosVal1) {
                System.out.println("Introduzca un nombre de usuario (sin carácteres especiales): ");
                datosVal1 = false;
            }
            usuario = sc.nextLine();
        } while (!usuario.matches("^[\\w]*"));

        for (String entry : usuariosRegistrados.keySet()) {
            while (entry.equals(usuario)) {
                System.out.println("El usuario " + usuario + " ya existe, introduzca otro usuario: ");
                usuario = sc.nextLine();
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
            contraseña = sc.nextLine();
        } while (contraseña.length() < 8);

        usuariosRegistrados.put(usuario, contraseña);
    }
}