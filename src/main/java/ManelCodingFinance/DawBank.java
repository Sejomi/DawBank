package ManelCodingFinance;

import java.util.*;

public class DawBank {
    static ArrayList<Cliente> usuariosRegistrados = new ArrayList<>();
    static Cliente clienteSesion = new Cliente(null, null, null, null);
    public static void main(String[] args) {

        usuariosRegistrados.add(new Cliente("admin", "admin@dmin.com", "admin", "admin"));

        Scanner sc = new Scanner(System.in);
        boolean menuVal1 = true;
        boolean menuEnd = false;
        String menuOption1;


        do {
            System.out.println("""
                
                  __  __                  _    ____          _ _               _____ _                           \s
                 |  \\/  | __ _ _ __   ___| |  / ___|___   __| (_)_ __   __ _  |  ___(_)_ __   __ _ _ __   ___ ___\s
                 | |\\/| |/ _` | '_ \\ / _ \\ | | |   / _ \\ / _` | | '_ \\ / _` | | |_  | | '_ \\ / _` | '_ \\ / __/ _ \\
                 | |  | | (_| | | | |  __/ | | |__| (_) | (_| | | | | | (_| | |  _| | | | | | (_| | | | | (_|  __/
                 |_|  |_|\\__,_|_| |_|\\___|_|  \\____\\___/ \\__,_|_|_| |_|\\__, | |_|   |_|_| |_|\\__,_|_| |_|\\___\\___|
                                                                       |___/                                     \s
                """);
            System.out.println("Bienvenido a DawBank, su dinero, y sobretodo, el nuestro.\n");

            System.out.println("Esta usted registrado?");

            do {
                if (!menuVal1)
                    System.out.println("Introudzca una opción válida (1, 2 o 3).\n");
                if (menuVal1) {
                    System.out.println("\n1. Estoy registrado -> Iniciar sesión.\n2. No lo estoy -> Registrarme.\n3. Salir\n");
                    menuVal1 = false;
                }
                menuOption1 = sc.nextLine();
            } while (!menuOption1.matches("[1-3]"));

            switch (menuOption1) {
                case "1":
                    iniciarSesion();
                    menuEnd = true;
                    break;
                case "2":
                    registrarUsuario();
                    break;
                default:
                    menuEnd = true;
            }
            menuVal1 = true;
        } while (!menuEnd);
    }

    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        boolean valSesion = false;

        for (int i = 0; i < 3; i++) {
            boolean breakVal = false;
            System.out.println("Usuario: ");
            String DNI = sc.nextLine();
            System.out.println("Contraseña: ");
            String contrasena = sc.nextLine();
            for (Cliente usuReg : usuariosRegistrados) {
                if (usuReg.getDNI().equals(DNI) && usuReg.getContrasena().equals(contrasena)) {
                    System.out.println("\nBienvenido " + usuReg.getNombre() + "!");
                    clienteSesion = usuReg;
                    menuSesion();
                    breakVal = true;
                    break;
                } else if (usuReg.equals(usuariosRegistrados.getLast())) {
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
        boolean usuVal = false;
        String usuValString = null;
        do {
            if (usuVal) {
                System.out.println("El DNI" + usuValString + " ya está registrado, por favor, introduzca otro DNI: ");
                usuVal = false;
            }
            else if (datosVal1) {
                System.out.println("Introduzca su DNI: ");
                datosVal1 = false;
            } else {
                System.out.println("Introudzca un DNI válido.\n");
            }

            DNI = sc.nextLine();
            for (Cliente usuReg : usuariosRegistrados) {
                if (usuReg.getDNI().equals(DNI)) {
                    usuValString = usuReg.getDNI();
                    usuVal = true;
                }
            }
        } while (!comprobarDNI(DNI) || usuVal);


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
        clienteSesion.setNombre(nombre);
        clienteSesion.setDNI(correo);
        clienteSesion.setDNI(DNI);
        clienteSesion.setContrasena(contrasena);
    }

    public static void menuSesion() {
        Scanner sc = new Scanner(System.in);
        boolean valMenu = true;
        boolean menuEnd = true;

        do {
            if (valMenu) {
                System.out.println("""
                        
                        Que desea hacer hoy?\
                        
                        1. Consultar Cuenta.\
                        
                        2. Consultar Movimientos\
                        
                        3. Operaciones.\
                        
                        4. Crear Cuenta\
                        
                        5. Salir.""");
                valMenu = false;
            }
            switch (sc.nextLine()) {
                case "1":
                    consultarCuenta();
                    valMenu = true;
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    crearCuenta();
                    valMenu = true;
                    break;
                case "5":
                    System.out.println("Gracias por usar nuestros servicios.");
                    menuEnd = false;
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
                    break;
            }
        } while (menuEnd);
    }

    public static void consultarCuenta() {
        Scanner sc = new Scanner(System.in);
        String selected;
        boolean menuEnd = false;
        boolean datosVal1 = true;
        int contador = 0;

        for (Cliente usuReg : usuariosRegistrados) {
            if (usuReg.getDNI().equals(clienteSesion.getDNI())) {
                if (usuReg.getCuentas().isEmpty()) {
                    System.out.println("Usted no tiene ninguna cuenta creada");
                } else {
                    do {
                        System.out.println("Elija la cuenta que desea consultar:\n");
                        for (CuentaBancaria cuenta : usuReg.getCuentas()) {
                            System.out.println((contador + 1) + ". " + cuenta.getIBAN());
                            contador++;
                        } selected = sc.nextLine();
                    } while (selected.matches("^[0-9]+") && (Integer.parseInt(selected) > (contador + 1)) || Integer.parseInt(selected) <= 0);
                    usuReg.getCuentas().get(Integer.parseInt(selected) - 1).printCuenta();
                }
            }
        }
    }

    public static void crearCuenta() {
        String IBAN = "";

        for (Cliente usuReg : usuariosRegistrados) {
            if (usuReg.getDNI().equals(clienteSesion.getDNI())) {
                usuReg.getCuentas().add(new CuentaBancaria(usuReg));
                IBAN = usuReg.getCuentas().getLast().getIBAN();
                break;
            }
        }

        System.out.println("Cuenta creada con éxito, su IBAN es: " + IBAN);

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