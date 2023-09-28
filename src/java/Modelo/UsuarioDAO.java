package Modelo;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar(String email, String password){
        Usuario us=new Usuario();
        String sql="select * from usuario where email=? and password=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setEmail(rs.getString("email"));
                us.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return us;
    }
    
   }
