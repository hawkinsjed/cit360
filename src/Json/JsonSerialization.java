/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JsonSerialization {
    
    
    public static void main (String[] args) throws IOException {
        
        // Object Declaration
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        
        // Declare Vehicle 1 Values
        vehicle1.setMake("Chevrolet");
        vehicle1.setModel("Silverado");
        vehicle1.setYear(2008);
        vehicle1.setVin("2GCEC19J881138304");
        vehicle1.setColor("Grey");
        
        // Declare Vehicle 2 Values
        vehicle2.setMake("Honda");
        vehicle2.setModel("Odyssey");
        vehicle2.setYear(2012);
        vehicle2.setVin("5FNRL5H66CB108942");
        vehicle2.setColor("White");
        
        // Display Vehicle Values
        System.out.println("Vehicle Data Before JSON Serialization");
        System.out.println("======================================");
        System.out.println("Vehicle 1");
        vehicle1.displayVehicle();
        System.out.print("\n");
        System.out.println("Vehicle 2");
        vehicle2.displayVehicle();
        
        // Create Google GSON Object
        Gson vehiclesJSON = new Gson();
        String data1, data2;
        
        // Serialize Vehicles to JSON
        data1 = vehiclesJSON.toJson(vehicle1);
        data2 = vehiclesJSON.toJson(vehicle2);
        
        // Display JSON
        System.out.println("\n\nJSON Serialization of Vehicle Data");
        System.out.println("==================================");
        System.out.println(data1);
        System.out.println(data2);
        
        // Save Serialized Data to File
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("savedfile.json"))) {
            bw.write(data1);
            bw.newLine();
            bw.write(data2);
            bw.close();
        } catch (Throwable te) {
            System.out.println("\nException: " + te.toString());
        } 
        
        // Retrieve Serialized Data from File
        String newData1 = new String();
        String newData2 = new String();
        try (BufferedReader br = new BufferedReader(new FileReader("savedfile.json"))) {
            newData1 = br.readLine();
            newData2 = br.readLine();
        } catch (Throwable te) {
            System.out.println("\nException: " + te.toString());
        }
        
        // Display JSON
        System.out.println("\n\nJSON Serialized data retrieve from file");
        System.out.println("=======================================");
        System.out.println(newData1);
        System.out.println(newData2);
        
        // Deserialize Vehicles
        Vehicle newVehicle1 = vehiclesJSON.fromJson(newData1, Vehicle.class);
        Vehicle newVehicle2 = vehiclesJSON.fromJson(newData2, Vehicle.class);
        
        // Display Vehicle Values
        System.out.println("\n");
        System.out.println("Vehicle Data after JSON Serialization Retrieval");
        System.out.println("===============================================");
        System.out.println("New Vehicle 1");
        newVehicle1.displayVehicle();
        System.out.print("\n");
        System.out.println("New Vehicle 2");
        newVehicle2.displayVehicle();
    }


    
    
}
