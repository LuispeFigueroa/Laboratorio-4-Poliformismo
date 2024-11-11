import java.util.Scanner;

/**
 * VistaGrupo6 es la clase de vista para interactuar con el sistema de climatización 
 * de un vehículo BMW Clase C. Implementa la interfaz BMWClaseC y proporciona 
 * métodos para mostrar el menú, ajustar la temperatura, la ventilación, la humedad, 
 * y otros parámetros de climatización.
 */
public class VistaGrupo6 implements BMWClaseC {
    private Scanner scanner;

    /**
     * Constructor de la clase VistaGrupo6. Inicializa el objeto Scanner para leer 
     * la entrada del usuario.
     */
    public VistaGrupo6() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del sistema de climatización, con opciones para 
     * ajustar distintos parámetros.
     */
    @Override
    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de climatización de su BMW");
        System.out.println("---------------------------------");
        System.out.println("1. Mostrar estado del sistema");
        System.out.println("2. Ajustar temperatura");
        System.out.println("3. Ajustar ventilación");
        System.out.println("4. Control de humedad");
        System.out.println("5. Control de desempañador");
        System.out.println("6. Salir");
        System.out.println("---------------------------------");
    }

    /**
     * Solicita al usuario que ingrese la temperatura deseada y valida que esté en el rango permitido.
     *
     * @return la temperatura deseada ingresada por el usuario en grados Celsius.
     */
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

    /**
     * Muestra la temperatura actual del sistema tanto en el interior como en el exterior.
     *
     * @param tempInt la temperatura interior en grados Celsius.
     * @param tempExt la temperatura exterior en grados Celsius.
     */
    @Override
    public void mostrarTemperatura(float tempInt, float tempExt) {
        System.out.println("\n=== TEMPERATURAS ACTUALES ===");
        System.out.printf("Temperatura Interior: %.1f°C\n", tempInt);
        System.out.printf("Temperatura Exterior: %.1f°C\n", tempExt);
        System.out.println("============================");
    }

    /**
     * Muestra el estado actual de la ventilación, incluyendo el nivel y la zona.
     *
     * @param nivel el nivel de ventilación.
     * @param zona la zona de ventilación.
     */
    @Override
    public void mostrarEstadoVentilacion(String nivel, String zona) {
        System.out.println("\n=== ESTADO DE VENTILACIÓN ===");
        System.out.println("Nivel actual: " + nivel);
        System.out.println("Zona actual:  " + zona);
        System.out.println("===========================");
    }

    /**
     * Solicita al usuario que seleccione el nivel de ventilación deseado.
     *
     * @return el nivel de ventilación seleccionado por el usuario.
     */
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

    /**
     * Solicita al usuario que seleccione la zona de ventilación deseada.
     *
     * @return la zona de ventilación seleccionada por el usuario.
     */
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

    /**
     * Muestra el nivel actual de humedad en el sistema de climatización.
     *
     * @param nivel el nivel de humedad actual.
     */
    @Override
    public void mostrarHumedad(String nivel) {
        System.out.println("\n=== NIVEL DE HUMEDAD ===");
        System.out.println("Nivel actual: " + nivel);
        System.out.println("======================");
    }

    /**
     * Muestra un mensaje de error con el texto especificado.
     *
     * @param mensaje el mensaje de error a mostrar.
     */
    @Override
    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    /**
     * Obtiene la opción seleccionada en el menú por el usuario.
     *
     * @return la opción del menú seleccionada por el usuario.
     */
    @Override
    public int obtenerOpcionMenu() {
        System.out.print("\nSeleccione una opción del menú: ");
        return scanner.nextInt();
    }

    /**
     * Muestra el estado del desempañador.
     *
     * @param activo el estado del desempañador (true si está activado, false si está desactivado).
     */
    @Override
    public void mostrarDesempañador(boolean activo) {
        String estado = activo ? "Activado" : "Desactivado";
        System.out.println("\n=== DESEMPAÑADOR ===");
        System.out.println("Estado actual: " + estado);
        System.out.println("====================");
    }
}
