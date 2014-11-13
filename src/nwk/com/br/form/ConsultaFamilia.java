/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import nwk.com.br.model.Familia;
import nwk.com.br.structures.FamiliaStru;

/**
 *
 * @author Richard Matheus
 */
public class ConsultaFamilia extends javax.swing.JDialog {
    FamiliaStru familiastru = new FamiliaStru();
    Familia familia = new Familia();
    CadFamilia cadfamilia = new CadFamilia(null,true);
    
    /**
     * Creates new form ConsultaFamilia
     */
    public ConsultaFamilia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTable();
    }
    
    //Carrega os dados na tabela
    private void atualizaTable(){
        TableModel model = (TableModel) (familiastru.getTable());
        jTableFamilia.setModel(model);
        
        //Seta as dimensões das colunas
        jTableFamilia.getColumnModel().getColumn(0).setMinWidth(35);
        jTableFamilia.getColumnModel().getColumn(0).setMaxWidth(35);
        jTableFamilia.getColumnModel().getColumn(1).setPreferredWidth(463);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBoxIdNome = new javax.swing.JComboBox();
        jFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFamilia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Familia");

        jButton1.setText("Inserir Familia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxIdNome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome" }));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableFamilia.setAutoCreateRowSorter(true);
        jTableFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFamilia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableFamilia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFamiliaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFamilia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        String pesquisaTabela = jFieldPesquisa.getText();
        String espacoTabela;
        int c;
        boolean encontrou = false;
        
        pesquisaTabela = pesquisaTabela.toUpperCase();
        //Pega o tamanho da tabela e a coluna que devera ser pesquisada
        if(pesquisaTabela.length()>=1){
            if(jComboBoxIdNome.getSelectedItem().toString() == "ID"){
                c = 0;
            }else{
                c = 1;
            }
            //Percorre os campos da tabela e procura pelos itens que contenham os parametros de pesquisa em seu nome
            for(int r=0;r<jTableFamilia.getRowCount();r++){
                
                //Converte os valores para maiusculo
                espacoTabela = jTableFamilia.getValueAt(r, c).toString();
                espacoTabela = espacoTabela.toUpperCase();
                
                if(espacoTabela.contains(pesquisaTabela)){
                    //Seleciona a linha em questão
                    jTableFamilia.setColumnSelectionInterval(0, 1);  
                    jTableFamilia.setRowSelectionInterval(r, r);
                    encontrou = true;
                    break;
                }
            }
        }
        //Caso não encontre o resutlado, retorna essa mensagem para o usuario
        if(encontrou == false){
            JOptionPane.showMessageDialog(null, "Resultado Não Encontrado!");
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadFamilia cadfamilia = new CadFamilia(null, true);
        cadfamilia.setLocationRelativeTo(null);
        cadfamilia.setVisible(true);
        
        atualizaTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableFamiliaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFamiliaMouseClicked
        int linhaSelecionada;
        
        linhaSelecionada = jTableFamilia.getSelectedRow();
        
        //Abaixo são setados os campos não obrigatorios
        familia.setId(Integer.parseInt(jTableFamilia.getValueAt(linhaSelecionada, 0).toString()));
        familia.setDescricao(jTableFamilia.getValueAt(linhaSelecionada, 1).toString());
        familia.setInserOrUpd("update");
        
        cadfamilia.setFamiliaForm(familia);
        cadfamilia.setLocationRelativeTo(null);
        cadfamilia.setVisible(true);
        
        atualizaTable();
    }//GEN-LAST:event_jTableFamiliaMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaFamilia dialog = new ConsultaFamilia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxIdNome;
    private javax.swing.JTextField jFieldPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFamilia;
    // End of variables declaration//GEN-END:variables
}
