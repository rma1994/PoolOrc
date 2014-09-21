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
import nwk.com.br.model.Similar;
import nwk.com.br.repository.Database;

/**
 *
 * @author Richard Matheus
 */
public class SimilarDAO {
    private Connection conn;
    
    //Função para checar o ultimo ID cadastrado no DB
    public int checarID(){
        int result = 0;
        String sql = "SELECT MAX(cod_similar) id FROM similar";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            rs.next();
            Similar similar = new Similar();
            similar.setId(rs.getInt("id")+1);
            result = similar.getId();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o id \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Função para inserir o similar no banco de dados
    public boolean inserir(Similar similar){
        boolean result = false;
        
        String sql = "INSERT INTO similar(descricao_similar) VALUES('" + similar.getDescricao()+ "') ";
                                                                                                    
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Similar inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    
    //Consulta para verificar se tal familia ja esta cadastrado
    public boolean existenciaFamilia(Similar similar){
        boolean result = false;
        String sql = "SELECT cod_similar id FROM similar WHERE cod_similar = " + similar.getId();
        
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
    
    
    //Atualiza o similar ja cadastrao no banco de dados
    public boolean atualizar(Similar similar){
        boolean result = false;
        
        String sql = "UPDATE similar"
                    + " SET descricao_similar = '" + similar.getDescricao()+ "'"
                + "WHERE cod_similar = " + similar.getId();
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Similar Atualizada Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    
    //Pega todos os 'similares' cadastrados no banco de dados
    public List<Similar> getTodosSimilares(){     
                
        List<Similar> result = new ArrayList<Similar>();
        String sql = "SELECT * FROM similar ORDER BY cod_similar";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Similar similar = new Similar();
                similar.setId(rs.getInt("cod_similar"));
                similar.setDescricao(rs.getString("descricao_similar"));
                result.add(similar);
            }
            
            
        }catch(Exception e){
            //e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
}
