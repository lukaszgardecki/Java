"Pobierz ze strony MySQL bazę danych zawierającą informacje na temat krajów i miast świata. Przejdź w tym celu do strony i w sekcji Example Databases pobierz archiwum world database. Następnie korzystając z MySQL Workbencha wybierz opcję File > Run SQL Script i wskaż plik sql wypakowany z pobranego archiwum.

Przeanalizuj strukturę bazy danych, a następnie zdefiniuj następujące zapytania:"

    "1. wyświetl informację o wszystkich polskich miastach"
        select * from city where CountryCode = "POL";


    "2. wyświetl informacje na temat miasta o największej populacji"
        select * from city order by Population desc limit 1;


    "3. wyświetl informacje na temat 3 krajów o największej populacji"
        select * from country order by Population desc limit 3;


    "4. wyświetl wszystkie języki używane w Stanach Zjednoczonych i posortuj je od najbardziej do najmniej popularnych"
        select * from countrylanguage where CountryCode = "USA" order by Percentage desc;


    "5.zmień liczbę ludności w Warszawie na 1,7 miliona"
        update city set Population = 1800000 where ID = 2928;


    "6. usuń z bazy danych informacje na temat Sosnowca"
        delete from city where ID = 2941;

