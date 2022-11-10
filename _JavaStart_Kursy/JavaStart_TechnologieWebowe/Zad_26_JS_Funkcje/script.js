//Zapis funkcji
function printHello() {
    console.log("Hello1");
}
printHello();

// Funkcję można przypisać do zmiennej
let sayHello = function() {
    console.log("Hello2")
}
sayHello();


// Funkcję można przypisać do zmiennej id OD RAZU wywołać
let sayHello2 = function() {
    console.log("Hello3")
}();

// IIFE - Immediately Invoked Function Expression (Natychmiasto Wywoływane Wyrażenie Funkcyjne)
(function() {
    console.log("Wywołanie funkcji.")
})();

//Funkcja z parametrami
let add = function(a, b) {
    let sum = a + b;
    return sum;
}
console.log(add(5,10));

let addAndPrint = function(a, b) {
    console.log(add(a, b));
}
addAndPrint(10, 20);

//Funkcja z parametrami, wywołana z niepełną listą argumentów
let sayHello3 = function(firstName, lastName, age) {
    console.log("Cześć " + firstName + " " + lastName + ", wiek, " + age);
}
sayHello3("Jan");


// Callback
let evaluate = function(a, b, callback) {
    let result = callback(a, b);
    console.log("Wynik wywołania callbacka: " + result);
}

let add2 = function(a, b) {
    return a + b;
}

evaluate(5, 10, add2);


//Połączenie callbacków z funcjami anonimowymi
let evaluate2 = function(a, b, callback) {
    let result = callback(a, b);
    console.log("Wynik wywołania callbacka: " + result);
}

evaluate2(5, 10, function(x, v) {
    return x + v;
});

// Funkcje strzałkowe (podobne do lambd z Javy, tylko strzałka jest inna)
let multiply = (a, b) => a * b;
console.log(multiply(3, 8));

let multiplyAndPrint = (a, b) => {
    console.log(a * b)
};

multiplyAndPrint(5, 9);


