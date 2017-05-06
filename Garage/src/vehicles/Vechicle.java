/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

/**
 *
 * @author Alek
 */
public class Vechicle {
    
    private String licence_plate;
    private boolean parked;
    private String typeOfVechicle;

    public Vechicle() {
    }

    public Vechicle(String licence_plate, boolean parked, String typeOfVechicle) {
        this.licence_plate = licence_plate;
        this.parked = parked;
        this.typeOfVechicle = typeOfVechicle;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public boolean isParked() {
        return parked;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    public String getTypeOfVechicle() {
        return typeOfVechicle;
    }

    public void setTypeOfVechicle(String typeOfVechicle) {
        this.typeOfVechicle = typeOfVechicle;
    }


    
    
            
}
