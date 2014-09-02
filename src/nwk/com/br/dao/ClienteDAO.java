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
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
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
}