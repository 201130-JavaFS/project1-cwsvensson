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
    credentials: 'include',
    samesite: 'None'
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
  let response = await fetch(url+"oneLogin", {credentials: 'include'});

  if(response.status===200){
    console.log(response);
    let user = await response.json();

    let row = document.createElement("tr");

    let title1   = document.createElement("td");
    title1.innerHTML = "ID #";
    row.appendChild(title1);

    let title2   = document.createElement("td");
    title2.innerHTML = "Login Name";
    row.appendChild(title2);

    let title3   = document.createElement("td");
    title3.innerHTML = "Password";
    row.appendChild(title3);

    let title4   = document.createElement("td");
    title4.innerHTML = "First Name";
    row.appendChild(title4);

    let title5   = document.createElement("td");
    title5.innerHTML = "Last Name";
    row.appendChild(title5);

    let title6   = document.createElement("td");
    title6.innerHTML = "User Email";
    row.appendChild(title6);

    let title7   = document.createElement("td");
    title7.innerHTML = "User Position";
    row.appendChild(title7);

    document.getElementById("userhead").appendChild(row);


    //for(let user of data){
      console.log(user);
      let row2 = document.createElement("tr");

      let cell = document.createElement("td");
      cell.innerHTML = user.userId;
      row2.appendChild(cell);

      let cell2 = document.createElement("td");
      cell2.innerHTML = user.userName;
      row2.appendChild(cell2);

      let cell3 = document.createElement("td");
      cell3.innerHTML = user.userPassword;
      row2.appendChild(cell3);

      let cell4 = document.createElement("td");
      cell4.innerHTML = user.userFname;
      row2.appendChild(cell4);

      let cell5 = document.createElement("td");
      cell5.innerHTML = user.userLname;
      row2.appendChild(cell5);

      let cell6 = document.createElement("td");
      cell6.innerHTML = user.userEmail;
      row2.appendChild(cell6);

      let cell7 = document.createElement("td");
      if(user.ersUserRoleId != null) {
        cell7.innerHTML = user.ersUserRoleId.roleDesc;
      }
      row2.appendChild(cell7);

      document.getElementById("userbody").appendChild(row2);
    //}
  }
}