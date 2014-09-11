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
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
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
}
