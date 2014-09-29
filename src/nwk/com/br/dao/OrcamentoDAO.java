/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Orcamento;
import nwk.com.br.model.Produto;
import nwk.com.br.repository.Database;

/**
 *
 * @author Richard Matheus
 */
public class OrcamentoDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(cod_orcamento) id FROM orcamento";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Orcamento orcamento = new Orcamento();
            orcamento.setId(rs.getInt("id")+1);
            result = orcamento.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Função para inserir o orçamento no banco de dados
    public boolean inserir(Orcamento orcamento){
        boolean result = false;
        
        String sql = "INSERT INTO Orcamento(id_funcionario, id_cliente, data_orcamento, sub_Total, forma_pagamento, desconto_valor, total_orcamento, orbservacoes_orcamento) "
                                                                                             + "VALUES('" + orcamento.getIdFuncionario()+ "',"
                                                                                                    + "'" + orcamento.getIdCliente() + "',"
                                                                                                    + "'" + formatDate.format(orcamento.getDhOrcamento()) + "',"
                                                                                                    + "'" + orcamento.getSubTotal().replace(".", ",") + "',"
                                                                                                    + "'" + orcamento.getFormaPagamento() + "',"
                                                                                                    + "'" + orcamento.getDesconto().replace(".", ",")  + "',"
                                                                                                    + "'" + orcamento.getTotal().replace(".", ",")  + "',"
                                                                                                    + "'" + orcamento.getObservacoes()+ "') ";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Orçamento salvo com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Pega a quantia de linhas da tabela
    public int getQuantiaLinha(){
        int qtd=0;
        
        String sql = "SELECT COUNT(*) qtd FROM orcamento";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                qtd = rs.getInt("qtd");
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return qtd;
    }
    
    
    //Pega todos os funcionarios cadastrados no banco de dados
    public List<Orcamento> getTodosOrcamentos(){     
                
        List<Orcamento> result = new ArrayList<Orcamento>();
        String sql = "SELECT o.*, c.NOME_CLIENTE FROM orcamento o, cliente c WHERE c.ID_CLIENTE = o.ID_CLIENTE ORDER BY cod_orcamento";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Orcamento orcamento = new Orcamento();
                orcamento.setId(rs.getInt("cod_orcamento"));
                orcamento.setIdCliente(rs.getInt("id_cliente"));
                orcamento.setIdFuncionario(rs.getString("id_funcionario") + "-");//Esse - serve para indicar o final do index usada em Produto)
                orcamento.setDhOrcamento(formatDate.format(rs.getDate("data_orcamento")).toString());
                orcamento.setSubTotal(Double.toString(rs.getDouble("sub_Total")).replace(",", "."));
                orcamento.setFormaPagamento(rs.getString("forma_pagamento"));
                orcamento.setDesconto(Double.toString(rs.getDouble("desconto_valor")).replace(",", "."));
                orcamento.setTotal(Double.toString(rs.getDouble("total_orcamento")).replace(",", "."));
                orcamento.setObservacoes(rs.getString("orbservacoes_orcamento"));
                orcamento.setNomeCliente(rs.getString("nome_cliente"));
                
                result.add(orcamento);
            }
            
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Pega todos os produtos cadastrados no banco de dados
    public List<Produto> getTodosProdutosOrcamento(Orcamento orcamento){   
        
        List<Produto> result = new ArrayList<Produto>();
        String sql = "SELECT io.cod_prod, io.quantidade, io.desconto_prod, io.valor_unidade, p.descricao_pecas, SUM((io.quantidade*valor_unidade)-desconto_prod) AS Total " +
                        "FROM itensorcamento io, produto p, orcamento o " +
                        "WHERE o.cod_orcamento = " + orcamento.getId() +
                        "AND o.cod_orcamento = io.cod_orcamento " +
                        "AND io.cod_prod = p.cod_prod " +
                        "GROUP BY p.descricao_pecas, io.cod_orcamento, io.cod_prod, io.quantidade, io.desconto_prod, io.valor_unidade " +
                        "ORDER BY io.cod_prod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getString("cod_prod"));
                produto.setQuantidade(rs.getString("quantidade"));
                produto.setDesconto(Double.toString(rs.getDouble("desconto_prod")).replace(",", "."));
                produto.setValorVenda(rs.getString("valor_unidade"));
                produto.setDescricao(rs.getString("descricao_pecas"));
                produto.setTotal(Double.toString(rs.getDouble("Total")).replace(",", "."));
                
                result.add(produto);
            }
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Pega a quantia de linhas da tabela
    public int getQuantiaLinhaProdutos(Orcamento orcamento){
        int qtd=0;
        
        String sql = "Select count(*)" +
                        "from ItensOrcamento" +
                        "where cod_orcamento = " + orcamento.getId();
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                qtd = rs.getInt("qtd");
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return qtd;
    }
    
    //Pega todos os produtos cadastrados no banco de dados
    public boolean insertProdutosOrc(int cod, List<Produto> produtolist){     
        boolean result = false;
        
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            
            for (Produto produto : produtolist){
                String sql = "INSERT INTO ItensOrcamento(cod_orcamento, cod_prod, quantidade, desconto_prod, valor_unidade)"
                        + "VALUES('" + cod + "',"
                        + "'" + produto.getId() + "',"
                        + "'" + produto.getQuantidade().replace(".", ",") + "',"
                        + "'" + produto.getDesconto().replace(".", ",") + "',"
                        + "'" + produto.getValorVenda().replace(".", ",") + "')";
                
                stm.executeUpdate(sql);
                System.out.println("Produto inserido com sucesso!");
            }
            result = true;
            stm.close();
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar Inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Atualiza o orçamento ja cadastrao no banco de dados
    public boolean atualizar(Orcamento orcamento, List<Produto> produtolist){
        boolean result = false;
        
        //SQL para atualizar os dados do orçamento
        String sqlUpd = "UPDATE orcamento"
                    + " SET id_funcionario = '" + orcamento.getIdFuncionario() + "',"
                    + "id_cliente = '" + orcamento.getIdCliente() + "',"
                    + "sub_Total = '" + orcamento.getSubTotal().replace(".", ",") + "',"
                    + "forma_pagamento = '" + orcamento.getFormaPagamento() + "',"
                    + "desconto_valor = '" + orcamento.getDesconto().replace(".", ",") + "',"
                    + "total_orcamento = '" + orcamento.getTotal().replace(".", ",") + "',"
                    + "orbservacoes_orcamento = '" + orcamento.getObservacoes()+ "' "
                + "WHERE cod_orcamento = " + orcamento.getId() + "";
        
        String sqlDel = "DELETE FROM itensorcamento WHERE cod_orcamento = " + orcamento.getId() + "";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            
            //Atualiza o orcamento
            stm.executeUpdate(sqlUpd);
            
            //Apaga os produtos que existiam no ormçamento
            stm.executeUpdate(sqlDel);
            
            //SQL para atualizar os produtos do orçamento
            for (Produto produto : produtolist){
                String sqlProd = "INSERT INTO ItensOrcamento(cod_orcamento, cod_prod, quantidade, desconto_prod, valor_unidade)"
                        + "VALUES('" + orcamento.getId() + "',"
                        + "'" + produto.getId() + "',"
                        + "'" + produto.getQuantidade().replace(".", ",") + "',"
                        + "'" + produto.getDesconto().replace(".", ",") + "',"
                        + "'" + produto.getValorVenda().replace(".", ",") + "')";
                
                stm.executeUpdate(sqlProd);
                System.out.println("Produto Atualizado com sucesso!");
            }
            
            System.out.println("Orcamento Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    
    //Consulta para verificar se tal orcamento ja esta cadastrado
    public boolean existenciaOrcamento(Orcamento orcamento){
        boolean result = false;
        String sql = "SELECT cod_orcamento id FROM orcamento WHERE cod_orcamento = '" + orcamento.getId() + "'";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            //Checa se o valor ja existe
            if(rs.isBeforeFirst() || rs.isAfterLast()){
                result = true;
            }else{
                result = false;
            }
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
}
