/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import com.sun.javafx.css.CalculatedValue;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import nwk.com.br.calculos.OrcamentoCalc;
import nwk.com.br.dao.FuncionarioDAO;
import nwk.com.br.dao.ClienteDAO;
import nwk.com.br.dao.OrcamentoDAO;
import nwk.com.br.dao.ProdutoDAO;
import nwk.com.br.documents.ControleTexto;
import nwk.com.br.documents.ControleTextoId;
import nwk.com.br.documents.ControleTextoValores;

import nwk.com.br.model.Funcionario;
import nwk.com.br.model.Cliente;
import nwk.com.br.model.Orcamento;
import nwk.com.br.model.Produto;
import nwk.com.br.structures.ProdutosOrcamentoStru;

/**
 *
 * @author RMA
 */
public class cadorcamentoframe extends javax.swing.JDialog {
    //Variaveis
    private FuncionarioDAO funcionariodao = new FuncionarioDAO();
    private OrcamentoDAO orcamentodao = new OrcamentoDAO();
    private ClienteDAO clientedao = new ClienteDAO();
    private ProdutoDAO produtodao = new ProdutoDAO();
    
    private Orcamento orcamento = new Orcamento();
    
    private ProdutosOrcamentoStru prodorcstru = new ProdutosOrcamentoStru();
    
    private OrcamentoCalc orcamentocalc = new OrcamentoCalc();
    
    /**
     * Creates new form cadorcamentoframe
     */
    public cadorcamentoframe() {
        initComponents();
        this.setModal(true); 
        
        atualizaTable();//
        setCamposTexto();//
        setIdDescOrcamento(); // Pega o ID
        getTimeStamp(); //Pega a hora atual
        setBoxFuncionario();//Mostra os funcionarios cadastrados na combobox funcionario
    }
    
    //Seta as configurações dos campos de texto
    private void setCamposTexto(){
        jFieldcodcliCadOrcamento.setDocument(new ControleTextoId());
        jFieldcodprodiCadOrcamento.setDocument(new ControleTextoId());
        jFielddescCadOrcamento.setDocument(new ControleTextoValores());
    }
    
    //Seta os valores existentes na box funcionario
    private void setBoxFuncionario(){
        jComboBoxFuncionario.removeAllItems();
        for (Funcionario funcionario : funcionariodao.getTodosFuncionarios()){
            jComboBoxFuncionario.addItem(funcionario.getId() + " - " + funcionario.getNome());
        }
    }
    

    //Seta o id do Orcamento
    private void setIdDescOrcamento(){
        int orcamentoID;
        String id;
        
        orcamentoID = (orcamentodao.checarID()); //checa o ultimo ID do funcionario
        id = Integer.toString(orcamentoID); // transforma esse Id em String
        jFieldcodCadOrcamento.setText(id); //coloca esse id no campo jFieldidCadFuncionario
        
        jFielddescCadOrcamento.setText("0");
    }
    
    //Pega a Hora atual para colocar no campo de texto 'data cadastro'
    private void getTimeStamp(){
        Date dataAtual = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        jFielddtCadOrcamento.setText(formatDate.format(dataAtual));
    }
    
    //Seta os dados do cliente no frame
    private void setDadosClienteLocal(){
        Cliente cliente = new Cliente();
        int idCliente;
        
        idCliente = Integer.parseInt(jFieldcodcliCadOrcamento.getText());
        cliente.setId(idCliente);
        
        if(clientedao.existenciaCliente(cliente)){
            cliente = clientedao.select(idCliente);
            
            jFieldnomecliCadOrcamento.setText(cliente.getNome());
            jFieldtelCadOrcamento.setText(cliente.getTelefone());
            jFieldcelCadOrcamento.setText(cliente.getCelular());
            jFieldemailCadOrcamento.setText(cliente.getEmail());
        }else{
            JOptionPane.showMessageDialog(null, "ID Não Cadastrado!");
            jFieldnomecliCadOrcamento.setText(null);
            jFieldtelCadOrcamento.setText(null);
            jFieldcelCadOrcamento.setText(null);
            jFieldemailCadOrcamento.setText(null);
            
        }
    }
    
    
    //Seta os dados pegos no ConsultaClienteOrcaçamento
    private void setDadosClienteConsulta(Cliente cliente){
        jFieldnomecliCadOrcamento.setText(cliente.getNome());
        jFieldtelCadOrcamento.setText(cliente.getTelefone());
        jFieldcelCadOrcamento.setText(cliente.getCelular());
        jFieldemailCadOrcamento.setText(cliente.getEmail());
    }
    
    
    //Carrega os dados na tabela
    private void atualizaTable(){
        TableModel model = (TableModel) (prodorcstru.getTable());
        jTableProdOrc.setModel(model);
        
        //Seta as dimensões das colunas
        jTableProdOrc.getColumnModel().getColumn(0).setMinWidth(35);
        jTableProdOrc.getColumnModel().getColumn(0).setMaxWidth(35);
        //jTableFuncionarios.getColumnModel().getColumn(1).setMinWidth(250);
        //jTableFuncionarios.getColumnModel().getColumn(2).setMinWidth(150);*/
    }
    
    //Inserir produto na tabela
    private void inserirProduto(){
        Produto produto = new Produto();
        String idProduto;
        
        idProduto = jFieldcodprodiCadOrcamento.getText();
        produto.setId(idProduto);
        
        //Checa se o codigo existe
        if(produtodao.existenciaProduto(produto)){
            //Se o produto existir ira jogalo para outra janela
            EdicaoProdutoOrc edicaoprodutoorc = new EdicaoProdutoOrc(null, true);
            
            //Pega todos os dados desse produto
            produto = produtodao.select(idProduto);
            
            //Joga os dados desse produto para janela edicaoprodutoorc
            produto = edicaoprodutoorc.getProdutoOrc(produto);
            
            //Caso a janela anterior nao tenha sido fechada sem finalizar, o programa segue em frente
            if(!(produto.getValorVenda().equals("") || produto.getQuantidade().equals(""))){
                //Cria um vetor com os dados do produto
                String[] dados = new String[] {produto.getId() , produto.getDescricao(), produto.getQuantidade(), produto.getValorVenda(), produto.getDesconto(), produto.getTotal()};

                //Adiciona uma linha na tabela com as informações do produto
                DefaultTableModel model = (DefaultTableModel)(jTableProdOrc.getModel());
                model.addRow(dados);
                
                //Soma o valor de todos os produtos na tabela
                BigDecimal subtotal = orcamentocalc.somarProdutos(getTodosProdutosOrc());
                jFieldsubtotalCadOrcamento.setText(subtotal.toString());
                
                //Subtrai o cvalor de subtotal pelo de desconto
                BigDecimal total = orcamentocalc.valorTotal(jFieldsubtotalCadOrcamento.getText(), jFielddescCadOrcamento.getText());
                jFieldtotalCadOrcamento.setText(total.toString());
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Codigo de Produto Não Encontrado!");
            jFieldcodprodiCadOrcamento.setText(null);
        }
    }
    
    
    //Editar produto na tabela
    private void editarProduto(){
        Produto produto = new Produto();
        String idProduto;
        int linhaSelecionada;
        
        //Pega a linha selecionada
        linhaSelecionada = jTableProdOrc.getSelectedRow();
        
        idProduto = jTableProdOrc.getValueAt(linhaSelecionada, 0).toString();
        
        produto.setId(idProduto);
        produto.setDescricao(jTableProdOrc.getValueAt(linhaSelecionada, 1).toString());
        produto.setQuantidade(jTableProdOrc.getValueAt(linhaSelecionada, 2).toString());
        produto.setValorVenda(jTableProdOrc.getValueAt(linhaSelecionada, 3).toString());
        produto.setDesconto(jTableProdOrc.getValueAt(linhaSelecionada, 4).toString());
        produto.setTotal(jTableProdOrc.getValueAt(linhaSelecionada, 5).toString());
        
        //Checa se o codigo existe
        if(produtodao.existenciaProduto(produto)){
            //Se o produto existir ira jogalo para outra janela
            EdicaoProdutoOrc edicaoprodutoorc = new EdicaoProdutoOrc(null, true);
                        
            //Joga os dados desse produto para janela edicaoprodutoorc
            produto = edicaoprodutoorc.editProdutoOrc(produto);
            
            //Caso a jenela anterior nao tenha sido fechada sem finalizar, o programa segue em frente
            if(!(produto.getId() == null || produto.getId().equals(""))){
                //Cria um vetor com os dados do produto
                //String[] dados = new String[] { , , , , , };

                //Adiciona uma linha na tabela com as informações do produto
                DefaultTableModel model = (DefaultTableModel)(jTableProdOrc.getModel());
                model.setValueAt(produto.getId(), linhaSelecionada, 0);
                model.setValueAt(produto.getDescricao(), linhaSelecionada, 1);
                model.setValueAt(produto.getQuantidade(), linhaSelecionada, 2);
                model.setValueAt(produto.getValorVenda(), linhaSelecionada, 3);
                model.setValueAt(produto.getDesconto(), linhaSelecionada, 4);
                model.setValueAt(produto.getTotal(), linhaSelecionada, 5);
                
                BigDecimal subtotal = orcamentocalc.somarProdutos(getTodosProdutosOrc());
                jFieldsubtotalCadOrcamento.setText(subtotal.toString());
                
                //Subtrai o valor de subtotal pelo de desconto
                BigDecimal total = orcamentocalc.valorTotal(jFieldsubtotalCadOrcamento.getText(), jFielddescCadOrcamento.getText());
                jFieldtotalCadOrcamento.setText(total.toString());
            }
            
        }
    }
    
    //Array com valores e ids dos produtos
    private List<Produto> getTodosProdutosOrc(){
        List<Produto> result = new ArrayList<Produto>();
            
        for(int r=0;r<jTableProdOrc.getRowCount();r++){
            Produto produto = new Produto();
            produto.setId(jTableProdOrc.getValueAt(r, 0).toString());
            produto.setTotal(jTableProdOrc.getValueAt(r, 5).toString());
            
            result.add(produto);
        }
        
        return result;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFielddtCadOrcamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFieldnomecliCadOrcamento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jFieldcelCadOrcamento = new javax.swing.JTextField();
        jFieldemailCadOrcamento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jFieldcodprodiCadOrcamento = new javax.swing.JTextField();
        jButtonInserirProd = new javax.swing.JButton();
        jButtonPesquisarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdOrc = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxFormaPagamento = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jFieldsubtotalCadOrcamento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jFielddescCadOrcamento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jFieldtotalCadOrcamento = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jFieldcodCadOrcamento = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jFieldcodcliCadOrcamento = new javax.swing.JTextField();
        jButtonPesquisarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jFieldobsCadOrcamento = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxFuncionario = new javax.swing.JComboBox();
        jFieldtelCadOrcamento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Orçamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Orçamento"));

        jLabel1.setText("Codigo :");

        jLabel2.setText("Data :");

        jFielddtCadOrcamento.setEditable(false);

        jLabel3.setText("Funcionario :");

        jLabel4.setText("Cliente :");

        jLabel9.setText("Telefone :");

        jLabel10.setText("E-Mail :");

        jLabel15.setText("Celular :");

        jLabel16.setText("Codigo do Produto :");

        jButtonInserirProd.setText("Inserir");
        jButtonInserirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirProdActionPerformed(evt);
            }
        });

        jButtonPesquisarProduto.setText("Pesquisar");
        jButtonPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarProdutoActionPerformed(evt);
            }
        });

        jTableProdOrc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Qtd", "Valor Und", "Desconto", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdOrc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableProdOrc.getTableHeader().setReorderingAllowed(false);
        jTableProdOrc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdOrcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdOrc);
        if (jTableProdOrc.getColumnModel().getColumnCount() > 0) {
            jTableProdOrc.getColumnModel().getColumn(0).setResizable(false);
            jTableProdOrc.getColumnModel().getColumn(1).setResizable(false);
            jTableProdOrc.getColumnModel().getColumn(2).setResizable(false);
            jTableProdOrc.getColumnModel().getColumn(3).setResizable(false);
            jTableProdOrc.getColumnModel().getColumn(4).setResizable(false);
            jTableProdOrc.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel17.setText("Forma de Pagamento :");

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A Vista: Dinheiro", "A Vista: Cartão", "Parcelado" }));

        jLabel18.setText("Subtotal :");

        jFieldsubtotalCadOrcamento.setEditable(false);

        jLabel19.setText("Desconto :");

        jFielddescCadOrcamento.setText("0");
        jFielddescCadOrcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFielddescCadOrcamentoFocusLost(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("TOTAL :");

        jFieldtotalCadOrcamento.setEditable(false);
        jFieldtotalCadOrcamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancela");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jFieldcodCadOrcamento.setEditable(false);

        jLabel21.setText("Cod Cliente :");

        jFieldcodcliCadOrcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFieldcodcliCadOrcamentoFocusLost(evt);
            }
        });
        jFieldcodcliCadOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldcodcliCadOrcamentoActionPerformed(evt);
            }
        });

        jButtonPesquisarCliente.setText("...");
        jButtonPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarClienteActionPerformed(evt);
            }
        });

        jFieldobsCadOrcamento.setColumns(20);
        jFieldobsCadOrcamento.setRows(5);
        jScrollPane2.setViewportView(jFieldobsCadOrcamento);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Observações :");

        jComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            jFieldtelCadOrcamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFieldtelCadOrcamento.setFocusCycleRoot(true);
        jFieldtelCadOrcamento.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFieldemailCadOrcamento)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFieldcodcliCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldnomecliCadOrcamento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFieldtelCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldcelCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFieldcodCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFielddtCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jFieldtotalCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldsubtotalCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFielddescCadOrcamento))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldcodprodiCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInserirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jFielddtCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFieldcodCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jFieldcodcliCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jFieldnomecliCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jFieldcelCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldtelCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFieldemailCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jFieldcodprodiCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInserirProd)
                    .addComponent(jButtonPesquisarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jFieldsubtotalCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jFielddescCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jFieldtotalCadOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orçamento", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFieldcodcliCadOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldcodcliCadOrcamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldcodcliCadOrcamentoActionPerformed

    private void jButtonPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarClienteActionPerformed
        ConsultaClienteOrcamento consultacliente = new ConsultaClienteOrcamento(null, true);
        String idCliente;
        
        //Pega o cliente retornado por consulta cliente
        //Depois pega o id desse cliente
        //converse esse id para String
        idCliente = Integer.toString(consultacliente.getCliente().getId());
        
        jFieldcodcliCadOrcamento.setText(idCliente);
        setDadosClienteLocal();//seta os dados no frame de acordo com o id do cliente
    }//GEN-LAST:event_jButtonPesquisarClienteActionPerformed

    private void jFieldcodcliCadOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldcodcliCadOrcamentoFocusLost
        setDadosClienteLocal();
    }//GEN-LAST:event_jFieldcodcliCadOrcamentoFocusLost

    private void jButtonInserirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirProdActionPerformed
        // TODO add your handling code here:
        inserirProduto();
    }//GEN-LAST:event_jButtonInserirProdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableProdOrcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdOrcMouseClicked
        editarProduto();
    }//GEN-LAST:event_jTableProdOrcMouseClicked

    private void jButtonPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarProdutoActionPerformed
        ConsultaProdutoOrcamento consultaproduto = new ConsultaProdutoOrcamento(null, true);
        String idProduto;
        
        //Pega o cliente retornado por consulta cliente
        //Depois pega o id desse cliente
        //converse esse id para String
        idProduto = consultaproduto.getProduto().getId();
        
        jFieldcodprodiCadOrcamento.setText(idProduto);
        inserirProduto();//Executa o inserir produto, que ira abrir outra tela
    }//GEN-LAST:event_jButtonPesquisarProdutoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        orcamento.setIdCliente(Integer.parseInt(jFieldcodcliCadOrcamento.getText()));
        orcamento.setIdFuncionario(jComboBoxFuncionario.getSelectedItem().toString());
        orcamento.setDhOrcamento(jFielddtCadOrcamento.getText());
        orcamento.setSubTotal(jFieldsubtotalCadOrcamento.getText());
        orcamento.setFormaPagamento(Integer.toString(jComboBoxFormaPagamento.getSelectedIndex()));
        orcamento.setDesconto(jFielddescCadOrcamento.getText());
        orcamento.setTotal(jFieldtotalCadOrcamento.getText());
        orcamento.setObservacoes(jFieldobsCadOrcamento.getText());
        
        orcamentodao.inserir(orcamento);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFielddescCadOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFielddescCadOrcamentoFocusLost
        String desconto = jFielddescCadOrcamento.getText();
        desconto = desconto.replace(",", ".");
        
        if(desconto.equals("") || desconto == null ){
            jFielddescCadOrcamento.setText("0");
        }
        
        //Subtrai o cvalor de subtotal pelo de desconto
        BigDecimal total = orcamentocalc.valorTotal(jFieldsubtotalCadOrcamento.getText(), desconto);
        jFieldtotalCadOrcamento.setText(total.toString());
    }//GEN-LAST:event_jFielddescCadOrcamentoFocusLost

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
            java.util.logging.Logger.getLogger(cadorcamentoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadorcamentoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadorcamentoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadorcamentoframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadorcamentoframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonInserirProd;
    private javax.swing.JButton jButtonPesquisarCliente;
    private javax.swing.JButton jButtonPesquisarProduto;
    private javax.swing.JComboBox jComboBoxFormaPagamento;
    private javax.swing.JComboBox jComboBoxFuncionario;
    private javax.swing.JTextField jFieldcelCadOrcamento;
    private javax.swing.JTextField jFieldcodCadOrcamento;
    private javax.swing.JTextField jFieldcodcliCadOrcamento;
    private javax.swing.JTextField jFieldcodprodiCadOrcamento;
    private javax.swing.JTextField jFielddescCadOrcamento;
    private javax.swing.JTextField jFielddtCadOrcamento;
    private javax.swing.JTextField jFieldemailCadOrcamento;
    private javax.swing.JTextField jFieldnomecliCadOrcamento;
    private javax.swing.JTextArea jFieldobsCadOrcamento;
    private javax.swing.JTextField jFieldsubtotalCadOrcamento;
    private javax.swing.JFormattedTextField jFieldtelCadOrcamento;
    private javax.swing.JTextField jFieldtotalCadOrcamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableProdOrc;
    // End of variables declaration//GEN-END:variables
}
