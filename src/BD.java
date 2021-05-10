import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//esta clase sera usada para administrar la base de datos
public class BD {
    BD(){}
    public boolean add(String nombre,int RUN){
        try {
            //establesemos coneccion con la base de datos 
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas_banco", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into cuentas values(?,?,?,?,?)");
            //se manda el nombre y el rut
            pst.setString(1, nombre.trim());
            pst.setInt(2, RUN);
            //se manda el saldo de las cuentas en 0
            pst.setInt(3, 0);
            pst.setInt(4, 0);
            pst.setInt(5, 0);
            //le indicamos a la base de tados la actualizacion
            pst.executeUpdate();
            //cerramos objetos
            cn.close();pst.close();
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
            return false;
        }
        return true;
    }
    public Cuenta search(int RUN){
        try {
            //establesemos coneccion con la base de datos 
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas_banco", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from cuentas where RUN ="+RUN);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("Nombre");
                Cuenta cuenta = new Cuenta(nombre, RUN);
                cuenta.CtaAhorros.setSaldo(rs.getFloat(4));
                cuenta.CtaCorriente.setSaldo(rs.getFloat(5));
                if(rs.getFloat(3)>0){
                    cuenta.cdt.depositar(rs.getFloat(3));
                }
                cn.close();pst.close();
                return cuenta;
            }
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
        }
        return null;
    }
    public void modificarSaldo(float monto, String cta, int RUN){
        try {
            //establesemos coneccion con la base de datos 
            String mysql = "update cuentas set "+cta+" = "+monto+" where RUN = "+RUN;
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas_banco", "root", "");
            PreparedStatement pst = cn.prepareStatement(mysql);
            pst.executeUpdate();
            cn.close();pst.close();
            //cerramos objetos
            cn.close();pst.close();
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
            //return null;
        }
    }
    public void tiempoMeses(){
        try {
            //establesemos coneccion con la base de datos 
            String mysql = "update cuentas set saldoCTA = round(saldoCTA+saldoCTA*0.006, 2)";
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas_banco", "root", "");
            PreparedStatement pst = cn.prepareStatement(mysql);
            pst.executeUpdate();
            cn.close();pst.close();
            //cerramos objetos
            cn.close();pst.close();
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
            //return null;
        }
    }
    public void delete(int RUN) {
        try {
            //establesemos coneccion con la base de datos 
            String mysql = "delete from cuentas where RUN ="+RUN;
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas_banco", "root", "");
            PreparedStatement pst = cn.prepareStatement(mysql);
            pst.executeUpdate();
            cn.close();pst.close();
            //cerramos objetos
            cn.close();pst.close();
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
            //return null;
        }
        
    }
}
