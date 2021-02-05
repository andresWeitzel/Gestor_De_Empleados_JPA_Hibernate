/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.gui.utils;

import javax.swing.JOptionPane;
import mypackage.gui.empleados.JFrameIngresoEmpleado;

/**
 *
 * @author andre
 */
public class JFrameValidacionIngreso extends javax.swing.JFrame {

    /** Creates new form JFrameValidacion */
    public JFrameValidacionIngreso() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelContraseña = new javax.swing.JLabel();
        jPasswordContraseña = new javax.swing.JPasswordField();
        jButtonValidar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelTitulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("VALIDACIÓN DE INGRESO");

        jLabelUsuario.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");

        jTextFieldUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabelContraseña.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setText("Contraseña:");

        jPasswordContraseña.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jButtonValidar.setBackground(new java.awt.Color(0, 32, 108));
        jButtonValidar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButtonValidar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonValidar.setText("Validar");
        jButtonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(0, 32, 108));
        jButtonLimpiar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar ");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabelTitulo1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("(Usuario-Contraseña por sector)");

        jDesktopPane1.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelContraseña, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPasswordContraseña, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonValidar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelTitulo1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelTitulo))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelTitulo1))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabelUsuario)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabelContraseña)
                        .addGap(1, 1, 1)
                        .addComponent(jPasswordContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGap(8, 8, 8)
                .addComponent(jLabelTitulo1)
                .addGap(64, 64, 64)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelContraseña))
                    .addComponent(jPasswordContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarActionPerformed
           

        
        if((jTextFieldUsuario.getText().equals("admin")) && (String.valueOf(jPasswordContraseña.getPassword()).equals("empleados"))){

             new  JFrameIngresoEmpleado().setVisible(true);

            dispose();

        }else if((jTextFieldUsuario.getText().equals("admin")) && (String.valueOf(jPasswordContraseña.getPassword()).equals("soporte"))){
            
           //  new  JFrameIngresoEmpleado().setVisible(true);

          //  dispose();
            
        }else{
                 JOptionPane.showMessageDialog(null, "EL USUARIO/CONTRASEÑA ES INVALIDO!");
                 
           
           
                }
        
        
        
        
        
        
        
        
        
//        boolean flagValidacionEntradaEmpleado = true;
//        boolean flagValidacionEntradaSoporteTecnico = true;
//        String flagSector="Ninguno";
//        
//        
//        while( (!(jTextFieldUsuario.getText().equals("admin"))
//                && !(jPasswordContraseña.getPassword().equals("1")) ) ){
//           
//            flagValidacionEntradaEmpleado = false;
//          
//           
//            JOptionPane.showMessageDialog(null, "EL USUARIO/CONTRASEÑA ES INVALIDO!");
//          
//            return;
//        }
//             while( (!(jTextFieldUsuario.getText().equals("admin"))
//                && !(jPasswordContraseña.getPassword().equals("2")) ) ){
//           
//            flagValidacionEntradaSoporteTecnico= false;
//          
//           
//            JOptionPane.showMessageDialog(null, "EL USUARIO/CONTRASEÑA ES INVALIDO!");
//          
//            return;
//        }
//
//        if ( jTextFieldUsuario.getText().equals("admin") ) {
//            
//            new  JFrameIngresoEmpleado().setVisible(true);
//
//            dispose();
//        }
//        else if(flagValidacionEntradaSoporteTecnico){
//           
//            new JFrameIngresoSoporteTecnico().setVisible(true);
//            
//            dispose();
//        }
//         
    }//GEN-LAST:event_jButtonValidarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        
        jTextFieldUsuario.setText("");
        jPasswordContraseña.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameValidacionIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameValidacionIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameValidacionIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameValidacionIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameValidacionIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonValidar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordContraseña;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
