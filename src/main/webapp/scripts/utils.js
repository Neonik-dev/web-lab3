const widgetVar = "checkbox";
let flag = false;

function setY(y, curCheckbox) {
    if (!flag) {
        flag = true;
        document.getElementById("sendToServer:Y_data").value = y;
        for (let i = -4; i < 5; i++) {
            if (i !== y) {
                PF(widgetVar + i).uncheck();
            }
        }
        flag = false;
    }
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