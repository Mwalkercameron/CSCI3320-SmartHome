/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import util.OracleConnection;
import java.util.List;

/**
 *
 * @author jcorbett
 */
public class AudioHomeSystem implements Serializable {
    private String volume;
    private String sound;

    //define DB connection
    private Connection conn = null;
    
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean confirm(String vlm, String snd){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            String sql = "select volume, sound from AudioHomeSystem where "
                    + " volume = ? and sound = ?";
            //create statement
            PreparedStatement stmt
                    = conn.prepareStatement(sql);
            stmt.setString(1, vlm);
            stmt.setString(2, snd);
            //run SQL
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //combination of vlm/snd is correct
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
    
    public List<AudioHomeSystem> getInfo(){
        List<AudioHomeSystem> info = new ArrayList<AudioHomeSystem>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "select volume, sound from AudioHomeSystem";
            Statement stmt = conn.createStatement();
            //Run SQL
            ResultSet rs = stmt.executeQuery(sql);
            //Process resultset
            while(rs.next()){
                //pull data in resultset
                //get volume and sound
                AudioHomeSystem options = new AudioHomeSystem();
                options.setVolume(rs.getString(1)); //volume
                options.setSound(rs.getString(2)); //Sound
                info.add(options);
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        return info;
    }//end ListAudio
    
    //test functions in Membership
    public static void main(String[] args){
        String volume = "100";
        String sound = "on";
        
        AudioHomeSystem mems = new AudioHomeSystem();
        if(mems.confirm(volume, sound)){
            System.out.println(volume + " Welcome to AudioHomeSystem");
        }
        else{
            System.out.println(volume + " does not has access!!!");
        }
    }
    
}
