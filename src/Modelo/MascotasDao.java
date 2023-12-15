
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotasDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarMascotas(Mascotas mas){
        String sql = "INSERT INTO mascota (codigo, nombre, sexo, stock, tamaño, peso) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mas.getCodigo());
            ps.setString(2, mas.getNombre());
            ps.setString(3, mas.getSexo());
            ps.setInt(4, mas.getStock());
            ps.setInt(5, mas.getTamaño());
            ps.setInt(6, mas.getPeso());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            }catch (SQLException e) {
                System.out.println(e.toString());
            }
            
        }
    }

    public List ListarMascotas(){
        List<Mascotas> ListarMas = new ArrayList();
        String sql = "SELECT * FROM mascota";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascotas mas = new Mascotas();
                mas.setId(rs.getInt("id"));
                mas.setCodigo(rs.getString("Codigo"));
                mas.setNombre(rs.getString("Nombre"));
                mas.setSexo(rs.getString("Sexo"));
                mas.setStock(rs.getInt("Stock"));
                mas.setTamaño(rs.getInt("Tamaño"));
                mas.setPeso(rs.getInt("Peso"));
                ListarMas.add(mas);
            }
        }catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListarMas;
    }
    
    public boolean EliminarMascotas(int id){
        String sql ="DELETE FROM mascota where ID = ?";
        try {
            ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}