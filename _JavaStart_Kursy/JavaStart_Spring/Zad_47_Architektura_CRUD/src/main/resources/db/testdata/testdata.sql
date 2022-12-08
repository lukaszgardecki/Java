INSERT INTO
    company (name, description, city, employees, telephone, email)
VALUES
    ('Appul', 'Jesteœmy innowacyjn¹ firm¹ z tradycjami, tworzymy oprogramowanie od ponad 20 lat', 'Wroc³aw', 100,
     '48 123-234-345', 'kontakt@appul.xyz'),
    ('Gugiel', 'Lider w bran¿y oprogramowania dla ma³ych i œrednich firm', 'Warszawa', 300,
     '48 999-888-777', 'hello@gugiel.com');
INSERT INTO
    job_offer (title, description, requirements, duties, location, min_salary, max_salary, date_added, submissions, company_id)
VALUES
    ('Senior java developer', 'Do³¹cz do naszego zespo³u i twórz nowoczesne aplikacje',
     '2 lata doœwiadczenia w programowaniu w Javie 8+. Znajomoœæ frameworków Spring i Hibernate',
     'Rozwój istniej¹cej aplikacji webowej tworzonej dla jednego ze sklepów wielkopowoerzchniowych',
     'Wroc³aw', 5000, 9000, '2021-01-01 12:00:00', 22, 1),
    ('Python developer', 'Twórz aplikacje dla czo³owych firm MSP',
     'Wymagamy dobrej znajomoœci Pythona i frameworka Django, a tak¿e relacyjnych baz danych, HTML, CSS i JavaScriptu',
     'Bêdziesz odpowiada³ za rozwój nowej aplikacji dla klienta z sektora finansów',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 33, 1),
    ('Devops engineer', 'Do³¹cz do nas i rozwijaj aplikacje dla najlepszych',
     'Znajomoœæ Dockera, Kubernetesa i Jenkinsa, umiejêtnoœæ pracy w metodologii Agile',
     'Bêdziesz odpowiedzialny za wdrozenie procesu ci¹g³ej integracji w jednym z naszych kluczowych projektów',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 11, 2);