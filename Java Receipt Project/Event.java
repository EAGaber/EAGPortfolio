/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.project;
import java.time.*;
/**
 *
 * @author Em
 */

public class Event {


      //Private fields:​
       //Declares eventDate ​
        private String eventDate;
       //Declares eventType ​
        private String eventType;
       //Declares guestCount ​
        private int guestCount;
       //Declares isWeekday ​
        private boolean isWeekday;
       //Declares isOffSeason​
        private boolean isOffSeason;
       //Declares requiresCatering​
        private boolean requiresCatering;

        //Constructor 1: - EventInfo() (contains all above fields)​, now Event()
        public Event(String eventDate,String eventType,int guestCount,boolean isWeekday,boolean isOffSeason,boolean requiresCatering){
            //Sets all the above fields​
            this.eventDate = eventDate;
            this.eventType = eventType;
            this.guestCount = guestCount;
            this.isWeekday = isWeekday;
            this.isOffSeason = isOffSeason;
            this.requiresCatering = requiresCatering;
            //Trims whitespace in the input​ (moved up so the whitspace isnt a part of the bottom code)
            String TEventType = eventType.trim();
            //Capitalizes the first letter of event type. ​
            String CapEvent = TEventType.substring(0,1).toUpperCase() ;
            String FixedEventType = CapEvent+ TEventType.substring(1);          
            //Calls all the validation methods of THIS CLASS
            validateGuestCount();
            validateEventType();
            validateEventDate();
        }
           // Method 1: - VAlidateGuestCount​
        public boolean validateGuestCount(){
                //Uses the local date method to get the current date​
                LocalDate  today = LocalDate.now();
                // Checks that the guest count is greater than zero but less than 1000​
                if (1000 > guestCount && guestCount > 0){
                    return true;
                }
                else {
                    return false;
                }
                
            }
        //  Method 2: - VAlidateEventType​
        public boolean validateEventType(){        
           // Uses a swithc statement and checks if event type is equal to 'wedding', 'corporate', 'birthday' or conference.​
            // Returns boolean value of true or false depending on validity.​
              switch(eventType){
               case "Wedding":
                   return true;
               case "Corporate":
                   return true;
               case "Birthday":
                   return true;
               case "Conference":
                   return true;
               default:
                   return false;
            }
           }
        //i somehow managed to miss this in my pseudo code so this is being made now sorry!
        //Method 3 ValidateEventdate() - will retun a boolean and checks the event length is more than 5 characters
        //im going off the literal term length but another interpretation might be the length of days? (i will talk in video)
        public boolean validateEventDate(){
            //checks that the event is more than five characters
            int eventlength = eventDate.length();
            if (eventlength>5)
                return true;
            else{
                return false;
                        }
        
        }
        // final method (not in pseudocode, oops) toString - makess the format of all our output into strings, neat
        @Override
        public String toString(){
             //Formats onput to be aligned strings using string.format​
             {
                return String.format(
                    "EVENT DETAILS:\n" +
                    "Event Date:          %s\n" +
                    "Event Type:          %s\n" +
                    "Guest Count:         %d\n" +
                    "Weekday Event:       %s\n" +
                    "Off-Season:          %s\n" +
                    "Catering Required:   %s\n",
                    eventDate,
                    eventType,
                    guestCount,
                    isWeekday ? "Yes" : "No",
                    isOffSeason ? "Yes" : "No",
                    requiresCatering ? "Yes" : "No"
                );
            }  
        }
        
        //getters for all out private fields
            public String getEventDate() {
                return eventDate;
            }

            public String getEventType() {
                return eventType;
            }

            public int getGuestCount() {
                return guestCount;
            }

            public boolean getIsWeekday() {
                return isWeekday;
            }

            public boolean getIsOffSeason() {
                return isOffSeason;
            }

            public boolean getRequiresCatering() {
                return requiresCatering;
            }
}




