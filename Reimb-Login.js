const url = 'http://localhost:8080/Reimbursement/';

document.getElementById("getUsersButton").addEventListener('click', displayUsersFunc);

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
    document.getElementById('login-row').innerText="Login failed! Reload the page or the computer will explode!"; 
  }

}

async function displayUsersFunc(){
  let response = await fetch(url+"allLogins", {credentials: 'include'});

  if(response.status===200){
    console.log(response);
    let data = await response.json();

    for(let user of data){
      console.log(user);
      let row = document.createElement("tr");

      let cell = document.createElement("td");
      cell.innerHTML = user.userId;
      row.appendChild(cell);

      let cell2 = document.createElement("td");
      cell2.innerHTML = user.userName;
      row.appendChild(cell2);

      let cell3 = document.createElement("td");
      cell3.innerHTML = user.userPassword;
      row.appendChild(cell3);

      let cell4 = document.createElement("td");
      cell4.innerHTML = user.userFname;
      row.appendChild(cell4);

      let cell5 = document.createElement("td");
      cell5.innerHTML = user.userLname;
      row.appendChild(cell5);

      let cell6 = document.createElement("td");
      cell6.innerHTML = user.userEmail;
      row.appendChild(cell6);

      let cell7 = document.createElement("td");
      if(user.ersUserRoleId != null) {
        cell7.innerHTML = user.ersUserRoleId.roleDesc;
      }
      row.appendChild(cell7);

      document.getElementById("userbody").appendChild(row);
    }
  }
}