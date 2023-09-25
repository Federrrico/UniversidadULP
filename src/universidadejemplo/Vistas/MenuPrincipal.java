/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Vistas;


import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setTitle("Alumnos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAlumnos = new javax.swing.JMenu();
        jMIFormularioAlumnos = new javax.swing.JMenuItem();
        jMMateria = new javax.swing.JMenu();
        jMIFormMateria = new javax.swing.JMenuItem();
        jMAdministracion = new javax.swing.JMenu();
        jMIManejo = new javax.swing.JMenuItem();
        jMIManipulacion = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMIAlumnosMa = new javax.swing.JMenuItem();
        jMSalir = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jEscritorioLayout = new javax.swing.GroupLayout(jEscritorio);
        jEscritorio.setLayout(jEscritorioLayout);
        jEscritorioLayout.setHorizontalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        jEscritorioLayout.setVerticalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        jMAlumnos.setText("Alumnos");

        jMIFormularioAlumnos.setText("Formulario de Alumnos");
        jMIFormularioAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFormularioAlumnosActionPerformed(evt);
            }
        });
        jMAlumnos.add(jMIFormularioAlumnos);

        jMenuBar1.add(jMAlumnos);

        jMMateria.setText("Materia");

        jMIFormMateria.setText("Formulario de Materias");
        jMIFormMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFormMateriaActionPerformed(evt);
            }
        });
        jMMateria.add(jMIFormMateria);

        jMenuBar1.add(jMMateria);

        jMAdministracion.setText("Administracion");

        jMIManejo.setText("Manejo de Inscripciones");
        jMIManejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIManejoActionPerformed(evt);
            }
        });
        jMAdministracion.add(jMIManejo);

        jMIManipulacion.setText("Manipulacion de Notas");
        jMIManipulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIManipulacionActionPerformed(evt);
            }
        });
        jMAdministracion.add(jMIManipulacion);

        jMenuBar1.add(jMAdministracion);

        jMConsultas.setText("Consultas");

        jMIAlumnosMa.setText("Alumnos por Materia");
        jMIAlumnosMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAlumnosMaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMIAlumnosMa);

        jMenuBar1.add(jMConsultas);

        jMSalir.setText("Salir");
        jMSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIFormularioAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFormularioAlumnosActionPerformed
       jEscritorio.removeAll();
        jEscritorio.repaint();
        FormularioAlumnos fA = new FormularioAlumnos();
        fA.setVisible(true);
        jEscritorio.add(fA);
        jEscritorio.moveToFront(fA);
    }//GEN-LAST:event_jMIFormularioAlumnosActionPerformed

    private void jMIFormMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFormMateriaActionPerformed
        jEscritorio.removeAll();
        jEscritorio.repaint();
        FormularioMateria fA = new FormularioMateria();
        fA.setVisible(true);
        jEscritorio.add(fA);
        jEscritorio.moveToFront(fA);
    }//GEN-LAST:event_jMIFormMateriaActionPerformed

    private void jMIManejoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIManejoActionPerformed
        jEscritorio.removeAll();
        jEscritorio.repaint();
        FormularioInscripcion fA = new FormularioInscripcion();
        fA.setVisible(true);
        jEscritorio.add(fA);
        jEscritorio.moveToFront(fA);
    }//GEN-LAST:event_jMIManejoActionPerformed

    private void jMIManipulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIManipulacionActionPerformed
        jEscritorio.removeAll();
        jEscritorio.repaint();
        CargaDeNotas fA = new CargaDeNotas();
        fA.setVisible(true);
        jEscritorio.add(fA);
        jEscritorio.moveToFront(fA);
    }//GEN-LAST:event_jMIManipulacionActionPerformed

    private void jMIAlumnosMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAlumnosMaActionPerformed
        jEscritorio.removeAll();
        jEscritorio.repaint();
        ConsultaAlumnosPorMateria fA = new ConsultaAlumnosPorMateria();
        fA.setVisible(true);
        jEscritorio.add(fA);
        jEscritorio.moveToFront(fA);
    }//GEN-LAST:event_jMIAlumnosMaActionPerformed

    private void jMSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSalirMouseClicked
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir?");
        if(showConfirmDialog == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jMSalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jEscritorio;
    private javax.swing.JMenu jMAdministracion;
    private javax.swing.JMenu jMAlumnos;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenuItem jMIAlumnosMa;
    private javax.swing.JMenuItem jMIFormMateria;
    private javax.swing.JMenuItem jMIFormularioAlumnos;
    private javax.swing.JMenuItem jMIManejo;
    private javax.swing.JMenuItem jMIManipulacion;
    private javax.swing.JMenu jMMateria;
    private javax.swing.JMenu jMSalir;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
