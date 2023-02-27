let x = document.getElementById("x-coordinate");

let y = document.getElementById("y-coordinate");

let r = document.getElementById("r-coordinate");

let form = document.getElementById("form");


function checkIfBlank() {
    let yValue = y.value.replace(/\D/g, '');
    let rValue = r.value.replace(/\D/g, '');
    if (yValue === '' || rValue === '') {
        setErrorFor(y, 'поле не может быть пустым');
        setErrorFor(r, 'поле не может быть пустым');
        return false;

    } else {
        setSuccessFor(y);
        setSuccessFor(r);
        return true;
    }
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');

    small.innerText = message;
    formControl.className = 'form-control error';
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';

}

function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateY() {
    let yVal = y.value.replace(/\s/g, '')
    if (yVal < -3 || yVal > 5) {
        y.classList.add('invalid');
        y.classList.remove('valid');
        return false;
    } else {
        y.classList.add('valid');
        y.classList.remove('invalid');
        setSuccessFor(y);
        return true;
    }

}

function validateR() {
    let rVal = r.value;
    if (rVal < 1 || rVal > 5) {
        r.classList.add('invalid');
        r.classList.remove('valid');
        return false;
    } else {
        r.classList.add('valid');
        r.classList.remove('invalid');
        setSuccessFor(r);
        return true;

    }
}

y.addEventListener('input', validateY);
r.addEventListener('input', validateY);
form.on('submit', function () {
    validateY();
    validateR();


});
form.addEventListener("submit", function (e) {
    if (!validateY() || !validateR() || checkIfBlank()) e.preventDefault();
});

y.addEventListener("input", function () {
    y.classList.remove("input_err");
});





















