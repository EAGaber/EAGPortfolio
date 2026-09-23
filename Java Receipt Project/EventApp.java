/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author mbcas
 */

// main application integrating all classes
public class EventApp {
    
    
    public static void main(String[] args)
    {
        // creates VenueConfig obj, Client obj, Event obj, VenueTier obj,
        // equipmentArray array, and AdvanceBooking int.
        VenueConfig tempVenueConfig = new VenueConfig();
        Client tempClient = getClientInput();
        Event tempEvent = getEventDetails();
        VenueTier tempVenueTier = getVenueTierDetails();
        String[] equipmentArray = getEquipment();
        int tempAdvanceBooking = getAdvanceBooking();
        
//      logic for which Booking constructor to call. If equipment array is empty
//      call the one that doesn't take an equipment array.
        if (equipmentArray[0] == null && equipmentArray[1] == null)
        {
            Booking booking = new Booking(tempClient, tempEvent, tempVenueTier, tempAdvanceBooking, tempVenueConfig);
            displayAndSave(booking);
        }
        else
        {
            Booking booking = new Booking (tempClient, tempEvent, tempVenueTier, equipmentArray, tempAdvanceBooking, tempVenueConfig);
            displayAndSave(booking);
        }
        
        
        
    }
    
    public static Client getClientInput()
    // this is the static method to create the Client obj in the main method
    {
        String name = JOptionPane.showInputDialog("Please enter your name");
        String org = JOptionPane.showInputDialog("Please enter your organization name (press enter if no organization)");
        String email = JOptionPane.showInputDialog("Please enter your email");   
        String state = JOptionPane.showInputDialog("Please enter your abbrv. state");
        String phone = JOptionPane.showInputDialog("Please enter your phone number (press enter if no phone)");
        
        Client client = null;
        
        // reprompting validation checks
        boolean valid = false;
        while (!valid)
        {
            
            //construct client with org and phone not provided other wise
            //construct all five fields of Client.
            if (org.equals("") && phone.equals(""))
            {
                client = new Client(name, email, state);
            }
            else
            {
                client = new Client(name, org, email, state, phone);
            }
            
            // individual validation of fields calling their respective validation
            // methods and reprompting.
            if (!client.validateEmail())
            {
                JOptionPane.showMessageDialog(null, "Please enter a correct email");
                email = JOptionPane.showInputDialog(null, "Please enter your email");
            }
            if (!client.validateState())
            {
                JOptionPane.showMessageDialog(null, "Please enter a correct abbreviated state");
                state = JOptionPane.showInputDialog(null, "Please enter your state (ex: TX)");
            }
            if (!client.validatePhone())
            {
                JOptionPane.showMessageDialog(null, "Please enter a correct phone number");
                phone = JOptionPane.showInputDialog(null, "Please enter your phone number");
            }
            
            // reconstruct the client obj
            if (org.equals("") && phone.equals(""))
            {
                client = new Client(name, email, state);
            }
            else
            {
                client = new Client(name, org, email, state, phone);
            }
            
            // final validation check and if all three are valid then break the loop
            if (client.validateEmail() &&
                client.validateState() &&
                client.validatePhone())
            {
                valid = true;
            }
            
        }
        
        return client;
           
    }
    
    public static Event getEventDetails()
    // this is the static method to construct Event objs to be used in the main method
    {
        //setting validation loop var, and field vars
        boolean valid = false;
        String eventDate;
        String eventType;
        int guestCount = 0;
        boolean isWeekday; 
        boolean isOffSeason;
        boolean isCatering;
        
        Event event = null;
        
        // assigning field vars 
        eventDate = JOptionPane.showInputDialog("Please enter a date for the event (MM/dd/yyyy)");
        
        // using JOptionPane.showOptionDialog which simplifies the validation on this field
        String[] options = {"Wedding", "Corporate", "Birthday", "Conference"};
        int choice = JOptionPane.showOptionDialog(null, options, "Please pick an event type", 0, 0, null, options, options[0]);
        eventType = options[choice];

        int result = JOptionPane.showConfirmDialog(null, "Is this a weekday event? (Monday-Thrusday)");
        isWeekday = (result == JOptionPane.YES_OPTION);

        result = JOptionPane.showConfirmDialog(null, "Is this a off-season event? (Jan-Mar.)");
        isOffSeason = (result == JOptionPane.YES_OPTION);

        result = JOptionPane.showConfirmDialog(null, "Do you need catering services?");
        isCatering = (result == JOptionPane.YES_OPTION);
        
        // try/catch blocks and reprompting loop
        boolean guestValid = false;
        while (!guestValid)
        {
            try 
                {
                    guestCount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of guests."));
                    guestValid = true;
                }
            catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
        }
        
        //validation loop
        while (!valid)
        {
            event = new Event(eventDate, eventType, guestCount, isWeekday, isOffSeason, isCatering);
            
            //final validation and reprompting for guest count
            if (!event.validateGuestCount())
            {
                JOptionPane.showMessageDialog(null, "Please enter a number greater than 0 but less than 1,000");
                guestValid = false;
                while (!guestValid)
                {
                    try 
                        {
                            guestCount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of guests."));
                            guestValid = true;
                        }
                    catch (NumberFormatException e)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number");
                        }
                }
            }
            if (!event.validateEventType())
            {
                JOptionPane.showMessageDialog(null, "Please enter a correct event type");
                
            }
            if (!event.validateEventDate())
            {
                JOptionPane.showMessageDialog(null, "Please enter a correct date (MM/dd/yyyy)");
                eventDate = JOptionPane.showInputDialog("Please enter a date for the event (MM/dd/yyyy)");
                
            }
            
            //construct a new event obj after passed validation checks
            event = new Event(eventDate, eventType, guestCount, isWeekday, isOffSeason, isCatering);

            //if all fields are valid break the loop and return event obj
            if (event.validateGuestCount() &&
                event.validateEventDate())
            {
                valid = true;
            }

        }

        return event;
    }
    
    public static VenueTier getVenueTierDetails()
    //this static method creates a VenueTier obj based of user interaction
    //and returns it
    {
        VenueTier venueType = null;
        
        //giving options for a user to choose from
        String[] options = {"Community (1.0x)", "Professional (1.55x)", "Grand (2.1x)"};
        int choice = JOptionPane.showOptionDialog(null, "Please select a venue tier", "Venue tier selection", 0, 0, null, options, options[0]);
        
        //uses switch/case/default statements to determine which VenueTier obj to return
        switch (choice)
        {
            case 0:
                venueType = new CommunityTier();
                break;
            case 1:
                venueType = new ProfessionalTier();
                break;
            case 2:
                venueType = new GrandTier();
                break;   
            default:
                venueType = new CommunityTier();
                
        }
        
        return venueType;
        
    }
    
    public static String[] getEquipment()
    // fairly straight forward, static method that asks the user if they need
    // equipment and returns a String[] with those string values
    {
        String[] equipmentArray = new String[2];
        int result = JOptionPane.showConfirmDialog(null, "Do you need audio/visual systems?");
        if (result == JOptionPane.YES_OPTION)
        {
            equipmentArray[0] = "AudioVisual";
        }
        
        result = JOptionPane.showConfirmDialog(null, "Do you want decorative lighting?");
        if (result == JOptionPane.YES_OPTION)
        {
            equipmentArray[1] = "Lighting";
        }
        
        return equipmentArray;
        
    }
    
    public static int getAdvanceBooking()
    // another simple static method, collects user input as an int and runs
    // a looping try/catch block which breaks out once the int value is < 0.
    // returns said int value
    {
        boolean valid = false;
        int daysInAdvance = 0;
        
        while (!valid)
        {   
            try
            {
                daysInAdvance = Integer.parseInt(JOptionPane.showInputDialog(null, "How many days in advance is this booking?"));
                
                if (daysInAdvance > 0)
                    {
                        valid = true;
                    }
                else
                    {
                        JOptionPane.showMessageDialog(null, "Days in advance must be greater than 0.");
                    }
                
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Please only enter days in an integer form");
            }
            
        }
        
        return daysInAdvance;
        
    }
    
    public static void displayAndSave(Booking booking)
    // this is the static method for displaying the booking information 
    // and creating or appending to a file with a try/catch block
    {
        JOptionPane.showMessageDialog(null, booking.toString());
        
        Path file = Paths.get("C:\\Users\\mbcas\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\bookings.txt");
        
        try (BufferedWriter writer = Files.newBufferedWriter(file, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND))
        {
            writer.write(booking.toString());
            writer.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace(); 
        }
        
        
        
        
    }
    
    
    
    
}
