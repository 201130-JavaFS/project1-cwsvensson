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
    Window.location.href="Reimb1-Start.html";
  }
}

async function displayUsersFunc(){
  let response = await fetch(url+"oneLogin", {credentials: 'include'});

  //user.ersUserRoleId.roleDesc
  

  if(response.status===200){
    console.log(response);
    let user = await response.json();

    if (user.ersUserRoleId.roleDesc=="Employee") {
      document.getElementById('login-row').innerText=user.ersUserRoleId;
      Window.location.href = "Reimb1-Emp-Welcome.html";
    } else if (user.ersUserRoleId.roleDesc=="Manager") {
      Window.location.href = "Reimb1-Emp-Welcome.html";
    } else if (user.ersUserRoleId.roleDesc=="SysAdmin") {
      Window.location.replace("Reimb1-Sys-Welcome.html");
    }
  }
  Window.location.href="Reimb1-Start.html";
}