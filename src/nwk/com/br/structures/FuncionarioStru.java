/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.FuncionarioDAO;
import nwk.com.br.model.Funcionario;

/**
 *
 * @author Richard Matheus
 */
public class FuncionarioStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");//formato de data
    
    //Consulta se a data foi digitada pelo usuario ou nao
    private String consultaDatas(Date data){
        String dataString = new String();
        
        //Coloca a data recebida em uma string
        dataString = sdf1.format(data).toString();
        
        //Verifica se a data esta no formato padrao para datas nao existentes
        if(dataString.equals("01/01/0001")){
            dataString = "  /  /    ";
        }
        
        return dataString;
    }
    
    public DefaultTableModel getTable() {
        
        FuncionarioDAO func = new FuncionarioDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = func.checarID();
        
        String[] colunas = new String[]{"ID", "Nome", "E-Mail", "Telefone", "CPF", "Data de Nascimento", "Celular", "Rua", "Numero", "Bairro", "Complemento", "Cidade", "Estado", "CEP", "Carteira de Trabalho", "Serie Carteira", "Data Contratação", "Data Demissão", "Observações", "Status"};
        String[][] dados = new String[max-1][20];
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela
        for (Funcionario funcionario : func.getTodosFuncionarios()){
            dados[l][0] = Integer.toString(funcionario.getId());
            dados[l][1] = funcionario.getNome();
            dados[l][2] = funcionario.getEmail();
            dados[l][3] = funcionario.getTelefone();
            dados[l][4] = funcionario.getCpf();
            dados[l][5] = consultaDatas(funcionario.getDhNascimento());
            dados[l][6] = funcionario.getCelular();
            dados[l][7] = funcionario.getRua();
            dados[l][8] = funcionario.getNumero();
            dados[l][9] = funcionario.getBairro();
            dados[l][10] = funcionario.getComplemento();
            dados[l][11] = funcionario.getCidade();
            dados[l][12] = funcionario.getEstado();
            dados[l][13] = funcionario.getCep();
            dados[l][14] = funcionario.getNumcarteiratrab();
            dados[l][15] = funcionario.getSeriecarteiratrab();
            dados[l][16] = consultaDatas(funcionario.getDhContrato());
            dados[l][17] = consultaDatas(funcionario.getDhDemissao());
            dados[l][18] = funcionario.getObservacoes();
            dados[l][19] = funcionario.getStatus().getValue();
            
            
            
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
