/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import nwk.com.br.dao.ClienteDAO;
import nwk.com.br.model.Cliente;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.documents.ControleTexto;
import nwk.com.br.documents.ControleTextoId;
/**
 *
 * @author RMA
 */
public class cadclienteframe extends javax.swing.JDialog {
    
    //Declaração das Variaveis
    private Cliente cliente = new Cliente();
    private ConsultaCliente consultacliente;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private String id;
    private int clienteID;
    
    /**
     * Creates new form cadclienteframe
     */
    public cadclienteframe() {
        initComponents();
        this.setModal(true); //Torna essa janela um modal
        jRadioButtonFisica.setSelected(true); //seleciona o botao Fisica
        setCamposTexto(); // Modifica os caracteres aceitos nos campos de texto
        
        clienteID = (clienteDAO.checarID()); //checa o ultimo ID do cliente
        id = Integer.toString(clienteID); // transforma esse Id em String
        jFieldidCadCliente.setText(id); //coloca esse id no campo jFieldidCadCliente
    }
   
    //reabre o form ConsultaCliente para que ele atualize
    public void reabrir(){
       ConsultaCliente a = new ConsultaCliente();
       a.setLocationRelativeTo(null);
       a.setVisible(true);
       dispose();
    }
   
   //Seta os campos desse frame, de acordo com os dados recebidos pelo frame
   //ConsultaCliente
   public void setClienteForm(Cliente cliente){
       //Seleciona o botão radio juridica ou fisica
       if(cliente.getTipoCliente().equals("Fisica")){
           this.setMascaraCPF();
           jRadioButtonFisica.setSelected(true);
       }else if (cliente.getTipoCliente().equals("Juridica")){
           this.setMascaraCNPJ();
           jRadioButtonJuridica.setSelected(true);
       }
       //System.out.println(cliente.getTipoCliente());
       
       //PEga os dados recebidos como parametro e seta nos campos do form.
       jComboBox1ClienteAtivo.setSelectedItem(cliente.getStatus().toString());
       jComboBoxEstado.setSelectedItem(cliente.getEstado());
       
       jFieldidCadCliente.setText(Integer.toString(cliente.getId()));
       jFieldnomeCadCliente.setText(cliente.getNome());
       jFieldcnpjcpfCadCliente.setText(cliente.getCpf_cnpj());
       jFieldruaCadCliente.setText(cliente.getRua());
       jFieldnumeroCadCliente.setText(cliente.getNumero());
       jFieldbairroCadCliente.setText(cliente.getBairro());
       jFieldcomplemCadCliente.setText(cliente.getComplemento());
       jFieldcepCadCliente.setText(cliente.getCep());
       jFieldcidadeCadCliente.setText(cliente.getCidade());
       jFieldtelCadCliente.setText(cliente.getTelefone());
       jFieldcelCadCliente.setText(cliente.getCelular());
       jFieldemailCadCliente.setText(cliente.getEmail());
       jFieldobsCadCliente.setText(cliente.getObservacoes());
       
       this.cliente.setInserOrUpd(cliente.getInserOrUpd());
    }
   
    //Função para setar a mascara de cpf
    private void setMascaraCPF(){
    //Cria a Mascara de CPF 
        try {   
            MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");  
  
            jFieldcnpjcpfCadCliente.setValue(null);
            /*if (jRadioButtonFisica.isSelected()){*/
            jFieldcnpjcpfCadCliente.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
            //}
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
    }
    
    //Função para setar a mascara de cnpf
    private void setMascaraCNPJ(){
        try {  
            MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");  
  
            jFieldcnpjcpfCadCliente.setValue(null);
            //if (jRadioButtonFisica.isSelected()){
            jFieldcnpjcpfCadCliente.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
            //}
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
    }
    
    //Define os caracteres validos nos campos de texto
    private void setCamposTexto(){
        jFieldidCadCliente.setDocument(new ControleTextoId());
        
        jFieldnomeCadCliente.setDocument(new ControleTexto(255));
        jFieldruaCadCliente.setDocument(new ControleTexto(100));
        jFieldbairroCadCliente.setDocument(new ControleTexto(50));
        jFieldnumeroCadCliente.setDocument(new ControleTexto(8));
        jFieldcomplemCadCliente.setDocument(new ControleTexto(100));
        jFieldcidadeCadCliente.setDocument(new ControleTexto(45));
        jFieldemailCadCliente.setDocument(new ControleTexto(50));
        jFieldobsCadCliente.setDocument(new ControleTexto(500));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fisico_juridico = new javax.swing.ButtonGroup();
        sexo = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFieldidCadCliente = new javax.swing.JTextField();
        jFieldnomeCadCliente = new javax.swing.JTextField();
        jFieldruaCadCliente = new javax.swing.JTextField();
        jFieldbairroCadCliente = new javax.swing.JTextField();
        jFieldemailCadCliente = new javax.swing.JTextField();
        jRadioButtonFisica = new javax.swing.JRadioButton();
        jRadioButtonJuridica = new javax.swing.JRadioButton();
        jComboBox1ClienteAtivo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jFieldnumeroCadCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jFieldcomplemCadCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jFieldcidadeCadCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jFieldcnpjcpfCadCliente = new javax.swing.JFormattedTextField();
        jFieldcepCadCliente = new javax.swing.JFormattedTextField();
        jFieldtelCadCliente = new javax.swing.JFormattedTextField();
        jFieldcelCadCliente = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jFieldobsCadCliente = new javax.swing.JTextArea();
        jButtonSalvarCliente = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Clientes"));

        jLabel1.setText("ID :");

        jLabel2.setText("Nome :");

        jLabel3.setText("CPF/CNPJ :");

        jLabel4.setText("Rua :");

        jLabel5.setText("Bairro :");

        jLabel6.setText("CEP :");

        jLabel7.setText("Telefone :");

        jLabel8.setText("E-Mail :");

        jFieldidCadCliente.setEditable(false);
        jFieldidCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldidCadClienteActionPerformed(evt);
            }
        });

        jFieldemailCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldemailCadClienteActionPerformed(evt);
            }
        });

        fisico_juridico.add(jRadioButtonFisica);
        jRadioButtonFisica.setText("Fisica");
        jRadioButtonFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFisicaActionPerformed(evt);
            }
        });

        fisico_juridico.add(jRadioButtonJuridica);
        jRadioButtonJuridica.setText("Juridica");
        jRadioButtonJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonJuridicaActionPerformed(evt);
            }
        });

        jComboBox1ClienteAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        jComboBox1ClienteAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ClienteAtivoActionPerformed(evt);
            }
        });

        jLabel11.setText("Nº :");

        jLabel12.setText("Complemento :");

        jLabel13.setText("Cidade :");

        jLabel14.setText("Estado :");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        jLabel15.setText("Celular :");

        jLabel16.setText("Tipo de Pessoa :");

        jLabel17.setText("Cliente Ativo :");

        try {
            jFieldcnpjcpfCadCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFieldcnpjcpfCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldcnpjcpfCadClienteActionPerformed(evt);
            }
        });

        try {
            jFieldcepCadCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFieldtelCadCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFieldcelCadCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFieldcelCadCliente.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jFieldcepCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFieldcidadeCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jFieldidCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonFisica)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonJuridica)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1ClienteAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jFieldruaCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldnumeroCadCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jFieldbairroCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldcomplemCadCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFieldemailCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jFieldtelCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFieldcelCadCliente)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jFieldnomeCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFieldcnpjcpfCadCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFieldidCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonFisica)
                    .addComponent(jRadioButtonJuridica)
                    .addComponent(jComboBox1ClienteAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFieldnomeCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFieldcnpjcpfCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFieldruaCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jFieldnumeroCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFieldbairroCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldcomplemCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jFieldcidadeCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldcepCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(jFieldtelCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldcelCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFieldemailCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jFieldobsCadCliente.setColumns(20);
        jFieldobsCadCliente.setLineWrap(true);
        jFieldobsCadCliente.setRows(5);
        jScrollPane1.setViewportView(jFieldobsCadCliente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Obs", jPanel2);

        jButtonSalvarCliente.setText("SALVAR");
        jButtonSalvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarClienteActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("CANCELAR");
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
                .addComponent(jButtonSalvarCliente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarCliente)
                    .addComponent(jButtonCancelar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jFieldidCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldidCadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldidCadClienteActionPerformed

    private void jComboBox1ClienteAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ClienteAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ClienteAtivoActionPerformed

    private void jFieldemailCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldemailCadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldemailCadClienteActionPerformed

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

    private void jRadioButtonFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFisicaActionPerformed
        // Caso o radio button fisica seja selecionado, ele altera a mascara do campo jFieldcnpjcpfCadCliente para uma mascara de cpf
        this.setMascaraCPF();
    }//GEN-LAST:event_jRadioButtonFisicaActionPerformed

    private void jButtonSalvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarClienteActionPerformed
        //Verifica qual radio button esta selecionado e da a ele o respectivo valor
        if(jRadioButtonFisica.isSelected()){
            cliente.setTipoCliente("Fisica");
        }else if(jRadioButtonJuridica.isSelected()){
            cliente.setTipoCliente("Juridica");
        };
        
        //Recebe os valores dos campos do formulario
        cliente.setId(Integer.parseInt(jFieldidCadCliente.getText()));
        cliente.setNome(jFieldnomeCadCliente.getText());
        cliente.setCpf_cnpj(jFieldcnpjcpfCadCliente.getText());
        cliente.setRua(jFieldruaCadCliente.getText());
        cliente.setBairro(jFieldbairroCadCliente.getText());
        cliente.setNumero(jFieldnumeroCadCliente.getText());
        cliente.setComplemento(jFieldcomplemCadCliente.getText());
        cliente.setCep(jFieldcepCadCliente.getText());
        cliente.setCidade(jFieldcidadeCadCliente.getText());
        cliente.setEstado(jComboBoxEstado.getSelectedItem().toString());
        cliente.setTelefone(jFieldtelCadCliente.getText());
        cliente.setCelular(jFieldcelCadCliente.getText());
        cliente.setEmail(jFieldemailCadCliente.getText());
        cliente.setStatus(StatusRepository.valueOf(jComboBox1ClienteAtivo.getSelectedItem().toString()));
        cliente.setObservacoes(jFieldobsCadCliente.getText());
                
        //Verifica se existe campos obrigatorios em branco ou nulos
        if(cliente.isValida() == true){
            if(cliente.getInserOrUpd() == null){
                //Tenta inserir os dados pelo formulario no banco de dados
                boolean clienteresult = clienteDAO.inserir(cliente);
                if(clienteresult == true){
                    JOptionPane.showMessageDialog(null, "Cliente Inserido Com Sucesso!");
                    this.dispose();
                }
                
            }else if(cliente.getInserOrUpd().equals("update")){
               //Tenta ATUALIZAR os dados pelo formulario no banco de dados
                boolean clienteresult = clienteDAO.atualizar(cliente);
                if(clienteresult == true){
                    JOptionPane.showMessageDialog(null, "Cliente Atualizado Com Sucesso!");
                    this.dispose();
                } 
            }
        }else if(cliente.isValida() == false){
            //Caso exista campos obrigatorios em branco ou nulos, ele apresenta aqui.
            JOptionPane.showMessageDialog(null, cliente.getMensagemerroCliente());
            cliente.setMensagemerroCliente("Campos em branco: \n");
            cliente.setIsValida(true);
        }
        
    }//GEN-LAST:event_jButtonSalvarClienteActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jFieldcnpjcpfCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldcnpjcpfCadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldcnpjcpfCadClienteActionPerformed

    private void jRadioButtonJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJuridicaActionPerformed
        // Caso o radio button fisica seja selecionado, ele altera a mascara do campo jFieldcnpjcpfCadCliente para uma mascara de cnpj
        this.setMascaraCNPJ();
    }//GEN-LAST:event_jRadioButtonJuridicaActionPerformed

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
            java.util.logging.Logger.getLogger(cadclienteframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadclienteframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadclienteframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadclienteframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadclienteframe().setVisible(true);
            }
        });
    }
    //merda de github
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup fisico_juridico;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvarCliente;
    private javax.swing.JComboBox jComboBox1ClienteAtivo;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JTextField jFieldbairroCadCliente;
    private javax.swing.JFormattedTextField jFieldcelCadCliente;
    private javax.swing.JFormattedTextField jFieldcepCadCliente;
    private javax.swing.JTextField jFieldcidadeCadCliente;
    private javax.swing.JFormattedTextField jFieldcnpjcpfCadCliente;
    private javax.swing.JTextField jFieldcomplemCadCliente;
    private javax.swing.JTextField jFieldemailCadCliente;
    private javax.swing.JTextField jFieldidCadCliente;
    private javax.swing.JTextField jFieldnomeCadCliente;
    private javax.swing.JTextField jFieldnumeroCadCliente;
    private javax.swing.JTextArea jFieldobsCadCliente;
    private javax.swing.JTextField jFieldruaCadCliente;
    private javax.swing.JFormattedTextField jFieldtelCadCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonFisica;
    private javax.swing.JRadioButton jRadioButtonJuridica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.ButtonGroup sexo;
    // End of variables declaration//GEN-END:variables
}
