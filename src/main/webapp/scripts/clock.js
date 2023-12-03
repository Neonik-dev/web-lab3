const UPDATE_TIME_IN_MS = 13000;

window.addEventListener( 'DOMContentLoaded', function () {
    const clock = document.querySelector('#clock').getContext('2d');
    clock.canvas.width = 140;
    clock.canvas.height = 45;

    getTime();
    setInterval(getTime, UPDATE_TIME_IN_MS);

    function getTime() {
        clock.clearRect(0, 0, clock.canvas.width, clock.canvas.height);
        const today = new Date().toDateString();
        clock.font = '14px Arial, sans-serif';
        clock.fillText(today, 15, 15);

        const time = new Date().toLocaleTimeString();
        clock.fillText(time, 35, 35);
    }
}, false);