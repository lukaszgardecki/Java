INSERT INTO
    company (name, description, city, employees, telephone, email)
VALUES
    ('Appul', 'Jeste�my innowacyjn� firm� z tradycjami, tworzymy oprogramowanie od ponad 20 lat', 'Wroc�aw', 100,
     '48 123-234-345', 'kontakt@appul.xyz'),
    ('Gugiel', 'Lider w bran�y oprogramowania dla ma�ych i �rednich firm', 'Warszawa', 300,
     '48 999-888-777', 'hello@gugiel.com');
INSERT INTO
    job_offer (title, description, requirements, duties, location, min_salary, max_salary, date_added, submissions, company_id)
VALUES
    ('Senior java developer', 'Do��cz do naszego zespo�u i tw�rz nowoczesne aplikacje',
     '2 lata do�wiadczenia w programowaniu w Javie 8+. Znajomo�� framework�w Spring i Hibernate',
     'Rozw�j istniej�cej aplikacji webowej tworzonej dla jednego ze sklep�w wielkopowoerzchniowych',
     'Wroc�aw', 5000, 9000, '2021-01-01 12:00:00', 22, 1),
    ('Python developer', 'Tw�rz aplikacje dla czo�owych firm MSP',
     'Wymagamy dobrej znajomo�ci Pythona i frameworka Django, a tak�e relacyjnych baz danych, HTML, CSS i JavaScriptu',
     'B�dziesz odpowiada� za rozw�j nowej aplikacji dla klienta z sektora finans�w',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 33, 1),
    ('Devops engineer', 'Do��cz do nas i rozwijaj aplikacje dla najlepszych',
     'Znajomo�� Dockera, Kubernetesa i Jenkinsa, umiej�tno�� pracy w metodologii Agile',
     'B�dziesz odpowiedzialny za wdrozenie procesu ci�g�ej integracji w jednym z naszych kluczowych projekt�w',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 11, 2);