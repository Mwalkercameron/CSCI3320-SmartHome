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
    private boolean enabledSmartHome;
    private boolean enabledCamera;
    
    public void turnOnSmartHome() {
        this.enabledSmartHome = true;
    }
    
    public void turnOffSmartHome() {
        this.enabledSmartHome = false;
    }
    
    public void turnOnDoors() {
        this.enabledDoors = true;
    }
    
    public void turnOffDoors() {
        this.enabledDoors = false;
    }
    
    public void turnOnLights() {
        this.enabledLights = true;
    }
    
    public void turnOffLights() {
        this.enabledLights = false;
    }
    
    public void turnOnThermostat() {
        this.enabledThermostat  = true;
    }
    
    public void turnOffThermostat() {
        this.enabledThermostat = false;
    }
    
    public void turnOnCamera() {
        this.enabledCamera = true;
    }
    
    public void turnOffCamera() {
        this.enabledCamera = false;
    }
}
