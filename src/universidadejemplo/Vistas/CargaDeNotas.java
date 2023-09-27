/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;

/**
 *
 * @author Editor
 */
public class CargaDeNotas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return columnIndex == 2;
        }
    };
   
    /**
     * Creates new form CargaDeNotas
     */
    public CargaDeNotas() {
        initComponents();
        setTitle("Carga de Notas");
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("NOTA");
        jTMaterias.setModel(modelo);
    }
    
    private void borrarFilas(){
        int f = modelo.getRowCount() - 1;
        for (;f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
    
    private void cargarTabla(){
        borrarFilas();
        modelo.isCellEditable(jTMaterias.getSelectedRow(), 2);

        int i = 0;
        Alumno al1 = (Alumno) jCBAlumnos.getSelectedItem();

        InscripcionData ida = new InscripcionData();

        try {
            List<Inscripcion> inscripciones = new ArrayList<>(ida.listarInscripciones());
            List<Materia> materias = new ArrayList<>(ida.obtenerMateriasCursadas(al1.getIdAlumno()));
            
            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getIdAlumno().getIdAlumno() == al1.getIdAlumno()
                        && inscripcion.getIdMateria().getIdMateria() == materias.get(i).getIdMateria()) {
                    modelo.addRow(new Object[]{materias.get(i).getIdMateria(), materias.get(i).getNombre(),
                        inscripcion.getNota()});
                    i++;
                }
            }
        } catch (NullPointerException ex) {
            return;
        }
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
        jCBAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(470, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Seleccione un alumno:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        jCBAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBAlumnosItemStateChanged(evt);
            }
        });
        jCBAlumnos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBAlumnosPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(jCBAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 190, 270, 30));

        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTMaterias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 410, 107));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("     NOTAS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/Recursos/alumnos.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 254, 163));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadejemplo/Recursos/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 0, 190, 163));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBAlumnosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBAlumnosPopupMenuWillBecomeVisible
        AlumnoData a1 = new AlumnoData();
        Alumno al1 = new Alumno();
        
        jCBAlumnos.removeAllItems();
        
        jCBAlumnos.addItem(null);
        
        for (Alumno alumno : a1.listarAlumnos()) {
            jCBAlumnos.addItem(alumno);
        }
    }//GEN-LAST:event_jCBAlumnosPopupMenuWillBecomeVisible

    private void jCBAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBAlumnosItemStateChanged
        cargarTabla();
    }//GEN-LAST:event_jCBAlumnosItemStateChanged

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        InscripcionData insData = new InscripcionData();
        modelo.isCellEditable(jTMaterias.getSelectedRow(), 2);
        try {
            if (Double.parseDouble(modelo.getValueAt(jTMaterias.getSelectedRow(), 2).toString()) > 10 || Double.parseDouble(modelo.getValueAt(jTMaterias.getSelectedRow(), 2).toString()) < 0) {
                JOptionPane.showMessageDialog(this, "La nota debe estar entre 0 y 10");
                cargarTabla();
            } else {
                int matId = Integer.parseInt(modelo.getValueAt(jTMaterias.getSelectedRow(), 0).toString());
                Double nota = Double.parseDouble(modelo.getValueAt(jTMaterias.getSelectedRow(), 2).toString());
                Alumno alu = (Alumno) jCBAlumnos.getSelectedItem();
                int aluId = alu.getIdAlumno();
                insData.actualizarNota(aluId, matId, nota);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Seleccione una opcion para modificar la nota");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Las notas deben ser numeradas");
            cargarTabla();
        }
    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables
}
