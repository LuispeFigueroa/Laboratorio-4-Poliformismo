public class Principal {
    public static void main(String[] args) {
        VistaGrupo6 vista = new VistaGrupo6();
        ControladorClimaC controlador = new ControladorClimaC(vista);

        System.out.println("Bienvenido al sistema de climatización de su BMW");

        // Iniciar el controlador, lo cual mostrará el menú de opciones
        controlador.iniciar();
    }
}
