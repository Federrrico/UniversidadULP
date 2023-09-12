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
//        PreparedStatement ps = null;
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
    
    public void modificarInscripcion(Inscripcion inscripcion) {
        String sql = "UPDATE inscripcion SET nota = ?, idAlumno= ?, idMAteria= ? WHERE idInscripto = ?;";
//        PreparedStatement ps = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getIdMateria().getIdMateria());
            int exito = ps.executeUpdate();    
            if (exito == 1) {
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
        List<Inscripcion> inscripcions = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM inscripcion WHERE estado = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt(1));
                inscripcion.setIdAlumno(alumnoData.buscarAlumno(rs.getInt(3)));
                inscripcion.setIdMateria(materiaData.buscarMateria(rs.getInt(4)));
                inscripcion.setNota(rs.getDouble(2));
                inscripcions.add(inscripcion);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion "+ex.getMessage());
        }
        return inscripcions;
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
        List<Materia> materiasC = new ArrayList<>(obtenerMateriasCursadas(id));
        List<Materia> materias = new ArrayList<>(materiaData.listarMaterias());
       
        materias.removeAll(materiasC);
               
        return materias;
    }
    
     
       
    
}
