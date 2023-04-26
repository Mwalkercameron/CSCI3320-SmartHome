/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.OracleConnection;
import java.io.Serializable;

/**
 *
 * @author monte
 */
public class Homeowner implements Serializable {
    private String accountID;
    private String fName;
    private String lName;
    private String email;
    
    private Connection conn = null;
    
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String membershipID) {
        this.accountID = membershipID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean login(String email, String pwd){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            String sql = "select * from membership where " + " email = ? and password = ?";
            //Create statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, pwd);
            //run SQL
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //combo of email/pwd is correct
                validated = true;
            }
            
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        
        return validated;
    }
        
        public List<Homeowner> getOwners(){
        List<Homeowner> owners = new ArrayList<Homeowner>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "select email, fname, lname from membership";
            Statement stmt = conn.createStatement();
            //Run SQL
            ResultSet rs = stmt.executeQuery(sql);
            //Process resultset
            while(rs.next()){
                Homeowner owner = new Homeowner();
                owner.setEmail(rs.getString(1));//email
                owner.setfName(rs.getString(2));//First name
                owner.setlName(rs.getString(3));//last name
                owners.add(owner);
            }
        } catch(Exception exp) {
            exp.printStackTrace();
        }finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        return owners;
    }//end getOwners()
    
        
    public static void main(String[] args) {
        String email = "jdoe@clayton.edu";
        String password = "0k123";
        
        Homeowner owner = new Homeowner();
        if(owner.login(email, password)){
            System.out.println(email + " Welcome to SmartHome");
            
        }else{
            System.out.println(email + "does not have access");
        }
    }
}