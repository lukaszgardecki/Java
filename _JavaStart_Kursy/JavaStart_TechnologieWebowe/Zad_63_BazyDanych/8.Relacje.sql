-- Tworzymy bazę danych:
create database course_platform collate utf8mb4_polish_ci;

-- Tworzymy pierwszą tabelę (dane o użytkownikach):
create table user (
    id int primary key auto_increment,
    username varchar(30) unique not null,
    email varchar(40) unique not null,
    password varchar(40) not null
);

-- Tworzymy drugą tablę z info nt. kursów:
create table course (
    id int primary key auto_increment,
    name varchar(50) unique not null,
    description varchar(2000)
);

-- Tworzymy użytkowników:
insert into user
    (username, email, password)
values
    ('jankowal', 'jan@kowalski.com', 'jan1234'),
    ('martita', 'martita@mymail.com', 'marta2001210'),
    ('peter99', 'don.petro@supermail.com', 'puszek');

-- Tworzymy kursy:
insert into course
    (name, description)
values
    ('Kurs Java', 'Kurs programowania przeznaczony dla początkujących i nieco bardziej zaawansowanych.'),
    ('Kurs Python', 'Naucz się języka Python i wykorzystaj go do programowania sztucznej inteligencji i zaawansowanych obliczeń.'),
    ('Kurs JavaScript', 'Poznaj język JavaScript i naucz się tworzyć piękne, dynamiczne strony internetowe, które podbiją świat.')


-- Relacje. Użytkownik może być zapisany na wiele kursów, a na jeden kurs może być zapisanych wielu użytkowników. Relacja wiele do wielu. W przypadku relacji wiele do wielu powinniśmy stworzyć dodatkową tabelę pośredniczącą!!
create table user_course (
    id int primary key auto_increment,
    user_id int not null,
    course_id int not null,
    signup_date date not null,
    expiration_cate date not null,
    constraint fk_user_id foreign key (user_id) references user (id),
    foreign key (course_id references course (id)
);

insert into user_course
    (user_id, course_id, signup_date, expiration_cate)
values
    (2, 2, '2018-10-10', '2019-10-10')
    (2, 3, '2019-10-10', '2020-10-10')
    (3, 1, '2019-11-06', '2020-11-06')

-- Jeden kurs może być przypisany tylko do jednej kategorii.
-- Do kategorii może być przypisanych wiele kursów.
-- W tej sytuacji występuje relacja JEDEN DO WIELU (lub wiele do jednego)
-- Tworzymy dodatkową tabelę, w której będą kategorie kursów:
create table course_category (
    id int primary key auto_increment,
    name varchar(30) not null,
    description varchar(200)
);

-- Dodajemy przykładowe kategorie:
insert into course_category
    (name, description)
values
    ('Frontend', 'Kursy związane z wizualną częścią aplikacji'),
    ('Backend', 'Kursy związane z serwerową częścią aplikacji');

-- Modyfikujemy tabelę kursów (dodajemy kulumnę z kategorią):
alter table course
add category_id int,
add foreign key (category_id) references course_category(id);


-- Aktualizujemy tabelę z kursami, do kolumny z kategorią należy wpisać ID kategorii:
-- Nasza tabela z kursami ma 3 pozycje, więc musimy je zaktualizować:
update course set category_id = 1 where id = 3;
update course set category_id = 2 where id IN (1, 2);


-- Tworzymy dodatkową tabelę ze szczegółami użytkownika. Szczegóły będa opcjonalne, tzn. że mogą byc użytkownicy, którzy nie będą posiadać szczegółów. Jeden użytkownik może mieć jedne szczegóły. Relacja JEDEN DO JEDNEGO.
-- Ważne jest tutaj by klucz obcy był UNIKALNY. Gdybyśmy tego nie zrobili to by powstała zwykła relacja jeden do wielu (wiele do jednego).
create table user_details (
    id int primary key auto_increment,
    user_id int unique not null,
    telephone varchar(11),
    city varchar(30),
    foreign key (user_id) references user(id)
);

insert into user_details
    (user_id, telephone, city)
values
    (2, '777 888 999', 'Warszawa');





