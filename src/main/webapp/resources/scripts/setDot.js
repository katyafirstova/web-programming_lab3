class Dot {
    constructor(options) {
        this.x = options.x
        this.y = options.y
        this.r = options.r
        this.result = options.result
        this.color = options.color
    }

    static create() {
        this.x = document.getElementById('dot-form:valueX').value;
        this.y = document.getElementById('dot-form:valueY').value;
        this.r = document.getElementById('dot-form:valueR').value;
        this.calculateResult()
        this.calculateColor()
        this.calculateCoordinates()
    }

    static update() {
        this.x = $('[id^=form\\:x-coordinate]:checked').val()
        this.y = document.getElementById('form:y-coordinate').value;
        this.r = document.getElementById('form:r-coordinate').value;
        this.calculateResult()
        this.calculateColor()
        this.calculateCoordinates()
    }

    static calculateCoordinates() {
        const calcX = 300 + this.x * 200 / this.r
        const calcY = 300 - this.y * 200 / this.r
        let target = document.getElementById('target-dot');
        target.setAttribute('r', 3)
        target.setAttribute('cx', String(calcX))
        target.setAttribute('cy', String(calcY))
        target.setAttribute('fill', this.color)
    }

    static calculateColor() {
        this.color = (this.result === 'true') ? '#91E876' : '#C25E51'
    }

    static calculateResult() {
        let checkRectangle = this.x <= 0 && this.y >= 0 && this.x <= this.r  && this.y <= this.r / 2
        let checkQuarterCircle = this.x >= 0 && this.y >= 0 && (this.x * this.x + this.y * this.y) <= this.r * this.r
        let checkTriangle = this.r > 0 && this.x >= 0 && this.y <= 0 && this.x <= this.r / 2 && this.y >= -this.r && this.y >= -this.r + 2*this.x;
        this.result = (checkRectangle || checkQuarterCircle || checkTriangle).toString()
    }


}