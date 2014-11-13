/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import nwk.com.br.dao.SimilarDAO;
import nwk.com.br.documents.ControleTexto;
import nwk.com.br.documents.ControleTextoId;
import nwk.com.br.model.Similar;

/**
 *
 * @author Richard Matheus
 */
public class CadSimilar extends javax.swing.JDialog {
    //Variaveis
    private Similar similar = new Similar();
    private SimilarDAO similardao = new SimilarDAO();
    
    /**
     * Creates new form CadSimilar
     */
    public CadSimilar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setCamposTexto(); // Modifica os caracteres aceitos nos campos de texto
        
        setIdSimilar();
    }
    
    
    //Define os caracteres validos nos campos de texto
    private void setCamposTexto(){
        jFieldDescricao.setDocument(new ControleTexto(100));
        
        jFieldId.setDocument(new ControleTextoId());
    }
    
    //Seta o id de similar
    private void setIdSimilar(){
        int similarID;
        String id;
        
        similarID = (similardao.checarID()); //checa o ultimo ID do funcionario
        id = Integer.toString(similarID); // transforma esse Id em String
        jFieldId.setText(id); //coloca esse id no campo jFieldidCadFuncionario
    }
    
    
    //Seta os campos de familia de acordo com o input de ConsultaFamilia
    public void setFamiliaForm(Similar similar){
        jFieldId.setText(Integer.toString(similar.getId()));
        jFieldDescricao.setText(similar.getDescricao());
        
        this.similar.setInserOrUpd(similar.getInserOrUpd());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFieldId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jFieldDescricao = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Similar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Similar"));

        jLabel1.setText("ID :");

        jLabel2.setText("Descrição :");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jFieldDescricao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(231, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(40, Short.MAX_VALUE))
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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        //Altera as mensagens da caixa de confirmação para Sim ou Não
        UIManager.put("OptionPane.yesButtonText", "Sim");  
        UIManager.put("OptionPane.noButtonText", "Não");
        
        //Mostra uma caixa de confirmação se o usuario deseja mesmo sair
        switch(JOptionPane.showConfirmDialog(null, "Deseja Mesmo Sair?", "Confirma" ,JOptionPane.YES_NO_OPTION)){
            case 0:
                setVisible(false);
                dispose();
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        String descricao = jFieldDescricao.getText();
        
        similar.setId(Integer.parseInt(jFieldId.getText()));
        similar.setDescricao(descricao);
        
        if(!descricao.equals("")){
            if(similar.getInserOrUpd() == null){
                
                //Tenta inserir os dados pelo formulario no banco de dados
                boolean funcionarioresult = similardao.inserir(similar);
                if(funcionarioresult == true){
                    JOptionPane.showMessageDialog(null, "Similar Inserido Com Sucesso!");
                    this.dispose();
                }
            }else if(similar.getInserOrUpd().equals("update")){
                
                //Tenta ATUALIZAR os dados pelo formulario no banco de dados
                boolean funcionarioresult = similardao.atualizar(similar);
                if(funcionarioresult == true){
                    JOptionPane.showMessageDialog(null, "Similar Atualizado Com Sucesso!");
                    this.dispose();
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "Campo Descrição em Branco!");
        }
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
            java.util.logging.Logger.getLogger(CadSimilar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadSimilar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadSimilar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadSimilar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadSimilar dialog = new CadSimilar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JTextField jFieldDescricao;
    private javax.swing.JTextField jFieldId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
