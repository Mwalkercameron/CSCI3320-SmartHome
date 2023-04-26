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
public class Camera implements Serializable {
    private String cameraID;
    private String cLocation;
    private String resolution;
    private String cName;

    //define DB connection
    private Connection conn = null;
    
    public String getCameraID() {
        return cameraID;
    }

    public void setCameraID(String cameraID) {
        this.cameraID = cameraID;
    }

    public String getCLocation() {
        return cLocation;
    }

    public void setCLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public boolean information(String cID, String cLoc, String res, String cN){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            String sql = "select cameraid, clocation, resolution, "
                    + "cname from camera where "
                    + " cameraid = ? and clocation = ? and resolution = ?"
                    + " and cname = ?";
            //create statement
            PreparedStatement stmt
                    = conn.prepareStatement(sql);
            stmt.setString(1, cID);
            stmt.setString(2, cLoc);
            stmt.setString(3, res);
            stmt.setString(4, cN);
            //run SQL
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //combination of cID, cLoc, res, and cN is correct
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
    
    public List<Camera> getInfo(){
        List<Camera> info = new ArrayList<Camera>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "select cameraid, clocation, resolution, cname from camera";
            Statement stmt = conn.createStatement();
            //Run SQL
            ResultSet rs = stmt.executeQuery(sql);
            //Process resultset
            while(rs.next()){
                //pull data in resultset
                //get camera info
                Camera display = new Camera();
                display.setCameraID(rs.getString(1)); //Camera ID
                display.setCLocation(rs.getString(2)); //Camera Location
                display.setResolution(rs.getString(3)); //Camera Resolution
                display.setCName(rs.getString(4));//Camera Name
                info.add(display);
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        return info;
    }//end ListCamera
    
    //test functions in Membership
    public static void main(String[] args){
        String cameraID = "10";
        String cLocation = "living room";
        String resolution = "1920*1080";
        String cName = "camera1";
        
        Camera mem = new Camera();
        if(mem.information(cameraID, cLocation, resolution, cName)){
            System.out.println(cName + " Hello");
        }
        else{
            System.out.println(cName + "does not has access!!!");
        }
    }
    
}
