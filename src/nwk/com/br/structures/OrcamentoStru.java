/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.OrcamentoDAO;
import nwk.com.br.model.Orcamento;

/**
 *
 * @author Richard Matheus
 */
public class OrcamentoStru {
     private SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");//formato de data
    
    public DefaultTableModel getTable() {
        
        OrcamentoDAO orcamentodao = new OrcamentoDAO();
        int l = 0;
        
        //Pega o ultimo valor do id, para ver a quantia maxima de linhas
        int max = orcamentodao.getQuantiaLinha();
        
        String[] colunas = new String[]{"ID", "Cliente", "Data", "Total", "ID Funcionario", "ID Cliente", "SubTotal", "Forma de Pagamento", "Desconto", "Observações"};
        String[][] dados = new String[max][11];
        
        //Para cada orcamento em getTodosOrcamentos, coloque esses dados na tabela
        for (Orcamento orcamento : orcamentodao.getTodosOrcamentos()){
            dados[l][0] = Integer.toString(orcamento.getId());
            dados[l][1] = orcamento.getNomeCliente();
            dados[l][2] = sdf1.format(orcamento.getDhOrcamento()).toString();
            dados[l][3] = orcamento.getTotal().replace(".", ",");
            dados[l][4] = Integer.toString(orcamento.getIdFuncionario());
            dados[l][5] = Integer.toString(orcamento.getIdCliente());
            dados[l][6] = orcamento.getSubTotal().replace(".", ",");
            dados[l][7] = orcamento.getFormaPagamento();
            dados[l][8] = orcamento.getDesconto().replace(".", ",");
            dados[l][9] = orcamento.getObservacoes();
            
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
