/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nwk.com.br.model.Produto;
import nwk.com.br.repository.Database;

/**
 *
 * @author Richard Matheus
 */
public class ProdutoDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    //Função para checar o ultimo ID cadastrado no DB
    public String checarID(){
        String result = "0";
        String sql = "SELECT MAX(cod_prod) id FROM produto";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Produto produto = new Produto();
            produto.setId(rs.getString("id"));
            result = produto.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Função para inserir o produto no banco de dados
    public boolean inserir(Produto produto){
        boolean result = false;
        
        String sql = "INSERT INTO produto(cod_prod, cod_fabricante, dat_cadastro, descricao_pecas, marca_pecas, familia_pecas, similar_pecas, valor_compras, valor_vendas, porcentagem_venpecas, observacoes_produto) "
                + "VALUES('" + produto.getId() + "',"
                    + "'" + produto.getIdFabricante() + "',"
                    + "'" + formatDate.format(produto.getDhCadastro()) + "',"
                    + "'" + produto.getDescricao() + "',"
                    + "'" + produto.getMarca() + "',"
                    + "'" + produto.getFamilia() + "',"
                    + "'" + produto.getSimilar() + "',"
                    + "'" + produto.getValorCompra() + "',"
                    + "'" + produto.getValorVenda() + "',"
                    + "'" + produto.getPorcentagem() + "',"
                    + "'" + produto.getObservacoes() + "')";
                                                                                                    
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Produto inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Pega todos os produtos cadastrados no banco de dados
    public List<Produto> getTodosProdutos(){     
                
        List<Produto> result = new ArrayList<Produto>();
        String sql = "SELECT * FROM produto ORDER BY cod_prod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getString("cod_prod"));
                produto.setIdFabricante(rs.getString("cod_fabricante"));
                produto.setDhCadastro(formatDate.format(rs.getDate("dat_cadastro")).toString());
                produto.setDescricao(rs.getString("descricao_pecas"));
                produto.setMarca(rs.getString("marca_pecas"));
                produto.setFamilia(rs.getString("familia_pecas") + "-");//Esse - serve para indicar o final do index usada em Produto
                produto.setSimilar(rs.getString("similar_pecas") + "-");
                produto.setValorCompra(rs.getString("valor_compras"));
                produto.setValorVenda(rs.getString("valor_vendas"));
                produto.setPorcentagem(rs.getString("porcentagem_venpecas"));
                produto.setObservacoes(rs.getString("observacoes_produto"));
                
                result.add(produto);
            }
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Consulta para verificar se tal cliente ja esta cadastrado
    public boolean existenciaProduto(Produto produto){
        boolean result = false;
        String sql = "SELECT cod_prod id FROM produto WHERE cod_prod = '" + produto.getId() + "'";
        
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
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Atualiza o cliente ja cadastrao no banco de dados
    public boolean atualizar(Produto produto){
        boolean result = false;
        
        String sql = "UPDATE produto"
                    + " SET cod_fabricante = '" + produto.getIdFabricante() + "',"
                    + "descricao_pecas = '" + produto.getDescricao() + "',"
                    + "marca_pecas = '" + produto.getMarca() + "',"
                    + "familia_pecas = '" + produto.getFamilia() + "',"
                    + "similar_pecas = '" + produto.getSimilar() + "',"
                    + "valor_compras = '" + produto.getValorCompra() + "',"
                    + "valor_vendas = '" + produto.getValorVenda()+ "',"
                    + "porcentagem_venpecas = '" + produto.getPorcentagem()+ "',"
                    + "observacoes_produto = '" + produto.getObservacoes() + "'"
                + "WHERE cod_prod = '" + produto.getId() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Produto Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Retorna um produto
    public Produto select(String id){     
                
        Produto produto = new Produto();
        String sql = "SELECT * FROM produto WHERE cod_prod = '" + id +"'";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                produto.setId(rs.getString("cod_prod"));
                produto.setIdFabricante(rs.getString("cod_fabricante"));
                produto.setDhCadastro(formatDate.format(rs.getDate("dat_cadastro")).toString());
                produto.setDescricao(rs.getString("descricao_pecas"));
                produto.setMarca(rs.getString("marca_pecas"));
                produto.setFamilia(rs.getString("familia_pecas") + "-");//Esse - serve para indicar o final do index usada em Produto
                produto.setSimilar(rs.getString("similar_pecas") + "-");
                produto.setValorCompra(rs.getString("valor_compras"));
                produto.setValorVenda(rs.getString("valor_vendas"));
                produto.setPorcentagem(rs.getString("porcentagem_venpecas"));
                produto.setObservacoes(rs.getString("observacoes_produto"));
            }
            stm.close();
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return produto;
    }
}
