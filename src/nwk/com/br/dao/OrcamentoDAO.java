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
import javax.swing.JOptionPane;
import nwk.com.br.model.Orcamento;
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
}
