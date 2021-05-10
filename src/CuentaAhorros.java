/*  Interes mensual de 0,6% sobre el saldo  */
public class CuentaAhorros extends Cuenta {
    private float interes;
    private float saldo;
    public CuentaAhorros(String nombre, int RUN) {
        super(RUN);
        this.interes = 0.006f;
        this.saldo = 0.0f;
    }
    public boolean depositar(int monto) {//si el deposito falla se retornara falso
        if(monto<0)return false;
        this.saldo += monto;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTA", RUN);
        return true;
    }
    public boolean girar(int monto) {//si el giro falla se retornara falso
        if(this.saldo < monto || monto<0)return false;
        this.saldo -= monto;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTA", RUN);
        return true;        
    }
    //cada vez que se llame esta funcion se restara un 0.6% del saldo total
    public boolean nuevoMes(){
        if(saldo<0)return false;
        this.saldo+=this.saldo*interes;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTA", RUN);
        return true;
    }
    protected float getSaldo() {
        return saldo;
    }
    protected void setSaldo(float saldo){
        this.saldo = saldo;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTA", RUN);
    }
    
}
