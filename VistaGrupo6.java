//Vista para el grupo, se llaman todos los metodos de la clase grupo

import java.util.Scanner;

public class VistaGrupo6 implements BMWClaseC {
  private Scanner scanner;

  public VistaGrupo6() {
    scanner = new Scanner(System.in);
  }

  @Override
  public void mostrarMenu(){
    System.out.println("Bienvenido al sistema de climatizacion de su BMW");
    System.out.println("---------------------------------");
    System.out.println("1. Mostar estado del sistema");
    System.out.println("2. Ajustar temperatura");
    System.out.println("3. Ajustar ventilacion");
    System.out.println("4. Control de humedad");
    System.out.println("5. Control de desempañado");
    System.out.println("6. Salir");
    System.out.println("---------------------------------");
  }

  //Metodo para poder pedir temperatura al usuario, se utiliza el override
  @Override
  public float pedirTemperatura() {
        float temperatura = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("\nIngrese temperatura deseada (16.0°C - 30.0°C): ");
                temperatura = scanner.nextFloat();
                
                if (temperatura >= ConstantesSistema.TEMP_MIN && 
                    temperatura <= ConstantesSistema.TEMP_MAX) {
                    entradaValida = true;
                } else {
                    mostrarError("Temperatura fuera de rango permitido");
                }
            } catch (Exception e) {
                mostrarError("Por favor, ingrese un número válido");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return temperatura;
    }
    @Override
    public void mostrarTemperatura(float tempInt, float tempExt) {
        System.out.println("\n=== TEMPERATURAS ACTUALES ===");
        System.out.printf("Temperatura Interior: %.1f°C\n", tempInt);
        System.out.printf("Temperatura Exterior: %.1f°C\n", tempExt);
        System.out.println("============================");
    }

    @Override
    public void mostrarEstadoVentilacion(String nivel, String zona) {
        System.out.println("\n=== ESTADO DE VENTILACIÓN ===");
        System.out.println("Nivel actual: " + nivel);
        System.out.println("Zona actual:  " + zona);
        System.out.println("===========================");
    }

    @Override
    public String pedirNivelVentilacion() {
        System.out.println("\nNiveles de ventilación disponibles:");
        System.out.println("1. " + ConstantesSistema.VENT_BAJO);
        System.out.println("2. " + ConstantesSistema.VENT_MEDIO);
        System.out.println("3. " + ConstantesSistema.VENT_ALTO);

        while (true) {
            try {
                System.out.print("\nSeleccione nivel (1-3): ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: return ConstantesSistema.VENT_BAJO;
                    case 2: return ConstantesSistema.VENT_MEDIO;
                    case 3: return ConstantesSistema.VENT_ALTO;
                    default:
                        mostrarError("Opción no válida");
                }
            } catch (Exception e) {
                mostrarError("Por favor, ingrese un número válido");
                scanner.nextLine();
            }
        }
    }

    @Override
    public String pedirZonaVentilacion() {
        System.out.println("\nZonas de ventilación disponibles:");
        System.out.println("1. " + ConstantesSistema.ZONA_PARABRISAS);
        System.out.println("2. " + ConstantesSistema.ZONA_FRONTAL);
        System.out.println("3. " + ConstantesSistema.ZONA_PIES);

        while (true) {
            try {
                System.out.print("\nSeleccione zona (1-3): ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: return ConstantesSistema.ZONA_PARABRISAS;
                    case 2: return ConstantesSistema.ZONA_FRONTAL;
                    case 3: return ConstantesSistema.ZONA_PIES;
                    default:
                        mostrarError("Opción no válida");
                }
            } catch (Exception e) {
                mostrarError("Por favor, ingrese un número válido");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void mostrarHumedad(String nivel) {
        System.out.println("\n=== NIVEL DE HUMEDAD ===");
        System.out.println("Nivel actual: " + nivel);
        System.out.println("======================");
    }
    
}

