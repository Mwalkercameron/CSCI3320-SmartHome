/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.*;

/**
 *
 *@author Monte
 */
public class OracleConnection {
    private static Connection connection = null;
    
    public static Connection getConnection(){
        try{
            System.out.println("Connecting to Oracle...");
            //load jbdc driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create connection object
            connection = DriverManager.getConnection(
             "jdbc:oracle:thin:@168.28.42.148:1521:csit", 
             "mwalkercameron", 
             "mwalkercameron");
        }catch(Exception exps){
            exps.printStackTrace();
            return null;
        }
        return connection;
    }
    
    public static void closeConnection(){
        try{
            //close connection
            connection.close();
    }catch(Exception exps){
        exps.printStackTrace();
            
    
        }
    }
    //build main function 
    public static void main(String[] args) {
        try{
            /*
            Step 1: get oracle connecction handled
            step2: build SQL command and statement
            step 3: process returned results from DB
            */
            
            //connection
            Connection conn = OracleConnection.getConnection();
            
            //Build sql
            String sql = "select sysdate from dual";
            
            //execute
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            //Process results
            while(rs.next()){
                //pull data in result set
                System.out.println("Current Oracle server time is: "+ rs.getString(1));
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            OracleConnection.closeConnection();
        }
    }
}
