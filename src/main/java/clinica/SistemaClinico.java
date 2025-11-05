package clinica;

import java.util.Scanner;

public class SistemaClinico {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar doctor");
            System.out.println("3. Crear consulta");
            System.out.println("4. Asignar tratamiento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Función no implementada");
                    break;
                case 2:
                    System.out.println("Función no implementada");
                    break;
                case 3:
                    System.out.println("Función no implementada");
                    break;
                case 4:
                    System.out.println("Función no implementada");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            System.out.println();
        } while (opcion != 5);
        
        scanner.close();
    }
    
    // Constructor básico
    public SistemaClinico() {
    }
    
}

