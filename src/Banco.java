import java.util.ArrayList;
/* esta clase es el simulador de banco sus metodos seran usados en el app */
public class Banco {
    private ArrayList<Cuenta> cuentas;
    Banco(){
        this.cuentas = new ArrayList<>();
    }

    /* 
     * en este metodo se crea una nueva cuenta al crear cuenta
     * se asume que el cliente quiere 3 cuentas por ello se crea una de cada tipo
     * aunque el saldo total de su cuenta no se vera afectado si no deposita dinero en la que no quiere usar
     */
    public void crearCuenta(int RUN, String nombre){
        if(existe(RUN))System.err.println("La cuenta que usted desea ingresar ya existe");
        Cuenta cuenta = new Cuenta(nombre, RUN);
        cuentas.add(cuenta);
        System.out.println("Cuenta creada exitosamente: \n"+cuenta);
    
    }

    //este metodo se usara para depositar
    public boolean depositar(int RUN, int monto, int tCuenta){
        if(!existe(RUN)){
            System.err.println("\nLa cuenta a la que ustes intenta depositar no existe");
            return false;
        }
        return buscarCuenta(RUN).deposito(monto, tCuenta);
    }
    //este metodo se usara para depositar
    public boolean girar(int RUN, int monto, int tCuenta){
        if(!existe(RUN)){
            System.err.println("\nLa cuenta a la que ustes intenta girar no existe");
            return false;
        }
        return buscarCuenta(RUN).giro(monto, tCuenta);
    }
    //este metodo es utilizado para verificar si ya existe una cuenta haciendo una busqueda por RUN
    public boolean existe(int RUN){
        if(cuentas.isEmpty())return false;
        if(buscarCuenta(RUN) != null && buscarCuenta(RUN).getRUN() == RUN)return true;
        return false;
    }
    //este metodo busca una cuenta
    public Cuenta buscarCuenta(int RUN){ 
        if(cuentas.isEmpty())return null;
        for(int i = 0; i<cuentas.size();i++){
            if(cuentas.get(i).getRUN() == RUN)return cuentas.get(i);
        }
        return null;
    }

}
