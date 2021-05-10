/* Las cuentas son identificadas por nombre y numero de cedula */
public class Cuenta {
    protected String Nombre;
    protected int RUN;
    protected float saldoCuenta;
    public CuentaAhorros CtaAhorros;
    public CuentaCorriente CtaCorriente;
    public CDT cdt;
    Cuenta(String nombre, int RUN) {
        Nombre = nombre;
        this.RUN = RUN;
        this.saldoCuenta = 0f;
        this.CtaAhorros = new CuentaAhorros(nombre, RUN);
        this.CtaCorriente = new CuentaCorriente(nombre, RUN);
        this.cdt = new CDT(nombre, RUN);
    }
    Cuenta(int RUN){this.RUN = RUN;}
    public boolean deposito(int monto, int tCuenta){//se debe especificar el tipo de cuenta a depositar
        switch(tCuenta){
            case 1:
                return this.CtaAhorros.depositar(monto);
            case 2:
                return this.CtaCorriente.depositar(monto);
            case 3:
                return this.cdt.depositar(monto);
            default:
                System.err.println("\nOpcion digitada no es valida");
                return false;
        }
    }
    public boolean giro(int monto, int tCuenta) {//se debe especificar el tipo de cuenta a girar
        switch(tCuenta){
            case 1:
                return this.CtaAhorros.girar(monto);
            case 2:
                return this.CtaCorriente.girar(monto);
            default:
                System.err.println("\nOpcion digitada no es valida");
                return false;
        }
    }
    //funcion creada para avanzar el mes
    public boolean mes(){
        if(!CtaAhorros.nuevoMes())return false;
        return true;
    }
    public float saldoA(){//funcion creada para calcular el sueldo total entre cuentas
        this.saldoCuenta = CtaAhorros.getSaldo()+CtaCorriente.getSaldo()+cdt.getSaldo();
        return this.saldoCuenta;
    }
    public int getRUN() {return RUN;}

    @Override
    public String toString() {
        //el saldo total de la cuenta se vera por medio de una funcion que cada vez que se necesite sera actualizado
        return "\nNombre: " + Nombre + "\nRUT: " + RUN + "\nSaldo Cuenta: " + saldoA()+"\n\n";
    }
    
}
