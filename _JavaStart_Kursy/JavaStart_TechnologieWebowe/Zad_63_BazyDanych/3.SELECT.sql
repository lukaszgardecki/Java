-- Wybieranie wszystkich danych z tabeli:
select * from employees;

-- Można również nazwę tabeli poprzedzić nazwą bazy danych:
select * from employees.employees;

-- Wybór kilku konretnych kolumn:
select first_name, last_name, hire_date from employees;

-- Sortowanie (domyślnie rosnąco ascending)
select * from employees order by last_name, first_name
-- lub
select * from employees order by last_name, first_name asc;

-- Sortowanie malejąco:
select * from employees order by last_name, first_name desc;


-- Ograniczenia wyników (LIMIT):
select * from employees order by birth_date desc limit 10;


-- WHERE:
select * from employees where gender = 'M';
-- "weź wszystkie pozycje z tabeli employees, które posiadają gender = 'M'"


select * from employees where gender = 'M' and hire_date >= '1990-01-01';

-- inny zapis:
SELECT * FROM 
	employees 
WHERE 
	gender = 'M' AND hire_date >= '1990-01-01'
ORDER BY
	hire_date
LIMIT
	10
;























