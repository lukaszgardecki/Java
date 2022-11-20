-- Dodawanie do tabeli kolumny:
alter table user
add column username varchar(30) not null unique;

-- Usuwanie kolumny z tabeli:
alter table user
drop column city;

-- Modyfikacja kolumny password:
alter table user
modify password varchar(50) not null;












