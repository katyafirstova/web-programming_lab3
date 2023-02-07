
    let xError = document.getElementsByClassName("xError");
    let yError = document.getElementById("yError");
    let rError = document.getElementById("rError")

    const X_VALUES = [-3, -2, -1, 0, 1, 2, 3, 4, 5];

    let xVal, yVal, rVal;

    function validateX() {

        xVal = $(".selectX").val();
        let label = $('label');

        if (X_VALUES.includes(parseInt(xVal))) {
            label.removeClass('reallyRequired');
            printError("xError", "");
            xError = false;
            return true;
        } else {
            xVal.prev('label').addClass('reallyRequired');
            xVal.classList.add("input_err");
            printError("xError", "выберите x");
            return false;
        }
    }

    function checkIfBlank() {
        yVal = $('.inputY').val();
        rVal = $('.inputR').val();
        if (yVal === '' || rVal === '') {
            setErrorFor(yVal, 'поле не может быть пустым');
            setErrorFor(rVal, 'поле не может быть пустым');
            printError("yError", 'поле не может быть пустым');
            printError("rError", 'поле не может быть пустым')
            //  canvasContainer.classList.add("input_err");
            return false;

        } else {
            setSuccessFor(yVal);
            setSuccessFor(rVal);
            printError("yError", "");
            printError("rError", "");
            yError = false;
            rError = false;
            //  canvasContainer.classList.remove("input_err");
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
        yVal = $('.inputY').val().replace(/\s/g, '');
        if ((yVal <= -3 || yVal >= 5)) {
            yVal.classList.add('invalid');
            yVal.classList.remove('valid');
            printError("yError, некорректное значение")
            return false;
        } else {
            yVal.classList.add('valid');
            yVal.classList.remove('invalid');
            yError = false;
            printError("yError", "");
            setSuccessFor(yVal);
            return true;
        }

    }

    function validateR() {
        rVal = $('.inputR').val();
        if (rVal <= 2 || rVal >= 5) {
            rVal.classList.add('invalid');
            rVal.classList.remove('valid');
            printError("rError", "поле не может быть пустым")
            return false;
        } else {
            rVal.classList.add('valid');
            rVal.classList.remove('invalid');
            printError("rError", "");
            setSuccessFor(rVal);
            rError = false;
            return true;

        }
    }

    $('.submitBtn').on('click', function (event) {
        if (!validateX() || !validateY() || !validateR() || checkIfBlank()) event.preventDefault();

    });
























