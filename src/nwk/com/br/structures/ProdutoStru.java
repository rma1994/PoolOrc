/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.ProdutoDAO;
import nwk.com.br.model.Produto;

/**
 *
 * @author Richard Matheus
 */
public class ProdutoStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");//formato de data
    
    public DefaultTableModel getTable() {
        
        ProdutoDAO produtodao = new ProdutoDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = Integer.parseInt(produtodao.checarID());
        
        String[] colunas = new String[]{"ID", "Descrição", "Valor de Venda", "Marca", "Familia", "Similar", "ID Pelo Fabricante", "Data Cadastro", "Valor de Compra", "Porcentagem", "Observações"};
        String[][] dados = new String[max][11];
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela
        for (Produto produto : produtodao.getTodosProdutos()){
            dados[l][0] = produto.getId();
            dados[l][1] = produto.getDescricao();
            dados[l][2] = produto.getValorVenda().replace(".", ",");
            dados[l][3] = produto.getMarca();
            dados[l][4] = produto.getFamilia();
            dados[l][5] = produto.getSimilar();
            dados[l][6] = produto.getIdFabricante();
            dados[l][7] = sdf1.format(produto.getDhCadastro()).toString();
            dados[l][8] = produto.getValorCompra().replace(".", ",");
            dados[l][9] = produto.getPorcentagem().replace(".", ",");
            dados[l][10] = produto.getObservacoes();
            
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
