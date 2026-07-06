public class Main {
    public static void main(String[] args) {
        
        // Verificar que se ingresaron 3 argumentos
        if(args.length != 3) {
            System.out.println("========================================");
            System.out.println("        CALCULADORA BÁSICA");
            System.out.println("========================================");
            System.out.println("INSTRUCCIONES:");
            System.out.println("En el cuadro de entrada, escribe 3 cosas:");
            System.out.println("1. Primer número");
            System.out.println("2. Segundo número");
            System.out.println("3. Operación (+, -, *, /)");
            System.out.println("");
            System.out.println("EJEMPLOS:");
            System.out.println("  10 5 +    → 10 + 5 = 15");
            System.out.println("  20 4 -    → 20 - 4 = 16");
            System.out.println("  7 3 *     → 7 × 3 = 21");
            System.out.println("  15 3 /    → 15 ÷ 3 = 5");
            System.out.println("========================================");
            return;
        }
        
        try {
            // Obtener los argumentos
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operacion = args[2];
            double resultado = 0;
            boolean error = false;
            
            // Realizar el cálculo según la operación
            switch(operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if(num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        System.out.println("ERROR: No se puede dividir entre cero");
                        error = true;
                    }
                    break;
                default:
                    System.out.println("ERROR: Operación no válida. Usa +, -, * o /");
                    error = true;
            }
            
            // Mostrar resultado
            if(!error) {
                System.out.println("========================================");
                System.out.println("              RESULTADO");
                System.out.println("========================================");
                System.out.println("  " + num1 + " " + operacion + " " + num2 + " = " + resultado);
                System.out.println("========================================");
            }
            
        } catch(NumberFormatException e) {
            System.out.println("ERROR: Los primeros dos argumentos deben ser números");
            System.out.println("Ejemplo correcto: 10 5 +");
        }
    }
}
