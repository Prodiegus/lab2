/* No se pued edepositar ni girar dinero, solo se puede cerrar de ser cerrado el dinero pasa a formar parte de la cuenta corriente */
public class CDT extends Cuenta{
    private float saldo;
    private int contadorDepositos;
    public CDT(String nombre, int RUN) {
        super();
        this.contadorDepositos = 0;
        this.saldo = 0f;
    }
    /*  
     * El contador de depositos se encarga de que el saldo solo pueda cambiar una vez
     * ademas la unica manera de cambiar el saldo es por medio de este metodo
     * ya que saldo es un atrivuto privado.
     */
    public boolean depositar(int monto) {
        if(monto<0 && contadorDepositos>0)return false;
        this.saldo += monto;
        this.contadorDepositos++;
        return true;
    }
    public float getSaldo() {
        return saldo;
    }
}
