import java.util.Scanner;

//El objetivo de este desafío es crear una calculadora básica en Java que pueda realizar operaciones aritméticas simples, como suma, resta, multiplicación y división. 

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int numUno, numDos, opcion;

            System.out.println("Ingresar Primer Numero: ");
            numUno = scanner.nextInt();
            System.out.println("Ingresar Segundo Numero: ");
            numDos = scanner.nextInt();
            System.out.println("Ingrese la operacion a realizar:\n1 = Sumar\n2 = Restar\n3 = Dividir\n4 = Multiplicar\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado = " +(numUno + numDos));
                    break;
                case 2:
                    System.out.println("Resultado = " +(numUno - numDos));
                    break;
                case 3:
                    System.out.println("Resultado = " +(numUno / numDos));
                    break;
                case 4:
                    System.out.println("Resultado = " +(numUno * numDos));                
                    break;
            
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } finally {
            scanner.close();
        }
        
    }
}

    
