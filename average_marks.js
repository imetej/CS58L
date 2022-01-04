function getMarks() {
    var m1 = parseInt(document.getElementById('m1').value);
    var m2 = parseInt(document.getElementById('m2').value);
    var m3 = parseInt(document.getElementById('m3').value);
    
    if (m1<m2 && m1<m3) {
        var avg = (m2 + m3) / 2;
    }

    else if (m2<m3 && m2<m1) {
        var avg = (m3 + m1) / 2;
    }

    else if (m3<m1 && m3<m2) {
        var avg = (m1 + m2) / 2;
    }

    alert("Average Marks : "+avg);      
}