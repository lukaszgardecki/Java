class Game {
    constructor(name, rate, details) {
        this.name = name;
        this.rate = rate;
        this.details = details;
    }
}

function addToTable(game) {
    let body = document.getElementById("body");

    let title = document.createTextNode(game.name);
    let rate = document.createTextNode(game.rate);
    let details = document.createElement("button");
    details.innerHTML = "Pokaż szczegóły";
    details.addEventListener("click", () => {
        document.getElementById("desc").innerHTML = game.details;
    });

    let remove = document.createElement("button");
    remove.innerHTML = "Usuń";
    remove.addEventListener("click", () => {
        row.remove();
        clearDescription();
    });

    let row = body.insertRow(-1);

    row.insertCell(-1).appendChild(title);
    row.insertCell(-1).appendChild(rate);
    row.insertCell(-1).appendChild(details);
    row.insertCell(-1).appendChild(remove);
}

function clearDescription() {
    document.getElementById("desc").innerHTML = "<br>";
}



function createExampleData() {
    addToTable(new Game("Wiedźmin 3", 10, "Opis gry Wiedźmin 3"));
    addToTable(new Game("Starcraft", 7, "Opis gry Starcraft"));
    addToTable(new Game("The Sims", 8, "Opis gry The Sims"));
}
createExampleData();

function registerButton() {
    let button = document.getElementById("add-button");
    button.addEventListener("click", () => {
        let title = document.getElementById("title-input").value;
        let rate = document.getElementById("rate-input").value;
        let details = document.getElementById("details-input").value;
        if (title !== "" && rate !== "" && details !== "") {
            addToTable(new Game(title, rate, details));
        }
        document.getElementById("title-input").value = "";
        document.getElementById("rate-input").value = "";
        document.getElementById("details-input").value = "";
        clearDescription();
    });
}
registerButton();
