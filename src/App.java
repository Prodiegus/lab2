import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        int mes=0;
        System.out.println("Simulador de banco |mes: "+mes);
        System.out.println("____________________________");
        Banco banco = new Banco();
        //algunas cuentas para agregar casos de prueba
        banco.crearCuenta(12345678, "Maria Rodrigez");
        banco.crearCuenta(186547832, "Marcos Benite");
        banco.crearCuenta(206097894, "Javiera santander");
        do{
            System.out.println("Eliga Una de las siguientes opciones: ");
            System.out.println("1.- Crear cuenta");
            System.out.println("2.- Buscar cuenta por rut");
            System.out.println("3.- Depositar dinero en una cuenta");
            System.out.println("4.- Realizar un giro a una cuenta");
            System.out.println("5.- Avazar de mes");
            System.out.println("6.- Consultar en que mes nos encontramos");
            System.out.println("7.- Eliminar una cuenta por RUT");
            System.out.println("8.- cerrar el emulador");
            System.out.print("Opcion: ");
            Scanner entrada = new Scanner(System.in);
            switch(entrada.nextInt()){
                case 1:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e) {/*No hacer nada*/}
                    crearCuenta(banco, entrada);
                    break;
                case 2:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e) {/*No hacer nada*/}
                    verCuenta(banco, entrada);
                    break;
                case 3:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    depositar(banco, entrada);
                    break;
                case 4:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    girar(banco, entrada);
                    break;
                case 5:
                    System.out.print("Cuantos meses desea avanzar: ");
                    int incremento = entrada.nextInt();
                    mes(banco, incremento);
                    mes+=incremento;
                    break;
                case 6:
                    System.out.println("Usted se cuentra en el mes "+mes+" de la emulacion");
                    try {
                        new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    break;
                case 7:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    eliminar(banco, entrada);
                    break;
                case 8:
                    mes=-10;
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    System.out.println("Usted esta cerrando el emulador");
                    System.out.println("Muchas gracias por haber utilizado este simulador bancario");
                    try {
                        new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e){/*no hacer nada*/}
                    break;    
                default:
                    System.err.println("La opcion digitada no es valida");
            }

        }while(mes>=0);
    }
    //este es un menu para crear una cuenta
    private static void crearCuenta(Banco banco, Scanner entrada) {
        System.out.println("Menu de emulacion de creacion de cuenta");
        System.out.println("_______________________________________");
        System.out.print("Por favor ingrese su RUT seguido de su nombre en el formato(rut nombre apellido): ");
        banco.crearCuenta(entrada.nextInt(), (entrada.next()+" "+entrada.next()));
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}
    }
    //este metodo permite ver una cuenta 
    private static void verCuenta(Banco banco, Scanner entrada) {
        System.out.println("Menu de emulacion de busqueda de Cuenta");
        System.out.println("_______________________________________");
        System.out.print("Ingrese el RUT del titular de la cuenta: ");
        int RUN = entrada.nextInt();
        if(!banco.existe(RUN))System.err.println("\nEsta cuenta no existe\n");
        System.out.println("\n"+banco.buscarCuenta(RUN)); 
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}    
    }
    //este metodo tiene la finalidad de crear un deposito
    private  static void depositar(Banco banco, Scanner entrada){
        System.out.println("Menu de emulacion de deposito a una cuenta");
        System.out.println("__________________________________________");
        System.out.println("1.- Cuenta Ahorro");
        System.out.println("2.- Cuenta Corriente");
        System.out.println("3.- Certificado de Deposito a Termino");
        System.out.print("Porfavor especifique el tipo de cuenta al que desea depositar: ");
        int tcuenta = entrada.nextInt();
        System.out.print("Porfavor indique el RUT, Cantidas a depositar formato(RUT Cantidad): ");
        int RUN = entrada.nextInt();
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {/*No hacer nada*/}
        if(!banco.depositar(RUN, entrada.nextInt(), tcuenta))System.err.println("Operacion Fallida\n");
        else{
            System.out.println("Operacion exitosa");
            System.out.println(banco.buscarCuenta(RUN));
        }
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}
    }
    //este metodo tiene la finalidad de crear un deposito
    private  static void girar(Banco banco, Scanner entrada){
        System.out.println("Menu de emulacion de giro a una cuenta");
        System.out.println("__________________________________________");
        System.out.println("1.- Cuenta Ahorro");
        System.out.println("2.- Cuenta Corriente");
        System.out.print("Porfavor especifique el tipo de cuenta al que desea girar: ");
        int tcuenta = entrada.nextInt();
        System.out.print("Porfavor indique el RUT, Cantidas a girar formato(RUT Cantidad): ");
        int RUN = entrada.nextInt();
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {/*No hacer nada*/}
        if(!banco.girar(RUN, entrada.nextInt(), tcuenta))System.err.println("Operacion Fallida\n");
        else{
            System.out.println("Operacion exitosa");
            System.out.println(banco.buscarCuenta(RUN));
        }
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}
    }
    public static void mes(Banco banco, int mes){
        System.out.println("Se a emulado el avance de un mes exitosamente");
        for(int i = 0; i<mes;i++)banco.otroMes();
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}
    }
    public static void eliminar(Banco banco, Scanner entrada){
        System.out.println("Menu de emulacion de eliminacion de Cuenta");
        System.out.println("__________________________________________");
        System.out.print("Ingrese el RUT del titular de la cuenta: ");
        if(!banco.eliminarCuenta(entrada.nextInt()))System.err.println("No ha sido posible eliminar la cuenta");
        System.out.println("Cuenta elimminada exitosamente");
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){/*no hacer nada*/}
    }
}
