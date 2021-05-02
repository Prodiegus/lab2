/* Las cuentas son identificadas por nombre y numero de cedula */
public class Cuenta {
    protected String Nombre;
    protected int RUN;
    protected float saldoCuenta;
    private CuentaAhorros CtaAhorros;
    private CuentaCorriente CtaCorriente;
    private CDT cdt;
    Cuenta(String nombre, int RUN) {
        Nombre = nombre;
        this.RUN = RUN;
        this.saldoCuenta = 0f;
        this.CtaAhorros = new CuentaAhorros(nombre, RUN);
        this.CtaCorriente = new CuentaCorriente(nombre, RUN);
        this.cdt = new CDT(nombre, RUN);
    }
    Cuenta(){}//este costructor esta vacio para evitar un loop recursivo infinito
    public boolean deposito(int monto, int tCuenta){//se debe especificar el tipo de cuenta a depositar
        switch(tCuenta){
            case 1:
                return this.CtaAhorros.depositar(monto);
            case 2:
                return this.CtaCorriente.depositar(monto);
            case 3:
                return this.cdt.depositar(monto);
            default:
                System.err.println("\nopcion digitada no es valida");
                return false;
        }
    }
    public float saldoA(){//funcion creada para calcular el sueldo total entre cuentas
        this.saldoCuenta = CtaAhorros.getSaldo()+CtaCorriente.getSaldo()+cdt.getSaldo();
        return this.saldoCuenta;
    }
    public int getRUN() {return RUN;}

    @Override
    public String toString() {
        //el saldo total de la cuenta se vera por medio de una funcion que cada vez que se necesite sera actualizado
        return "\nNombre: " + Nombre + "\nRUN: " + RUN + "\nSaldo Cuenta: " + saldoA()+"\n\n";
    }
    
}
