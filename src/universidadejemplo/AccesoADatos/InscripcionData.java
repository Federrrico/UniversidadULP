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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.*;
/**
 *
 * @author federico.acenjo
 */
public class InscripcionData {
    private Connection con = null;
    private MateriaData materiaData;
    private AlumnoData alumnoData;

    public InscripcionData() {
        con = Conexion.getConexion();
        materiaData = new MateriaData();
        alumnoData = new AlumnoData();
    }
    
    public void guardarInscripcion(Inscripcion inscripcion) {
        
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getIdMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito.");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscricion "+ex.getMessage());
        }
    }
    
    public Inscripcion buscarInscripcion(int id) {
        Inscripcion inscripcion = null;
        String sql = "SELECT * FROM inscripcion WHERE idInscripto = ? AND estado = 1";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1,id );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                inscripcion=new Inscripcion();
                inscripcion.setIdInscripcion(id);
                inscripcion.setIdAlumno(alumnoData.buscarAlumno(rs.getInt(3)));
                inscripcion.setIdMateria(materiaData.buscarMateria(rs.getInt(4)));
                inscripcion.setNota(rs.getDouble(2));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el inscripcion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        return inscripcion;
    }
    
    public void actualizarNota(int idAlumno, int idMateria, Double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int exito = ps.executeUpdate();    
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Modificada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripcion no existe");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
    }
    
    public List<Inscripcion> listarInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt(1));
                inscripcion.setIdAlumno(alumnoData.buscarAlumno(rs.getInt(3)));
                inscripcion.setIdMateria(materiaData.buscarMateria(rs.getInt(4)));
                inscripcion.setNota(rs.getDouble(2));
                inscripciones.add(inscripcion);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        return inscripciones;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<>();
        
        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMateria AND "
                    + "inscripcion.idAlumno = ? AND materia.estado = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                materias.add(materia);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        return materias;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materias = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1"
                    + " AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                materias.add(materia);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        return materias;
    }
    
    public void borrarInscripcion(int idAlumno, int idMateria){
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?;";

        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int exito = ps.executeUpdate();    
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Eliminada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripcion no existe");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        
    }
       
    public List<Alumno> listarAlumnosPorMateria(int idMateria){
        List<Alumno> alumnosPorMateria = new ArrayList<>();
        
        try {
            String sql = "SELECT i.idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM Inscripcion i,"
                    + " Alumno a WHERE i.idAlumno = a.idAlumno AND "
                    + "i.idMateria = ? AND a.estado = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            Alumno alumno;
            while(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                alumnosPorMateria.add(alumno);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion o Alumno "+ex.getMessage());
        }
        return alumnosPorMateria;
    }
}
