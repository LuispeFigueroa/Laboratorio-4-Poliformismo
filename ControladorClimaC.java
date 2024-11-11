/**
 * ControladorClimaC maneja la lógica del sistema de climatización para un vehículo BMW Clase C.
 */
public class ControladorClimaC {
    private VistaGrupo6 vista;
    private float tempInt;  // Temperatura interior
    private float tempExt;  // Temperatura exterior
    private String nivelVentilacion;
    private String zonaVentilacion;
    private boolean desempañador;
    private boolean encendido;

    /**
     * Constructor de la clase ControladorClimaC. Inicializa el controlador con una vista
     * y valores predeterminados para los atributos del sistema de climatización.
     *
     * @param vista la vista utilizada para interactuar con el usuario
     */
    public ControladorClimaC(VistaGrupo6 vista) {
        this.vista = vista;
        this.tempInt = 22.0f;
        this.tempExt = 20.0f;
        this.nivelVentilacion = ConstantesSistema.VENT_MEDIO;
        this.zonaVentilacion = ConstantesSistema.ZONA_FRONTAL;
        this.desempañador = false;
        this.encendido = false;
    }

    /**
     * Inicia el sistema de climatización y muestra el menú principal, permitiendo al usuario
     * seleccionar opciones hasta que decida salir.
     */
    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();  // Muestra el menú en la consola
            opcion = vista.obtenerOpcionMenu();  // Obtiene la opción del usuario
            String resultado = manejarOpcion(opcion);  // Ejecuta la opción seleccionada
            System.out.println(resultado);  // Muestra el resultado en la consola
        } while (opcion != 6);  // Continua hasta que se elija salir
    }

    /**
     * Maneja la opción seleccionada por el usuario en el menú, llamando a los métodos
     * correspondientes según la funcionalidad deseada.
     *
     * @param opcion la opción seleccionada por el usuario
     * @return un mensaje indicando el resultado de la opción seleccionada
     */
    public String manejarOpcion(int opcion) {
        switch (opcion) {
            case 1: return mostrarEstado();
            case 2: return manejarTemperatura();
            case 3: return manejarVentilacion();
            case 4: return manejarHumedad();
            case 5: return manejarDesempañador();
            case 6: return "Saliendo del sistema de climatización...";
            default: return "Opción no válida";
        }
    }

    private String mostrarEstado() {
        return "Temperatura Interior: " + tempInt + "°C, Exterior: " + tempExt + "°C\n"
             + "Nivel de ventilación: " + nivelVentilacion + ", Zona de ventilación: " + zonaVentilacion + "\n"
             + "Desempañador: " + (desempañador ? "Activado" : "Desactivado");
    }

    private String manejarTemperatura() {
        if (encendido) {
            tempInt = vista.pedirTemperatura();
            return "Temperatura ajustada a " + tempInt + "°C.";
        } else {
            return "El sistema está apagado.";
        }
    }

    private String manejarVentilacion() {
        if (encendido) {
            nivelVentilacion = vista.pedirNivelVentilacion();
            zonaVentilacion = vista.pedirZonaVentilacion();
            return "Ventilación ajustada a nivel " + nivelVentilacion + " en zona " + zonaVentilacion + ".";
        } else {
            return "El sistema está apagado.";
        }
    }

    private String manejarHumedad() {
        if (encendido) {
            String nivelHumedad = vista.pedirNivelHumedad();
            return "Humedad ajustada a nivel " + nivelHumedad + ".";
        } else {
            return "El sistema está apagado.";
        }
    }

    private String manejarDesempañador() {
        if (encendido) {
            desempañador = !desempañador;
            return "Desempañador " + (desempañador ? "activado" : "desactivado") + ".";
        } else {
            return "El sistema está apagado.";
        }
    }
}
