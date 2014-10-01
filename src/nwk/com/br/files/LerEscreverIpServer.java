/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard Matheus
 */
public class LerEscreverIpServer {
    
    public void setIp(String ip) throws Exception{        
        File arquivo;
        
        //Abre o arquivo ou o cria e escreve o ip nele
        arquivo = new File("C:\\PoolOrc\\IPServer.txt");
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter(fw);
            
        bw.write(ip);
        bw.flush();
        bw.close();
    }
    
    public String getIp(){
        String ip = "localhost";
        
        try{
            //Le o arquivo em questao
            File file = new File("C:\\PoolOrc\\IPServer.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ip = br.readLine();
            br.close();
        }catch(Exception e){
            System.out.println("Erro ao tentar consultar ip do host (" + this.getClass().getName().toString() + ") - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar ip do host (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        
        return ip;
    }
    
}
