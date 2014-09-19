/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.structures;

import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.FamiliaDAO;
import nwk.com.br.model.Familia;

/**
 *
 * @author Richard Matheus
 */
public class FamiliaStru {
    
    public DefaultTableModel getTable() {
        
        FamiliaDAO familiadao = new FamiliaDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = familiadao.checarID();
        
        String[] colunas = new String[]{"ID", "Descrição"};
        String[][] dados = new String[max-1][2];
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela
        for (Familia familia : familiadao.getTodasFamilias()){
            dados[l][0] = Integer.toString(familia.getId());
            dados[l][1] = familia.getDescricao();
            
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
