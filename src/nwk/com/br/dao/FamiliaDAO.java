/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nwk.com.br.enums.StatusRepository;
import nwk.com.br.model.Familia;
import nwk.com.br.repository.Database;

/**
 *
 * @author Richard Matheus
 */
public class FamiliaDAO {
    private Connection conn;
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(cod_familia) id FROM familia";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Familia familia = new Familia();
            familia.setId(rs.getInt("id")+1);
            result = familia.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Pega todos os funcionarios cadastrados no banco de dados
    public List<Familia> getTodasFamilias(){     
                
        List<Familia> result = new ArrayList<Familia>();
        String sql = "SELECT * FROM familia ORDER BY cod_familia";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Familia familia = new Familia();
                familia.setId(rs.getInt("cod_familia"));
                familia.setDescricao(rs.getString("descricao_familia"));
                result.add(familia);
            }
            
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    
    }
}
