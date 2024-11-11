public class ControladorClimaC {
    private IVistaClimaC vista;
    private float tempInt;  // Temperatura interior
    private float tempExt;  // Temperatura exterior
    private String nivelVentilacion;
    private String zonaVentilacion;
    private boolean desempañador;
    private boolean encendido;

    public ControladorClimaC(IVistaClimaC vista) {
        this.vista = vista;
        this.tempInt = 22.0f; // Valor inicial de temperatura interior
        this.tempExt = 20.0f; // Simulación de temperatura exterior
        this.nivelVentilacion = ConstantesSistema.VENT_MEDIO;
        this.zonaVentilacion = ConstantesSistema.ZONA_FRONTAL;
        this.desempañador = false;
        this.encendido = false;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.obtenerOpcionMenu();
            manejarOpcion(opcion);
        } while (opcion != 6);
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarEstado();
                break;
            case 2:
                manejarTemperatura();
                break;
            case 3:
                manejarVentilacion();
                break;
            case 4:
                manejarHumedad();
                break;
            case 5:
                manejarDesempañador();
                break;
            case 6:
                System.out.println("Saliendo del sistema de climatización...");
                break;
            default:
                vista.mostrarError("Opción no válida");
        }
    }

    private void mostrarEstado() {
        vista.mostrarTemperatura(tempInt, tempExt);
        vista.mostrarEstadoVentilacion(nivelVentilacion, zonaVentilacion);
        vista.mostrarDesempañador(desempañador);
    }

    private void manejarTemperatura() {
        if (encendido) {
            tempInt = vista.pedirTemperatura();
        } else {
            vista.mostrarError("El sistema está apagado.");
        }
    }

    private void manejarVentilacion() {
        if (encendido) {
            nivelVentilacion = vista.pedirNivelVentilacion();
            zonaVentilacion = vista.pedirZonaVentilacion();
        } else {
            vista.mostrarError("El sistema está apagado.");
        }
    }

    private void manejarHumedad() {
        if (encendido) {
            String nivelHumedad = vista.pedirNivelHumedad();
            vista.mostrarHumedad(nivelHumedad);
        } else {
            vista.mostrarError("El sistema está apagado.");
        }
    }

    private void manejarDesempañador() {
        if (encendido) {
            desempañador = !desempañador;
            vista.mostrarDesempañador(desempañador);
        } else {
            vista.mostrarError("El sistema está apagado.");
        }
    }
}
