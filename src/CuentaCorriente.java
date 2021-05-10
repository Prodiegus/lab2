/*  Se puede retirar o depositar dinero sin intereces */
public class CuentaCorriente extends Cuenta{
    private float saldo;
    public CuentaCorriente(String nombre, int RUN) {
        super(RUN);
        this.saldo = 0f;
    }
    public boolean depositar(int monto) {//si el deposito falla se retornara falso
        if(monto<0)return false;
        this.saldo += monto;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTC", RUN);
        return true;
    }
    public boolean girar(int monto) {//si el giro falla se retornara falso
        if(this.saldo < monto || monto<0)return false;
        this.saldo -= monto;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTC", RUN);
        return true;        
    }
    protected float getSaldo() {
        return saldo;
    }
    protected void setSaldo(float saldo){
        this.saldo = saldo;
        BD bd = new BD();
        bd.modificarSaldo(this.saldo, "saldoCTC", RUN);
    }
}
