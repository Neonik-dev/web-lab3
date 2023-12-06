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