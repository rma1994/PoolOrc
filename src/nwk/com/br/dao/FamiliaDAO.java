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
    
    
    //Função para inserir o cliente no banco de dados
    public boolean inserir(Familia familia){
        boolean result = false;
        
        String sql = "INSERT INTO familia(descricao_familia) VALUES('" + familia.getDescricao()+ "') ";
                                                                                                    
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Familia inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
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
    
    //Consulta para verificar se tal familia ja esta cadastrado
    public boolean existenciaFamilia(Familia familia){
        boolean result = false;
        String sql = "SELECT cod_familia id FROM familia WHERE cod_familia = " + familia.getId();
        
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
    public boolean atualizar(Familia familia){
        boolean result = false;
        
        String sql = "UPDATE familia"
                    + " SET descricao_familia = '" + familia.getDescricao()+ "'"
                + "WHERE cod_familia = " + familia.getId();
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Familia Atualizada Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
}
