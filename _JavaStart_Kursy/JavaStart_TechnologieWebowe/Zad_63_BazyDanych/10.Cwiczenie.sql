"Zaprojektuj wycinek bazy danych dla platformy VOD działającego na zasadach podobnych jak Netflix i umożliwiającej oglądanie filmów.Wycinek, który nas interesuje powinien umożliwiać przechowywanie wszystkich opisanych poniżej informacji.

User, aktywne abonamenty, filmy, gdzie skończył oglądać dany film.

W bazie znajdują się użytkownicy. Przechowujemy podstawowe informacje takie jak imię (aby móc wyświetlić na stronie powitanie typu "Cześć Adam"), adres email oraz hasło. Wszystkie te informacje są wymagane, a adres email nie może się powtarzać. Użytkownik może wykupywać na naszej platformie abonamenty. Oferujemy tylko jeden pakiet (dostęp do całej naszej biblioteki filmów), więc interesuje nas to od kiedy do kiedy ktoś ma aktywną subskrypcję. Użytkownik może mieć kilka aktywnych subskrypcji jednocześnie.

Nasza platforma posiada funkcję zapamiętywania tego, w którym momencie użytkownik przerwał oglądanie danego filmu. Dzięki temu, jeżeli wróci na naszą stronę po jakimś czasie nieobecności, to film zacznie mu się wyświetlać dokładnie od momentu, w którym zakończył jego oglądanie. Dodatkowo zaraz po zalogowaniu się na stronie użytkownikowi powinien wyświetlić się ostatnio oglądany film.

Filmy na stronie posiadają tytuł, opis, rok produkcji i ocenę pobraną z serwisu imdb (odpowiednik polskiego filmweba) oraz są przypisane do dokładnie jednej kategorii. Wszystkie informacje o filmie, oprócz jego opisu są obowiązkowe."

create database vod1 character set utf8mb4 collate utf8mb4_polish_ci;
use vod1;

create table user (
	id int primary key auto_increment,
	name varchar(45) not null,
    email varchar(50) unique not null,
    password varchar(40) not null
);

create table subscription (
	id int primary key auto_increment,
    start_date datetime not null,
    end_date datetime not null,
	user_id int,
    foreign key (user_id) references user(id)
);

create table movie_cateogry (
	id int primary key auto_increment,
    name varchar(30) not null,
    description varchar(200)
);

create table movie (
	id int primary key auto_increment,
    title varchar(80) not null,
    description varchar(2000),
    year int not null,
    rating int not null,
    category_id int,
    foreign key (category_id) references movie_category(id)
);

create table watch_progress (
	user_id int not null,
    movie_id int not null,
    watch_time int not null,
    primary key (user_id, movie_id),
    foreign key (user_id) references user(id),
    foreign key (movie_id) references movie(id)
);