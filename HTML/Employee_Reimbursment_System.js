const url = 'http://localhost:8080/Reimbursement/';

// document.getElementById("getRequestsButton").addEventListener('click', displayUsersFunc);

document.getElementById("loginbtn").addEventListener('click', loginFunc);

//-------------------------------------------------------------------------------

// Global Variables...
let loginData;
let user;
let reimb;
let button1;
let button2;
let button3;
let button4;
let button5;
let buttonPosition;
let inputPosition;

//-------------------------------------------------------------------------------

async function loginFunc() {
  let usern = document.getElementById("username").value;
  let userp = document.getElementById("password").value;

  user = {
    username:usern,
    password:userp
  };

  let resp1 = await fetch(url+'login', {
    method:"POST",
    body: JSON.stringify(user),
    credentials: 'include'
    //Credentials:include will ensure that they cookie is captured, future fetch requests
    //will also require this value in order to send the cookie back. 
  });

  if (resp1.status===200) {
    // document.getElementById('login-row').innerText="YOU HAVE LOGGED IN";
    // let logData = await response.json();

    let resp2 = await fetch(url+"oneLogin", {
      method:"POST",
      body: JSON.stringify(user),
      credentials: 'include'
    });

    if (resp2.status===200) {
      loginData = await resp2.json();
      console.log(loginData);
      //console.log(loginData.ersUserRoleId);

      if (loginData.ersUserRoleId.roleID === 'E') {
        document.getElementById('login-row').innerText="Welcome employee " +
        loginData.userFname + " " + loginData.userLname;

        employeeChoices();

      } else if (loginData.ersUserRoleId.roleID === 'M') {
        document.getElementById('login-row').innerText="Welcome manager " +
        loginData.userFname + " " + loginData.userLname;

        managerChoices();
      }

    }
    
  } else {
    document.getElementById('login-row').innerText="Login failed!"; 
  }
}

//-------------------------------------------------------------------------------

function employeeChoices() {  // The 3 choices for an exployee are here

  buttonPosition = document.getElementById("buttonrow");

  // 1. Create the buttons on the fly
  button1 = document.createElement("BUTTON");
  button1.innerHTML = "View My Reimbursment Requests";
  button1.id = "ViewMyTicketsButton";
  buttonPosition.appendChild(button1);

// 2. Append somewhere
  //var body = document.getElementsByTagName("body")[0];

  button2 = document.createElement("BUTTON");      // Create a <button> element
  button2.innerHTML = "New Reimbursement Request";     // Insert text
  button2.id = "NewTicketButton";
  buttonPosition.appendChild(button2);

  button3 = document.createElement("BUTTON");   // Create a <button> element
  button3.innerHTML = "Logout";                     // Insert text
  button3.id = "Logout";
  buttonPosition.appendChild(button3);

  button1.addEventListener('click', viewMyTickets);
  button2.addEventListener('click', createNewTicket);
  button3.addEventListener('click', getMeOutOfHere);
}

//-------------------------------------------------------------------------------

function managerChoices() {  // The 5

  buttonPosition = document.getElementById("buttonrow");

  // Create the buttons on the fly...

  button1 = document.createElement("BUTTON");
  button1.innerHTML = "My Requests";
  button1.id = "ViewMyTicketsButton";
  buttonPosition.appendChild(button1);

  button2 = document.createElement("BUTTON");
  button2.innerHTML = "All Closed Requests";
  button2.id = "ViewAllTicketsButton";
  buttonPosition.appendChild(button2);

  button3 = document.createElement("BUTTON"); 
  button3.innerHTML = "New Request";
  button3.id = "NewTicketButton";
  buttonPosition.appendChild(button3);

  button4 = document.createElement("BUTTON");
  button4.innerHTML = "Process Requests";
  button4.id = "ProcessAnyTicketButton";
  buttonPosition.appendChild(button4);

  button5 = document.createElement("BUTTON"); 
  button5.innerHTML = "Logout"; 
  button5.id = "Logout";
  buttonPosition.appendChild(button5);

  button1.addEventListener('click', viewMyTickets);
  button2.addEventListener('click', viewAllTickets);
  button3.addEventListener('click', createNewTicket);
  button4.addEventListener('click', processTickets);
  button5.addEventListener('click', getMeOutOfHere);
}

//-------------------------------------------------------------------------------

async function viewAllTickets() {
  document.getElementById('login-row').innerText="Retrieving All Tickets: ";
  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";
  document.getElementById("newticket_or_processticket").innerText="";

  let response = await fetch(url+"allTickets", {credentials: 'include'});

  if (response.status===200) {
    console.log(response);
    let data = await response.json();

    document.getElementById('login-row').innerText="Displaying All Tickets: ";
    displayTable(data)
  }
}

//-------------------------------------------------------------------------------

async function viewMyTickets() {
  
  document.getElementById('login-row').innerText="Retrieving Reimbursement Requests For: "
       + loginData.userFname + " " + loginData.userLname;

  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";
  document.getElementById("newticket_or_processticket").innerText="";
  
  let urlWithId = url + "oneUsersTickets/" + loginData.userId;
  //console.log(urlWithId);

  let response = await fetch(urlWithId, {credentials: 'include'});

  if (response.status===200) {
    console.log(response);
    let data = await response.json();

    document.getElementById('login-row').innerText="Displaying Reimbursement Requests For: "
       + loginData.userFname + " " + loginData.userLname;
    
       displayTable(data)
  }
}

//-------------------------------------------------------------------------------

function displayTable(data) {

    document.getElementById("userhead").innerText="";
    let headerrow = document.createElement("tr");

    let hdcell1 = document.createElement("td");
    hdcell1.innerHTML = 'Request #';
    headerrow.appendChild(hdcell1);

    let hdcell2 = document.createElement("td");
    hdcell2.innerHTML = 'Amount';
    headerrow.appendChild(hdcell2);

    let hdcell5 = document.createElement("td");
    hdcell5.innerHTML = 'Description';
    headerrow.appendChild(hdcell5);

    let hdcell6 = document.createElement("td");
    hdcell6.innerHTML = 'Requested By';
    headerrow.appendChild(hdcell6);
      
    let hdcell7 = document.createElement("td");
    hdcell7.innerHTML = 'Reviewed By';
    headerrow.appendChild(hdcell7);

    let hdcell8 = document.createElement("td");
    hdcell8.innerHTML = 'Reason';
    headerrow.appendChild(hdcell8);

    let hdcell9 = document.createElement("td");
    hdcell9.innerHTML = 'Status';
    headerrow.appendChild(hdcell9);

    document.getElementById("userhead").appendChild(headerrow);

    document.getElementById("userbody").innerText="";  

    for(let eachType of data){
      console.log(eachType);
      let detailrow = document.createElement("tr");

      let dtcell1 = document.createElement("td");
      dtcell1.innerHTML = eachType.reimbId;
      detailrow.appendChild(dtcell1);

      let dtcell2 = document.createElement("td");
      dtcell2.innerHTML = eachType.reimbAmount.toFixed(2);
      detailrow.appendChild(dtcell2);

      let dtcell5 = document.createElement("td");
      dtcell5.innerHTML = eachType.reimbDesc;
      detailrow.appendChild(dtcell5);

      let dtcell6 = document.createElement("td");
      dtcell6.innerHTML = eachType.ersUserAuthorId.userFname +
                    " " + eachType.ersUserAuthorId.userLname;
      detailrow.appendChild(dtcell6);
      
      let dtcell7 = document.createElement("td");
      dtcell7.innerHTML = eachType.ersUserResolverId.userFname +
                    " " + eachType.ersUserResolverId.userLname;
      detailrow.appendChild(dtcell7);

      let dtcell8 = document.createElement("td");
      dtcell8.innerHTML = eachType.ersTypeId.typeDesc;
      detailrow.appendChild(dtcell8);

      let dtcell9 = document.createElement("td");
      dtcell9.innerHTML = eachType.ersStatusId.statusDesc;
      detailrow.appendChild(dtcell9);

      document.getElementById("userbody").appendChild(detailrow);
    }
}

//-------------------------------------------------------------------------------

async function createNewTicket() {
  document.getElementById('login-row').innerText="Create a new reimbursement request:";
  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";
  document.getElementById("newticket_or_processticket").innerText="";

  inputPosition = document.getElementById("newticket_or_processticket");

//<input class="col-sm-3 form-control" id="ReimbursementAmount" 
 //    type="text" placeholder="Enter Reimbursement Amount">
  var input1 = document.createElement("input");
  input1.setAttribute('type', 'text');
  input1.setAttribute('placeholder', 'Description');
  input1.setAttribute('required', 'true');
  input1.setAttribute('class', 'col-sm-3 form-control');
  input1.setAttribute('id', 'reimbDescription');
  inputPosition.appendChild(input1);

  var input2 = document.createElement("input");
  input2.setAttribute('type', 'number');
  input2.setAttribute('placeholder', 'Amount');
  input2.setAttribute('required', 'true');
  input2.setAttribute('class', 'col-sm-3 form-control');
  input2.setAttribute('id', 'reimbAmount');
  inputPosition.appendChild(input2);

  // Create array of options to be added
  var array = ["Self Travel","Hired Travel","Lodging","Meals","Tolls","Parking","Misc."];
  
  // Create and append select list
  var selectList = document.createElement("select");
  selectList.setAttribute('class', 'col-sm-3 form-control');
  selectList.id = "reimbType";
  inputPosition.appendChild(selectList);
  
  // Create and append the options
  for (var ii = 0; ii < array.length; ii++) {
      var option = document.createElement("option");
      option.value = ii+1;
      option.text = array[ii];
      selectList.appendChild(option);
  }

  processButton = document.createElement("BUTTON"); 
  processButton.innerHTML = "Submit"; 
  processButton.id = "reimbSubmit";
  inputPosition.appendChild(processButton);

  processButton.addEventListener('click', submitCreatRequest);

}

//-------------------------------------------------------------------------------

async function submitCreatRequest() {
  let reimbDescription = document.getElementById("reimbDescription").value;
  //console.log(reimbDescription);
  let reimbAmount = document.getElementById("reimbAmount").value;
  //console.log(reimbAmount);
  let reimbType = document.getElementById("reimbType").value;
  //console.log(reimbType);
  //console.log(loginData.userId);

  reimb = {
    reimbAmountFE:reimbAmount,
    reimbDescFE:reimbDescription,
    reimbAuthorFE:loginData.userId,
    reimbStatusFE:1,
    reimbTypeFE:reimbType
  };

  let resp1 = await fetch(url+'newTicket', {
    method:"POST",
    body: JSON.stringify(reimb),
    credentials: 'include' 
  });

  document.getElementById('login-row').innerText="Request Sent:";
  document.getElementById("reimbDescription").innerText=" ";
  document.getElementById("reimbAmount").innerText="0.00";
  
  if (resp1.status===200) {
    document.getElementById('login-row').innerText=
        "Request has been submitted.  Enter more if desired.";

  } else {
    document.getElementById('login-row').innerText=
        "Processing Error - Please contact Support.";
  }
}

//-------------------------------------------------------------------------------

async function processTickets() {
  document.getElementById('login-row').innerText="Retrieving All Tickets: ";
  document.getElementById("newticket_or_processticket").innerText="";
  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";
  
  inputPosition = document.getElementById("newticket_or_processticket");

  var input1 = document.createElement("input");
  input1.setAttribute('type', 'number');
  input1.setAttribute('placeholder', 'Ticket Number');
  input1.setAttribute('required', 'true');
  input1.setAttribute('class', 'col-sm-3 form-control');
  input1.setAttribute('id', 'reimbId');
  inputPosition.appendChild(input1);

  // Create array of options to be added
  var array = ["Pending","Audit","Receipt Required","Declined","Approved"];
  
  // Create and append select list
  var selectList = document.createElement("select");
  selectList.setAttribute('class', 'col-sm-3 form-control');
  selectList.id = "reimbStatus";
  inputPosition.appendChild(selectList);
  
  // Create and append the options
  for (var ii = 0; ii < array.length; ii++) {
      var option = document.createElement("option");
      option.value = ii+1;
      option.text = array[ii];
      selectList.appendChild(option);
  }

  putButton = document.createElement("BUTTON"); 
  putButton.innerHTML = "Submit"; 
  putButton.id = "processSubmit";
  inputPosition.appendChild(putButton);

  let response = await fetch(url+"allTickets/" + loginData.userId,
  {credentials: 'include'
  });

  if (response.status===200) {
    //console.log(response);
    let data = await response.json();

    document.getElementById('login-row').innerText = 
         "Displaying All Unprocessed Tickets Except For Yours: ";
    displayTable(data)
  }

  putButton.addEventListener('click', submitProcessRequest);

}

//-------------------------------------------------------------------------------

async function submitProcessRequest() {

  let reimbId = document.getElementById("reimbId").value;
  console.log(reimbId);
  let reimbStatus = document.getElementById("reimbStatus").value;
  console.log(loginData.userId);
  console.log(reimbStatus);
  
  document.getElementById('login-row').innerText = 
     "Processing Ticket #" + reimbId + ", Please Wait.";
  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";

  reimbUpdate = {
    reimbIdFE:reimbId,
    reimbResolverIdFE:loginData.userId,
    reimbStatusIdFE:reimbStatus,
  };

  let resp2 = await fetch(url+"processTicket",
  {
    method:"POST",
    body: JSON.stringify(reimbUpdate),
    credentials: 'include' 
  });

  if (resp2.status===200) {
    document.getElementById('login-row').innerText=
        "Ticket Processed.";
    console.log(resp2);
  } else {
    document.getElementById('login-row').innerText=
        "Processing Error - Please contact Support.";
  }
   processTickets();
}

//-------------------------------------------------------------------------------

async function getMeOutOfHere() {
  // Time For You To Go... (from: Kung Foo - movie and TV show)
  document.getElementById('login-row').innerText="Good-Bye";
  document.getElementById("userhead").innerText="";
  document.getElementById("userbody").innerText="";
  document.getElementById("newticket_or_processticket").innerText="";

  let response = await fetch(url+"logout", {
    method:"POST",
    credentials: 'include'
    }
  );

window.location.replace("Employee_Reimbursment_System.html");

}