const url = 'http://localhost:8080/Reimbursement/';

document.getElementById("getStatusesButton").addEventListener('click', displayUsersFunc);

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
  let response = await fetch(url+"allStatuses", {credentials: 'include'});

  if(response.status===200){
    console.log(response);
    let data = await response.json();

    for(let eachStatus of data){
      console.log(eachStatus);
      let row = document.createElement("tr");

      let cell = document.createElement("td");
      cell.innerHTML = eachStatus.statusId;
      row.appendChild(cell);

      let cell2 = document.createElement("td");
      cell2.innerHTML = eachStatus.statusDesc;
      row.appendChild(cell2);


      document.getElementById("userbody").appendChild(row);
    }
  }
}