/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

//import javax.swing.table.*;
import javax.swing.JOptionPane;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Cliente;
import nwk.com.br.dao.ClienteDAO;
/**
 *
 * @author Richard Matheus
 */
public class ConsultaCliente extends javax.swing.JDialog {
    
    cadclienteframe cadclienteframe = new cadclienteframe();
    Cliente cliente = new Cliente();
    ClienteDAO clientedao = new ClienteDAO();
    /**
     * Creates new form ConsultaCliente
     */
    public ConsultaCliente() {
        initComponents();
        this.setModal(true);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonInserir = new javax.swing.JButton();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Clientes");
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jTableClientes.setAutoCreateRowSorter(true);
        jTableClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList, jTableClientes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idCliente}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeCliente}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${emailCliente}"));
        columnBinding.setColumnName("e-mail");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefoneCliente}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpfCnpjCliente}"));
        columnBinding.setColumnName("CPF/CNPJ");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${celularCliente}"));
        columnBinding.setColumnName("Celular");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoCliente}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ruaCliente}"));
        columnBinding.setColumnName("Rua");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroEndCliente}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bairroCliente}"));
        columnBinding.setColumnName("Bairro");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${complementoCliente}"));
        columnBinding.setColumnName("Complemento");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cidadeCliente}"));
        columnBinding.setColumnName("Cidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estadoCliente}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cepCliente}"));
        columnBinding.setColumnName("CEP");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ativoCliente}"));
        columnBinding.setColumnName("Ativo");
        columnBinding.setColumnClass(Character.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${observacoesCliente}"));
        columnBinding.setColumnName("Observações");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(0).setMinWidth(35);
            jTableClientes.getColumnModel().getColumn(0).setMaxWidth(35);
            jTableClientes.getColumnModel().getColumn(1).setMinWidth(250);
            jTableClientes.getColumnModel().getColumn(2).setMinWidth(150);
        }

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonInserir.setText("Inserir Cliente");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jComboBoxCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar)
                            .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        // TODO add your handling code here:
        cadclienteframe cadclienteframe = new cadclienteframe();
        cadclienteframe.setLocationRelativeTo(null);
        cadclienteframe.setVisible(true);
        dispose();
        cadclienteframe.reabrir();
        
        //TableModel model = (TableModel) (jTableClientes.getModel());
        //String [] valores = {Integer.toString(cliente.getId()),cliente.getNome()};
        //model.
        
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        String pesquisaTabela = jFieldPesquisa.getText();
        String espacoTabela;
        int c;
        boolean encontrou = false;
        
        pesquisaTabela = pesquisaTabela.toUpperCase();
        //Pega o tamanho da tabela e a coluna que devera ser pesquisada
        if(pesquisaTabela.length()>=1){
            if(jComboBoxCampoPesquisa.getSelectedItem().toString() == "ID"){
                c = 0;
            }else{
                c = 1;
            }
            //Percorre os campos da tabela e procura pelos itens que contenham os parametros de pesquisa em seu nome
            for(int r=0;r<jTableClientes.getRowCount();r++){
                
                espacoTabela = jTableClientes.getValueAt(r, c).toString();
                espacoTabela = espacoTabela.toUpperCase();
                
                if(espacoTabela.contains(pesquisaTabela)){
                    jTableClientes.setColumnSelectionInterval(0, 2);  
                    jTableClientes.setRowSelectionInterval(r, r);
                    encontrou = true;
                    break;
                }
            }
            if(encontrou == false){
                JOptionPane.showMessageDialog(null, "Resultado Não Encontrado!");
            }
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int linhaSelecionada;
        
        
        linhaSelecionada = jTableClientes.getSelectedRow();
        
        //Abaixo são setados os campos não obrigatorios
        cliente.setId(Integer.parseInt(jTableClientes.getValueAt(linhaSelecionada, 0).toString()));
        cliente.setNome(jTableClientes.getValueAt(linhaSelecionada, 1).toString());
        cliente.setEmail(jTableClientes.getValueAt(linhaSelecionada, 2).toString());
        cliente.setTelefone(jTableClientes.getValueAt(linhaSelecionada, 3).toString());
        cliente.setCpf_cnpj(jTableClientes.getValueAt(linhaSelecionada, 4).toString());
        //cliente.setCelular(jTableClientes.getValueAt(linhaSelecionada, 5).toString());
        cliente.setTipoCliente(jTableClientes.getValueAt(linhaSelecionada, 6).toString());
        cliente.setRua(jTableClientes.getValueAt(linhaSelecionada, 7).toString());
        cliente.setNumero(jTableClientes.getValueAt(linhaSelecionada, 8).toString());
        cliente.setBairro(jTableClientes.getValueAt(linhaSelecionada, 9).toString());
        //cliente.setComplemento(jTableClientes.getValueAt(linhaSelecionada, 10).toString());
        cliente.setCidade(jTableClientes.getValueAt(linhaSelecionada, 11).toString());
        cliente.setEstado(jTableClientes.getValueAt(linhaSelecionada, 12).toString());
        cliente.setCep(jTableClientes.getValueAt(linhaSelecionada, 13).toString());
        cliente.setStatus(StatusRepository.getByValue(jTableClientes.getValueAt(linhaSelecionada, 14).toString()));
        
        /*Uma vez que os campos obrigatorios podem ser nulos, 
        é necessario checar se eles são, e caso sejam é preciso dar um valor mesmo que em branco para eles*/
        
        //Verifica se o campo Observações na tabela é nulo
        if(jTableClientes.getValueAt(linhaSelecionada, 15) == null){
            cliente.setObservacoes("");
        }else {
            cliente.setObservacoes(jTableClientes.getValueAt(linhaSelecionada, 15).toString());
        }
        
        //Verifica se o campo celular na tabela é nulo
        if(jTableClientes.getValueAt(linhaSelecionada, 5) == null){
            cliente.setCelular("");
        }else {
            cliente.setCelular(jTableClientes.getValueAt(linhaSelecionada, 5).toString());
        }
        
        //Verifica se o campo complemento na tabela é nulo
        if(jTableClientes.getValueAt(linhaSelecionada, 10) == null){
            cliente.setComplemento("");
        }else {
            cliente.setComplemento(jTableClientes.getValueAt(linhaSelecionada, 10).toString());
        }
        
        cadclienteframe.setClienteForm(cliente);
        cadclienteframe.setLocationRelativeTo(null);
        cadclienteframe.setVisible(true);
        
        //Pega os dados do banco de dados para atualizar a tabela
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
    }//GEN-LAST:event_jTableClientesMouseClicked
  
    
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
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<nwk.com.br.form.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxCampoPesquisa;
    private javax.swing.JTextField jFieldPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
