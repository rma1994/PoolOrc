/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.OrcamentoDAO;
import nwk.com.br.dao.ProdutoDAO;
import nwk.com.br.model.Produto;
import nwk.com.br.model.Orcamento;

/**
 *
 * @author Richard Matheus
 */
public class ProdutosOrcamentoStru {
    public DefaultTableModel getTable() {
        
        ProdutoDAO produtodao = new ProdutoDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = Integer.parseInt(produtodao.checarID());
        
        String[] colunas = new String[]{"Codigo", "Descrição", "Quantidade", "Valor Und", "Desconto", "Total"};
        /*String[][] dados = new String[max][11];
        
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
        }*/
       
    
    //Linhas não editaveis.
    DefaultTableModel model = new DefaultTableModel(null , colunas ){
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    
    //Retorna o modelo gerado aqui
    return model;
    }
    
    
    
    public DefaultTableModel getTableProdutosCadastr(Orcamento orcamento) {
        
        OrcamentoDAO orcamentodao = new OrcamentoDAO();
        //int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        //int max = orcamentodao.getQuantiaLinhaProdutos(orcamento);
        
        String[] colunas = new String[]{"Codigo", "Descrição", "Quantidade", "Valor Und", "Desconto", "Total"};
        //String[][] dados = new String[max][6];
        
        //Linhas não editaveis.
        DefaultTableModel model = new DefaultTableModel(null , colunas ){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        
        //Para cada funcionario em getTodosFuncionarios, coloque esses dados na tabela, adicionando uma nova linha
        for (Produto produto : orcamentodao.getTodosProdutosOrcamento(orcamento)){
            String[] dados = new String[6];
            dados[0] = produto.getId();
            dados[1] = produto.getDescricao();
            dados[2] = produto.getQuantidade();
            dados[3] = produto.getValorVenda().replace(",", ".");
            dados[4] = produto.getDesconto().replace(",", ".");
            dados[5] = produto.getTotal().replace(",", ".");
            model.addRow(dados);
        }
       
    
    //Retorna o modelo gerado aqui
    return model;
    }
}
