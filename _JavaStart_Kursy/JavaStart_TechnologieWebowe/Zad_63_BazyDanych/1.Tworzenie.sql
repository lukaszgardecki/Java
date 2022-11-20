-- Tworzenie baz:
create database LUB create schema (to samo)

-- Kodowanie znaków:
character set utf8mb4

-- Sposób w jaki mają być porównywane ze sobą znaki:
collate utf8mb4_polish_ci

-- Przykład tworznenia bazy danych:
create database social_network character set utf8mb4 collate utf8mb4_polish_ci;

-- Tworzenie tabel:
create table user (
	id int primary key auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    email varchar(50) not null unique,
    password varchar(30) not null,
    age int,
    city varchar(30)
);

-- Tworzenie tabel ze złożonym kluczem głównym:
create table user (
	id int auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    email varchar(50) not null unique,
    password varchar(30) not null,
    age int,
    city varchar(30)
    primary key (id, email)
);

-- Usuwanie tabel:
drop table if exists user;
-- (dodanie if exists sprawdza, czy tabela istnieje, jest opcjonalne)

-- Usuwanie bazy danych:
drop database if exists social_network;
drop schema if exists social_network;
-- if exists jest opcjonalne




