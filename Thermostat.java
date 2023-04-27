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
    
    public int getTemperature() {
        return temperature;
    }
    

    public boolean turnUpTemperature(String temperature) {
        if (this.temperature == 100) {
            return false;
        }
        this.temperature = this.temperature + 1;
        return true;
    }
    
    public boolean turnDownTemperature(String temperature) {
        if (this.temperature == 32) {
            return false;
        }
        this.temperature = this.temperature - 1;
        return true;
    }
    

    
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        System.out.println(thermostat.getTemperature());
    }
}
