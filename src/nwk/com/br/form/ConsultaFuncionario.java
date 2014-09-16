/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Funcionario;
import nwk.com.br.structures.FuncionarioStru;

/**
 *
 * @author Richard Matheus
 */
public class ConsultaFuncionario extends javax.swing.JDialog {
    
    FuncionarioStru funcionariostru = new FuncionarioStru();
    Funcionario funcionario = new Funcionario();
    cadfuncionarioframe funcionarioframe = new cadfuncionarioframe();
    /**
     * Creates new form ConsultaFuncionario
     */
    public ConsultaFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Carrega os dados na tabela
        atualizaTable();
       
    }
    
    //Carrega os dados na tabela
    private void atualizaTable(){
        TableModel model = (TableModel) (funcionariostru.getTable());
        jTableFuncionarios.setModel(model);
        
        
        
        //Seta as dimensões das colunas
        jTableFuncionarios.getColumnModel().getColumn(0).setMinWidth(35);
        jTableFuncionarios.getColumnModel().getColumn(0).setMaxWidth(35);
        jTableFuncionarios.getColumnModel().getColumn(1).setMinWidth(250);
        jTableFuncionarios.getColumnModel().getColumn(2).setMinWidth(150);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jComboBoxIdNome = new javax.swing.JComboBox();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonInserir = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(594, 535));

        jTableFuncionarios.setAutoCreateRowSorter(true);
        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFuncionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);

        jComboBoxIdNome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome" }));
        jComboBoxIdNome.setToolTipText("");
        jComboBoxIdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIdNomeActionPerformed(evt);
            }
        });

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });

        jButtonInserir.setText("Inserir Funcionario");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        cadfuncionarioframe funcionarioframe = new cadfuncionarioframe();
        funcionarioframe.setLocationRelativeTo(null);
        funcionarioframe.setVisible(true);
        
        atualizaTable();
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        String pesquisaTabela = jTextFieldPesquisar.getText();
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
            for(int r=0;r<jTableFuncionarios.getRowCount();r++){
                
                espacoTabela = jTableFuncionarios.getValueAt(r, c).toString();
                espacoTabela = espacoTabela.toUpperCase();
                
                if(espacoTabela.contains(pesquisaTabela)){
                    jTableFuncionarios.setColumnSelectionInterval(0, 2);  
                    jTableFuncionarios.setRowSelectionInterval(r, r);
                    encontrou = true;
                    break;
                }
            }
        }
        if(encontrou == false){
            JOptionPane.showMessageDialog(null, "Resultado Não Encontrado!");
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jComboBoxIdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIdNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIdNomeActionPerformed

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked
        int linhaSelecionada;
        
        linhaSelecionada = jTableFuncionarios.getSelectedRow();
        
        //Abaixo são setados os campos não obrigatorios
        funcionario.setId(Integer.parseInt(jTableFuncionarios.getValueAt(linhaSelecionada, 0).toString()));
        funcionario.setNome(jTableFuncionarios.getValueAt(linhaSelecionada, 1).toString());
        funcionario.setEmail(jTableFuncionarios.getValueAt(linhaSelecionada, 2).toString());
        funcionario.setTelefone(jTableFuncionarios.getValueAt(linhaSelecionada, 3).toString());
        funcionario.setCpf(jTableFuncionarios.getValueAt(linhaSelecionada, 4).toString());
        funcionario.setDhNascimento(jTableFuncionarios.getValueAt(linhaSelecionada, 5).toString());
        funcionario.setRua(jTableFuncionarios.getValueAt(linhaSelecionada, 7).toString());
        funcionario.setNumero(jTableFuncionarios.getValueAt(linhaSelecionada, 8).toString());
        funcionario.setBairro(jTableFuncionarios.getValueAt(linhaSelecionada, 9).toString());
        funcionario.setCidade(jTableFuncionarios.getValueAt(linhaSelecionada, 11).toString());
        funcionario.setEstado(jTableFuncionarios.getValueAt(linhaSelecionada, 12).toString());
        funcionario.setCep(jTableFuncionarios.getValueAt(linhaSelecionada, 13).toString());
        funcionario.setDhContrato(jTableFuncionarios.getValueAt(linhaSelecionada, 16).toString());
        funcionario.setDhDemissao(jTableFuncionarios.getValueAt(linhaSelecionada, 17).toString());
        funcionario.setStatus(StatusRepository.getByValue(jTableFuncionarios.getValueAt(linhaSelecionada, 19).toString()));
        
        /*Uma vez que os campos obrigatorios podem ser nulos, 
        é necessario checar se eles são, e caso sejam é preciso dar um valor mesmo que em branco para eles*/
      
        //Verifica se o campo Observações na tabela é nulo
        if(jTableFuncionarios.getValueAt(linhaSelecionada, 18) == null){
            funcionario.setObservacoes("");
        }else {
            funcionario.setObservacoes(jTableFuncionarios.getValueAt(linhaSelecionada, 18).toString());
        }
        
        //Verifica se o campo celular na tabela é nulo
        if(jTableFuncionarios.getValueAt(linhaSelecionada, 6) == null){
            funcionario.setCelular("");
        }else {
            funcionario.setCelular(jTableFuncionarios.getValueAt(linhaSelecionada, 6).toString());
        }
        
        //Verifica se o campo complemento na tabela é nulo
        if(jTableFuncionarios.getValueAt(linhaSelecionada, 10) == null){
            funcionario.setComplemento("");
        }else {
            funcionario.setComplemento(jTableFuncionarios.getValueAt(linhaSelecionada, 10).toString());
        }
        
        //Verifica se o campo carteira de trabalho na tabela é nulo
        if(jTableFuncionarios.getValueAt(linhaSelecionada, 14) == null){
            funcionario.setNumcarteiratrab("");
        }else {
            funcionario.setNumcarteiratrab(jTableFuncionarios.getValueAt(linhaSelecionada, 14).toString());
        }
        
        //Verifica se o campo serie de trabalho na tabela é nulo
        if(jTableFuncionarios.getValueAt(linhaSelecionada, 15) == null){
            funcionario.setSeriecarteiratrab("");
        }else {
            funcionario.setSeriecarteiratrab(jTableFuncionarios.getValueAt(linhaSelecionada, 15).toString());
        }
        
        funcionarioframe.setFuncionarioForm(funcionario);
        funcionarioframe.setLocationRelativeTo(null);
        funcionarioframe.setVisible(true);
        
        atualizaTable();
        
        //cadclienteframe.setClienteForm(cliente);
        //cadclienteframe.setLocationRelativeTo(null);
        //cadclienteframe.setVisible(true);
        
        /*Pega os dados do banco de dados para atualizar a tabela
        cliente = clientedao.select(cliente.getId());
        jTableClientes.setValueAt(cliente.getNome(), linhaSelecionada, 1);
        jTableClientes.setValueAt(cliente.getEmail(), linhaSelecionada, 2);
        jTableClientes.setValueAt(cliente.getTelefone(), linhaSelecionada, 3);
        jTableClientes.setValueAt(cliente.getCpf_cnpj(), linhaSelecionada, 4);
        jTableClientes.setValueAt(cliente.getCelular(), linhaSelecionada, 5);
        jTableClientes.setValueAt(cliente.getTipoCliente(), linhaSelecionada, 6);
        jTableClientes.setValueAt(cliente.getRua(), linhaSelecionada, 7);
        jTableClientes.setValueAt(cliente.getNumero(), linhaSelecionada, 8);
        jTableClientes.setValueAt(cliente.getBairro(), linhaSelecionada, 9);
        jTableClientes.setValueAt(cliente.getComplemento(), linhaSelecionada, 10);
        jTableClientes.setValueAt(cliente.getCidade(), linhaSelecionada, 11);
        jTableClientes.setValueAt(cliente.getEstado(), linhaSelecionada, 12);
        jTableClientes.setValueAt(cliente.getCep(), linhaSelecionada, 13);
        jTableClientes.setValueAt(cliente.getStatus().getValue(), linhaSelecionada, 14);
        jTableClientes.setValueAt(cliente.getObservacoes(), linhaSelecionada, 15);
    */
    }//GEN-LAST:event_jTableFuncionariosMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaFuncionario dialog = new ConsultaFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
