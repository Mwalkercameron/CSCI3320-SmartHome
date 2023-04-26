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
public class LightSwitch implements Serializable
{
    private String room;
    private String brightness;
    private String contrast;

  
    private Connection conn = null;
    
    
    public String getRoom() 
    {
        return room;
    }

    public void setRoom(String room) 
    {
        this.room = room;
    }
    
    public String getBrightness() 
    {
        return brightness;
    }

    public void setBrightness(String brightness) 
    {
        this.brightness = brightness;
    }
    
    public String getContrast() 
    {
        return contrast;
    }

    public void setContrast(String contrast) 
    {
        this.contrast = contrast;
    }

    
    public boolean lSwitch(String toggleOn, String toggleOff)
    {
        boolean validated = false;
        try
        {
           conn = OracleConnection.getConnection();
           String sql = "select * from light where "
                   + " brightness =? and contrast =?";
           
           
           PreparedStatement stmt
                   = conn.prepareStatement(sql);
                   
           stmt.setString(1, toggleOn);
           stmt.setString(2, toggleOff);
           
          
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
    
    public List<LightSwitch> getLights()
    {
        List<LightSwitch> ls = new ArrayList<LightSwitch>();
        
        try
        {
            conn = OracleConnection.getConnection();
            String sql = "select room, contrast, brightness from light";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                LightSwitch lights = new LightSwitch();
                lights.setRoom(rs.getString(1));
                lights.setBrightness(rs.getString(2));
                lights.setContrast(rs.getString(3));
                ls.add(lights);
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
        return ls;
    }
    
    public static void main(String[] args)
    {
        String room = "Bedroom";
        String brightness = "high";
        String contrast = "high";
                
        LightSwitch ls = new LightSwitch();
        if( ls.lSwitch(contrast, brightness) )
        {
            System.out.println("The lights are on in the " + room);
        }
        else
        {
            System.out.println("The Lights are off in the " + room);
        }
    }
}
