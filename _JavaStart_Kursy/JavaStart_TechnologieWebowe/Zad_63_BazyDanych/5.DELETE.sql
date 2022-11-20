-- Usuwanie rekordu - schemat:
delete from nazwa_tabeli where warunek;

-- Przykład:
DELETE FROM departments WHERE dept_name = 'Purchasing'

"MUSI BYĆ WHERE! BEZ WHERE ZOSTAŁABY USUNIĘTA CAŁA KOLUMNA departments"

-- Przykład:
DELETE FROM employees WHERE last_name = 'Zielinski' OR gender = 'M';
















