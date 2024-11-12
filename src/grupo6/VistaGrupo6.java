
import java.util.Scanner;



/**
 * VistaGrupo6 es la clase de vista para interactuar con el sistema de climatización 
 * de un vehículo BMW Clase C. Proporciona métodos para recoger datos del usuario 
 * sin imprimir mensajes en la consola.
 */
public class VistaGrupo6 {
    private Scanner scanner;

    /**
     * Constructor de la clase VistaGrupo6. Inicializa el objeto Scanner para leer 
     * la entrada del usuario.
     */
    public VistaGrupo6() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("---------------------------------");
        System.out.println("1. Mostrar estado del sistema");
        System.out.println("2. Ajustar temperatura");
        System.out.println("3. Ajustar ventilación");
        System.out.println("4. Control de humedad");
        System.out.println("5. Control de desempañador");
        System.out.println("6. Salir");
        System.out.println("---------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Muestra el menú principal del sistema de climatización, utilizado en la clase Principal.
     */
  
    /**
     * Solicita al usuario que ingrese la temperatura deseada.
     *
     * @return la temperatura deseada ingresada por el usuario en grados Celsius.
     */
    public float pedirTemperatura() {
        return scanner.nextFloat();
    }

    /**
     * Solicita al usuario que seleccione el nivel de ventilación deseado.
     *
     * @return el nivel de ventilación seleccionado por el usuario.
     */
    public String pedirNivelVentilacion() {
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return ConstantesSistema.VENT_BAJO;
            case 2: return ConstantesSistema.VENT_MEDIO;
            case 3: return ConstantesSistema.VENT_ALTO;
            default: return "";
        }
    }

    /**
     * Solicita al usuario que seleccione la zona de ventilación deseada.
     *
     * @return la zona de ventilación seleccionada por el usuario.
     */
    public String pedirZonaVentilacion() {
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return ConstantesSistema.ZONA_PARABRISAS;
            case 2: return ConstantesSistema.ZONA_FRONTAL;
            case 3: return ConstantesSistema.ZONA_PIES;
            default: return "";
        }
    }

    /**
     * Solicita al usuario que seleccione el nivel de humedad deseado.
     *
     * @return el nivel de humedad seleccionado por el usuario.
     */
    public String pedirNivelHumedad() {
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return ConstantesSistema.HUM_BAJO;
            case 2: return ConstantesSistema.HUM_MEDIO;
            case 3: return ConstantesSistema.HUM_ALTO;
            default: return "";
        }
    }

    /**
     * Obtiene la opción seleccionada en el menú por el usuario.
     *
     * @return la opción del menú seleccionada por el usuario.
     */
    public int obtenerOpcionMenu() {
        return scanner.nextInt();
    }

    // Métodos adicionales según el diagrama UML, sin imprimir en consola

    public void mostrarError(String mensaje) {
        // Método para mostrar errores, no imprime en consola.
    }

    public void mostrarAviso(String aviso) {
        // Método para mostrar avisos, no imprime en consola.
    }

    public void mostrarEstado(String estado) {
        // Método para mostrar el estado del sistema, no imprime en consola.
    }

    public void mostrarTemperatura(float tempInt, float tempExt) {
        // Método para mostrar las temperaturas, no imprime en consola.
    }

    public void mostrarEstadoVentilacion(String nivel, String zona) {
        // Método para mostrar el estado de la ventilación, no imprime en consola.
    }

    public void mostrarHumedad(String nivel) {
        // Método para mostrar el nivel de humedad, no imprime en consola.
    }

    public void mostrarDesempañador(boolean activo) {
        // Método para mostrar el estado del desempañador, no imprime en consola.
    }
}
