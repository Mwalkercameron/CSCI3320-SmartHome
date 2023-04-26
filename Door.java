/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.sql.*;
import util.OracleConnection;
import java.util.*;
/**
 *
 * @author ajohnbellot
 */
public class Door implements Serializable
{
    private String location;
  
    private Connection conn = null;
    
    
    public String getLocation() 
    {
        return location;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    
    public boolean Entrance(String area)
    {
        boolean validated = false;
        try
        {
           conn = OracleConnection.getConnection();
           String sql = "select * from door where "
                   + " location =? ";
           
           
           PreparedStatement stmt
                   = conn.prepareStatement(sql);
                   
           stmt.setString(1, area);
          
           ResultSet rs = stmt.executeQuery();
           if(rs.next())
           {
               
               validated = true;
           }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            conn = null;
            OracleConnection.closeConnection();
        }
        
        return validated;
    }
    
    public List<Door> getDoors()
    {
        List<Door> dr = new ArrayList<Door>();
        
        try
        {
            conn = OracleConnection.getConnection();
            String sql = "select location from door";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                Door doors = new Door();
                doors.setLocation(rs.getString(1));
                dr.add(doors);
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            conn = null;
            OracleConnection.closeConnection();
        }
        return dr;
    }
    
    public static void main(String[] args)
    {
        String location = "Garage Entrance";
        
                
        Door dr = new Door();
        if( dr.Entrance(location) )
        {
            System.out.println(location + " door is open.");
        }
        else
        {
            System.out.println(location + " door is closed.");
        }
    }
}