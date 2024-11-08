public interface BMWClaseC{
    public float mostrarTemp();
    public void mostrarMenu();
    public void limpiarPantalla();
    public float pedirTemperatura(float temp);
    public String mostrarEstadoVentilacion();
    public String pedirNivelVentilacion(String nivel);
    public String pedirZonaVentilacion(String nivel);
    public String mostrarHumedad();
    public void pedirNivelHumedad(String nivel);
    public String mostrarEstado();
    public String mostrarError();
    public String mostrarAviso(String aviso);
    public int obtenerOpcionMenu();
    public boolean mostrarDesempañador();
}