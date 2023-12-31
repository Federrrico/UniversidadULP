/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import universidadejemplo.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author federico.acenjo
 */
public class AlumnoData {
    
    private Connection con = null;
     
    
    public AlumnoData() {
       con=Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno) {
        AlumnoData aluD = new AlumnoData();
        Alumno alu2 = aluD.buscarAlumnoPorDni(alumno.getDni(), 0);
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        
        if(alu2 == null){
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                ps.setBoolean(5, true);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    alumno.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Alumno existente");
            }
        } else {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Este alumno fue dado de baja. Desea habilitarlo?");
            if (showConfirmDialog == 0) {
                String sql1 = "UPDATE alumno SET estado= 1 WHERE dni = ?;";
                PreparedStatement ps = null;
                try {
                    ps = con.prepareStatement(sql1);
                    ps.setInt(1, alu2.getDni());
                    ps.executeUpdate();
                    int exito = ps.executeUpdate();

                    if (exito == 1) {
                        JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
                        ps.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
                }
            }
        }
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }   
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni, int est) {
        Alumno alumno = null;
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = " + est;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,dni );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
        
        return alumno;
    }
    
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni= ?, apellido= ?, nombre= ?, fechaNacimiento= ? WHERE idAlumno = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
    }
    
    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado= 0 WHERE idAlumno = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            int exito = ps.executeUpdate();  
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
            ps.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
    }
     
    public void eliminarAlumnoporDni(int dni) {
        String sql = "UPDATE alumno SET estado= 0 WHERE dni = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado Exitosamente.");
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
    }
    
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
        return alumnos;
    }
    
}
