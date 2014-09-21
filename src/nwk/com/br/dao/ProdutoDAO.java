/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import nwk.com.br.model.Produto;
import nwk.com.br.repository.Database;

/**
 *
 * @author Richard Matheus
 */
public class ProdutoDAO {
    private Connection conn;
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(cod_prod) id FROM produto";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Produto produto = new Produto();
            produto.setId(rs.getInt("id")+1);
            result = produto.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
}
