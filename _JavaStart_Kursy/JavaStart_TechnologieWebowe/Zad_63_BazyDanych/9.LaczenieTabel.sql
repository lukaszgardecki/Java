-- Wyświetlenie informacji o wszystkich pracownikach, któzy kiedykolwiek pracowali w firmie na stanowisku inżyniera (Engineer):
select * from titles where tile = 'Engineer';


-- Wyświetlenie wszystkich pracowników, których identyfikator znajduje się w zbiorze pracowników, którzy mieli przypisane stanowisko inżyniera:
select *
from employees
where emp_no in (
    select emp_no from titles where title = "Engineer"
);
-- IN - znajduje się w zbiorze


-- Sposób 1. Łączenie tabel. Wyświetlenie pasujących rekordów z dwóch tabel. Wyświetlone zostaną wszystkie kolumny:
SELECT *
FROM employees, titles
WHERE
	employees.emp_no = titles.emp_no
    AND
    title = 'Engineer'
;


-- Sposób 2. Łączenie tabel. Wyświetlenie pasujących rekordów z dwóch tabel. Wyświetlone zostaną tylko kolumny z imieniem, nazwiskiem, tytułem, datą zatrudnienia i datą zwolnienia:
SELECT
	first_name, last_name, title, from_date, to_date
FROM
	employees, titles
WHERE
	employees.emp_no = titles.emp_no
    AND
    title = 'Engineer'
;

-- Sposób 3. Łączenie tabel przy użyciu JOIN. Wyświetlenie pasujących rekordów z dwóch tabel. Wyświetlone zostaną tylko kolumny z imieniem, nazwiskiem, tytułem, datą zatrudnienia i datą zwolnienia:
SELECT
	first_name, last_name, title, from_date, to_date
FROM
	employees JOIN titles ON employees.emp_no = titles.emp_no
WHERE
    title = 'Engineer'
;

Oprócz tego istnieją jeszcze złączenia zewnętrzne:

    LEFT OUTER JOIN lub krócej LEFT JOIN - pobiera te rekordy z tabeli znajdującej się po lewej stronie i do rekordów dodaje informacje z tabeli znajdującej się po prawej stronie o ile takie istnieją,
    RIGHT OUTER JOIN lub krócej RIGHT JOIN - pobiera wszystkie rekordy z tabeli znajdującej się po prawej stronie i do rekordów dodaje informacje z tabeli znajdującej się po lewej stronie o ile takie istnieją,
    FULL OUTER JOIN lub krócej FULL JOIN - pobiera wszystkie rekordy z obu tabel, nawet jeżeli nie mają one swojego odpowiednika w drugiej tabeli, z którą dokonujemy złączenia.




