
import java.util.Scanner;


public class Principal {
    static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Digite el numero de filas-columnas: ");
        int n = in.nextInt();
        Matriz m1 = new Matriz(n);
        m1.rellenarValor();
        m1.mostrarMatriz();
        System.out.println("\nLa determinante es: "+m1.determinante());
       
    }
}
