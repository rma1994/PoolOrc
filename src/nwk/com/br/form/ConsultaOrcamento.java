/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.form;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import nwk.com.br.model.Orcamento;
import nwk.com.br.structures.OrcamentoStru;

/**
 *
 * @author Richard Matheus
 */
public class ConsultaOrcamento extends javax.swing.JDialog {
    //variaveis locais
    private OrcamentoStru orcamentostru = new OrcamentoStru();
    private Orcamento orcamento = new Orcamento();
    private cadorcamentoframe orcamentoframe = new cadorcamentoframe();
    /**
     * Creates new form ConsultaProduto
     */
    public ConsultaOrcamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        atualizaTable();
    }
    
    
    //Carrega os dados na tabela
    private void atualizaTable(){
        TableModel model = (TableModel) (orcamentostru.getTable());
        jTableOrcamento.setModel(model);
        
        //Seta as dimensões das colunas
        jTableOrcamento.getColumnModel().getColumn(0).setMinWidth(35);
        jTableOrcamento.getColumnModel().getColumn(0).setMaxWidth(35);
        jTableOrcamento.getColumnModel().getColumn(1).setMinWidth(250);
        //jTableOrcamento.getColumnModel().getColumn(2).setMinWidth(150);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInserir = new javax.swing.JButton();
        jComboBoxIdNome = new javax.swing.JComboBox();
        jFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrcamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonInserir.setText("Inserir Produto");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jComboBoxIdNome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Descrição" }));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableOrcamento.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableOrcamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrcamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrcamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        cadorcamentoframe orcamentoframe = new cadorcamentoframe();
        orcamentoframe.setLocationRelativeTo(null);
        orcamentoframe.setVisible(true);
        
        atualizaTable();
    }//GEN-LAST:event_jButtonInserirActionPerformed

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
            for(int r=0;r<jTableOrcamento.getRowCount();r++){
                
                espacoTabela = jTableOrcamento.getValueAt(r, c).toString();
                espacoTabela = espacoTabela.toUpperCase();
                
                if(espacoTabela.contains(pesquisaTabela)){
                    jTableOrcamento.setColumnSelectionInterval(0, 2);  
                    jTableOrcamento.setRowSelectionInterval(r, r);
                    encontrou = true;
                    break;
                }
            }
        }
        if(encontrou == false){
            JOptionPane.showMessageDialog(null, "Resultado Não Encontrado!");
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrcamentoMouseClicked
        int linhaSelecionada;
        
        linhaSelecionada = jTableOrcamento.getSelectedRow();
        
        orcamento.setId(Integer.parseInt(jTableOrcamento.getValueAt(linhaSelecionada, 0).toString()));//converte objeto para string e depois para int
        orcamento.setNomeCliente(jTableOrcamento.getValueAt(linhaSelecionada, 1).toString());
        orcamento.setDhOrcamento(jTableOrcamento.getValueAt(linhaSelecionada, 2).toString());
        orcamento.setTotal(jTableOrcamento.getValueAt(linhaSelecionada, 3).toString());
        orcamento.setIdFuncionario(jTableOrcamento.getValueAt(linhaSelecionada, 4).toString() + "-");//Esse - serve para indicar o final do index usada em Produto
        orcamento.setIdCliente(Integer.parseInt(jTableOrcamento.getValueAt(linhaSelecionada, 5).toString()));//converte objeto para string e depois para int
        orcamento.setSubTotal(jTableOrcamento.getValueAt(linhaSelecionada, 6).toString());
        orcamento.setFormaPagamento(jTableOrcamento.getValueAt(linhaSelecionada, 7).toString());
        orcamento.setDesconto(jTableOrcamento.getValueAt(linhaSelecionada, 8).toString());
        
        /*Uma vez que os campos obrigatorios podem ser nulos, 
        é necessario checar se eles são, e caso sejam é preciso dar um valor mesmo que em branco para eles*/
         
        //Verifica se o campo OBSERVAÇÕES na tabela é nulo
        if(jTableOrcamento.getValueAt(linhaSelecionada, 9) == null){
            orcamento.setObservacoes("");
        }else {
            orcamento.setObservacoes(jTableOrcamento.getValueAt(linhaSelecionada, 9).toString());
        }
        
        orcamentoframe.setOrcamentoForm(orcamento);
        orcamentoframe.setLocationRelativeTo(null);
        orcamentoframe.setVisible(true);
        
        atualizaTable();
    }//GEN-LAST:event_jTableOrcamentoMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaOrcamento dialog = new ConsultaOrcamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxIdNome;
    private javax.swing.JTextField jFieldPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrcamento;
    // End of variables declaration//GEN-END:variables
}