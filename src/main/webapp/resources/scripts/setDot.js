class TargetDot {
    constructor(options) {
        this.x = options.x
        this.y = options.y
        this.r = options.r
        this.result = options.result
        this.color = options.color
    }

    static create() {
        document.getElementById('table').childNodes.forEach(row => {
            let cell = row.childNodes
            this.x = Number(cell[0].innerText)
            this.y = Number(cell[1].innerText)
            this.r = Number(cell[2].innerText)
            this.result = cell[3].innerText
            this.calculateColor()
            this.calculateCoordinates()
        });
    }

    static calculateCoordinates() {
        const calcX = 300 + this.x * 200 / this.r
        const calcY = 300 - this.y * 200 / this.r
        let target = document.getElementById('target-dot');
        target.setAttribute('r', 10)
        target.setAttribute('cx', String(calcX))
        target.setAttribute('cy', String(calcY))
        target.setAttribute('fill', this.color)
    }

    static calculateColor() {
        this.color = (this.result === 'true') ? '#91E876' : '#C25E51'
    }

    static calculateResult() {
        let checkRectangle = this.x <= 0 && this.y >= 0 && this.x <= this.r / 2 && this.y >= -this.r
        let checkQuarterCircle = this.x >= 0 && this.y >= 0 && (this.x * this.x + this.y * this.y) <= this.r * this.r
        let checkTriangle = this.x >= 0 && this.y <= 0 && (this.x * this.x + this.y * this.y) >= this.r * this.r;

        this.result = (checkRectangle || checkQuarterCircle || checkTriangle).toString()
    }

    static update() {
        if (this.result) {
            this.r = Number(document.getElementById('form:r-coordinate').value)
            this.calculateResult()
            this.calculateColor()
            this.calculateCoordinates()
        }
    }
}

