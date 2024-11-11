public class Principal {
    public static void main(String[] args) {
        IVistaClimaC vista = new VistaGrupo6();
        ControladorClimaC controlador = new ControladorClimaC(vista);
        controlador.iniciar();
    }
}

