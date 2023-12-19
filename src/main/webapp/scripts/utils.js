const widgetVar = "checkbox";
let flag = false;

function setY(y) {
    if (!flag) {
        flag = true;
        console.log(y);
        document.getElementById("sendToServer:Y_data").value = y;
        for (let i = -4; i < 5; i++) {
            if (i !== y) {
                PF(widgetVar + i).uncheck();
            } else {
                console.log(110);
                PF(widgetVar + i).check();
            }
        }
        flag = false;
    }
}

function getR() {
    return parseFloat(document.getElementById("sendToServer:rValue").value)
}


function validateBeforeSend() {
    const y = document.getElementById("sendToServer:Y_data").value;
    if (y) {
        for (let i = -4; i < 5; i++) {
            if (i === parseInt(y) && PF(widgetVar + i).isChecked()) {
                return true;
            }
        }
        document.getElementById("sendToServer:Y_data").value = null;
    }
    return false;
}