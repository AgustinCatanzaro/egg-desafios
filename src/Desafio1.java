import java.util.Scanner;

//El objetivo de este desafío es escribir un programa que use un operador ternario para determinar si un número es par o impar.

public class Desafio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int valor;
            String resultado;

            System.out.println("Ingresar Numero: ");
            valor = scanner.nextInt();

            resultado = (valor%2 == 0)? "Es PAR" : "Es IMPAR";
            System.out.println(resultado);
        } finally {
            scanner.close();
        }
    }
}
