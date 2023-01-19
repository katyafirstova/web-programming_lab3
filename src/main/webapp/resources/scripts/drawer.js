function onImageClick (event) {

    const r = $('.');

    let coordinates = getCoordinates(event.offsetX, event.offsetY, r);

    const xInput = window.document.getElementById('hidden-form:hidden-x');
    xInput.value = coordinates.x;

    const yInput = window.document.getElementById('hidden-form:hidden-y');
    yInput.value = coordinates.y;

    let submitButton = window.document.getElementById("hidden-form:hidden-submit");
    submitButton.click();
}

function getCoordinates (offsetX, offsetY, r) {
    /* в этой функции мы просто получаем координаты клика относительно установленного радиуса */
    const parent = window.document.getElementById('hidden-form:image');

    const x = r*(offsetX - parent.clientWidth / 2 ) / parent.clientWidth * 2;
    const y = r*(parent.clientHeight / 2 - offsetY) / parent.clientHeight * 2;

    return { x, y };
}

function updateImage (event) {
    /* строки таблицы с точками */
    const rows = window.document.getElementById("result-table").rows;

    /* парсим все строки, кроме первой (там заголовок);
    создаем объекты { x, y, result } для удобства и кладем их в массив */
    let points = [];
    for (let i = 1; i < rows.length; ++i) {
        points.push({
            x: window.document.getElementById("xVal"),
            y: window.document.getElementById("yVal"),
            result: window.document.getElementById("res")
        })
    }

    /* удаляем старые точки с картинки */
    clearImage();

    /* рисуем новые */
    drawPoints(points);
}

function drawPoints (points) {

    const imageElement = window.document.getElementById('image-container');

    points.forEach(function (point) {
        const div = window.document.createElement('div');
        div.classList.add('point');
        div.classList.add(point.result === 'true' ? 'in' : 'out');
        const offset = getOffset(point.x, point.y, r);
        div.style.top = offset.offsetY + "px";
        div.style.left = offset.offsetX + "px";
        imageElement.appendChild(div);
    });
}

function clearImage () {
    /* просто удаляем все дочерние div'ы-точки */
    const imageContainer = window.document.getElementById('image-container');

    while (imageContainer.lastChild && imageContainer.lastChild.localName === 'div') {
        imageContainer.removeChild(imageContainer.lastChild);
    }
}

const getOffset = (x, y, r) => {
    const parent = window.document.getElementById('hidden-form:image');

    const offsetX = x / r * parent.clientWidth / 2 + parent.clientWidth / 2;
    const offsetY = -y / r * parent.clientHeight / 2 + parent.clientHeight / 2;

    return {offsetX, offsetY };
};

updateImage();



