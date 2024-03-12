import java.util.Scanner;

public class Vista {
    Scanner sc = new Scanner(System.in);

    public void menu() throws Exception {
        Controlador controlador = new Controlador();
        System.out.println("Binevenido al Intérprete Lisp");
        System.out.println(
                "\nIngrese el nombre del archivo que desea evaluar. \n(Nota: debe encontrarse en la misma carpeta que el programa y poner el .txt al final)");
        System.err.print("  - Nombre Archivo: ");
        String arch = sc.next();

        controlador.archivos(arch);

    }
}
