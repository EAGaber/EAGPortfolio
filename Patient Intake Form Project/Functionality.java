/*
Name: Emily Gaber
 File: MIS3371Brains.js
 Date Created: 6/23/2026 (technically old code but im using it for a new clinic)
 Date Updated: 6/27/2026
 Purpose: To creat logic for the website to validate
 */

 
function ValidateFirstName() {
  const fname = document.getElementById("FirstName").value;
  const FNStatus = document.getElementById("FNStatus");
  if (fname == "") {
    FNStatus.textContent = ("You must enter your first name.");
    FNStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/^[a-zA-Z]+$/.test(fname)) {
    FNStatus.textContent = "Only letters, apostrophes, and hyphens are allowed in the first name.";
    FNStatus.style.color = "yellow";
    document.getElementById("Submit").disabled = true;
  }
  else {
    FNStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//Validates Middle Initial
function ValidateMname() {
  const mname = document.getElementById("MiddleInitial").value;
  const MNStatus = document.getElementById("MNStatus");
  if (mname == "") {
    MNStatus.textContent = ("You must enter your middle name.");
    MNStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/^[a-zA-Z]+$/.test(mname)) {
    MNStatus.textContent = "Only letters are allowed in the middle initial.";
    MNStatus.style.color = "yellow";
    document.getElementById("Submit").disabled = true;
  }
  else {
    MNStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//Validates Last Name
function ValidateLastName() {
  const lname = document.getElementById("LastName").value;
  const LNStatus = document.getElementById("LNStatus");
  if (lname == "") {
    LNStatus.textContent = ("You must enter your last name.");
    LNStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/^[a-zA-Z-' ]+$/.test(lname)) {
    LNStatus.textContent = "Only letters, apostrophes, and hyphens are allowed in the last name.";
    LNStatus.style.color = "yellow";
    document.getElementById("Submit").disabled = true;
  }
  else {
    LNStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
    
  }
}
//here we go....lets try this again! I will try to validate the birthday field 
function RealBirthdays() {
  const BDStatus = document.getElementById("BDStatus");
  const today = new Date();
  if (document.getElementById("birthday").value === "") {
    BDStatus.textContent = "You must enter your birthday.";
    BDStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (new Date(document.getElementById("birthday").value) > today) {
    BDStatus.textContent = "You cannot enter a future date.";
    BDStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    document.getElementById("Submit").disabled = false;
    BDStatus.textContent = "";
  }
  }
//validate the SSN. Credit to Jonny Roller! https://codepen.io/jonny_roller I go the idea to format the SSN from his code. (not an exact replica but i took the parts  i liked
function ValidateSSN() {
  const ssn = document.getElementById("SSN").value;
  const SSNStatus = document.getElementById("SSNStatus");
  //let SSFormat = document.getElementById("SSN").value.replace(/[^0-9]/g, '');
 if (ssn == "" || SSN.length < 9) {
    SSNStatus.textContent = ("You must enter the 9 digits of your Social Security Number.");
    SSNStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/^[0-9]{9}$/.test(ssn)) { 
    SSNStatus.textContent = "Please enter a valid Social Security Number. Example: 123-45-6789";
    SSNStatus.style.color = "yellow";
    document.getElementById("Submit").disabled = true;
  }
  else {
   // SSFormat.substr(0, 3) + '-' + SSFormat.substr(3, 2) + '-' + SSFormat.substr(5, 4);
    SSNStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  } 
  
}


//validates the email
function ValidateEmail() {
  const email = document.getElementById("EmailAddress").value;
  const EmailStatus = document.getElementById("EmailStatus");
  if (email == "") {
    EmailStatus.textContent = "You must enter your email address.";
    EmailStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,32}$/.test(email)) {
    EmailStatus.textContent = "Please enter a valid email address. Must contain an @ symbol and a domain name. Example: ProfMake@Hu.edu";
    EmailStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    EmailStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//validate the phone number
function ValidatePhone() {
  const phone = document.getElementById("PhoneNum").value;
  const PhoneStatus = document.getElementById("PhoneStatus");
  if (phone == "") {
    PhoneStatus.textContent = "You must enter your phone number.";
    PhoneStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (!/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phone)) {
    PhoneStatus.textContent = "Please enter a valid phone number. Example: (123) 456-7890";
    PhoneStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    PhoneStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//validate the address
function ValidateAddress() {
  const address = document.getElementById("AddressLine").value;
  const AddressStatus = document.getElementById("AddressStatus");
  if (address == ""|| address.length < 2) {
    AddressStatus.textContent = "You must enter a valid address. At least 2 characters are required.";
    AddressStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    AddressStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
function ValidateAddress2() {
  const address = document.getElementById("AddressLine2").value;
  const AddressStatus2 = document.getElementById("AddressStatus2");
  if (address == ""|| address.length < 2) {
    AddressStatus2.textContent = "You must enter a valid address. At least 2 characters are required.";
    AddressStatus2.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    AddressStatus2.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
function validateCity() {
  const city = document.getElementById("City").value;
  const CityStatus = document.getElementById("CityStatus");
  if (city == ""|| city.length < 2) {
    CityStatus.textContent = "You must enter a valid city. At least 2 characters are required.";
    CityStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    CityStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//validate zip code 
function validateZCode() {
  const zipCode = document.getElementById("ZCode").value;
  const ZipCodeStatus = document.getElementById("ZipCodeStatus");
  if (zipCode == ""|| zipCode.length < 5 || ![a-zA-Z].test(zipCode)) {
    ZipCodeStatus.textContent = "You must enter a valid zip code. At least 5 characters are required.";
    ZipCodeStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    ZipCodeStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}
//validate state ( defunct, theres no requirment to fill and options are added for null/none)
/*function validateState() {
  const state = document.getElementById("state").value;
  const StateStatus = document.getElementById("StateStatus");
  if (state == "") {
    StateStatus.textContent = "You must select an option from the dropdown menu.";
    StateStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else {
    StateStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}*/
//validate Username
function validateUsername() {
  const username = document.getElementById("uname").value;
  const UsernameStatus = document.getElementById("UsernameStatus");
    const Password = document.getElementById("Password").value;
   const firstLetter = username.charAt(0);
   if (/[0-9]/.test(firstLetter) || /[^a-zA-Z0-9_-]/.test(username)) {
    UsernameStatus.textContent = "Username cannot start with a number or contain spaces/special characters.";
    UsernameStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (username == ""|| username.length < 2 || username.length > 20) {
    UsernameStatus.textContent = "You must enter a valid username. At least 2 characters but maximum of 20 characters are required.";
    UsernameStatus.style.color = "red";
    document.getElementById("Submit").disabled = true;
  }
  else if (Password === username) {
    UsernameStatus.textContent = "Username cannot be same as Password.";
    UsernameStatus.style.color = "red";
  }
  else {
    UsernameStatus.textContent = "";
    document.getElementById("Submit").disabled = false;
    return true;
  }
}



// Credit to Technical Rajni and W3schools for the tutorial! I did change it however
function ValidatePassword(){
  const uname = document.getElementById("uname").value;
  const Password = document.getElementById("Password").value;
  const ConfirmPassword = document.getElementById("ConfirmPassword").value;
  const Status = document.getElementById("Status");
  //credit to GeeksforGeeks for the spcial character regex. I adapted it to my code
   
    if (Password == "" ) {
      Status.textContent = "Please add a valid password.";
      Status.style.color = "yellow";
      document.getElementById("Submit").disabled = true;
  } else if (Password === uname) {
      Status.textContent = "Password cannot be the same as username.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
   }
  else if (Password.length < 8) {
      Status.textContent = "Password must be longer than 8 characters.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
   }
   else if (!/[^A-Za-z0-9\s]/.test(Password)) {
      Status.textContent = "Password must contain a special character.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
   }
   else if (!/[A-Z]/g.test(Password)) {
      Status.textContent = "Password must contain a capital (uppercase) letter.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
   }
   else if (!/[0-9]/g.test(Password)) {
      Status.textContent = "Password must contain a number.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
   }
   else if (Password !== ConfirmPassword) {
      Status.textContent = "Passwords do not match.";
      Status.style.color = "red";
      document.getElementById("Submit").disabled = true;
      
  } 
   
   else {
      Status.textContent = "Passwords match.";
      Status.style.color = "green";
      document.getElementById("Submit").disabled = false;
  } 
  
}
function updateSliderValue() {
  const slider = document.getElementById("Pscale");
  const sliderValue = document.getElementById("slider-value");
  const slidermessage = document.getElementById("slider-message");
  sliderValue.textContent = slider.value;
  
  if (slider.value < 4) {
    sliderValue.style.color = "green";
    slidermessage.textContent = "";
  }
    else if (slider.value >= 4 && slider.value <= 6) {
      sliderValue.style.color = "yellow";
      slidermessage.textContent = "";
}
    else if (slider.value > 6) {
  sliderValue.style.color = "red";
  slidermessage.style.color = "red";
  slidermessage.textContent = "If this is an Emergency please call 911.";
  slidermessage.style.fontWeight = "bold";
}
}
 //Credit to W3Schools 
function Reveal() {
  let x = document.getElementById("SSN");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
  let y = document.getElementById("Password");
  if (y.type === "password") {
    y.type = "text";
  } else {
    y.type = "password";
  }
  let z = document.getElementById("ConfirmPassword");
  if (z.type === "password") {
    z.type = "text";
  } else {
    z.type = "password";
  }
}       
// Source - https://stackoverflow.com/a/61736486
// Posted by Vinay
// Retrieved 2026-07-11, License - CC BY-SA 4.0

/*function createCookie(FirstName){
  let FirstName = document.getElementById("FirstName")

  today = new Date();
  let expire = new Date();
  expire.setTime(today.getTime() + 48*60*60*1000);
 
  document.cookie = "name="+FirstName.value+";path=/" + ";expires="+expire.toUTCString();
  //can only write one entity at a time (name, pass)
}  

//credit to  ggogle? + gemini for troubleshooting
function onSubmit(token) {
  const form = document.getElementById("Intake");
  if (form) {
    form.submit();
  }
}
credit to gemini but i didnt get it to function sadly
async function loadStateOptions() {
  try {
    // 1. Fetch the raw file content
    const response = await fetch('states.html');
    
    // Check if the response is valid
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    
    const htmlData = await response.text();
    
    document.getElementById('state').innerHTML = htmlData;
    
  } catch (error) {
    console.error("Fetch failed: ", error);
    document.getElementById('StateStatus').textContent = "Failed to load options. Please refresh.";
    document.getElementById('StateStatus').style.color = "red";
  }
}

window.onload = function() {

  loadStateOptions();

  if (document.getElementById('FirstName')) {
    document.getElementById('FirstName').value = 'John';
  }
};

credit to w3schools and gemini for assisting me, it didnt work
window.onload = function() {
  loadStateOptions(); 
  Names();           
};

function Names() {
  const savedName = localStorage.getItem("savedFirstName");
  const savedEmail = localStorage.getItem("savedEmailAddress");
  const savedPhone = localStorage.getItem("savedPhoneNumber");
  const savedAddress = localStorage.getItem("savedAddress");
  const savedZCode = localStorage.getItem("savedZCode");
  const savedCity = localStorage.getItem("savedCity");

  if (savedName || savedEmail || savedPhone || savedAddress || savedZCode || savedCity) {
    document.getElementById('Remember').checked = true;
  }

  if (savedName) document.getElementById('FirstName').value = savedName;
  if (savedEmail) document.getElementById('EmailAddress').value = savedEmail;
  if (savedPhone) document.getElementById('PhoneNum').value = savedPhone;
  if (savedAddress) document.getElementById('AddressLine').value = savedAddress;
  if (savedZCode) document.getElementById('ZCode').value = savedZCode;
  if (savedCity) document.getElementById('City').value = savedCity;
}

function handleRememberMe() {
  const rememberCheckbox = document.getElementById("Remember");

  if (rememberCheckbox.checked) {
    const firstNameInput = document.getElementById("FirstName").value;
    const emailInput = document.getElementById("EmailAddress").value;
    const phoneInput = document.getElementById("PhoneNum").value;
    const addressInput = document.getElementById("AddressLine").value;
    const zCodeInput = document.getElementById("ZCode").value;
    const cityInput = document.getElementById("City").value;

    localStorage.setItem("savedFirstName", firstNameInput);
    localStorage.setItem("savedEmailAddress", emailInput);
    localStorage.setItem("savedPhoneNumber", phoneInput);
    localStorage.setItem("savedAddress", addressInput);
    localStorage.setItem("savedZCode", zCodeInput);
    localStorage.setItem("savedCity", cityInput);
  } else {
    localStorage.removeItem("savedFirstName");
    localStorage.removeItem("savedEmailAddress");
    localStorage.removeItem("savedPhoneNumber");
    localStorage.removeItem("savedAddress");
    localStorage.removeItem("savedZCode");
    localStorage.removeItem("savedCity");
  }
}*/
//Credit to Professor Jake! (i made some tweaks dont worry! I must add that I used Google GEmini (You mentioned we can use it somewhat) to help me figure out why i coulnt get it to function)
function returndata() {
  let formcontents = document.getElementById("Intake");
  let  = document.getElementById("Review");
  let formoutput;
  let datatype;
  let i;
 //credit gemini....need to update the names
 Review.addEventListener('click', () => {
        // Toggle visibility
        if (outputformdata.style.display === 'none' || outputformdata.style.display === '') {
            outputformdata.style.display = 'block';
            Review.textContent = 'Hide Code';
        } else {
            outputformdata.style.display = 'none';
            Review.textContent = 'Show Code';
        }
    });
  Review.onclick = function() {
   
    if (document.getElementById("returndata")) {
      document.getElementById("returndata").style.display = "block";
    }

    formoutput = "<table class='form'><tr><th class='returndata'>Title</th><th class='returndata'>Input</th></tr>";

    for (i = 0; i < formcontents.length; i++) {
      datatype = formcontents.elements[i].type;

      switch (datatype) {
        case "checkbox":
          if (formcontents.elements[i].checked) {
            formoutput  = formoutput + "<tr><td class='returndata'>" + formcontents.elements[i].name + "</td>";               
            formoutput  = formoutput + "<td class='returndata'>Checked</td></tr>";
          }
          break;

        case "radio":
          if (formcontents.elements[i].checked) {
            formoutput  = formoutput + "<tr><td class='returndata'>" + formcontents.elements[i].name + "</td>";
            formoutput  = formoutput + "<td class='returndata'>" + formcontents.elements[i].value + "</td></tr>";
          }
          break;
        default:
          formoutput  = formoutput + "<tr><td class='returndata'>" + formcontents.elements[i].name + "</td>";
          formoutput  = formoutput + "<td class='returndata'>" + formcontents.elements[i].value + "</td></tr>";
          break;
      }
    }
    if (formoutput.length > 0) { 
      formoutput  = formoutput + "</table>";
      document.getElementById("outputformdata").innerHTML = formoutput;
    }
  };
} 
  returndata();
