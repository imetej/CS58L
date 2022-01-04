function validForm() {
    let uname = document.getElementById("uname").value;
    let uemail = document.getElementById("email").value;
    let umobile = document.getElementById("mobile").value;
    let ucolor = document.getElementById("color").value;

    if (nameValid(uname)) {}
    if (emailValid(uemail)) {}
    if (mobileValid(umobile)) {}
    if (colorValid(ucolor)) {}

    getFormvalue();

    document.getElementById("validForm").reset();
}

function nameValid(uname) {
    var letters = /^[A-Za-z]+$/;

    if (uname.match(letters)) {
        return true;
    }

    else {
        alert('Username must have alphabet characters only');
        uname.focus();
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

function mobileValid(umobile) {
    var phoneno = /^\d{10}$/;

    if (umobile.match(phoneno)) {
      return true;
    }

    else {
        alert("Enter a valid number!");
        umobile.focus();
        return false;
    }
}

function colorValid(ucolor) {
    if (ucolor == "") {
        alert("Favorite Color must be filled out");
        ucolor.focus();
        return false;
    }

    else {
        return true;
    }
}

function getFormvalue() {
    var x = document.getElementById("validForm");
    
    document.write("You submitted the following values :" + "<br/>");

    for (var i = 0 ; i < x.length ; i++) {
        if (x.elements[i].value != 'Submit') {
            document.write(x.elements[i].value + "<br/>");
        }
    }
}