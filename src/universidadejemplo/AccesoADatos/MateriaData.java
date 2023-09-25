/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import universidadejemplo.Entidades.Materia;
/**
 *
 * @author federico.acenjo
 */
public class MateriaData {
    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        MateriaData matD = new MateriaData();        
        Materia mat = matD.buscarMateriaEliminada(materia.getNombre());
        String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
        String sql2 = "UPDATE materia SET estado= 1 WHERE nombre = ?;";
        
        if (mat == null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, materia.getNombre());
                ps.setInt(2, materia.getAño());
                ps.setBoolean(3, materia.isEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    materia.setIdMateria(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Materia añadida con exito con ID: " + materia.getIdMateria());
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
            }
        }else {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "La materia " + mat.toString() + " fue dada de baja \n "
                    + "Desea habilitarla nuevamente?");

            if (showConfirmDialog == 0) {
                try {
                    PreparedStatement ps = con.prepareStatement(sql2);
                    ps.setString(1, materia.getNombre());
                    int exito = ps.executeUpdate();
                    if (exito == 1) {
                        JOptionPane.showMessageDialog(null, "Se actualizo estado de Materia" + mat.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "La materia no existe");
                    }
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
                }
            }
        }
    }
    
    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT nombre, año FROM materia WHERE idMateria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id );           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }
        return materia;
    }
    
    public Materia buscarMateriaEliminada(String nombre) {
        Materia materia = null;
        String sql = "SELECT idMateria, nombre, año FROM materia WHERE nombre = ? AND estado = 0";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,nombre );           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }
        return materia;
    }
    
    
    
    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre= ?, año= ? WHERE idMateria = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }
    }
    
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado= 0 WHERE idMateria = ? ;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            int exito = ps.executeUpdate();            

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Eliminada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }
    }
    
    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                materias.add(materia);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }
        return materias;
    }
    
    
}
