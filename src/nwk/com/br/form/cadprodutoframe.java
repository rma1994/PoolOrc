/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import nwk.com.br.dao.FamiliaDAO;
import nwk.com.br.dao.ProdutoDAO;
import nwk.com.br.dao.SimilarDAO;
import nwk.com.br.documents.ControleTexto;
import nwk.com.br.documents.ControleTextoId;
import nwk.com.br.documents.ControleTextoValores;
import nwk.com.br.model.Familia;
import nwk.com.br.model.Produto;
import nwk.com.br.model.Similar;

/**
 *
 * @author RMA
 */
public class cadprodutoframe extends javax.swing.JDialog {
    //Variaveis
    private FamiliaDAO familiadao = new FamiliaDAO();
    private SimilarDAO similardao = new SimilarDAO();
    private Produto produto = new Produto();
    private ProdutoDAO produtodao = new ProdutoDAO();
    /*private String id;
    private int produtoID;*/
            
    /**
     * Creates new form cadprodutoframe
     */
    public cadprodutoframe() {
        initComponents();
        this.setModal(true); 
        
        setCamposTexto(); // Modifica os caracteres aceitos nos campos de texto
        setBoxFamilia(); //Mostra as familias cadastradas na combobox familia
        setBoxSimilar(); //Mostra os similares cadastrados na combobox similar
        getTimeStamp(); //Pega a Hora atual para colocar no campo de texto 'data cadastro'
        
        /*produtoID = (produtodao.checarID()); //checa o ultimo ID do funcionario
        id = Integer.toString(produtoID); // transforma esse Id em String
        jFieldcodproCadProduto.setText(id); //coloca esse id no campo jFieldidCadFuncionario*/
    }
    
    //Define os caracteres validos nos campos de texto
    private void setCamposTexto(){
        jFieldcodproCadProduto.setDocument(new ControleTexto(9));
        jFieldcodfabCadProduto.setDocument(new ControleTexto(15));
        jFielddescCadProduto.setDocument(new ControleTexto(255));
        jFieldMarca.setDocument(new ControleTexto(100));
        
        jFieldvlcompCadProduto.setDocument(new ControleTextoValores());
        jFieldvlvendaCadProduto.setDocument(new ControleTextoValores());
        jFieldporcenCadProduto.setDocument(new ControleTextoValores());
    }
    
    //Seta os valores existentes na box familia
    private void setBoxFamilia(){
        jComboFamilia.removeAllItems();
        for (Familia familia : familiadao.getTodasFamilias()){
            jComboFamilia.addItem(familia.getId() + " - " + familia.getDescricao());
        }
    }
    
    //Seta os valores existentes na box similar
    private void setBoxSimilar(){
        jComboSimilar.removeAllItems();
        for (Similar similar : similardao.getTodosSimilares()){
            jComboSimilar.addItem(similar.getId() + " - " + similar.getDescricao());
        }
    }

    //Pega a Hora atual para colocar no campo de texto 'data cadastro'
    private void getTimeStamp(){
        Date dataAtual = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        jFielddtCadProduto.setText(formatDate.format(dataAtual));
    }
    
    public void setProdutoForm(Produto produto){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        //Converte os dados para int
        //Seta a combobox pelo valor do index, uma vez que o index sera sempre
        //o valor da chave primaria de familia/similar -1
        jComboFamilia.setSelectedIndex(Integer.parseInt(produto.getFamilia())-1);
        jComboSimilar.setSelectedIndex(Integer.parseInt(produto.getSimilar())-1);
        
        jFieldcodproCadProduto.setText(produto.getId());
        jFieldcodfabCadProduto.setText(produto.getIdFabricante());
        jFielddtCadProduto.setText(formatDate.format(produto.getDhCadastro()).toString());
        jFielddescCadProduto.setText(produto.getDescricao());
        jFieldMarca.setText(produto.getMarca());
        jFieldvlcompCadProduto.setText(produto.getValorCompra());
        jFieldvlvendaCadProduto.setText(produto.getValorVenda());
        jFieldporcenCadProduto.setText(produto.getPorcentagem());
        jTextAreaObs.setText(produto.getObservacoes());
        
        this.produto.setInserOrUpd(produto.getInserOrUpd());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vlvemCadProduto = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFieldcodproCadProduto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFieldcodfabCadProduto = new javax.swing.JTextField();
        jFielddescCadProduto = new javax.swing.JTextField();
        jFieldMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFielddtCadProduto = new javax.swing.JTextField();
        jFieldvlcompCadProduto = new javax.swing.JTextField();
        jFieldporcenCadProduto = new javax.swing.JTextField();
        jFieldvlvendaCadProduto = new javax.swing.JTextField();
        jComboFamilia = new javax.swing.JComboBox();
        jComboSimilar = new javax.swing.JComboBox();
        jButtonCadSimilar = new javax.swing.JButton();
        jButtonCadFamilia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produto"));

        jLabel1.setText("Codigo Produto :");

        jLabel2.setText("Descrição :");

        jLabel3.setText("Marca :");

        jLabel4.setText("Similar :");

        jLabel5.setText("Valor de Compra :");

        jLabel6.setText("Valor de Venda :");

        jLabel7.setText("Porcentagem :");

        jLabel8.setText("Codigo Produto Pelo Fabricante :");

        jFieldcodfabCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldcodfabCadProdutoActionPerformed(evt);
            }
        });

        jLabel9.setText("Familia :");

        jLabel10.setText("Data de Cadastro :");

        jFielddtCadProduto.setEditable(false);

        jComboFamilia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboSimilar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonCadSimilar.setText("...");
        jButtonCadSimilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadSimilarActionPerformed(evt);
            }
        });

        jButtonCadFamilia.setText("...");
        jButtonCadFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFieldcodproCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldcodfabCadProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(107, 107, 107))
                    .addComponent(jFielddescCadProduto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFielddtCadProduto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFieldvlvendaCadProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jFieldvlcompCadProduto, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFieldporcenCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCadFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboSimilar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCadSimilar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFieldcodproCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jFieldcodfabCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFielddescCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jFielddtCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFieldvlcompCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFieldvlvendaCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboSimilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadSimilar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFieldporcenCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadFamilia))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produto", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));
        jPanel2.setToolTipText("");

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setLineWrap(true);
        jTextAreaObs.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Obs", jPanel2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFieldcodfabCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldcodfabCadProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldcodfabCadProdutoActionPerformed

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

    private void jButtonCadFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadFamiliaActionPerformed
        CadFamilia cadfamilia = new CadFamilia(null, true);
        cadfamilia.setLocationRelativeTo(null);
        cadfamilia.setVisible(true);
        
        setBoxFamilia();
    }//GEN-LAST:event_jButtonCadFamiliaActionPerformed

    private void jButtonCadSimilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadSimilarActionPerformed
        CadSimilar cadsimilar = new CadSimilar(null, true);
        cadsimilar.setLocationRelativeTo(null);
        cadsimilar.setVisible(true);
        
        setBoxSimilar();
    }//GEN-LAST:event_jButtonCadSimilarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        produto.setId(jFieldcodproCadProduto.getText());
        produto.setIdFabricante(jFieldcodfabCadProduto.getText());
        produto.setDhCadastro(jFielddtCadProduto.getText());
        produto.setDescricao(jFielddescCadProduto.getText());
        produto.setMarca(jFieldMarca.getText());
        produto.setFamilia(jComboFamilia.getSelectedItem().toString());
        produto.setSimilar(jComboSimilar.getSelectedItem().toString());
        produto.setValorCompra(jFieldvlcompCadProduto.getText());
        produto.setValorVenda(jFieldvlvendaCadProduto.getText());
        produto.setPorcentagem(jFieldporcenCadProduto.getText());
        produto.setObservacoes(jTextAreaObs.getText());
        
        if(produto.isValida() == true){
            if(produto.getInserOrUpd() == null){
                //Tenta inserir os dados pelo formulario no banco de dados
                boolean produtoresult = produtodao.inserir(produto);
                if(produtoresult == true){
                    JOptionPane.showMessageDialog(null, "Produto Inserido Com Sucesso!");
                    this.dispose();
                }
                
            }else if(produto.getInserOrUpd().equals("update")){
                //Tenta ATUALIZAR os dados pelo formulario no banco de dados
                boolean produtoresult = produtodao.atualizar(produto);
                if(produtoresult == true){
                    JOptionPane.showMessageDialog(null, "Produto Atualizado Com Sucesso!");
                    this.dispose();
                }
            }
        }else if(produto.isValida() == false){
                //Caso exista campos obrigatorios em branco ou nulos, ele apresenta aqui.
                JOptionPane.showMessageDialog(null, produto.getMensagemerroProduto());
                produto.setMensagemerroProduto("Campos em branco: \n");
                produto.setValida(true);
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
            java.util.logging.Logger.getLogger(cadprodutoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadprodutoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadprodutoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadprodutoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadprodutoframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadFamilia;
    private javax.swing.JButton jButtonCadSimilar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboFamilia;
    private javax.swing.JComboBox jComboSimilar;
    private javax.swing.JTextField jFieldMarca;
    private javax.swing.JTextField jFieldcodfabCadProduto;
    private javax.swing.JTextField jFieldcodproCadProduto;
    private javax.swing.JTextField jFielddescCadProduto;
    private javax.swing.JTextField jFielddtCadProduto;
    private javax.swing.JTextField jFieldporcenCadProduto;
    private javax.swing.JTextField jFieldvlcompCadProduto;
    private javax.swing.JTextField jFieldvlvendaCadProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JTextField vlvemCadProduto;
    // End of variables declaration//GEN-END:variables
}
