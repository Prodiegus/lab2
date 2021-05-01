/*  Se puede retirar o depositar dinero sin intereces */
public class CuentaCorriente extends Cuenta{
    private float saldo;
    public CuentaCorriente(String nombre, int RUN) {
        super();
        this.saldo = 0f;
    }
    public boolean depositar(int monto) {//si el deposito falla se retornara falso
        if(monto<0)return false;
        this.saldo += monto;
        return true;
    }
    public float getSaldo() {
        return saldo;
    }
    
}
