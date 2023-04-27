/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Whoslala
 */
public class EnabledOrDisabled {
    private boolean enabledDoors;
    private boolean enabledLights;
    private boolean enabledThermostat;
    private boolean enabledSmartHome = true;
    private String enabledSmartHomeS;
    private boolean enabledCamera;
    
    public void turnOnSmartHome() {
        this.enabledSmartHome = true;
        this.enabledSmartHomeS = "true";
    }
    
    public void turnOffSmartHome() {
        this.enabledSmartHome = false;
        this.enabledSmartHomeS = "false";
    }
    
    public void turnOnDoors() {
        if (enabledSmartHome == true)
            this.enabledDoors = true;
    }
    
    public void turnOffDoors() {
        if (enabledSmartHome == true)
            this.enabledDoors = false;
    }
    
    public void turnOnLights() {
        if (enabledSmartHome == true)
            this.enabledLights = true;
    }
    
    public void turnOffLights() {
        if (enabledSmartHome == true)
            this.enabledLights = false;
    }
    
    public void turnOnThermostat() {
        if (enabledSmartHome == true)
            this.enabledThermostat  = true;
    }
    
    public void turnOffThermostat() {
        if (enabledSmartHome == true)
            this.enabledThermostat = false;
    }
    
    public void turnOnCamera() {
        if (enabledSmartHome == true)
            this.enabledCamera = true;
    }
    
    public void turnOffCamera() {
        if (enabledSmartHome == true)
            this.enabledCamera = false;
    }
    
    public boolean checkCurrent(boolean enabledSmartHome) {
        return enabledSmartHome;
    }
    
    public static void main(String[] args) {
        EnabledOrDisabled onOrOff = new EnabledOrDisabled();
    }
}
