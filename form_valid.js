function formValid() {
    let uid = document.getElementById("uid").value;
    let uname = document.getElementById("uname").value;
    let upassword = document.getElementById("password").value;
    let uemail = document.getElementById("email").value;

    if (uidValid(uid)) {}
    if (nameValid(uname)) {}
    if (passwordValid(upassword)) {}
    if (emailValid(uemail)) {}
    
    document.getElementById("formValid").reset();
}

function uidValid(uid) {
    if(uid.length >= 5 && uid.length <= 12) {
        return true;
    }

    else {
        alert("Please input between 5 and 12 characters");
        uid.focus();
        return false;
    }  
}

function nameValid(uname) {
    var letters = /^[A-Za-z]+$/;

    if (uname.match(letters) && uname.length <= 15) {
        return true;
    }

    else {
        alert('Username must have alphabet characters only and must be less than 15 characters without space');
        uname.focus();
        return false;
    }
}

function passwordValid(upassword) {
    var pwd = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    
    if (upassword.match(pwd)) { 
        return true;
    }

    else {
        alert('Password must be eight characters including one uppercase letter, one special character and alphanumeric characters');
        upassword.focus();
        return false;
    }
}

function emailValid(uemail) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if(uemail.match(mailformat)) {
        return true;
    }

    else {
        alert("You have entered an invalid email address!");
        uemail.focus();
        return false;
    }
}