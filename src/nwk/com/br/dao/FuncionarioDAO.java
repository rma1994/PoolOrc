/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.dao;

import nwk.com.br.repository.Database;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Funcionario;
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
public class FuncionarioDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(id_funcionario) id FROM funcionario";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id")+1);
            result = funcionario.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Função para inserir o cliente no banco de dados
    public boolean inserir(Funcionario funcionario){
        boolean result = false;
        
        String sql = "INSERT INTO funcionario(nome_funcionario, cpf_funcionario, datanasc_funcionario, telefone_funcionario, celular_funcionario, email_funcionario, rua_funcionario, numero_funcionario, bairro_funcionario, complemento_funcionario, cidade_funcionario, estado_funcionario, cep_funcionario, numcarteiratrab_funcionario, seriecarteiratrab_funcionario, datacontra_funcionario, datademiss_funcionario, observacoes_funcionario, ativo_funcionario) "
                                                                                             + "VALUES('" + funcionario.getNome()+ "',"
                                                                                                    + "'" + funcionario.getCpf()+ "',"
                                                                                                    + "'" + formatDate.format(funcionario.getDhNascimento())+ "',"
                                                                                                    + "'" + funcionario.getTelefone()+ "',"
                                                                                                    + "'" + funcionario.getCelular()+ "',"
                                                                                                    + "'" + funcionario.getEmail()+ "',"
                                                                                                    + "'" + funcionario.getRua()+ "',"
                                                                                                    + "'" + funcionario.getNumero()+ "',"
                                                                                                    + "'" + funcionario.getBairro()+ "',"
                                                                                                    + "'" + funcionario.getComplemento()+ "',"
                                                                                                    + "'" + funcionario.getCidade()+ "',"
                                                                                                    + "'" + funcionario.getEstado()+ "',"
                                                                                                    + "'" + funcionario.getCep()+ "',"
                                                                                                    + "'" + funcionario.getNumcarteiratrab()+ "',"
                                                                                                    + "'" + funcionario.getSeriecarteiratrab()+ "',"
                                                                                                    + "'" + formatDate.format(funcionario.getDhContrato()) + "',"
                                                                                                    + "'" + formatDate.format(funcionario.getDhDemissao()) + "',"
                                                                                                    + "'" + funcionario.getObservacoes()+ "',"
                                                                                                    + "'" + funcionario.getStatus().getValue() + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Funcionario inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Pega todos os funcionarios cadastrados no banco de dados
    public List<Funcionario> getTodosFuncionarios(){     
                
        List<Funcionario> result = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario ORDER BY id_funcionario";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome_funcionario"));
                funcionario.setCpf(rs.getString("CPF_FUNCIONARIO"));
                funcionario.setDhNascimento(formatDate.format(rs.getDate("datanasc_funcionario")).toString());
                funcionario.setTelefone(rs.getString("telefone_funcionario"));
                funcionario.setCelular(rs.getString("celular_funcionario"));
                funcionario.setEmail(rs.getString("email_funcionario"));
                funcionario.setRua(rs.getString("rua_funcionario"));
                funcionario.setNumero(rs.getString("numero_funcionario"));
                funcionario.setBairro(rs.getString("bairro_funcionario"));
                funcionario.setComplemento(rs.getString("complemento_funcionario"));
                funcionario.setCidade(rs.getString("cidade_funcionario"));
                funcionario.setEstado(rs.getString("estado_funcionario"));
                funcionario.setCep(rs.getString("cep_funcionario"));
                funcionario.setNumcarteiratrab(rs.getString("numcarteiratrab_funcionario"));
                funcionario.setSeriecarteiratrab(rs.getString("seriecarteiratrab_funcionario"));
                funcionario.setDhContrato(formatDate.format(rs.getDate("datacontra_funcionario")).toString());
                funcionario.setDhDemissao(formatDate.format(rs.getDate("datademiss_funcionario")).toString());
                funcionario.setObservacoes(rs.getString("observacoes_funcionario"));
                funcionario.setStatus(StatusRepository.getByValue(rs.getString("ativo_funcionario")));
                
                result.add(funcionario);
            }
            
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    
    }
    
    //Consulta para verificar se tal cliente ja esta cadastrado
    public boolean existenciaFuncionario(Funcionario funcionario){
        boolean result = false;
        String sql = "SELECT id_funcionario id FROM funcionario WHERE id_funcionario = " + funcionario.getId();
        
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
    public boolean atualizar(Funcionario funcionario){
        boolean result = false;
        
        String sql = "UPDATE funcionario"
                    + " SET nome_funcionario = '" + funcionario.getNome() + "',"
                    + "cpf_funcionario = '" + funcionario.getCpf() + "',"
                    + "datanasc_funcionario = '" + formatDate.format(funcionario.getDhNascimento()) + "',"
                    + "telefone_funcionario = '" + funcionario.getTelefone() + "',"
                    + "celular_funcionario = '" + funcionario.getCelular() + "',"
                    + "email_funcionario = '" + funcionario.getEmail() + "',"
                    + "rua_funcionario = '" + funcionario.getRua() + "',"
                    + "numero_funcionario = '" + funcionario.getNumero() + "',"
                    + "bairro_funcionario = '" + funcionario.getBairro() + "',"
                    + "complemento_funcionario = '" + funcionario.getComplemento() + "',"
                    + "estado_funcionario = '" + funcionario.getEstado() + "',"
                    + "cep_funcionario = '" + funcionario.getCep() + "',"
                    + "numcarteiratrab_funcionario = '" + funcionario.getNumcarteiratrab() + "',"
                    + "seriecarteiratrab_funcionario = '" + funcionario.getSeriecarteiratrab() + "',"
                    + "observacoes_funcionario = '" + funcionario.getObservacoes()+ "',"
                    + "datacontra_funcionario = '" + formatDate.format(funcionario.getDhContrato()) + "',"
                    + "datademiss_funcionario = '" + formatDate.format(funcionario.getDhContrato()) + "',"
                    + "ativo_funcionario = '" + funcionario.getStatus().getValue() + "'"
                + "WHERE id_funcionario = " + funcionario.getId();
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Funcionario Atualizado Com Sucesso!");
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
        
        String sql = "SELECT COUNT(*) qtd FROM funcionario";
        
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
}
