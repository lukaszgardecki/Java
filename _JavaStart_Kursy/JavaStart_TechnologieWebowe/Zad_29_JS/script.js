
// Ćwiczenie

// Zdefiniuj funkcję, która przyjmuje dowolną liczbę naturalną i zwraca w wyniku liczbę cyfr tej liczby. Przetestuj jej działanie na kilku przykładowych liczbach.

// W rozwiązaniu możesz wykorzystywać jedynie podstawowe operatory matematyczne. Nie możesz zamieniać liczby na napis, ani korzystać z funkcji zdefiniowanych w klasie Math.


// Rozwiązanie z wykorzystaniem rekurencji
function countDigits(a) {
    let b = a / 10;
    if (b <= 1) {
        return 1;
    } else {
        return 1 + countDigits(b);
    }
}

function countDigitsAndPrint(a) {
    console.log("Liczba cyfr w liczbie " + a + " to " + countDigits(a));
}

countDigitsAndPrint(1);
countDigitsAndPrint(12);
countDigitsAndPrint(321);
countDigitsAndPrint(2435);