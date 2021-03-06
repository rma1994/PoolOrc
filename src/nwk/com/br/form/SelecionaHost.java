/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.form;

import javax.swing.JOptionPane;
import nwk.com.br.files.LerEscreverIpServer;



/**
 *
 * @author Richard Matheus
 */
public class SelecionaHost extends ModeloJDialog {
    LerEscreverIpServer leserver = new LerEscreverIpServer();
    /**
     * Creates new form SelecionaHost
     */
    public SelecionaHost(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jRadioLocal.setSelected(true);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupHost = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioLocal = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioRemoto = new javax.swing.JRadioButton();
        jTextFieldIp = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Local do Banco de Dados");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Local do Banco de Dados"));

        buttonGroupHost.add(jRadioLocal);
        jRadioLocal.setText("Local");
        jRadioLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioLocalActionPerformed(evt);
            }
        });

        jLabel3.setText("(Este computador é o servidor)");

        buttonGroupHost.add(jRadioRemoto);
        jRadioRemoto.setText("Remoto");
        jRadioRemoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRemotoActionPerformed(evt);
            }
        });

        jTextFieldIp.setEditable(false);
        jTextFieldIp.setText("IP Do Servidor");
        jTextFieldIp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIpFocusGained(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancela");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText(" (Este computador acessa um servidor remoto)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioRemoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTextFieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioLocal)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioRemoto)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioRemotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioRemotoActionPerformed
        jTextFieldIp.setEditable(true);
    }//GEN-LAST:event_jRadioRemotoActionPerformed

    private void jRadioLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioLocalActionPerformed
        jTextFieldIp.setEditable(false);
    }//GEN-LAST:event_jRadioLocalActionPerformed

    private void jTextFieldIpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIpFocusGained
        //Verifica se é o texto padrao que esta na caixa, se for, apaga ele
        if(jTextFieldIp.getText().equals("IP Do Servidor") && jRadioRemoto.isSelected()){
            jTextFieldIp.setText(null);
        }
    }//GEN-LAST:event_jTextFieldIpFocusGained

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        //Se o radio button Local for selecionado, envia como parametro ' locahost ' para a classe lerescrever        
        //Se for o Remoto, manda o conteudo da caixa jTextFieldIp
        
        if(jRadioLocal.isSelected()){
            try{
                leserver.setIp("localhost");
                JOptionPane.showMessageDialog(null, "Gravação Feita Com sucesso\nPara que as alterações tenham efeito, reinicie o programa");
            }catch(Exception e){
                System.out.println("Erro ao tentar gravar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
            }
            
        } else if(jRadioRemoto.isSelected()){
            try{
                leserver.setIp(jTextFieldIp.getText());
                JOptionPane.showMessageDialog(null, "Gravação Feita Com sucesso\nPara que as alterações tenham efeito, reinicie o programa");
            }catch(Exception e){
                System.out.println("Erro ao tentar gravar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
            }
        }
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecionaHost dialog = new SelecionaHost(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroupHost;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioLocal;
    private javax.swing.JRadioButton jRadioRemoto;
    private javax.swing.JTextField jTextFieldIp;
    // End of variables declaration//GEN-END:variables
}
