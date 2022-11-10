let number = 5;

if (number !== 0) {
    console.log("Liczba rózna od 0")
} else {
    console.log("Liczba to 0")
}

// To samo można zapisać tak:
let number1 = 5;

if (number1) {
    //nie trzeba sprawdzać warunku, ponieważ sama liczba zostanie zamieniona na TRUE lub FALSE. Jeśli jest większa od 0 to zwróci true, jeśli nie to false.
    console.log("Liczba rózna od 0")
} else {
    console.log("Liczba to 0")
}

//Switch - do switcha możemy dać dowolne wartości, a nie tylko stałe liczbowe lub ciągi znaków jak jest to w Javie
let value = 5.5;
switch (value) {
    case 5:
        console.log("Liczba 5");
        break;
    case 5.5:
        console.log("Liczba 5.5");
        break;
    default:
        console.log("Nieznana wartość");
}

//pętla for
for (let i = 0; i < 3; i++) {
    console.log("Liczba for " + 1);
}

//pętla while
let counter = 0;
while(counter < 3) {
    console.log("Liczba while " + counter);
    counter++;
}

//pętla do while
let c = 0;
do {
    console.log("Liczba do-while " + c);
    c++;
} while(c < 3);


//pętla malejąca
let counter2 = 5;
// dopóki counter2 JEST WIĘKSZE OD ZERA!
while (counter2) {
    console.log(counter2);
    counter2--;
}

let i = 1;
while(true) {
    console.log("Liczba " + i);
    if (i === 3) {
        break;
    }
    i++;
}












