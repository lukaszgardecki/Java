let numbers = [1, 2, 3];
let numbers2 = new Array(1, 2, 3, 4);
let numbers4 = new Array(5); // utworzy pustą tablicę 5 elementową
let numbers3 = Array.of(1, 2, 3, 4);
let numbers5 = [1, "string", 5.43, [1, 2]];

let num = [10, 20, 30, 40];

let liczba = num[1]; //20
let len = num.length; // długośc tablicy

num[4] = 3.14;
console.log(num);

num.push(60); //wstawi 60 NA KONIEC tablicy
console.log(num);


console.log(num.pop()); //zwróci ostatni element z tablicy i go USUNIE
console.log(num);

console.log(num.shift()); //zwróci pierwszy element z tablicy i go usunie
console.log(num);

num.unshift(433); //wstawia element NA POCZĄTEK tablicy
console.log(num);

// pętla for of, jest to odpowiednik pętli for each
for (const number of num) {
    console.log(number);
}

for (const letter of "słowo") {
    console.log(letter);
}

num.reverse();
console.log(num);

num.sort();
console.log(num);

let index = num.indexOf(30); //zwróci indeks pod którym jest liczba 30
console.log("Wartość 30 znajduje się pod indeksem " + index);


console.log("num.join(|): " + num.join("|"));

let liczby = [100, 200, 300];
let dwietablice = num.concat(liczby); // do tablicy num zostaną dodane elementy tablicy liczby
console.log(dwietablice);


let t = [5, 10, 15, 20];
let isDividedBy5 = x => x % 5 === 0;

let cond = t.every(isDividedBy5); // sprawdza czy KAŻDY element tablicy spełnia warunek
console.log("Czy każdy element tablicy jest podzielny przez 5? " + cond);

let mojatablica = [5, 10, 150, 200];
let predykat = x => x > 100;
let firstGreaterThan100 = mojatablica.find(predykat); // znajdzie pierwszy element z tablicy, który spełni warunek
console.log("pierwszy element, który jest większy od 100 to " + firstGreaterThan100);

let getIndexIfGreaterThan100 = mojatablica.findIndex(predykat);
console.log("indeks w tablicy pierwszego elementu, który spełnia warunek: " + getIndexIfGreaterThan100)

console.log("Czy wartość 10 znajduje się w tablicy? " + mojatablica.includes(10));
console.log("Czy wartość 3 znajduje się w tablicy? " + mojatablica.includes(3));

console.log("Komputer! Podaj mjeee indeks liczby 10: " + mojatablica.indexOf(10));


console.log("Czy jakiś element w tablicy jest większy od 100? " + mojatablica.some(predykat));
















