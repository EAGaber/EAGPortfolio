/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

/**
 *
 * @author mbcas
 */

// This class is responsible for setting the constants used in all the calculations
// by the use of a text file.
public class VenueConfig {
    
    private double baseRental;
    private double weekdayDiscount;
    private double offSeasonDiscount;
    private double weekendSurcharge;
    private double cateringPerGuest;
    private double audioVisualFee;
    private double lightingFee;
    private double ninetyDayDiscount;
    private double oneEightyDayDiscount;
    
    //constructor for the VenueConfig obj if you want to use custom vals
    public VenueConfig(double baseRental, double weekdayDiscount, double offSeasonDiscount,
                double weekendSurcharge, double cateringPerGuest, double audioVisualFee,
                double lightingFee, double ninetyDayDiscount, double oneEightyDayDiscount)
    {
        this.baseRental = baseRental;
        this.weekdayDiscount = weekdayDiscount;
        this.offSeasonDiscount = offSeasonDiscount;
        this.weekendSurcharge = weekendSurcharge;
        this.cateringPerGuest = cateringPerGuest;
        this.audioVisualFee = audioVisualFee;
        this.lightingFee = lightingFee;
        this.ninetyDayDiscount = ninetyDayDiscount;
        this.oneEightyDayDiscount = oneEightyDayDiscount;
        
    }
    
    //the default constructor using default values if the readConfigFile() 
    //catches and goes to an exception
    public VenueConfig()
    {
        this.baseRental = 500;
        this.weekdayDiscount = 0.20;
        this.offSeasonDiscount = 0.15;
        this.weekendSurcharge = 200;
        this.cateringPerGuest = 25;
        this.audioVisualFee = 150;
        this.lightingFee = 100;
        this.ninetyDayDiscount = 0.10;
        this.oneEightyDayDiscount = 0.15;
        readConfigFile("venues.txt");
        
    }
    
    public void readConfigFile(String filename)
    // this method is responsible for taking a file arg and reading from it
    // line by line, splitting on the equals, and assigning values using try 
    // catch blocks and switch/case conditions.
    {
        Path file = Paths.get("C:\\Users\\mbcas\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\venues.txt");
        try (InputStream input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input))) 
        {
            
            // sets String obj line, the the while loop sets each line to the line var
            // until it reaches a null value
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
               line = line.trim(); 
               if (line.isEmpty() || line.startsWith("#")) 
                   continue;
               int eq = line.indexOf('='); 
               if (eq < 0) 
                   continue;
               String key = line.substring(0, eq).trim().toUpperCase();
               String val = line.substring(eq + 1).trim();
               
               try 
               {
                   switch (key) 
                   {
                       case "BASE_RENTAL":
                           this.baseRental = Double.parseDouble(val);
                           System.out.println(line);  
                           break;
                        case "WEEKDAY_DISCOUNT": 
                            weekdayDiscount = Double.parseDouble(val); 
                            System.out.println(line); 
                            break;
                        case "OFF_SEASON_DISCOUNT": 
                            offSeasonDiscount = Double.parseDouble(val);
                            System.out.println(line);
                            break;
                        case "WEEKEND_SURCHARGE": 
                            weekendSurcharge = Double.parseDouble(val);
                            System.out.println(line);
                            break;
                        case "CATERING_PER_GUEST": 
                            cateringPerGuest = Double.parseDouble(val); 
                            System.out.println(line);
                            break;
                        case "AUDIO_VISUAL_FEE": 
                            audioVisualFee =Double.parseDouble(val);
                            System.out.println(line);
                            break;
                        case "LIGHTING_FEE": 
                            lightingFee = Double.parseDouble(val);
                            System.out.println(line);
                            break;
                        case "NINETY_DAY_DISCOUNT": 
                            ninetyDayDiscount = Double.parseDouble(val);
                            System.out.println(line);
                            break;
                        case "ONE_EIGHTY_DAY_DISCOUNT":
                            oneEightyDayDiscount = Double.parseDouble(val);
                            System.out.println(line);
                            break;
                            
                        default: 
                            ;
                   }                   
                }
               catch (NumberFormatException e) 
               {
                    System.out.println("Bad number for " + key + ": " + val); 
               }
            }
               
        }
        
        catch (FileNotFoundException e) 
        {
            System.out.println("venues.txt not found; using defaults."); 
        }
        catch (IOException e) 
            { 
              System.out.println("Read error: " + e.getMessage()); 
            }
           
            
    }
    
    public double getBaseRental() 
    {
        return this.baseRental;
    }
    
    public double getWeekdayDiscount() 
    {
        return this.weekdayDiscount;
    }
    
    public double getOffSeasonDiscount(){
        return this.offSeasonDiscount;
    }
    
    public double getWeekendSurcharge () {
        return this.weekendSurcharge;
    }

    public double getCateringPerGuest() {
        return this.cateringPerGuest;
    }
    
    public double getAudioVisualFee() {
        return this.audioVisualFee;
    }
    
    public double getLightingFee() {
        return this.lightingFee;
    }
    
    public double getNinetyDayDiscount() {
        return this.ninetyDayDiscount;
    }
    
    public double getOneEightyDayDiscount() {
        return this.oneEightyDayDiscount;
    }
    
}
   
