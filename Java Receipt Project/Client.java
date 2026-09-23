/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

public class Client {

        //Declares a private field for client's name;​
        private String CName;
        //Declares a private field for client's organization.​
        private String COrganization;
        //Declares a private field for client's email address.​
        private String CEmail;
        //Declares a private field for client's state.​
        private String CState;
        //Declares a private field for client's phone number.​
        private String CPhoneNum;
        //Constructor 1 - ClientInfo​ ( in post, i realized the constructor has to have the same name as the class so it has been changed accordingly)
        
        //Clientinfo(old)-> Client()  - Overload the constructor with client's name, ogranization,email, state, and phone number.​
        public Client(String CName,String COrganization,String CEmail, String CState,String CPhoneNum){
                //Set name, organization, email, state, and phone number individually.​
                this.CName = CName;
                this.COrganization = COrganization;
                this.CEmail = CEmail;
                this.CState = CState;
                this.CPhoneNum = CPhoneNum;
                //Calls the method that validates the above variables. – ValidatePhone(), ValidateState().ValidateEmail()
                validatePhone();
                validateState();
                validateEmail();
                //InputtoString(Name,Organization,Email,State,PhoneNum);? 
           }
        // 2 – ClientInfo ( same as above, now renamed to Client)
        //Client() - Overloaded with only name, email and state.​
        public Client(String CName, String CEmail, String CState){
                //Sets the three variables.​
                this.CName = CName;
                this.CEmail = CEmail;
                this.CState = CState;
                //Sets the organization to' individual ' instead.​
                 this.COrganization = "individual";
                //Sets phone to 'Not Provided'​
                 this.CPhoneNum = "Not Provided";
                //Calls validation methods – ValidatePhone(), ValidateState().ValidateEmail()​
                validatePhone();
                validateState();
                validateEmail();
                
        }
        
        //Method 1 – validatePhone()​- Purpose: Check that the phone number is meeting minimum length and return a boolean​
        public boolean validatePhone(){
                //Count length of phone as a string ( this as a string part is defunct) to determine if length is greater than or equal to seven.​      
                int PhoneLength = CPhoneNum.length();    
                if (PhoneLength >= 7){
                    //Returns whether or not the phone number is valid as a boolean.​
                    boolean isPhVal = true;
                    return isPhVal;
                            }
                else{
                    boolean isPhVal = false;
                    return isPhVal;
                            }
        }
        //Method 2 – validateState()​- Purpose: Check if certain states were chosen and returns a boolean.​
        public boolean validateState(){
                //Runs a switch statement that checks for state inputs "TX,"LA", or "OK" ​
                    switch(CState){
                        case "TX":
                           return true;

                        case "LA":
                           return true;

                        case "OK":
                           return true;

                        default:
                            return false;

                        //Returns the above three as a true and as a boolean. If not, it is false.​

                }
        }
     
        //Method 3– validateEmail( - purpose: Check if email has a valid format and returns answer as boolean.​
        public boolean validateEmail(){        
                //Checks the input for '@' sign ​
                int isEmailat = CEmail.indexOf('@');
                //Checks the length of the email has more than 5 characters.​
                int Emaillength = CEmail.length(); 
                //Returns a boolean valude of true if the above are present and false if not.​
                 if(isEmailat != -1 && Emaillength > 5){
                    return true;
                     }
                 else{
                     return false;
                }
        }
        
        //​Method 4 – toString()​- Purpose:  converts the output to all be a sting
        @Override
          public String toString(){
             //Formats onput to be aligned strings using string.format​
             return String.format(
                "CLIENT INFORMATION:\n" +
                "Name:                %s\n" +
                "Organization:        %s\n" +
                "Email:               %s\n" +
                "State:               %s\n" +
                "Phone:               %s\n",
                CName,
                COrganization,
                CEmail,
                CState,
                CPhoneNum
            );
          }
       
        //There are getters for all the private fields. ​  

                public String getCName() {
                return CName;
            }

            public String getCOrganization() {
                return COrganization;
            }

            public String getCEmail() {
                return CEmail;
            }

            public String getCState() {
                return CState;
            }
        public String getCPhoneNum() {
                return CPhoneNum;
            }
                }



