/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.ClienteDAO;
import nwk.com.br.model.Cliente;

/**
 *
 * @author Richard Matheus
 */
public class ClienteStru {
    
    public DefaultTableModel getTable() {
        
        ClienteDAO clientedao = new ClienteDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = clientedao.checarID();
        
        String[] colunas = new String[]{"ID", "Nome", "E-Mail", "Telefone", "CPF/CNPJ", "Celular", "Tipo", "Rua", "Numero", "Bairro", "Complemento", "Cidade", "Estado", "CEP", "Status", "Observações"};
        String[][] dados = new String[max-1][16];
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela
        for (Cliente cliente : clientedao.getTodosClientes()){
            dados[l][0] = Integer.toString(cliente.getId());
            dados[l][1] = cliente.getNome();
            dados[l][2] = cliente.getEmail();
            dados[l][3] = cliente.getTelefone();
            dados[l][4] = cliente.getCpf_cnpj();
            dados[l][5] = cliente.getCelular();
            dados[l][6] = cliente.getTipoCliente();
            dados[l][7] = cliente.getRua();
            dados[l][8] = cliente.getNumero();
            dados[l][9] = cliente.getBairro();
            dados[l][10] = cliente.getComplemento();
            dados[l][11] = cliente.getCidade();
            dados[l][12] = cliente.getEstado();
            dados[l][13] = cliente.getCep();
            dados[l][14] = cliente.getStatus().getValue();
            dados[l][15] = cliente.getObservacoes();
            
            l++;
        }
       
    
    //Linhas não editaveis.
    DefaultTableModel model = new DefaultTableModel(dados , colunas ){
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    
    //Retorna o modelo gerado aqui
    return model;
    }
}
