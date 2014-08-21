/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author monan
 */
public class Database {
    
    private final String DATABASE = "xe";
    //private final String HOST = "jdbc:oracle:thin:@//25.176.118.32:1521/" + DATABASE;
    private final String HOST = "jdbc:oracle:thin:@//localhost:1521/" + DATABASE;
    private final String USER = "PoolOrc";
    private final String PASSWORD = "PoolOrcNWK";
    private Connection connection;
    
    private static Database instance;
    
    
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        if (connection == null){
            connection = DriverManager.getConnection(HOST,USER,PASSWORD);
        }
        return connection;
    }    
    
}
