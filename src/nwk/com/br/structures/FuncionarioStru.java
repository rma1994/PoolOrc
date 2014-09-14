/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.structures;

import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.FuncionarioDAO;
import nwk.com.br.model.Funcionario;

/**
 *
 * @author Richard Matheus
 */
public class FuncionarioStru {
    
    public DefaultTableModel getTable() {
        FuncionarioDAO func = new FuncionarioDAO();
        int l = 0;
        
        int max = func.checarID();
        
        String[] colunas = new String[]{"ID", "Nome", "E-Mail", "Telefone", "CPF", "Data de Nascimento", "Celular", "Rua", "Numero", "Bairro", "Complemento", "Cidade", "Estado", "CEP", "Carteira de Trabalho", "Serie Carteira", "Data Contratação", "Data Demissão", "Observações", "Status"};
        String[][] dados = new String[max-1][2];

        for (Funcionario funcionario : func.getTodosFuncionarios()){
            dados[l][0] = Integer.toString(funcionario.getId());
            dados[l][1] = funcionario.getNome();
            l++;
        }
        
        /*for (int i = 0; i < max; i++) {
             dados[i][0] = a[i].getNome();
        }*/
    

    DefaultTableModel model = new DefaultTableModel(dados , colunas );
    
    return model;
    }
    
        /*for (Funcionario funcionario : dao.getTodosFuncionarios()){
            dados[l][0] = funcionario.getNome();
            l++;
        }*/
        
        
    
}
