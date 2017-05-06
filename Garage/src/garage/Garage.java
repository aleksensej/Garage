/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import vehicles.Vechicle;
import controlleranddatabase.Controller;
import controlleranddatabase.DB;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alek
 */
public class Garage {
    
    public int used_car_space=0;
    public int used_motor_space=0;
    
    public List<Level> lv;
    public List<Vechicle> vechicle;
    
    public void generateLevels (int num_of_lvs, int num_of_carPS, int num_of_motorPS){
        if (lv.isEmpty()){
            lv = new ArrayList<Level>();
            System.out.println("New levels are generated from scratch");
        }
        if (num_of_lvs<2){
        lv.add(new Level(1,0,0));
        System.out.println("Default first level is created.");
        System.out.println("You will have to load the parking spaces");
        } else {
            for(int i=0;i<num_of_lvs;i++){
                lv.add(new Level(i,num_of_carPS, num_of_motorPS));
                for(int j=0;j<num_of_carPS;j++){
                    lv.get(num_of_lvs).addCarParkingSpace(j);
                }
                for(int z=0;z<num_of_motorPS;z++){
                    lv.get(num_of_lvs).addMotorParkingSpace(z);
                }
            }
            }
        System.out.println("Created "+num_of_lvs+" levels,with "+num_of_carPS+" of car park spaces "+num_of_motorPS+" of motorbike parking spaces.");
        System.out.println("You can change the number of parking spaces");
        }
    
    
    public void changeParkingSpacesAtLevel(int num_of_lv, int num_of_carPS, int num_of_motorPS){
        if (lv.isEmpty()){
        System.out.println("You have to genarate level before using this method");
        }
        if (lv.get(num_of_lv)!=null){
            removeParkingSpacesAtLevel(num_of_lv);
                for(int j=0;j<num_of_carPS;j++){
                    lv.get(num_of_lv).addCarParkingSpace(j);
                }
                for(int z=0;z<num_of_motorPS;z++){
                    lv.get(num_of_lv).addMotorParkingSpace(z);
                }
            lv.get(num_of_lv).setN_p_cars(num_of_carPS);
            lv.get(num_of_lv).setN_p_motorbike(num_of_motorPS);
        System.out.println("Changed "+num_of_lv+"'s car park space to "+num_of_carPS+" and motorbike parking spaces to "+num_of_motorPS+"." );
        }
        }
    
    public void removeParkingSpacesAtLevel(int num_of_lv){
        if (lv.isEmpty()){
        System.out.println("You have to genarate level before using this method");
        }
        if(lv.get(num_of_lv)!=null){
          int p_cars = lv.get(num_of_lv).getN_p_cars();
          int p_motors = lv.get(num_of_lv).getN_p_motorbike();
            for(int i=0;i<p_cars+p_motors;i++){
                    lv.get(num_of_lv).removeParkingSpace(i);
                }
          lv.get(num_of_lv).setN_p_cars(0);
          lv.get(num_of_lv).setN_p_motorbike(0);
        System.out.println("Removed parking spaces from level " +num_of_lv);
        }
    }
    
    public void enter(String licence_plate, String type){
        int car_max_lv=0;
        int motor_max_lv=0;
        if (type=="Car"){
        if (vechicle.isEmpty()){
        vechicle = new ArrayList<Vechicle>();
        }
        for (int i=0; i<lv.size();i++){
            if(used_car_space>car_max_lv){
            car_max_lv =+ lv.get(i).getN_p_cars();
            } else
                for (int x=0; x<lv.get(i).getN_p_cars()+lv.get(i).getN_p_motorbike(); x++){
                if(lv.get(i).parkingSpace.get(x).getLicence_plate()==null){
                lv.get(i).parkingSpace.get(x).setLicence_plate(licence_plate);
                used_car_space++;
                
                vechicle.add(new Vechicle(licence_plate, true, "Car"));
                }
            }
        } if (used_car_space>car_max_lv){
            vechicle.add(new Vechicle(licence_plate, false, "Car"));
            System.out.println("Sorry, no available spots for your Car");
        }
        }
        if (type=="Motorbike"){
        for (int i=0; i<lv.size();i++){
            if(used_motor_space>=motor_max_lv){
            motor_max_lv =+ lv.get(i).getN_p_cars();
            } else
                for (int y=0; y<lv.get(i).getN_p_cars()+lv.get(i).getN_p_motorbike(); y++){
                if(lv.get(i).parkingSpace.get(y).getLicence_plate()==null){
                lv.get(i).parkingSpace.get(y).setLicence_plate(licence_plate);
                used_motor_space++;
                
                vechicle.add(new Vechicle(licence_plate, true, "Motorbike"));
                }
            }
        } if (used_motor_space>motor_max_lv){
            vechicle.add(new Vechicle(licence_plate, false, "Motorbike"));
            System.out.println("Sorry, no available spots for your Motorbike");
        }
        }
    }
    
        public void exit(String licence_plate){
        for (int i=0; i<lv.size();i++){
            for (int x=0; x<lv.get(i).getN_p_cars()+lv.get(i).getN_p_motorbike(); x++){
                if(lv.get(i).parkingSpace.get(x).getLicence_plate()==licence_plate){
                lv.get(i).parkingSpace.get(x).setLicence_plate(null);
                }
                if(lv.get(i).parkingSpace.get(x).getType()=="Car"){
                    used_car_space--;
                } else {
                    used_motor_space--;
                }
                vechicle.get(returnVechicle(licence_plate)).setParked(false);
            }
        }
    }
    
    public int returnVechicle(String licence_plate){
        int value=-1;
        if (!(vechicle.isEmpty())){
            for (int i=0;i<vechicle.size();i++){
                if(vechicle.get(i).getLicence_plate() == licence_plate){
                value=i;
                break;
                }
            }
        }
        return value;
    }
    
    public int returnParkedVechicle (String licence_plate){
        int value=-1;
        if (!(vechicle.isEmpty())){
            for (int i=0;i<vechicle.size();i++){
                if((vechicle.get(i).getLicence_plate() == licence_plate)&&(vechicle.get(i).isParked())){
                value=i;
                break;
                }
            }
        }
        return value;
    }
    
    public void findParkedVechicleInfo (String licence_plate){
        if(returnParkedVechicle(licence_plate)!=-1){
        for (int i=0; i<lv.size();i++){
            for (int j=0; j<lv.get(i).getN_p_cars()+lv.get(i).getN_p_motorbike();j++){
                if (lv.get(i).parkingSpace.get(j).getLicence_plate() == licence_plate){
                   int space = lv.get(i).parkingSpace.get(j).getParking_spade_id();
                System.out.println("Level: "+i+", space"+space);
                break;
                }
            }
        }
        }
    }
    
    
    public static void main(String args[]) {

        Garage garage = new Garage();
        
        garage.generateLevels(0, 0, 0);
        garage.changeParkingSpacesAtLevel(0, 0, 0);
        garage.removeParkingSpacesAtLevel(0);
        
        garage.enter("CZ-1234", "Car");
        garage.enter("CZ-4321", "Motorbike");
        garage.exit("CZ-1234");
        
    }
    
}
