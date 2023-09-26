/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Vistas;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.Conexion;
import universidadejemplo.Entidades.Alumno;

/**
 *
 * @author Editor
 */
public class FormularioAlumnos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioAlumnos
     */
    public FormularioAlumnos() {
        initComponents();
    }
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    
//    recibe jdate retorna string
    private String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
        }
    }
    
    private void limpiarCampos() {
        jTDocumento.setText("");
        jTApellido.setText("");
        jTNombre.setText("");
        jRadioButton1.setSelected(false);
        jDateChooser1.setCalendar(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jBuscar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jElimiinar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Documento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 200, -1, -1));

        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 238, -1, -1));

        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 276, -1, -1));

        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 311, -1, -1));
        getContentPane().add(jTDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, 20));
        getContentPane().add(jTApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 150, 20));
        getContentPane().add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 150, 20));
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, 20));

        jLabel6.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 160, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jBNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, 30));

        jElimiinar.setText("Eliminar");
        jElimiinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElimiinarActionPerformed(evt);
            }
        });
        getContentPane().add(jElimiinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, 30));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, 30));

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/Recursos/alumnos.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 258, 186));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/Recursos/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 0, 203, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        Conexion.getConexion();
        AlumnoData a1 = new AlumnoData();
        Alumno al1 = new Alumno();
        String fecha = getFecha(jDateChooser1);
        try{
            if (!jTDocumento.getText().isEmpty() && !jTApellido.getText().isEmpty()
                    && !jTNombre.getText().isEmpty() && jDateChooser1.isEnabled() && jRadioButton1.isSelected()) {
                al1.setDni(Integer.parseInt(jTDocumento.getText()));
                al1.setApellido(jTApellido.getText());
                al1.setNombre(jTNombre.getText());
                al1.setEstado(true);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                al1.setFechaNacimiento(LocalDate.parse(fecha, dtf));
                a1.guardarAlumno(al1);
            } else {
                JOptionPane.showMessageDialog(this, "Tenes que completar todos los campos");
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this,"La fecha no ha sido Ingresada!!");
        }catch(NumberFormatException ex){
             JOptionPane.showMessageDialog(this,"Solo tenes que ingresar numeros");
        }
        limpiarCampos();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jElimiinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElimiinarActionPerformed
        AlumnoData a1 = new AlumnoData();
        try {
            int dni = Integer.parseInt(jTDocumento.getText());
            a1.eliminarAlumnoporDni(dni);
        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Verifique los datos ingresados e intente nuevamente");
        }
        limpiarCampos();
    }//GEN-LAST:event_jElimiinarActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        
        Alumno alu;
        AlumnoData a1 = new AlumnoData();
        
        try {
            int dni=Integer.parseInt(jTDocumento.getText());
            alu = a1.buscarAlumnoPorDni(dni, 1);
            jTApellido.setText(alu.getApellido());
            jTNombre.setText(alu.getNombre());
            jTDocumento.setText(alu.getDni() + "");
            jRadioButton1.setSelected(true);
            jDateChooser1.setDate(Date.valueOf(alu.getFechaNacimiento()));
        }  catch (NullPointerException | NumberFormatException nf){
            jTDocumento.setText("");
            JOptionPane.showMessageDialog(null, "Error al buscar alumno, verifique los datos ingresados");
        }        
    }//GEN-LAST:event_jBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBuscar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JButton jElimiinar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables

}
