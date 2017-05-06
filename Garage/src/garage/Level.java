/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alek
 */
public class Level {
    
    private int lv_number;
    private int n_p_cars;
    private int n_p_motorbike;
    
    public List<ParkingSpace> parkingSpace;
     
    
    public void addCarParkingSpace (int num_p_cars){
        if (parkingSpace.isEmpty()){
            parkingSpace = new ArrayList<ParkingSpace>();
        }
        parkingSpace.add(new ParkingSpace(num_p_cars, null, "Car"));
        
    }
    
    public void addMotorParkingSpace (int num_p_motor){
        if (parkingSpace.isEmpty()){
            parkingSpace = new ArrayList<ParkingSpace>();
        }
        parkingSpace.add(new ParkingSpace(num_p_motor, null, "Motorbike"));
        
    }
    
    public void removeParkingSpace (int num_p){
        if (parkingSpace.isEmpty()){
        }
        parkingSpace.remove(num_p);
    }
    
    public String getLicence_plateFromParkingSpace(int lv_number){
        
        return parkingSpace.get(lv_number).getLicence_plate();
    }
    
    public Level(){
    }

    public Level(int lv_number, int n_p_cars, int n_p_motorbike) {
        this.lv_number = lv_number;
        this.n_p_cars = n_p_cars;
        this.n_p_motorbike = n_p_motorbike;
    }
    
    public int getLv_number() {
        return lv_number;
    }

    public void setLv_number(int lv_number) {
        this.lv_number = lv_number;
    }

    public int getN_p_cars() {
        return n_p_cars;
    }

    public void setN_p_cars(int n_p_cars) {
        this.n_p_cars = n_p_cars;
    }

    public int getN_p_motorbike() {
        return n_p_motorbike;
    }

    public void setN_p_motorbike(int n_p_motorbike) {
        this.n_p_motorbike = n_p_motorbike;
    }
    
    
    
}
