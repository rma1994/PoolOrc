/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.structures;

import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.SimilarDAO;
import nwk.com.br.model.Similar;

/**
 *
 * @author Richard Matheus
 */
public class SimilarStru {
    
    public DefaultTableModel getTable() {
        
        SimilarDAO similardao = new SimilarDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = similardao.getQuantiaLinha();
        
        String[] colunas = new String[]{"ID", "Descrição"};
        String[][] dados = new String[max][2];
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela
        for (Similar similar : similardao.getTodosSimilares()){
            dados[l][0] = Integer.toString(similar.getId());
            dados[l][1] = similar.getDescricao();
            
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
