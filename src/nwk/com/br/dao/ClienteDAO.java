/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.dao;

import nwk.com.br.repository.Database;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard Matheus
 */
public class ClienteDAO {
    private Connection conn;
    
    public ClienteDAO(){
      
    }
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(id_cliente) id FROM cliente";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id")+1);
            result = cliente.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Consulta para verificar se tal cliente ja esta cadastrado
    public boolean existenciaCliente(Cliente cliente){
        boolean result = false;
        String sql = "SELECT id_cliente id FROM cliente WHERE id_cliente = " + cliente.getId();
        
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
    
    //Função para inserir o cliente no banco de dados
    public boolean inserir(Cliente cliente){
        boolean result = false;
        
        String sql = "INSERT INTO cliente(tipo_cliente, nome_cliente, cpf_cnpj_cliente, rua_cliente, bairro_cliente, numero_end_cliente, complemento_cliente, cep_cliente, cidade_cliente, estado_cliente, telefone_cliente, celular_cliente, email_cliente, ativo_cliente, observacoes_cliente) "
                                                                                             + "VALUES('" + cliente.getTipoCliente()+ "',"
                                                                                                    + "'" + cliente.getNome() + "',"
                                                                                                    + "'" + cliente.getCpf_cnpj()+ "',"
                                                                                                    + "'" + cliente.getRua()+ "',"
                                                                                                    + "'" + cliente.getBairro()+ "',"
                                                                                                    + "'" + cliente.getNumero()+ "',"
                                                                                                    + "'" + cliente.getComplemento()+ "',"
                                                                                                    + "'" + cliente.getCep()+ "',"
                                                                                                    + "'" + cliente.getCidade()+ "',"
                                                                                                    + "'" + cliente.getEstado()+ "',"
                                                                                                    + "'" + cliente.getTelefone()+ "',"
                                                                                                    + "'" + cliente.getCelular()+ "',"
                                                                                                    + "'" + cliente.getEmail()+ "',"
                                                                                                    + "'" + cliente.getStatus().getValue() + "',"
                                                                                                    + "'" + cliente.getObservacoes() + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Usuario inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Atualiza o cliente ja cadastrao no banco de dados
    public boolean atualizar(Cliente cliente){
        boolean result = false;
        
        String sql = "UPDATE cliente"
                    + " SET tipo_cliente = '" + cliente.getTipoCliente() + "',"
                    + "nome_cliente = '" + cliente.getNome() + "',"
                    + "cpf_cnpj_cliente = '" + cliente.getCpf_cnpj() + "',"
                    + "rua_cliente = '" + cliente.getRua() + "',"
                    + "bairro_cliente = '" + cliente.getBairro() + "',"
                    + "numero_end_cliente = '" + cliente.getNumero() + "',"
                    + "complemento_cliente = '" + cliente.getComplemento() + "',"
                    + "cep_cliente = '" + cliente.getCep() + "',"
                    + "cidade_cliente = '" + cliente.getCidade() + "',"
                    + "estado_cliente = '" + cliente.getEstado() + "',"
                    + "telefone_cliente = '" + cliente.getTelefone() + "',"
                    + "celular_cliente = '" + cliente.getCelular() + "',"
                    + "email_cliente = '" + cliente.getEmail() + "',"
                    + "ativo_cliente = '" + cliente.getStatus().getValue() + "',"
                    + "observacoes_cliente = '" + cliente.getObservacoes() + "' "
                + "WHERE id_cliente = " + cliente.getId();
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Usuario Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Retorna todas as informações do cliente
    public Cliente select(int id){
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id_cliente = " + id;
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){        
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setTipoCliente(rs.getString("tipo_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCpf_cnpj(rs.getString("cpf_cnpj_cliente"));
                cliente.setRua(rs.getString("rua_cliente"));
                cliente.setBairro(rs.getString("bairro_cliente"));
                cliente.setNumero(rs.getString("numero_end_cliente"));
                cliente.setComplemento(rs.getString("complemento_cliente"));
                cliente.setCep(rs.getString("cep_cliente"));
                cliente.setCidade(rs.getString("cidade_cliente"));
                cliente.setEstado(rs.getString("estado_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setCelular(rs.getString("celular_cliente"));
                cliente.setEmail(rs.getString("celular_cliente"));
                cliente.setStatus(StatusRepository.getByValue(rs.getString("ativo_cliente")));
                cliente.setObservacoes(rs.getString("observacoes_cliente"));
            }
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return cliente;
    }
    
    //Retorna o ultimo cliente inserido no banco de dados.
    /*public Cliente selectNovoCliente(){
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id_cliente = (" + checarID() + ")";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){        
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setTipoCliente(rs.getString("tipo_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCpf_cnpj(rs.getString("cpf_cnpj_cliente"));
                cliente.setRua(rs.getString("rua_cliente"));
                cliente.setBairro(rs.getString("bairro_cliente"));
                cliente.setNumero(rs.getString("numero_end_cliente"));
                cliente.setComplemento(rs.getString("complemento_cliente"));
                cliente.setCep(rs.getString("cep_cliente"));
                cliente.setCidade(rs.getString("cidade_cliente"));
                cliente.setEstado(rs.getString("estado_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setCelular(rs.getString("celular_cliente"));
                cliente.setEmail(rs.getString("celular_cliente"));
                cliente.setStatus(StatusRepository.getByValue(rs.getString("ativo_cliente")));
                cliente.setObservacoes(rs.getString("observacoes_cliente"));
            }
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return cliente;
    }*/
    
    
    //Pega todos os Clientes cadastrados no banco de dados
    public List<Cliente> getTodosClientes(){     
                
        List<Cliente> result = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente ORDER BY id_cliente";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setTipoCliente(rs.getString("tipo_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCpf_cnpj(rs.getString("cpf_cnpj_cliente"));
                cliente.setRua(rs.getString("rua_cliente"));
                cliente.setBairro(rs.getString("bairro_cliente"));
                cliente.setNumero(rs.getString("numero_end_cliente"));
                cliente.setComplemento(rs.getString("complemento_cliente"));
                cliente.setCep(rs.getString("cep_cliente"));
                cliente.setCidade(rs.getString("cidade_cliente"));
                cliente.setEstado(rs.getString("estado_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setCelular(rs.getString("celular_cliente"));
                cliente.setEmail(rs.getString("email_cliente"));
                cliente.setStatus(StatusRepository.getByValue(rs.getString("ativo_cliente")));
                cliente.setObservacoes(rs.getString("observacoes_cliente"));
                
                result.add(cliente);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Pega a quantia de linhas da tabela
    public int getQuantiaLinha(){
        int qtd=0;
        
        String sql = "SELECT COUNT(*) qtd FROM cliente";
        
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
    
    
    //Retorna o cliente que mais comprou
    public List<Cliente> getClienteMaisComprou(){
        List<Cliente> result = new ArrayList<Cliente>();
        
        /*String subquery = "(SELECT MAX (SUM(v.quantidade * v.valor_unidade)) "
                            + "FROM Cliente c, Orcamento o, ItensOrcamento v "
                            + "WHERE v.cod_orcamento = o.cod_orcamento "
                            + "AND c.id_cliente = o.id_cliente "
                            + "GROUP BY nome_cliente) ";*/
        
        String sql = "SELECT c.id_cliente, c.nome_cliente, SUM(v.quantidade * v.valor_unidade) \"soma\" "
         + "FROM Cliente c, ItensOrcamento v, Orcamento o "
         + "WHERE v.cod_orcamento = o.cod_orcamento "
         + "AND c.id_cliente = o.id_cliente "
         + "GROUP BY c.ID_CLIENTE, c.nome_cliente "
         + "ORDER BY \"soma\" DESC";
        // + "HAVING SUM(v.quantidade * v.valor_unidade) = " + subquery;
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            //System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(rs.getString("id_cliente")));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setTotalCompra(rs.getString("soma"));
                
                result.add(cliente);
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
}