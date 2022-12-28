insert into item(id, price, name, short_description, img_url, description) VALUES
       (1, 22.50, 'Pizza Margherita', 'W³oska pizza na cienkim cieœcie z serem i sosem pomidorowym',
        '/img/pizza-margherita.jpg',
        'Pizza Margherita to klasyka w³oskiej kuchni. W naszym wydaniu serwujemy pizzê na cienkim cieœcie z ' ||
        'rêcznie przygotowanym sosem pomidorowym i oryginalnym serem mozarella'),
       (2, 25.99, 'Pizza Capriciosa', 'Pizza na cienkim cieœcie z serem, sosem pomidorowym i pieczarkami',
        '/img/pizza-capriciosa.jpg',
        'Pizza Capriciosa to po Marghericie najpopularniejsza wersja tej smacznej w³oskiej potrawy. Oprócz naszego ' ||
        'domowego sosu pomidorowego i oryginalnej w³oskiej mozarelli znajdziesz tutaj tak¿e pieczarki i wyœmienit¹ sznkê.'),
       (3, 32.99, 'Spaghetti Bolognese', 'Robiona na miejscu pasta z sosem pomidorowym i wo³owin¹',
        '/img/spaghetti-bolognese.jpg',
        'Idealna propozycja dla ka¿dego mi³oœnika pasty. Spaghetti bolognese w naszym wykonaniu to rêcznie przygotowany ' ||
        'makaron z sosem pomidorowym oraz wysokiej jakoœci wo³owin¹. Do przygotowania sosu wykorzystujemy pomidory z ' ||
        'lokalnych upraw oraz œwie¿e zio³a.'),
       (4, 18.99, 'Panna Cotta', 'Klasyczny w³oski deser o smaku œmietankowym z polew¹ z truskawek',
        '/img/panna-cotta.jpg',
        'Masz ochodê na coœ s³odkiego? Ta propozycja to nasza interpretacja jednego z najbardziej rozpoznawalnych w³oskich' ||
        'deserów. Przygotowujemy go ze œmietanki BIO, œwie¿ego mleka i prawdziwej wanilii. Na ¿yczenie deser podajemy ' ||
        'w alternatywnej wersji z sosem czekoladowym.');

insert into client_order(id, address, telephone, status) VALUES
         (1, 'Zakrzewskiego 23/5, 50-225 Wroc³aw', '888777666', 'NEW'),
         (2, 'Koœciuszki 13, 52-316 Wroc³aw', '767454989', 'NEW'),
         (3, 'Krakowska 88/16, 51-515 Wroc³aw', '666234123', 'IN_PROGRESS'),
         (4, 'Centralna 8/12, 55-100 Wroc³aw', '598787999', 'IN_PROGRESS'),
         (5, 'Dworcowa 33, 51-200 Wroc³aw', '600700900', 'COMPLETE'),
         (6, 'Krucza 66/4, 53-300 Wroc³aw', '696787898', 'COMPLETE');

insert into order_item (order_id, item_id) values
           (1, 1),
           (1, 2),
           (1, 3),
           (2, 3),
           (2, 4),
           (3, 1),
           (3, 1),
           (3, 1),
           (4, 1),
           (4, 2),
           (5, 3),
           (5, 3),
           (5, 4),
           (6, 4),
           (6, 4);