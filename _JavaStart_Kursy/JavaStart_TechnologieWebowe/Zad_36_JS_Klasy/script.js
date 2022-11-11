class Product {
    constructor(name, netPrice) {
        this.name = name;
        this.netPrice = netPrice;
    }

    bruttoPrice() {
        return this.netPrice * 1.23;
    }
}

let prod1 = new Product("mleko", 2.5);
console.log(prod1);
console.log(prod1.bruttoPrice());


class Player {
    constructor(nickname, points) {
        this.nickname = nickname;
        this._points = points;
    }

    //gettery i settery powinny mieć te same nazwy i być konstruowane w poniższy sposób

    // getter
    get points() {
        return `${this._points} points`;
    }


    // setter
    set points(value) {
        if (value >= 0) {
            this._points = value;
        } else {
            console.log("Liczba punktów musi być nieujemna");
        }
    }

    get info() {
        return `${this.nickname} : ${this._points}`;
    }
}


let player1 = new Player("John", 22);
// do getterów i setterów odwołujemy się jak do zwykłego pola.
// Dlatego ich nazwy muszą być inne niż nazwy pól.
player1.points = -5;
console.log(player1.points);
console.log(player1.info);



class Calculator {
    static rectangleArea(rect) {
        return rect.a * rect.b;
    }
}

class Rectangle {
    constructor(a, b) {
        this.a = a;
        this.b = b;
    }
}

let rect1 = new Rectangle(5, 10);
let area = Calculator.rectangleArea(rect1);
console.log(`Pole prostokąta: ${area}`);




class Course {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }

    getInfo() {
        return `${this.name} - ${this.price}`;
    }
}

class OnlineCourse extends Course {
    constructor(name, price, videoLength) {
        super(name, price);
        this.videoLength = videoLength;
    }

    getInfo() {
        return super.getInfo() + `, czas: ${this.videoLength}`;
    }
}

let javaCourse = new OnlineCourse("Kurs Java", 199, 480);
console.log(javaCourse.getInfo());