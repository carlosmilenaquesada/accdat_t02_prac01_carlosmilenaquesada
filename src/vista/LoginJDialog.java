package vista;

import controlador.Conexion;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class LoginJDialog extends javax.swing.JDialog {

    public LoginJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void CrearConexion() {
        String servidor = /*jTextFieldServidor.getText()*/ "localhost";
        String puerto = /*jTextFieldPuerto.getText()*/ "1521";
        String usuario = /*jTextFieldUsuario.getText()*/ "AD_TEMA02_FICHAJES";
        String password = /*jTextFieldPassword.getText()*/ "AD_TEMA02_FICHAJES";

        boolean camposEscritos = true;

        if (servidor.isEmpty()) {
            camposEscritos = false;
            jTextFieldServidor.setBackground(Defectos.COLOR_ERROR);
        }
        if (puerto.isEmpty()) {
            camposEscritos = false;
            jTextFieldPuerto.setBackground(Defectos.COLOR_ERROR);
        }
        if (usuario.isEmpty()) {
            camposEscritos = false;
            jTextFieldUsuario.setBackground(Defectos.COLOR_ERROR);
        }
        if (password.isEmpty()) {
            camposEscritos = false;
            jTextFieldPassword.setBackground(Defectos.COLOR_ERROR);
        }
        if (camposEscritos == true) {
            Conexion conexion = new Conexion(servidor, puerto, usuario, password);
            if (Conexion.getInstance() != null) {
                //En mi caso el esquema al que me conecto tiene el mismo nombre 
                //que el usuario, pero lo ideal sería pedir tambien el esquema
                //de conexión en el login.
                Defectos.CONEXION_ESQUEMA = usuario;
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha establecido"
                        + " una conexión válida con el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelServidor = new javax.swing.JLabel();
        jTextFieldServidor = new javax.swing.JTextField();
        jLabelPuerto = new javax.swing.JLabel();
        jTextFieldPuerto = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Parámetros de conexión");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabelServidor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelServidor.setText("Servidor:");
        jPanel1.add(jLabelServidor);
        jLabelServidor.setBounds(10, 10, 80, 25);

        jTextFieldServidor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldServidor);
        jTextFieldServidor.setBounds(110, 10, 230, 25);

        jLabelPuerto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPuerto.setText("Puerto:");
        jPanel1.add(jLabelPuerto);
        jLabelPuerto.setBounds(10, 45, 80, 25);

        jTextFieldPuerto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldPuerto);
        jTextFieldPuerto.setBounds(110, 45, 230, 25);

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setText("Usuario:");
        jPanel1.add(jLabelUsuario);
        jLabelUsuario.setBounds(10, 80, 80, 25);

        jTextFieldUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(110, 80, 230, 25);

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPassword.setText("Password:");
        jPanel1.add(jLabelPassword);
        jLabelPassword.setBounds(10, 115, 80, 25);

        jTextFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldPassword);
        jTextFieldPassword.setBounds(110, 115, 230, 25);

        jButtonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAceptar);
        jButtonAceptar.setBounds(10, 150, 100, 25);

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(240, 150, 100, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        CrearConexion();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginJDialog dialog = new LoginJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPuerto;
    private javax.swing.JLabel jLabelServidor;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPuerto;
    private javax.swing.JTextField jTextFieldServidor;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
