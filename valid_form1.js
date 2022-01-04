function getFormvalue() {
    var x = document.getElementById("validForm");
    
    document.write("You submitted the following values :" + "<br/>");

    for (var i = 0 ; i < x.length ; i++) {
        if (x.elements[i].value != 'Submit') {
            document.write(x.elements[i].value + "<br/>");
        }
    }

    document.getElementById("validForm").reset();
}