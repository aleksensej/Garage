/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

/**
 *
 * @author Alek
 */
public class ParkingSpace {
    
    private int parking_spade_id;
    private String licence_plate;
    private String type;

    public ParkingSpace() {
    }
    
    public ParkingSpace(int parking_spade_id, String licence_plate, String type) {
        this.parking_spade_id = parking_spade_id;
        this.licence_plate = licence_plate;
        this.type = type;
    }

    public int getParking_spade_id() {
        return parking_spade_id;
    }

    public void setParking_spade_id(int parking_spade_id) {
        this.parking_spade_id = parking_spade_id;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
