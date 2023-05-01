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
    private int minimumTemperature = 32;
    private int maximumTemperature = 100;
    
    public int getTemperature() {
        return this.temperature;
    }
    
    public boolean adjustThermostat(String temperature) {
        if (Integer.parseInt(temperature) < minimumTemperature || Integer.parseInt(temperature) > maximumTemperature) {
            return false;
        }
        this.temperature = Integer.parseInt(temperature);
        return true;
    }

    
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        System.out.println(thermostat.getTemperature());
    }
}
