/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.io.Serializable;

/**
 *
 * @author Whoslala
 */
public class Thermostat implements Serializable {
    private int temperature = 68;
    private boolean lockTemperature = false;
    
    public int getTemperature() {
        return temperature;
    }
    
    public void setTemperature(int temperature) {
        if (lockTemperature = false)
            this.temperature = temperature;
    }
    
    public void turnUpTemperature() {
        if (lockTemperature = false)
            this.temperature = temperature + 1;
    }
    
    public void turnDownTemperature() {
        if (lockTemperature = false)
            this.temperature = temperature - 1;
    }
    
    public void lockTemperature() {
        this.lockTemperature = true;
    }
    
    public void unlockTemperature() {
        this.lockTemperature = false;
    }
}
