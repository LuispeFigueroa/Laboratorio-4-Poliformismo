//Vista para el grupo, se llaman todos los metodos de la clase grupo

public class VistaGrupo6 implements BMWClaseC {
  private Scanner scanner;

  public VistaGrupo6() {
    scanner = new Scanner(System.in);
  }

  @Override
  public void mostrarMenu(){
    System.out.println("Bienvenido al sistema de climatizacion de su BMW")
    System.out.println("---------------------------------")
    System.out.println("1. Mostar estado del sistema")
    System.out.println("2. Ajustar temperatura")
    System.out.println("3. Ajustar ventilacion")
    System.out.println("4. Control de humedad")
    System.out.println("5. Control de desempañado")
    System.out.println("6. Salir")
    System.out.println("---------------------------------")
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

}

