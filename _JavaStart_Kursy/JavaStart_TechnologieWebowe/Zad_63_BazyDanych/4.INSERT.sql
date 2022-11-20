-- Wstawianie rekordu do tabeli - schemat:
INSERT INTO nazwa_tabeli (kolumna1, kolumna2, ...) VALUES (wartosc1, wartosc2, ...);

-- Wstawianie rekordu do tabeli:
INSERT INTO departments (dept_no, dept_name) VALUES ('d010', 'Purchasing');

-- Wstawianie kilku rekordów na raz jako dwa osobne zapytania:
INSERT INTO departments (dept_no, dept_name) VALUES ('d010', 'Purchasing');
INSERT INTO departments (dept_no, dept_name) VALUES ('d011', 'Legal');

-- Wstawianie kilku rekordów na raz w jednym zapytaniu:
INSERT INTO departments (dept_no, dept_name)
VALUES ('d010', 'Purchasing'),
		('d011', 'Legal');
















