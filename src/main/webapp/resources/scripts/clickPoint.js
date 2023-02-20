function clickPoint() {

    const rect = document.getElementById("plot").getBoundingClientRect();
    const valueR = $('.inputR').val();
    const centerX = rect.left + 300
    const centerY = rect.top + 300;

    const valueX = event.clientX;
    const valueY = event.clientY;

    const calcX = ((valueX - centerX) * valueR / 200).toFixed(3);
    const calcY = ((centerY - valueY) * valueR / 200).toFixed(3);

    document.getElementById('dot-form:valueX').value = calcX;
    document.getElementById('dot-form:valueY').value = calcY;
    document.getElementById('dot-form:valueR').value = valueR
    document.getElementById('dot-form:check').click();

}

