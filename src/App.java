import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        System.out.println("Simulador de banco");
        System.out.println("__________________");
        Banco banco = new Banco();
        //algunas cuentas para agregar casos de prueba
        banco.crearCuenta(12345678, "Maria Rodrigez");
        banco.crearCuenta(186547832, "Marcos Benite");
        banco.crearCuenta(206097894, "Javiera santander");
        do{
            System.out.println("Eliga Una de las siguientes opciones: ");
            System.out.println("1.- Crear cuenta");
            System.out.println("2.- Buscar cuenta por rut");
            Scanner entrada = new Scanner(System.in);
            switch(entrada.nextInt()){
                case 1:
                    crearCuenta(banco, entrada);
                    break;
                case 2:
                    verCuenta(banco, entrada);
                    break;
                default:
                    System.err.println("La opcion digitada no es valida");
            }

        }while(true);
    }
    //este es un menu para crear una cuenta
    private static void crearCuenta(Banco banco, Scanner entrada) {
        System.out.println("Menu de emulacion de creacion de cuenta");
        System.out.println("_______________________________________");
        System.out.print("Por favor ingrese su RUT seguido de su nombre en el formato(rut nombre apellido): ");
        banco.crearCuenta(entrada.nextInt(), (entrada.next()+" "+entrada.next()));
    }
    //este metodo permite ver una cuenta
    private static void verCuenta(Banco banco, Scanner entrada) {
        System.out.println("Menu de emulacion de busqueda de Cuenta");
        System.out.println("_______________________________________");
        System.out.print("Ingrese el RUT del titular de la cuenta: ");
        int RUN = entrada.nextInt();
        if(!banco.existe(RUN))System.err.println("Esta cuenta no existe");
        System.out.println("\n"+banco.buscarCuenta(RUN));

        
    }
}
