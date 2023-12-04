window.addEventListener('DOMContentLoaded', function () {
    const canvas = document.getElementById("canvas");
    const ctx = canvas.getContext("2d");
    const maxLength = 350;
    const R = 150

    ctx.fillStyle = "rgba(30, 144, 255, 0.8)";
    drawTopRightQuadrant();
    drawDownLeftQuadrant();
    drawDownRightQuadrant();
    drawArrow(maxLength / 2, maxLength, maxLength / 2, 0);
    drawArrow(0, maxLength / 2, maxLength, maxLength / 2);
    drawMark()
    ctx.fillStyle = "rgb(0,0,0)";
    drawText()


    function drawArrow(fromX, fromY, toX, toY) {
        ctx.beginPath();
        const headLen = 10;
        const dx = toX - fromX;
        const dy = toY - fromY;
        const angle = Math.atan2(dy, dx);
        ctx.moveTo(fromX, fromY);
        ctx.lineTo(toX, toY);
        ctx.lineTo(toX - headLen * Math.cos(angle - Math.PI / 6), toY - headLen * Math.sin(angle - Math.PI / 6));
        ctx.moveTo(toX, toY);
        ctx.lineTo(toX - headLen * Math.cos(angle + Math.PI / 6), toY - headLen * Math.sin(angle + Math.PI / 6));
        ctx.stroke();
    }

    function drawTopRightQuadrant() {
        ctx.beginPath();
        ctx.moveTo(maxLength / 2, maxLength / 2 - R);
        ctx.lineTo(maxLength / 2, maxLength / 2);
        ctx.lineTo(maxLength / 2 + R, maxLength / 2);
        ctx.closePath();
        ctx.fill();
    }

    function drawDownLeftQuadrant() {
        ctx.beginPath();
        ctx.fillRect(maxLength / 2 - R, maxLength / 2, R, R / 2);
        ctx.stroke();
    }

    function drawDownRightQuadrant() {
        ctx.beginPath();
        ctx.arc(maxLength / 2, maxLength / 2, R, 0, Math.PI / 2, false);
        ctx.lineTo(maxLength / 2, maxLength / 2);
        ctx.fill();
    }

    function drawMark() {
        const lenMark = 5;
        ctx.beginPath();
        ctx.moveTo(maxLength / 2 - lenMark, maxLength / 2 - R); // Oy
        ctx.lineTo(maxLength / 2 + lenMark, maxLength / 2 - R);

        ctx.moveTo(maxLength / 2 - lenMark, maxLength / 2 - R / 2);
        ctx.lineTo(maxLength / 2 + lenMark, maxLength / 2 - R / 2);

        ctx.moveTo(maxLength / 2 - lenMark, maxLength / 2 + R / 2);
        ctx.lineTo(maxLength / 2 + lenMark, maxLength / 2 + R / 2);

        ctx.moveTo(maxLength / 2 - lenMark, maxLength / 2 + R);
        ctx.lineTo(maxLength / 2 + lenMark, maxLength / 2 + R);

        ctx.moveTo(maxLength / 2 - R, maxLength / 2 - lenMark); // Ox
        ctx.lineTo(maxLength / 2 - R, maxLength / 2 + lenMark);

        ctx.moveTo(maxLength / 2 - R / 2, maxLength / 2 - lenMark);
        ctx.lineTo(maxLength / 2 - R / 2, maxLength / 2 + lenMark);

        ctx.moveTo(maxLength / 2 + R / 2, maxLength / 2 - lenMark);
        ctx.lineTo(maxLength / 2 + R / 2, maxLength / 2 + lenMark);

        ctx.moveTo(maxLength / 2 + R, maxLength / 2 - lenMark);
        ctx.lineTo(maxLength / 2 + R, maxLength / 2 + lenMark);

        ctx.stroke();
    }

    function drawText() {
        const delta = 10;
        ctx.font = "17px serif"
        ctx.fillText("y", maxLength / 2 + delta, delta);
        ctx.fillText("R", maxLength / 2 + delta, maxLength / 2 - R + delta / 2);
        ctx.fillText("R/2", maxLength / 2 + delta, maxLength / 2 - R / 2 + delta / 2);
        ctx.fillText("-R/2", maxLength / 2 + delta, maxLength / 2 + R / 2 + delta / 2);
        ctx.fillText("-R", maxLength / 2 + delta, maxLength / 2 + R + delta / 2);

        ctx.fillText("x", maxLength - delta, maxLength / 2 - delta);
        ctx.fillText("-R", maxLength / 2 - R - delta, maxLength / 2 - delta);
        ctx.fillText("-R/2", maxLength / 2 - R / 2 - delta, maxLength / 2 - delta);
        ctx.fillText("R/2", maxLength / 2 + R / 2 - delta, maxLength / 2 - delta);
        ctx.fillText("R", maxLength / 2 + R - delta / 2, maxLength / 2 - delta);
    }

    function drawPoint(x, y, r) {
        ctx.fillRect(maxLength / 2 + R * (x / r) - 1, maxLength / 2 - R * (y / r) - 1, 2, 2);
    }

    canvas.onclick = (event) => {
        if (validR()) {
            const userR = getR();
            document.getElementById("errorMessage").innerHTML = "";

            const x = event.pageX - event.target.offsetLeft - maxLength / 2;
            const y = maxLength / 2 - event.pageY + event.target.offsetTop;

            document.getElementById("Y-input").value = Math.round(y / R * userR * 1000) / 1000;
            document.querySelector(".X-input").value = Math.round(x / R * userR);
            if (isValid()) {
                document.getElementById('sendToServer').submit();
            }
        } else {
            document.getElementById("errorMessage").innerHTML = "Value for R is not selected";
        }
    }
}, false);