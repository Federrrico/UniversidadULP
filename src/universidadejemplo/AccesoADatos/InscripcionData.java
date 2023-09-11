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
    }
    
    public void guardarInscripcion(Inscripcion inscripcion) {
        
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getIdMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito.");
            }
            ps.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscricion "+ex.getMessage());
        }
    }
    
    
}
