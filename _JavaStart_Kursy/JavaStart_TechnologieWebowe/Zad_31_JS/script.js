// Ćwiczenie

// Zdefiniuj tablicę dziesięciu dowolnych liczb, a następnie zapisz niżej opisane funkcje.

// 1. Funkcja, która przyjmuje dwie tablice liczb i sprawdza ile liczb z drugiej tablicy znajduje się w pierwszej. Możesz założyć, że liczby w obu tablicach są unikalne.

// Dla tablic [1, 2, 3, 4, 5], [3, 4, 6, 8] oczekiwany wynik to 2.

// 2. Funkcja, która przyjmuje tablicę liczb, a w wyniku zwraca dwuelementową tablicę, w której pierwsza liczba jest najmniejszą, a druga liczba jest największą wartością z przekazanej jako argument tablicy. Zakładamy, że przekazana tablica ma co najmniej 1 element.

// Dla tablicy [10, 5, 15, 20, 3, 8] oczekiwany wynik to [3, 20]

// 3. Funkcja, która przyjmuje tablicę i dowolną liczbę, a w wyniku zwraca nową tablicę, w której wartości z oryginalnej tablicy będą rozdzielone przekazaną liczbą.

// Dla tablicy [5, 10, 15] i liczby 1 oczekiwany wynik to [5, 1, 10, 1, 15, 1]

// Przetestuj działanie każdej z funkcji.




let nums = [1, 56, 12, 9, 59, 81, 26, 41, 7, 65];

// Zadanie 1:
function getNumOfCommonEl(tab1, tab2) {
    let counter = 0;
    for (let i = 0; i < tab2.length; i++) {
        if (tab1.includes(tab2[i])) {
            counter++;
        }
    }
    return counter;
}

let t1 = [1, 2, 3, 4, 5];
let t2 = [3, 4, 6, 8];
let commonEls = getNumOfCommonEl(t1, t2);
console.log("Ilość elementów wspólnych tablic t1 i t2 to " + commonEls);

// Zadanie 2:
function getFirstAndLast(tab) {
    let max = tab[0];
    let min = tab[0];
    for (let i = 0; i < tab.length; i++) {
        if(tab[i] > max) {
            max = tab[i];
        }
        if (tab[i] < min) {
            min = tab[i];
        }
    }
    return Array.of(min, max);
}

let exampleTab = [10, 5, 15, 20, 3, 8];
let exMin = getFirstAndLast(exampleTab)[0];
let exMax = getFirstAndLast(exampleTab)[1];
console.log("Dla tablicy [10, 5, 15, 20, 3, 8], największa wartość to " + exMax + ", a najmniejsza to " + exMin);


// Zadanie 3:
function getTabSeparatedBy(tab, num) {
    let t = new Array;
    for (el of tab) {
        t.push(el);
        t.push(num);
    }
    return t;
}
let exTab = [5, 10, 15];
console.log("Tablica [5, 10, 15] przedzielona liczbą 1: " + getTabSeparatedBy(exTab, 1));




