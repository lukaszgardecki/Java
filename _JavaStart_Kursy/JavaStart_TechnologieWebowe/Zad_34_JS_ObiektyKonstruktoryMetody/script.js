let product1 = {
    name: "Czekolada",
    price: 2.5,
    category: ["Słodycze", "Przekąski"],
    producer: {
        name: "Nestle",
        address: "Warszawa"
    }
}


let myObj = {
    a: "first",
    "b": "second",
    3: "third"
}


console.log(myObj.a);
console.log(product1.producer.address);
console.log(product1["name"]);



function Calc() {
    this.add = function(a, b) {
        return a + b;
    }
    this.multiply = function(a, b) {
        return a * b;
    }
}

let calc = {
    add(a, b) {
        return a + b;
    },
    multiply: function(a, b) {
        return a * b;
    }
}

let add = calc.add(10, 5);
console.log(add);
calc.multiply(8, 8);



// console.log(product1);

// function Product(name, price, category) {
//     this.name = name;
//     this.price = price;
//     this.category = category;
// }

// let prod1 = new Product("Mleko", 2.5, "Nabiał");
// let prod2 = new Product("Czekolada", 3.0, "Słodycze");

// console.log(prod1);
// console.log(prod2);

// prod1.name = "Niemleko";

// console.log(prod1);


let product = {
    name: "Czkolada",
    nettoPrice: 2.5
}

product.quantity = 10;
product.producer = "Nestle";
product.bruttoPrice = function() {
    return this.nettoPrice * 1.23;
}

console.log(product);
console.log(product.bruttoPrice());


//petla FOR IN
for (key in product) {
    console.log(key + ": " + product[key]);
}