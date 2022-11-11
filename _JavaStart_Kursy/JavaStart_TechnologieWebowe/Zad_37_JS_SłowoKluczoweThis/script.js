var x = "Ania";
let y = "Karol";

console.log(x); //Ania
console.log(this.x); //Ania
console.log(window.x); //Ania

console.log(y); //Karol
console.log(this.y); //undefined
console.log(window.y); //undefined

console.log(this === window); //true





function showThis() {
    console.log(this);
}
showThis(); //window






function Product(name, price) {
    this.name = name;
    this.price = price;
    this.bruttoPrice = function() {
        console.log(this);
        console.log(this.price * 1.23);
    }
}

let product1 = new Product("mleko", 3.0);
product1.bruttoPrice();


let prod1 = {
    name: "mleko",
    price: 3.0,
    bruttoPrice: function() {
        console.log(this);
        console.log(this.price * 1.23);
    }
}
prod1.bruttoPrice();