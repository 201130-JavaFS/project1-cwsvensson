const url = 'http://localhost:8080/Reimbursement/';

document.getElementById("getRequestsButton").addEventListener('click', displayUsersFunc);

document.getElementById("loginbtn").addEventListener('click', loginFunc);

async function loginFunc() {
  let usern = document.getElementById("username").value;
  let userp = document.getElementById("password").value;

  let user = {
    username:usern,
    password:userp
  };

  let resp = await fetch(url+'login', {
    method:"POST",
    body: JSON.stringify(user),
    credentials: 'include'
    //Credentials:include will ensure that they cookie is captured, future fetch requests
    //will also require this value in order to send the cookie back. 
  });

  if(resp.status===200){
    document.getElementById('login-row').innerText="YOU HAVE LOGGED IN";  
  }else{
    document.getElementById('login-row').innerText="Login failed!"; 
  }
}

async function displayUsersFunc(){
  let response = await fetch(url+"allReimbursements", {credentials: 'include'});

  if(response.status===200){
    console.log(response);
    let data = await response.json();

    for(let eachType of data){
      console.log(eachType);
      let row = document.createElement("tr");

      let cell1 = document.createElement("td");
      cell1.innerHTML = eachType.reimbId;
      row.appendChild(cell1);

      let cell2 = document.createElement("td");
      cell2.innerHTML = eachType.reimbAmount;
      row.appendChild(cell2);

      let cell3 = document.createElement("td");
      cell3.innerHTML = eachType.reimbSubmitted;
      row.appendChild(cell3);

      let cell4 = document.createElement("td");
      cell4.innerHTML = " ";
      row.appendChild(cell4);

      let cell5 = document.createElement("td");
      cell5.innerHTML = " ";
      row.appendChild(cell5);

      let cell6 = document.createElement("td");
      cell6.innerHTML = " ";
      row.appendChild(cell6);

      let cell7 = document.createElement("td");
      cell7.innerHTML = " ";
      row.appendChild(cell7);

      let cell8 = document.createElement("td");
      cell8.innerHTML = " ";
      row.appendChild(cell8);

      let cell9 = document.createElement("td");
      cell9.innerHTML = " ";
      row.appendChild(cell9);

      document.getElementById("userbody").appendChild(row);
    }
  }
}