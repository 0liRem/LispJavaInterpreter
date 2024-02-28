import java.util.Scanner;
public class Vistas {
    Scanner sc=new Scanner(System.in);
    public void menu(){
        Controlador controlador = new Controlador();
        System.out.println("Binevenido a traductor de infix to posfix y luego calculadora");
        System.out.println("Ingrese el nombre del archivo. (Nota: debe encontrarse en la misma carpeta que el programa y poner el .txt al final)");
        String arch=sc.next();

        controlador.archivos(arch);


    }
}
