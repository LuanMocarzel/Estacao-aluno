
import javax.swing.JOptionPane;
import java.sql.*;

public class Matricula extends javax.swing.JDialog {

    Cliente cliente = new Cliente();
    ClienteDAO clientedao = new ClienteDAO();
    public Matricula() {
    initComponents();
    }
    
    public Matricula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntSalvar = new javax.swing.JButton();
        txtMat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        bntConsultar = new javax.swing.JButton();
        bntExcluir = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(bntSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 100, -1));

        txtMat.setBackground(new java.awt.Color(204, 204, 204));
        txtMat.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        txtMat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatActionPerformed(evt);
            }
        });
        getContentPane().add(txtMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 250, 40));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel5.setText("Matricula:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 88, 40));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel7.setText("Email:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 40));

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel10.setText("Nome:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 60, 40));

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 250, 40));

        txtNome.setBackground(new java.awt.Color(204, 204, 204));
        txtNome.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 250, 40));

        bntConsultar.setText("Consultar");
        bntConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(bntConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 100, -1));

        bntExcluir.setText("Excluir");
        bntExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(bntExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 100, -1));

        bntSair.setText("Sair");
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });
        getContentPane().add(bntSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/matricula.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        try {
        Salvar_Dados();
        } catch(Exception ex) {
        }
        }
        private boolean validaCamposObrigatorios() {
        return (txtNome.getText().equals("") || txtEmail.getText().equals(""));
        }
        private void Salvar_Dados() throws Exception{

        if(validaCamposObrigatorios()) {
        JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de gravar!!");
        } else {
        try {
        cliente.setMat(txtMat.getText());
        cliente.setNome(txtNome.getText());
        cliente.setEmail(txtEmail.getText());

        clientedao.adicionar(cliente);

        txtMat.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Erro aos salvar os dados" + e.toString());
        }
        }

    }//GEN-LAST:event_bntSalvarActionPerformed

    private void txtMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void bntConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntConsultarActionPerformed

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntExcluirActionPerformed

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        this.dispose();
        JOptionPane.showMessageDialog(null, "SISTEMA FECHADO!!!");
    }//GEN-LAST:event_bntSairActionPerformed

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
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Matricula dialog = new Matricula(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntConsultar;
    private javax.swing.JButton bntExcluir;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton bntSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
