package ManelCodingFinance;

import java.util.Scanner;

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

        do {
            if (!menuVal1)
                System.out.println("Introudzca una opción válida (1 o 2).");
            if (menuVal1) {
                System.out.println("1. Estoy registrado -> Iniciar sesión.\n2. No lo estoy -> Registrarme.\n");
                menuVal1 = false;
            }
            menuOption1 = sc.nextLine();
        } while (!menuOption1.matches("[1-2]"));
    }
}