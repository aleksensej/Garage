/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleranddatabase;

import garage.ParkingSpace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alek
 */
public class DB {
    
    private Connection connection;
    
    public void loadDriver() throws ClassNotFoundException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }
    
    public void connectToDB() throws SQLException {
        connection = DriverManager.getConnection("jbdc:odbc:Garage");
        connection.setAutoCommit(false); //normally it is set to true.
    }
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    public void commitTransaction() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Error during commit of transaction");
        }
    }
    
    public void rollbackTransaction() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Error during rollback of transaction!");
        }
    }
    
    public List<ParkingSpace> returnList() throws Exception{
    
        String sql= "SELECT * FROM Level";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<ParkingSpace> pslist = new ArrayList<ParkingSpace>();
        while(rs.next()){
         int id_parking_space = rs.getInt("ID_parking_space");
         int id_level = rs.getInt("ID_level");
         String licence_plate = rs.getString("licence_plate");
         String type = rs.getString("type");
         ParkingSpace psObject = new ParkingSpace(id_parking_space,licence_plate, type);
         pslist.add(psObject);
        }
        rs.close();
        statement.close();
        return pr;
           
    }
    
}
