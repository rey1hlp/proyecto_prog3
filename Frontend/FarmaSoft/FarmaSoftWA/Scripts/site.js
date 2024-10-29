function updateProgressBar(percent) {
    var progressBar = document.getElementById("progressBar");
    progressBar.style.width = percent + "%";
    progressBar.innerHTML = percent + "%";
}

function startProgress() {
    document.getElementById("progressContainer").style.display = "block";
    updateProgressBar(0);

    var percent = 0;
    var interval = setInterval(function () {
        if (percent >= 100) {
            clearInterval(interval);
            alert("Proceso completado!");
        } else {
            percent += 10; // Incremento simulado, cambia este valor según tus necesidades
            updateProgressBar(percent);
        }
    }, 500); // Intervalo en milisegundos
}
