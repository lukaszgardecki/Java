function changeHeadings() {
    let news = document.getElementById("news");
    news.innerHTML = "Wesołe njusy"
    let sport = document.getElementById("sport");
    sport.innerHTML = "taktak tak";
}

// metoda changeHeadings() zostanie wywołana po 3 sekundach:
setTimeout(changeHeadings, 3000);

// funkcja, która DODAJE to elementu klasę
function addDynamicClassToH2() {
    let h2Elements = document.getElementsByTagName("h2");
    for (let i = 0; i < h2Elements.length; i++) {
        const element = h2Elements[i];
        element.classList.add("dynamic");
    }
}
addDynamicClassToH2();

function addDynamicClassToBullets() {
    //drugie elementy z list:
    let secondBullets = document.querySelectorAll("ul > li:nth-child(2)");
    //dodanie do nich klasy "dynamic":
    secondBullets.forEach(element => element.classList.add("dynamic"));

}
addDynamicClassToBullets(0)

// dodanie elementu do listy:
function addSportNews() {
    // pobieramy listę o id:
    let newList = document.querySelector("#sport-news");

    //najpierw tworzymy element, który będziemy dodawać:
    let li = document.createElement("li");

    let text = document.createTextNode("Niemcy ponownie mistrzami świata w jedzeniu chleba na czas");

    //dodajemy test do elementu li:
    li.appendChild(text);

    //dodajemy element listy do listy:
    newList.appendChild(li);
}
addSportNews();



//usuwanie elementu z drzewa DOM
function removeSecondNews() {
    let secondNews = document.querySelector("#news-list > li:nth-child(2)")
    secondNews.remove();
}
removeSecondNews();



