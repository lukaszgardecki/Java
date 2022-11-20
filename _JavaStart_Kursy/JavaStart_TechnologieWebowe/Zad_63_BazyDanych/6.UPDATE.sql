-- Aktualizacja danych - schemat:
UPDATE nazwa_tabeli
SET kolumna1=nowa_wartosc1, kolumna2=nowa_wartosc2, ... WHERE warunek;


-- Przykład:
UPDATE employees
SET first_name = 'Karol'
WHERE emp_no = 10005;

