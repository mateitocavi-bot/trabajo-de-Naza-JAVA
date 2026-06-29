import java.util.Scanner;

/**
 * Clase Calculadora - Realiza operaciones matemáticas básicas
 */
public class Calculadora {
    
    private Scanner scanner;
    
    public Calculadora() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Suma dos números
     */
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }
    
    /**
     * Resta dos números
     */
    public double restar(double num1, double num2) {
        return num1 - num2;
    }
    
    /**
     * Multiplica dos números
     */
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
    
    /**
     * Divide dos números
     */
    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir entre cero");
            return 0;
        }
        return num1 / num2;
    }
    
    /**
     * Calcula el módulo (residuo de la división)
     */
    public double modulo(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: No se puede calcular módulo entre cero");
            return 0;
        }
        return num1 % num2;
    }
    
    /**
     * Calcula la potencia
     */
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
    
    /**
     * Calcula la raíz cuadrada
     */
    public double raizCuadrada(double num) {
        if (num < 0) {
            System.out.println("Error: No se puede calcular la raíz de un número negativo");
            return 0;
        }
        return Math.sqrt(num);
    }
    
    /**
     * Muestra el menú de opciones
     */
    public void mostrarMenu() {
        System.out.println("\n===== CALCULADORA =====");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Módulo");
        System.out.println("6. Potencia");
        System.out.println("7. Raíz Cuadrada");
        System.out.println("0. Salir");
        System.out.println("=======================");
        System.out.print("Selecciona una opción: ");
    }
    
    /**
     * Ejecuta la calculadora en modo interactivo
     */
    public void iniciar() {
        int opcion;
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            
            try {
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        operacionDosNumeros("suma");
                        break;
                    case 2:
                        operacionDosNumeros("resta");
                        break;
                    case 3:
                        operacionDosNumeros("multiplicación");
                        break;
                    case 4:
                        operacionDosNumeros("división");
                        break;
                    case 5:
                        operacionDosNumeros("módulo");
                        break;
                    case 6:
                        operacionDosNumeros("potencia");
                        break;
                    case 7:
                        operacionUnNumero("raíz cuadrada");
                        break;
                    case 0:
                        salir = true;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                scanner.nextLine(); // Limpia el buffer
            }
        }
        
        scanner.close();
    }
    
    /**
     * Realiza una operación con dos números
     */
    private void operacionDosNumeros(String operacion) {
        System.out.print("Ingresa el primer número: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Ingresa el segundo número: ");
        double num2 = scanner.nextDouble();
        
        double resultado = 0;
        
        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = sumar(num1, num2);
                System.out.printf("Resultado: %.2f + %.2f = %.2f\n", num1, num2, resultado);
                break;
            case "resta":
                resultado = restar(num1, num2);
                System.out.printf("Resultado: %.2f - %.2f = %.2f\n", num1, num2, resultado);
                break;
            case "multiplicación":
                resultado = multiplicar(num1, num2);
                System.out.printf("Resultado: %.2f × %.2f = %.2f\n", num1, num2, resultado);
                break;
            case "división":
                resultado = dividir(num1, num2);
                System.out.printf("Resultado: %.2f ÷ %.2f = %.2f\n", num1, num2, resultado);
                break;
            case "módulo":
                resultado = modulo(num1, num2);
                System.out.printf("Resultado: %.2f %% %.2f = %.2f\n", num1, num2, resultado);
                break;
            case "potencia":
                resultado = potencia(num1, num2);
                System.out.printf("Resultado: %.2f ^ %.2f = %.2f\n", num1, num2, resultado);
                break;
        }
    }
    
    /**
     * Realiza una operación con un número
     */
    private void operacionUnNumero(String operacion) {
        System.out.print("Ingresa el número: ");
        double num = scanner.nextDouble();
        
        double resultado = 0;
        
        if (operacion.equalsIgnoreCase("raíz cuadrada")) {
            resultado = raizCuadrada(num);
            System.out.printf("Resultado: √%.2f = %.2f\n", num, resultado);
        }
    }
    
    /**
     * Método main - Punto de entrada del programa
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.iniciar();
    }
}
