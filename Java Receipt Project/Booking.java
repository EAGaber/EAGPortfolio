/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Booking.java
// this class handles calculating the price and making the booking ID
// MIS 3370 Capstone - Abdul


import java.time.LocalDateTime;


public class Booking
{
    // fields for the booking
    private Client client;
    private Event event;
    private VenueTier venueTier;
    private String[] equipment;
    private int advanceBookingDays;
    private double totalCost;
    private String bookingID;


    // this one is static bc every booking object shares it
    // starts at 3000 like the instructions said
    private static int bookingCounter = 3000;


    // this constructor is for when they pick equipment
    public Booking(Client client, Event event, VenueTier venueTier,
                   String[] equipment, int advanceBookingDays, VenueConfig config)
    {
        this.client = client;
        this.event = event;
        this.venueTier = venueTier;
        this.equipment = equipment;
        this.advanceBookingDays = advanceBookingDays;


        // call these right away so the cost and ID are ready
        calculateCost(config);
        bookingID = generateBookingID();
    }


    // second constructor for when no equipment is needed
    // just sets equipment to empty so the loop doesnt break
    public Booking(Client client, Event event, VenueTier venueTier,
                   int advanceBookingDays, VenueConfig config)
    {
        this.client = client;
        this.event = event;
        this.venueTier = venueTier;
        this.advanceBookingDays = advanceBookingDays;
        this.equipment = new String[0];


        calculateCost(config);
        bookingID = generateBookingID();
    }


    // does all the math for the total price
    // starts from base rental then adds or subtracts based on the event
    public void calculateCost(VenueConfig config)
    {
        // grab the base rental to start
        double rentalFee = config.getBaseRental();


        // weekday gets a discount, but weekend costs more
        if (event.getIsWeekday())
        {
            // take off the weekday discount from base rental
            rentalFee -= config.getBaseRental() * config.getWeekdayDiscount();
        }
        else
        {
            // weekend so add the surcharge
            rentalFee += config.getWeekendSurcharge();
        }


        // january through march is off season so another discount
        if (event.getIsOffSeason())
        {
            rentalFee -= config.getBaseRental() * config.getOffSeasonDiscount();
        }


        // catering is 25 dollars per guest
        if (event.getRequiresCatering())
        {
            rentalFee += config.getCateringPerGuest() * event.getGuestCount();
        }


        // multiply by whatever tier they picked (1.0, 1.55, or 2.1)
        rentalFee *= venueTier.getMultiplier();


        // go through the equipment they picked and add those fees
        for (int iter = 0; iter < equipment.length; iter++)
        {
            //skips null values
            if (equipment[iter] != null)
            {
                if (equipment[iter].equals("AudioVisual"))
                {
                    rentalFee += config.getAudioVisualFee(); // 150 dollars
                }
                else if (equipment[iter].equals("Lighting"))
                {
                    rentalFee += config.getLightingFee(); // 100 dollars
                }
            }
        }


        // have to check 180 first bc its the bigger discount
        if (advanceBookingDays >= 180)
        {
            rentalFee -= rentalFee * config.getOneEightyDayDiscount();
        }
        else if (advanceBookingDays >= 90)
        {
            rentalFee -= rentalFee * config.getNinetyDayDiscount();
        }
        // if less than 90 days no discount applied


        totalCost = rentalFee;
    }


    // static bc it uses the shared counter
    // builds the ID from the current date and time
    public static String generateBookingID()
    {
        LocalDateTime now = LocalDateTime.now();


        // EP then year month day hour minute then the counter number
        String bookingID = "EP" + now.getYear() +
                           String.format("%02d", now.getMonthValue()) +
                           String.format("%02d", now.getDayOfMonth()) +
                           String.format("%02d", now.getHour()) +
                           String.format("%02d", now.getMinute()) +
                           bookingCounter;


        // add 1 to counter so next booking gets a different ID
        bookingCounter += 1;


        return bookingID;
    }


    // puts everything together for the receipt basically
    @Override
    public String toString()
    {
        // build equipment section first
        String equipmentList = "";
        for (int iter = 0; iter < equipment.length; iter++)
        {   
            //skips null values
            if (equipment[iter] != null)
            {
                if (equipment[iter].equals("AudioVisual"))
                {
                    equipmentList += String.format("- Audio/Visual System: $150.00\n");
                }
                else if (equipment[iter].equals("Lighting"))
                {
                    equipmentList += String.format("- Decorative Lighting: $100.00\n");
                }
            }
        }


        // if they didnt pick anything just say none
        if (equipmentList.equals(""))
        {
            equipmentList = "None selected\n";
        }


        // figure out what to say about the advance discount
        String advanceDiscountText = "";
        if (advanceBookingDays >= 180)
        {
            advanceDiscountText = String.format("%d days in advance: -15%%\n", advanceBookingDays);
        }
        else if (advanceBookingDays >= 90)
        {
            advanceDiscountText = String.format("%d days in advance: -10%%\n", advanceBookingDays);
        }
        else
        {
            advanceDiscountText = "No advance booking discount\n";
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm:ss a");
        
        //format the booking information as a string and return it
        return String.format(
            "===========================================\n" +
            " EVENTPRO BOOKING SUMMARY \n" +

            "===========================================\n" +
            "Booking ID: %s\n" +
            "Booking Date: %s\n" + 
            "-------------------------------------------\n" +
            "%s\n" +
            "-------------------------------------------\n" +
            "%s\n" +
            "-------------------------------------------\n" +
            "VENUE DETAILS:\n" +
            "Tier: %s (%.2fx)\n" +
            "-------------------------------------------\n" +
            "EQUIPMENT RENTALS:\n" +
            "%s\n" +
            "-------------------------------------------\n" +
            "ADVANCE BOOKING:\n" +
            "%s" +
            "Days in Advance: %d\n" +

            "===========================================\n" +
            "TOTAL COST: $%,.2f\n" +
            "===========================================\n",
            bookingID,
            now.format(formatter),
            client.toString(),
            event.toString(),
            venueTier.getTierName(), venueTier.getMultiplier(),
            equipmentList,
            advanceDiscountText,
            this.getAdvanceBookingDays(),
            totalCost
        );
    }


    public Client getClient()
    {
        return client;
    }


    public Event getEvent()
    {
        return event;
    }


    public VenueTier getVenueTier()
    {
        return venueTier;
    }


    public String[] getEquipment()
    {
        return equipment;
    }


    public int getAdvanceBookingDays()
    {
        return advanceBookingDays;
    }


    public double getTotalCost()
    {
        return totalCost;
    }


    public String getBookingID()
    {
        return bookingID;
    }
}

