function newPoint() {

    const rect = document.getElementById("plot").getBoundingClientRect();
    const valueR =$('.inputR').val();
    const centerX = rect.left + 300
    const centerY = rect.top + 300

    const valueX = event.clientX
    const valueY = event.clientY

    const calcX = ((valueX - centerX) * valueR / 200).toFixed(3)
    const calcY = ((centerY - valueY) * valueR / 200).toFixed(3)

    if (calcX <= 4 && calcX >= -4 && calcY >= -3 && calcY <= 5 && valueR !== 0 && valueR >= 1 && valueR <= 5) {
        document.getElementById('plot-form:plot-valueX').value = String(calcX);
        document.getElementById('plot-form:plot-valueY').value = String(calcY);
        document.getElementById('plot-form:plot-valueR').value = String(valueR);
        document.getElementById('plot-form:plot-check').click()
    }else {
        alert('Выбранные значения не входят в ОДЗ')
    }
}

